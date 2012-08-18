/**
 * 2012-7-2
 * 
 * 周坤
 * 
 * 个人信息显示页面 
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
	enum Corporeity{平和型,气虚型,阴虚型,阳虚型,湿热型,气郁型,痰湿型,血瘀型,特禀型};
	enum Age{儿童,中年,老年人,孕妇};
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
			//TODO:转到修改密码页面
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
			mSexTextView.setText("女");
		}
		else 
		{
			mSexTextView.setText("男");
		}
		mPhysiqueTextView.setText(healthInfo.getCorporeity());

	}

}
