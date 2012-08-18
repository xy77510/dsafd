package com.codestorm.medicine;

import com.codestorm.medicine.model.Information;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyInformationActivity extends Activity implements OnClickListener
{
	TextView mTextView;
	Button mButton;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mymission);
		mTextView = (TextView) findViewById(R.id.mtitleTextView);
		mTextView.setText(Information.information.title);
		mTextView = (TextView) findViewById(R.id.missionTextView);
		mTextView.setText(Information.information.text);
		mButton = (Button) findViewById(R.id.missonButton);
		mButton.setText("返回");
		mButton.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		// TODO 返回上级界面
		switch (v.getId())
		{
		case R.id.missonButton:
			finish();
			break;

		default:
			break;
		}

	}

}
