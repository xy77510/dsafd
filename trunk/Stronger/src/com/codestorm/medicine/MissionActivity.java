package com.codestorm.medicine;

/*
 * 	Ö£Ôó
 * 	2012-7-22
 * 	ÈÎÎñ´°¿Ú
 * 
 * */
import com.codestorm.medicine.model.Mission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MissionActivity extends Activity implements OnClickListener
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
		mTextView.setText(Mission.mission.missiontitle);
		mTextView = (TextView) findViewById(R.id.missionTextView);
		mTextView.setText(Mission.mission.missionstring);
		mButton = (Button) findViewById(R.id.missonButton);
		mButton.setOnClickListener(this);

	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		if (v.getId() == R.id.missonButton)
			this.finish();
	}
}
