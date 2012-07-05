package com.codestorm.medicine;

/*
 * 	֣��
 * 	2012-6-29
 * 	���񴰿�
 * */
import com.codestorm.medicine.model.TempMission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyMissionActivity extends Activity implements OnClickListener
{
	Button mMissionButton;
	TempMission tempMission = new TempMission(); // ����ģ������
	TextView mMissonTextView;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.mymission);
		mMissonTextView = (TextView) findViewById(R.id.missionTextView);
		mMissonTextView.setText(tempMission.missionString); // ���������ı�

	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub

	}

}
