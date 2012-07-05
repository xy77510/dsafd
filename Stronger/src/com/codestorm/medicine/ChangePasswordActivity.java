/**
 * 
 * 2012-7-2
 * 
 * 周坤
 * 
 * 修改密码页面
 * 
 * */
package com.codestorm.medicine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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
		
		mInputOldpasswordTextView=(TextView)findViewById(R.id.input_old_passwordEditText);
		mInputNewpasswordTextView=(TextView)findViewById(R.id.input_newpasswordEditText);
		mConfirmNewpasswordTextView=(TextView)findViewById(R.id.confirm_newpasswordEditText);
		mConfirmButton=(Button)findViewById(R.id.confirmButton);
		mConfirmButton.setOnClickListener(this);		
		mCancelButton=(Button)findViewById(R.id.cancelButton);
		mCancelButton.setOnClickListener(this);
		
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.confirmButton:
			//TODO:验证新密码并使生效
			break;
		case R.id.cancelButton:
			this.finish();
		default:
			break;
		}
		
	}

	

}
