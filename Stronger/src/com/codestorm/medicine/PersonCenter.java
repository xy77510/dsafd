package com.codestorm.medicine;

/*
 * 	֣��	
 * 	2012-7-24
 * 	�������Ľ���
 * 
 * */
import com.codestorm.medicine.db.DataManage;
import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.HealthInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PersonCenter extends Activity implements OnClickListener
{
	Button mInformationButton;
	Button mMyPushButton;
	Button mPublicSpaceButton;
	Button mMyWantButton;
	Button mHealthCenterButton;
	Button mPersonalAssistantButton;
	Intent intent;
	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	DataManage dataManage;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.personcenter);
		mInformationButton = (Button) findViewById(R.id.informationButton);
		mInformationButton.setOnClickListener(this);
		mMyPushButton = (Button) findViewById(R.id.myPushButton);
		mMyPushButton.setOnClickListener(this);
		mPublicSpaceButton = (Button) findViewById(R.id.publicSpaceButton);
		mPublicSpaceButton.setOnClickListener(this);
		mMyWantButton = (Button) findViewById(R.id.myWantButton);
		mMyWantButton.setOnClickListener(this);
		mHealthCenterButton = (Button) findViewById(R.id.healthCenterButton);
		mHealthCenterButton.setOnClickListener(this);
		mPersonalAssistantButton = (Button) findViewById(R.id.personalAssistantButton);
		mPersonalAssistantButton.setOnClickListener(this);
		dataManage=DataManage.getDataManage(this);
		FileOperate.readHealthInfo(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, 0, 0, "�˳�");
		menu.add(0, 1, 0, "����");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id)
		{
		case 0:
			finish();
			break;
		case 1:
			intent = new Intent();
			intent.setClass(this, OptionActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		return true;
	}


	public void onClick(View v)
	{
		// ��ť����¼�
		switch (v.getId())
		{
		case R.id.informationButton:
		{
			// TODO:�鿴��Ѷ
			intent = new Intent();
			intent.setClass(this, InformationActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.myPushButton:
		{
			// TODO:�鿴�ҵ�����
			intent = new Intent();
			intent.setClass(this, MyPushActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.publicSpaceButton:
		{
			// TODO:�鿴�����ռ�
			intent = new Intent();
			intent.setClass(this, MyCommentary.class);
			startActivity(intent);
		}
			break;
		case R.id.myWantButton:
		{
			// TODO:�����ҵĶ���
			intent = new Intent();
		}
			break;
		case R.id.healthCenterButton:
		{
			// TODO:���뽡������
			intent = new Intent();
			intent.setClass(this, MedRegActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.personalAssistantButton:
		{
			// �����������
			intent = new Intent();
		}
			break;
		default:
			break;
		}
	}
	
	//����ʱִ�еĺ���
	@Override
	protected void onDestroy()
	{
		dataManage.closeDB();
		super.onDestroy();
		
	}
	
	public void finish()
	{		
		super.finish();
	}

}
