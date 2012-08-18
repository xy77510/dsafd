package com.codestorm.medicine;
/*
 * 		郑泽
 * 		2012-7-25
 * 		设置界面
 * 
 * */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OptionActivity extends Activity implements OnClickListener {
	Button mChangeUserButton;
	Button mChangePassButton;
	Button mOptionButton;
    Intent intent = new Intent();
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.option);
		mChangeUserButton = (Button) findViewById(R.id.changeUserButton);
		mChangeUserButton.setOnClickListener(this);
		mChangePassButton = (Button) findViewById(R.id.changePassButton);
		mChangePassButton.setOnClickListener(this);
		mOptionButton = (Button) findViewById(R.id.optionButton);
		mOptionButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.changeUserButton:
			//TODO 修改用户信息
			intent.setClass(this, ChangeUserInfoActivity.class);
			startActivity(intent);
			break;
		case R.id.changePassButton:
			//TODO 修改密码
			intent.setClass(this,ChangePasswordActivity.class );
			startActivity(intent);
			break;
		case R.id.optionButton:
			//TODO 软件设置
			break;
		default:
			break;
		}

	}

}
