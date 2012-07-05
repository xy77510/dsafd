package com.codestorm.medicine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PersonCenter extends Activity implements OnClickListener
{
	Button mMyMissionButton;
	Button mUserInfoButton;
	Button mPublicSpaceButton;
	Button mNewsButton;
	Button mAssistantButton;
	Button mHeathcenterButton;
	Button mDrugstoreButton;
	Intent intent;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.center);

		mMyMissionButton = (Button) findViewById(R.id.myMissionButton);
		mMyMissionButton.setOnClickListener(this);
		mUserInfoButton = (Button) findViewById(R.id.userinfoButton);
		mUserInfoButton.setOnClickListener(this);
		mPublicSpaceButton = (Button) findViewById(R.id.publicspaceButton);
		mPublicSpaceButton.setOnClickListener(this);
		mNewsButton = (Button) findViewById(R.id.newsButton);
		mNewsButton.setOnClickListener(this);
		mAssistantButton = (Button) findViewById(R.id.assistantButton);
		mAssistantButton.setOnClickListener(this);
		mHeathcenterButton = (Button) findViewById(R.id.heathcenterButton);
		mHeathcenterButton.setOnClickListener(this);
		mDrugstoreButton = (Button) findViewById(R.id.drugstoreButton);
		mDrugstoreButton.setOnClickListener(this);

	}

	public void onClick(View v)
	{
		// 按钮点击事件
		switch (v.getId())
		{
		case R.id.myMissionButton:
		{
			// TODO:查看体质
			intent = new Intent();
			intent.setClass(this, MyMissionActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.userinfoButton:
		{
			//TODO:查看个人信息
			intent=new Intent();
			intent.setClass(this, UserInfoActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.publicspaceButton:
		{
			//TODO:查看药品记录
		}
			break;
		case R.id.newsButton:
		{
			//TODO:进入新闻中心
			intent = new Intent();
			intent.setClass(this, InformationActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.assistantButton:
		{
			// TODO:进入私人助理
		}
			break;
		case R.id.heathcenterButton:
		{
			// 进入健康中心
			intent = new Intent();
			intent.setClass(this, MedRegActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.drugstoreButton:
		{
			// 进入药店
			intent = new Intent();
			intent.setClass(this, MedRoomActivity.class);
			startActivity(intent);
		}
			break;
		default:
			break;
		}
	}

}
