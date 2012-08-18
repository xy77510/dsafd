/**
 * 
 * 2012-6-19
 * 
 * 郑泽
 * 
 * 登录页面
 * 
 * */

package com.codestorm.medicine;

import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.UserInfo;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
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
	CheckBox mCheckBox;

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
		if (FileOperate.readUser(this))
		{
			users = UserInfo.getUserInfo();
		}
		String[] strings = FileOperate.readOption(this);
		if (strings != null)
		{
			if (strings[0] != null && strings[0].equals("1"))
			{ // 是否记录邮箱
				mCheckBox = (CheckBox) findViewById(R.id.mailCheckBox);
				mCheckBox.setChecked(true);
				mUserNameEditText.setText(users.userName);
			}
			if (strings[1] != null && strings[1].equals("1"))
			{ // 是否记录密码
				mCheckBox = (CheckBox) findViewById(R.id.passwordCheckBox);
				mCheckBox.setChecked(true);
				mPasswordEditText.setText(users.userPassword);
			}
		}
	}

	public void onClick(View v)
	{
		if (v == mLoginButton)
		{
			String mail = mUserNameEditText.getText().toString();
			String password = mPasswordEditText.getText().toString();
			if ("".equals(mail) || "".equals(password)) // 判断用户名与密码是否为空
			// if(false)
			{
				Toast.makeText(this, "请输入用户名与密码！", Toast.LENGTH_LONG).show();
			} else
			{
				// TODO:传递用户名与密码给服务器验证
				if (AnologServer.login(mail, password))
				{
					// 验证成功
					FileOperate.readHealthInfo(this);
					HealthInfo healthInfo = HealthInfo.getHealthInfo();
					if (healthInfo.firstLogin())
					{
						// 用户第一次登陆时进入信息填写引导界面
						intent = new Intent();
						intent.setClass(this, FirstLoginActivity.class);
						startActivity(intent);
						this.finish();
					} else
					{
						intent = new Intent();
						intent.setClass(this, PersonCenter.class);
						startActivity(intent);
						this.finish();
					}

				} else
				{
					// TODO:验证失败操作
					Toast.makeText(this, "帐户密码错误，请重新输入！", Toast.LENGTH_LONG).show();
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

	public void finish()
	{
		String s = "";
		mCheckBox = (CheckBox) findViewById(R.id.mailCheckBox);
		if (mCheckBox.isChecked())
			s = "1|";
		else
			s = "0|";
		mCheckBox = (CheckBox) findViewById(R.id.passwordCheckBox);
		if (mCheckBox.isChecked())
			s += "1";
		else
			s += "0";
		FileOperate.writeOption(this, s);
		super.finish();
	}
}