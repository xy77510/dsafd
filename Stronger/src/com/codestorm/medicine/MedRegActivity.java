/**
 * 2012-6-19
 * 
 * ��۾�
 * 
 * �������Ľ���
 * 
 * */
package com.codestorm.medicine;

import java.util.ArrayList;
import java.util.List;

import com.codestorm.medicine.model.Office;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MedRegActivity extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	private Button mRegofficeButton;
	private Button mRegselectButton;
	private Button mTestButton;
	Intent intent;
	
	public static String choice; // ����ɸѡ���ַ���
	public static List<Office> offices = new ArrayList<Office>();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.heath);
		mRegofficeButton = (Button) findViewById(R.id.regofficeButton);
		mRegofficeButton.setOnClickListener(this);
		mRegselectButton = (Button) findViewById(R.id.regconsultButton);
		mRegselectButton.setOnClickListener(this);
		mTestButton = (Button) findViewById(R.id.testButton);
		mTestButton.setOnClickListener(this);
		intent=new Intent();
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.regofficeButton:
			// TODO:�����ǿ������
			choice = "ȫ��";
			intent.setClass(MedRegActivity.this, OfficeActivity.class);
			startActivity(intent);
			break;
		case R.id.regconsultButton:
			// TODO:��������ѯ���
			intent.setClass(this, AdvisoryActivity.class);
			startActivity(intent);
			break;
		case R.id.testButton:
			// TODO:������������
			intent.setClass(this, ExaminationActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}