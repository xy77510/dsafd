/**
 * 2012-7-2
 * 
 * ����
 * 
 * ������Ϣ��ʾҳ�� 
 * 
 * */
package com.codestorm.medicine;

import com.codestorm.medicine.model.HealthInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class UserInfoActivity extends Activity implements OnClickListener
{
	enum Corporeity{ƽ����,������,������,������,ʪ����,������,̵ʪ��,Ѫ����,������};
	enum Age{��ͯ,����,������,�и�};
	TextView mNameTextView;
	TextView mAgeTextView;
	TextView mSexTextView;
	TextView mPhysiqueTextView;
	Button mChangePasswordButton;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.userinfo);
		mNameTextView=(TextView)findViewById(R.id.nameTextView);
		mAgeTextView=(TextView)findViewById(R.id.ageTextView);
		mSexTextView=(TextView)findViewById(R.id.sexTextView);
		mPhysiqueTextView=(TextView)findViewById(R.id.physiqueTextView);
		mChangePasswordButton=(Button)findViewById(R.id.changepasswordButton);
		mChangePasswordButton.setOnClickListener(this);
		loadData();
		
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.changepasswordButton:
			//TODO:ת���޸�����ҳ��
			intent=new Intent();
			intent.setClass(this, ChangePasswordActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
	
	private void loadData()
	{   
		HealthInfo healthInfo=HealthInfo.getHealthInfo();
		mNameTextView.setText(healthInfo.name);
		mAgeTextView.setText(String.valueOf(healthInfo.age));
		if(healthInfo.sex)
		{
			mSexTextView.setText("Ů");
		}
		else 
		{
			mSexTextView.setText("��");
		}
		mPhysiqueTextView.setText(healthInfo.getCorporeity());

	}

}
