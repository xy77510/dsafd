package com.codestorm.medicine;

/*
 * 		֣��
 * 		2012-7-27
 * 		�������۽���
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
	Button canButton; // ȡ����ť
	Button comButton; // �������۰�ť
	EditText mEditText; // ��������
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
			// TODO:���ȡ����ť
			setResult(RESULT_CANCELED);
			finish();
			break;
		case R.id.comButton:
			// TODO:����������۰�ť
			String textString = mEditText.getText().toString();
			if (!"".equals(textString))
			{ // ����Ƿ��ı����Ƿ�Ϊ��
				Commentary newCommentary = new Commentary(healthInfo.name, textString);
				Commentary.commentaries.add(newCommentary);
				// �˴���������ӽ����ݿ�
				if (AnologServer.insertCommentary(this, healthInfo.name, textString, Commentary.commentriesname))
				{
					Toast.makeText(this, "����ɹ���", Toast.LENGTH_LONG).show();
				} else
				{
					Toast.makeText(this, "����ʧ�ܣ�", Toast.LENGTH_LONG).show();
				}

				setResult(RESULT_OK);
				finish();
			} else
			{
				Toast.makeText(this, "��������������", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}

	}

}
