/**
 * 
 * 2012-6-19
 * 
 * ��
 * 
 * ��ҩ������
 * 
 * 
 * */


package com.codestorm.medicine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MedRoomActivity extends Activity implements OnClickListener
{
	private Button mGetButton;
	private Button mCustomButton;
	private Button mSettleButton;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.store);
		mGetButton = (Button)findViewById(R.id.getmedButton);
		mGetButton.setOnClickListener(this);
		mCustomButton=(Button)findViewById(R.id.customButton);
		mCustomButton.setOnClickListener(this);
		mSettleButton=(Button)findViewById(R.id.settleButton);
		mSettleButton.setOnClickListener(this);
	}
	
	public void onClick(View arg0)
	{
		// TODO:��ӦButton����¼�
		switch (arg0.getId())
		{
		case R.id.getmedButton:
			//TODO:����ҩ����ȡҩ������
			break;
		case R.id.customButton:
			//TODO�������Զ����ȡҩ������
			break;
		case R.id.settleButton:
			//TODO:������㹦��
			break;
		default:
			break;
		}
		
	}

}