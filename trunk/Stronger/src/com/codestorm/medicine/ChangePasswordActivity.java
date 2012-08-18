/**
 * 
 * 2012-7-2
 * 
 * ����
 * 
 * �޸�����ҳ��
 * 
 * */
package com.codestorm.medicine;

import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.UserInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePasswordActivity extends Activity implements OnClickListener
{
	TextView mInputOldpasswordTextView;
	TextView mInputNewpasswordTextView;
	TextView mConfirmNewpasswordTextView;
	Button mConfirmButton;
	Button mCancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.changepassword);

		mInputOldpasswordTextView = (TextView) findViewById(R.id.input_old_passwordEditText);
		mInputNewpasswordTextView = (TextView) findViewById(R.id.input_newpasswordEditText);
		mConfirmNewpasswordTextView = (TextView) findViewById(R.id.confirm_newpasswordEditText);
		mConfirmButton = (Button) findViewById(R.id.confirmButton);
		mConfirmButton.setOnClickListener(this);
		mCancelButton = (Button) findViewById(R.id.cancelButton);
		mCancelButton.setOnClickListener(this);

	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.confirmButton:
			// TODO:��֤�����벢ʹ��Ч

			String oldPassword = mInputOldpasswordTextView.getText().toString();
			String newPassword = mInputNewpasswordTextView.getText().toString();
			String confirmPassword = mConfirmNewpasswordTextView.getText().toString();
			if ("".equals(oldPassword) || "".equals(newPassword) || "".equals(confirmPassword)) // �ж������Ƿ�Ϊ��
			{
				Toast.makeText(this, "���벻��Ϊ�գ�", Toast.LENGTH_LONG).show();
			} else
			{
				UserInfo userInfo = UserInfo.getUserInfo();
				if (!oldPassword.equals(userInfo.userPassword))
				{
					Toast.makeText(this, "�������������", Toast.LENGTH_LONG).show();
				} else if (!newPassword.equals(confirmPassword))
				{
					Toast.makeText(this, "��������������벻��ͬ��", Toast.LENGTH_LONG).show();
				} else
				{
					userInfo.userPassword=newPassword;
					FileOperate.writeUser(this);
				}
			}

			break;
		case R.id.cancelButton:
			this.finish();
		default:
			break;
		}

	}

}
