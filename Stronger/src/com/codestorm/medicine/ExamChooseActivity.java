/**
 * 2012-6-19
 * 
 * ��
 * 
 * �����Ŀѡ�����
 * 
 * */
package com.codestorm.medicine;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ExamChooseActivity extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	private Button mFatRateButton;
	private Button mPhysiqueButton;
	Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.examchoose);
		mFatRateButton = (Button) findViewById(R.id.fatrateButton);
		mFatRateButton.setOnClickListener(this);
		mPhysiqueButton = (Button) findViewById(R.id.physiqueButton);
		mPhysiqueButton.setOnClickListener(this);
		intent=new Intent();
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.fatrateButton:
			// TODO:�����Ƿ���ָ���������
			intent.setClass(this, ExaminationActivity.class);
			startActivity(intent);
			break;
		case R.id.physiqueButton:
			// TODO:��������ҽ���ʲ������
			intent.setClass(this, PhysiqueActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}