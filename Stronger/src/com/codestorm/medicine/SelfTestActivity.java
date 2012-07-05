package com.codestorm.medicine;

/*
 * 	֣��
 * 	2012/6/22
 * 	���Һ���Բ����
 * 
 * */
import java.util.List;

import com.codestorm.medicine.model.AnologServer;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.TempData;
import com.codestorm.medicine.model.Medicine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SelfTestActivity extends Activity implements OnClickListener
{

	TextView mTextView; // ��Ŀ�ı������
	Button mYesButton, mNoButton, mReButton, mPushButton; // ���ǡ���ť�¼��롰�񡱰�ť�¼�
	TempData data = new TempData(); // ����ģ����Ŀ
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
		mTextView.setText(data.getData()); // ��ȡ����Ŀ�ı�
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// ���¡��ǡ����o
		case R.id.yesButton:
		{
			data.setId(1); // ת�����ǡ������һ����Ŀ
			mTextView.setText(data.getData()); // ��ȡ��Ŀ�ı�
			break;
		}
		// ���¡��񡱰��o
		case R.id.noButton:
		{
			data.setId(0); // ת�����񡱺����һ����Ŀ
			mTextView.setText(data.getData()); // ��ȡ��Ŀ�ı�
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
			String disease = data.getData();

			// �ӷ�������ö�Ӧ�˲���ҩƷ��Ϣ�б�
			List<Medicine> medicals = AnologServer.getMedicals(disease);

			// ��������ɸѡ
			sift(medicals);
			
			// ��ʾ�Ƽ�ҩƷ
			String string = new String();
			if(medicals.isEmpty())
			{
				string+="��Ǹ��û���ҵ��ʺ�����ҩƷ��";
			}
			else
			{				
				for (Medicine medical : medicals)
				{
					string += medical.name + "\n";
				}
			}			
			mTextView.setText(string);
		}
		default:
			break;
		}

		// �ж���Ŀ�Ƿ����
		if ("".equals(data.getId()))
		{
			mYesButton.setVisibility(View.INVISIBLE); // ���ء��ǡ���ť
			mNoButton.setVisibility(View.INVISIBLE); // ���ء�����ť
			mReButton.setVisibility(View.VISIBLE); // ��ʾ�����²��ԡ���ť
			mPushButton.setVisibility(View.VISIBLE); // ��ʾ������ҩƷ����ť
		}

	}

	private List<Medicine> sift(List<Medicine> medicals)
	{
		HealthInfo healthInfo = HealthInfo.getHealthInfo();
		
		// ɸѡ		
		for(String taboo:healthInfo.taboos)
		{

			for (Medicine medical : medicals)
			{
				//���ݽ���
				if(medical.taboos.contains(taboo))
				{
					medicals.remove(medical);
					continue;
				}
				//����״̬ɸѡ
				if(medical.taboos.contains("�и�"))
				{
					medicals.remove(medical);
					continue;
				}
				//��������ɸѡ
				if (healthInfo.age <= 3)
				{
					// Ӥ��
					if(medical.taboos.contains("Ӥ��"))
					{
						medicals.remove(medical);
						continue;
					}
				} else if (healthInfo.age <= 12)
				{
					// ��ͯ
					if(medical.taboos.contains("��ͯ"))
					{
						medicals.remove(medical);
						continue;
					}
				} else if (healthInfo.age >= 60)
				{
					// ����
					if(medical.taboos.contains("����"))
					{
						medicals.remove(medical);
						continue;
					}
				} 
			}
		
		}
		return medicals;

	}

}
