/**
 * 
 * 2012-6-21
 * 
 * ����
 * 
 * ���ҳ��
 * 
 * 2012-7-10
 * 
 * ֣���޸ģ�
 * */
package com.codestorm.medicine;

import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.HealthInfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExaminationActivity extends Activity implements OnClickListener
{
	Button mSubmitButton;
	Button mCancelButton;
	EditText mHeightEditText;
	EditText mWeightEditText;
	HealthInfo healthInfo;
	Intent intent = new Intent();

	private boolean judge;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.examination);
		mSubmitButton = (Button) findViewById(R.id.submitButton);
		mSubmitButton.setOnClickListener(this);
		mCancelButton = (Button) findViewById(R.id.cancelButton);
		mCancelButton.setOnClickListener(this);
		mHeightEditText = (EditText) findViewById(R.id.heighEditText);
		mWeightEditText = (EditText) findViewById(R.id.weithtEditText);
		healthInfo = HealthInfo.getHealthInfo();
		if (healthInfo.firstLogin())
		{
			judge = true;
		} else
		{
			judge = false;
		}
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.submitButton:
			// �ύ�������

			if ("".equals(mHeightEditText.getText().toString()) || "".equals(mWeightEditText.getText().toString())) // �ж��û����������Ƿ�Ϊ��
			{
				Toast.makeText(this, "��������ߺ����أ�", Toast.LENGTH_LONG).show();
			} else
			{
				// TODO:�ύ������ݲ���ʾ������
				healthInfo.height = Float.valueOf(mHeightEditText.getText().toString());
				healthInfo.weight = Float.valueOf(mWeightEditText.getText().toString());
				int index = countHealthScore();
				String hint = new String();
				switch (index)
				{
				case 0:
					hint = "����";
					if (!healthInfo.corporeitysList.contains("��"))
						healthInfo.corporeitysList.add("��");
					break;
				case 1:
					hint = "��������";
					if (!healthInfo.corporeitysList.contains("��׼"))
						healthInfo.corporeitysList.add("��׼");
					break;
				case 2:
					hint = "����";
					if (!healthInfo.corporeitysList.contains("����"))
						healthInfo.corporeitysList.add("����");
					break;
				case 3:
					hint = "���֣���һ�ȣ�";
					if (!healthInfo.corporeitysList.contains("����"))
						healthInfo.corporeitysList.add("����");
					break;
				case 4:
					hint = "���֣��ڶ��ȣ�";
					if (!healthInfo.corporeitysList.contains("����"))
						healthInfo.corporeitysList.add("����");
					break;
				case 5:
					hint = "���֣������ȣ�";
					if (!healthInfo.corporeitysList.contains("����"))
						healthInfo.corporeitysList.add("����");
					break;
				default:
					break;
				}
				// NumberFormat numberFormat = new DecimalFormat("###.0");
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				final Context context = this;
				builder.setMessage("�������ͣ�" + hint + "!");
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener()
				{

					public void onClick(DialogInterface dialog, int which)
					{
						dialog.cancel();
						FileOperate.writeHealthInfo(ExaminationActivity.this);
						if (judge)
						{
							intent.setClass(context, PersonCenter.class);
							startActivity(intent);
						}
						ExaminationActivity.this.finish();
					}
				});
				AlertDialog alertDialog = builder.create();
				alertDialog.show();
			}

			break;
		case R.id.cancelButton:
			// ȡ�����
			this.finish();
			break;

		default:
			break;
		}
	}

	// ��ý���ָ��
	private int countHealthScore()
	{
		float healthScore = healthInfo.weight / (float) Math.pow(healthInfo.height / 100, 2);
		if (healthScore < 18.5)
		{
			healthInfo.healthScore = 0;
			return 0;
		} else if (healthScore < 23)
		{
			healthInfo.healthScore = 1;
			return 1;
		} else if (healthScore < 25)
		{
			healthInfo.healthScore = 2;
			return 2;
		} else if (healthScore < 30)
		{
			healthInfo.healthScore = 3;
			return 3;
		} else if (healthScore < 35)
		{
			healthInfo.healthScore = 4;
			return 4;
		} else
		{
			healthInfo.healthScore = 5;
			return 5;
		}
	}

}
