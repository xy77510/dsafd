/**
 * 
 * 2012-6-19
 * 
 * ֣��
 * 
 * ��¼ҳ��
 * 
 * */

package com.codestorm.medicine;

import com.codestorm.medicine.model.AnologServer;
import com.codestorm.medicine.model.UserInfo;

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

public class LoginActivity extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	Button mLoginButton;
	Button mRegisterButton;
	EditText mUserNameEditText;
	EditText mPasswordEditText;
	UserInfo users = UserInfo.getUserInfo();
	Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.login);
		mLoginButton = (Button) findViewById(R.id.loginButton);
		mRegisterButton = (Button) findViewById(R.id.registerButton);
		mLoginButton.setOnClickListener(this);
		mRegisterButton.setOnClickListener(this);
		mUserNameEditText = (EditText) findViewById(R.id.usernameEditText);
		mPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
	}

	public void onClick(View v)
	{
		if (v == mLoginButton)
		{
//			if ("".equals(mUserNameText.getText().toString()) || "".equals(mPasswordText.getText().toString())) // �ж��û����������Ƿ�Ϊ��
			if(false)
			{
				Toast.makeText(this, "�������û��������룡", Toast.LENGTH_LONG).show();
			} else
			{
				// TODO:�����û������������������֤
				if (AnologServer.login())
				{
					// ��֤�ɹ�
					intent = new Intent();
					intent.setClass(this, PersonCenter.class);
					startActivity(intent);
					this.finish();
				} else
				{
					//TODO:��֤ʧ�ܲ���
				}
			}
		}
		if (v == mRegisterButton)
		{
			Intent intent = new Intent();
			intent.setClass(this, RegisterActivity.class);
			startActivity(intent);
		}
	}
}