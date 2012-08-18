package com.codestorm.medicine;

/*
 * 	֣��
 *  2012/6/26
 * 	��ѯ����
 * */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdvisoryActivity extends Activity implements OnClickListener
{
	Button mNoseButton;
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.advisory);
		mNoseButton = (Button) findViewById(R.id.noseButton);
		mNoseButton.setOnClickListener(this);

	}

	public void onClick(View v)
	{
		// TODO ��λѡ��
		switch (v.getId())
		{
		case R.id.noseButton:
		{
			com.codestorm.medicine.MedRegActivity.choice = "����";
			intent.setClass(this, OfficeActivity.class);
			startActivity(intent);
		}
		}
	}

}
