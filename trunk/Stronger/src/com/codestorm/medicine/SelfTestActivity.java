package com.codestorm.medicine;

/*
 * 	֣��
 * 	2012/6/22
 * 	���Һ���Բ����
 * 
 * */

import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.Medicine;
import com.codestorm.medicine.model.QuestionInfo;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelfTestActivity extends Activity implements OnClickListener
{

	TextView mTextView; // ��Ŀ�ı������
	Button mYesButton, mNoButton, mReButton, mPushButton; // ���ǡ���ť�¼��롰�񡱰�ť�¼�

	HashMap<String, QuestionInfo> questions;
	QuestionInfo questionInfo;

	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	// TempMedical medical = new TempMedical(); // ����ģ�MˎƷ�б�
	Intent intent;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.selftest);
		mYesButton = (Button) findViewById(R.id.yesButton);
		mYesButton.setOnClickListener(this);
		mNoButton = (Button) findViewById(R.id.noButton);
		mNoButton.setOnClickListener(this);
		mReButton = (Button) findViewById(R.id.reTestButton);
		mReButton.setOnClickListener(this);
		mPushButton = (Button) findViewById(R.id.pushButton);
		mPushButton.setOnClickListener(this);
		mTextView = (TextView) findViewById(R.id.questionTextView);
		AnologServer.iniQuestion(this);
		questions = QuestionInfo.getQuestions();
		questionInfo = questions.get("0");
		mTextView.setText(questionInfo.question); // ��ȡ����Ŀ�ı�
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// ���¡��ǡ����o
		case R.id.yesButton:
		{
			questionInfo = questions.get(questionInfo.yesNext);
			mTextView.setText(questionInfo.question); // ��ȡ��Ŀ�ı�
			break;
		}
		// ���¡��񡱰��o
		case R.id.noButton:
		{
			questionInfo = questions.get(questionInfo.noNext); // ת�����񡱺����һ����Ŀ
			mTextView.setText(questionInfo.question); // ��ȡ��Ŀ�ı�
			break;
		}
		// ���¡����yԇ�����o
		case R.id.reTestButton:
		{
			intent = new Intent();
			intent.setClass(this, SelfTestActivity.class);
			startActivity(intent);
			finish();
			break;
		}
		// ���¡�����ˎƷ�����o
		case R.id.pushButton:
		{
			// TODO:���ͷ���

			// ��ȡ��������
			healthInfo.disease = questionInfo.question;

			// �ӷ�������ö�Ӧ�˲���ҩƷ��Ϣ�б�
			List<Medicine> medicals = AnologServer.getMedicals(this, healthInfo.disease);

			if (medicals.isEmpty())
			{
				Toast.makeText(this, "��Ǹ��û���ҵ��ʺ�����ҩƷ��", Toast.LENGTH_LONG).show();
			} else
			{
				intent = new Intent();
				intent.setClass(this, PushMedicineActivity.class);
				startActivity(intent);
				this.finish();
			}

			//
			// // ��������ɸѡ
			// // sift(medicals);
			//
			// // ��ʾ�Ƽ�ҩƷ
			// String string = new String();
			// if (medicals.isEmpty())
			// {
			// string += "��Ǹ��û���ҵ��ʺ�����ҩƷ��";
			// } else
			// {
			// for (Medicine medical : medicals)
			// {
			// string += medical.name + "\n";
			// }
			// }
			// mTextView.setText(string);

		}
		default:
			break;
		}

		// �ж���Ŀ�Ƿ����
		if ("".equals(questionInfo.yesNext))
		{
			mYesButton.setVisibility(View.INVISIBLE); // ���ء��ǡ���ť
			mNoButton.setVisibility(View.INVISIBLE); // ���ء�����ť
			mReButton.setVisibility(View.VISIBLE); // ��ʾ�����²��ԡ���ť
			mPushButton.setVisibility(View.VISIBLE); // ��ʾ������ҩƷ����ť
		}

	}

	// private List<Medicine> sift(List<Medicine> medicals)
	// {
	// HealthInfo healthInfo = HealthInfo.getHealthInfo();
	//
	// // ɸѡ
	// for (String corporeity : healthInfo.corporeitysList)
	// {
	//
	// for (Medicine medical : medicals)
	// {
	// // ���ݽ���
	// if (medical.taboos.contains(corporeity))
	// {
	// medicals.remove(medical);
	// continue;
	// }
	// // ����״̬ɸѡ
	// if (medical.taboos.contains(String.valueOf(healthInfo.age)))
	// {
	// medicals.remove(medical);
	// continue;
	// }
	//
	// }
	//
	// }
	// return medicals;
	//
	// }

}
