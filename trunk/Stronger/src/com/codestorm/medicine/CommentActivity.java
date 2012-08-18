package com.codestorm.medicine;

/*
 * 		郑泽
 * 		2012-7-27
 * 		发表评论界面
 * 
 * */
import com.codestorm.medicine.model.Commentary;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CommentActivity extends Activity implements OnClickListener
{
	Button canButton; // 取消按钮
	Button comButton; // 发表评论按钮
	EditText mEditText; // 评论内容
	HealthInfo healthInfo = HealthInfo.getHealthInfo();

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.comment);
		canButton = (Button) findViewById(R.id.canButton);
		canButton.setOnClickListener(this);
		comButton = (Button) findViewById(R.id.comButton);
		comButton.setOnClickListener(this);
		mEditText = (EditText) findViewById(R.id.commentEditText);

	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.canButton:
			// TODO:点击取消按钮
			setResult(RESULT_CANCELED);
			finish();
			break;
		case R.id.comButton:
			// TODO:点击发表评论按钮
			String textString = mEditText.getText().toString();
			if (!"".equals(textString))
			{ // 检测是否文本框是否为空
				Commentary newCommentary = new Commentary(healthInfo.name, textString);
				Commentary.commentaries.add(newCommentary);
				// 此处将评论添加进数据库
				if (AnologServer.insertCommentary(this, healthInfo.name, textString, Commentary.commentriesname))
				{
					Toast.makeText(this, "发表成功！", Toast.LENGTH_LONG).show();
				} else
				{
					Toast.makeText(this, "发表失败！", Toast.LENGTH_LONG).show();
				}

				setResult(RESULT_OK);
				finish();
			} else
			{
				Toast.makeText(this, "请输入您的评论", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}

	}

}
