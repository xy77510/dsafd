package com.codestorm.medicine;

/*
 * 		郑泽
 * 		2012-7-25
 * 		修改用户信息界面
 * 
 * */
import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.HealthInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ChangeUserInfoActivity extends Activity implements OnClickListener
{
	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	Button mButton;
	Spinner mSpinner;
	EditText mEditText;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.firstlogin);
		mSpinner = (Spinner) findViewById(R.id.ageSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agearray, android.R.layout.simple_spinner_item);
		mSpinner.setAdapter(adapter);
		mSpinner = (Spinner) findViewById(R.id.sexSpinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.sexarray, android.R.layout.simple_spinner_item);
		mSpinner.setAdapter(adapter);
		mButton = (Button) findViewById(R.id.nextButton);
		mButton.setOnClickListener(this);
		mButton.setText("保存");
		if (healthInfo != null)
		{// 前置条件
			mEditText = (EditText) findViewById(R.id.nameEditText);
			mEditText.setText(healthInfo.name);
			mSpinner.setSelection(healthInfo.getSex());
			mSpinner = (Spinner) findViewById(R.id.ageSpinner);
			mSpinner.setSelection(healthInfo.getAge());
		}
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// TODO 确定，保存用户信息
		case R.id.nextButton:
			EditText mEditText = (EditText) findViewById(R.id.nameEditText);
			if (!"".equals(mEditText.getText().toString()))
			{
				healthInfo.name = mEditText.getText().toString();
				mSpinner = (Spinner) findViewById(R.id.ageSpinner);
				healthInfo.setAge(mSpinner.getSelectedItemPosition());
				mSpinner = (Spinner) findViewById(R.id.sexSpinner);
				healthInfo.setSex(mSpinner.getSelectedItemPosition());
				FileOperate.writeHealthInfo(this);
				// 进入自测界面
				this.finish();
			} else
			{
				Toast.makeText(this, "请输入昵称", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}

	}

}
