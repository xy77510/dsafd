package com.codestorm.medicine;

import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.HealthInfo;

import android.app.Activity;
import android.content.Intent;
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

public class FirstLoginActivity extends Activity implements OnClickListener
{
	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	Button mButton;
	Spinner mSpinner;
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.firstlogin);
		// 初始化年龄spinner
		mSpinner = (Spinner) findViewById(R.id.ageSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agearray, android.R.layout.simple_spinner_item);
		mSpinner.setAdapter(adapter);
		// 初始化性别spinner
		mSpinner = (Spinner) findViewById(R.id.sexSpinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.sexarray, android.R.layout.simple_spinner_item);
		mSpinner.setAdapter(adapter);
		// 定义按钮事件
		mButton = (Button) findViewById(R.id.nextButton);
		mButton.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		// TODO
		switch (v.getId())
		{
		// 点击继续按钮
		case R.id.nextButton:
			EditText mEditText = (EditText) findViewById(R.id.nameEditText);
			if (!"".equals(mEditText.getText().toString()))
			{
				healthInfo.name = mEditText.getText().toString();
				mSpinner = (Spinner) findViewById(R.id.ageSpinner);
				healthInfo.setAge(mSpinner.getSelectedItemPosition());
				mSpinner = (Spinner) findViewById(R.id.sexSpinner);
				healthInfo.setSex(mSpinner.getSelectedItemPosition());
				// 进入自测界面
				intent.setClass(this, PhysiqueActivity.class);
				startActivity(intent);
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
