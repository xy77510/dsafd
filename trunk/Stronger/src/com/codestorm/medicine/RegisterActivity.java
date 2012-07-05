/**
 * 2012-6-19
 * 
 * 郑泽
 * 
 * 注册页面
 * 
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
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener
{
	Button mYesButton;
	Button mCancelButton;

	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.register);
		mYesButton = (Button) findViewById(R.id.yesButton);
		mYesButton.setOnClickListener(this);
		mCancelButton = (Button) findViewById(R.id.cancelButton);
		mCancelButton.setOnClickListener(this);
		intent.setClass(this, LoginActivity.class);
	}

	public void onClick(View v)
	{
		if (v == mYesButton)
		{
			EditText mUserText = (EditText) findViewById(R.id.inputuserEditText);
			EditText mPasswordText = (EditText) findViewById(R.id.inputpasswordEditText);
			EditText mRePsswordText = (EditText) findViewById(R.id.repasswordEditText);
			String userString = mUserText.getText().toString();
			String passwordString = mPasswordText.getText().toString();
			String repasswordString = mRePsswordText.getText().toString();
			if ("".equals(userString) || "".equals(passwordString) || "".equals(repasswordString))
			{
				Toast.makeText(this, "请填写完整", Toast.LENGTH_SHORT).show();
				return;
			} else if (!passwordString.equals(repasswordString))
			{
				Toast.makeText(this, "两次密码不一致", Toast.LENGTH_LONG).show();
				return;
			} else
			{				
				// TODO:注册过程
				RegisterActivity.this.finish();
			}

		}
		if (v == mCancelButton)
		{
			RegisterActivity.this.finish();
		}
	}
}
