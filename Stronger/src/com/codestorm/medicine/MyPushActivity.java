package com.codestorm.medicine;

/**
 * 郑泽
 * 	2012-7-24
 * 	我的推送
 * 
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MyPushActivity extends Activity implements OnClickListener
{
	Intent intent = new Intent();
	Button mMyMissonButton;
	Button mMyMedicinesButton;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mypush);
		mMyMissonButton = (Button) findViewById(R.id.myMissionButton);
		mMyMissonButton.setOnClickListener(this);
		mMyMedicinesButton = (Button) findViewById(R.id.myMedicinesButton);
		mMyMedicinesButton.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		// TODO 选择
		switch (v.getId())
		{
		case R.id.myMissionButton:
			intent.setClass(this, MyMissionActivity.class);
			startActivity(intent);
			break;
		case R.id.myMedicinesButton:
			intent.setClass(this, MyMedicinesActivity.class);
			startActivity(intent);			
			break;
		default:
			break;
		}
	}
}
