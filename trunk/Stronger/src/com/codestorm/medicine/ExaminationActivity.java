/**
 * 
 * 2012-6-21
 * 
 * 周坤
 * 
 * 体检页面
 * 
 * 2012-7-10
 * 
 * 郑泽（修改）
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
			// 提交体检数据

			if ("".equals(mHeightEditText.getText().toString()) || "".equals(mWeightEditText.getText().toString())) // 判断用户名与密码是否为空
			{
				Toast.makeText(this, "请输入身高和体重！", Toast.LENGTH_LONG).show();
			} else
			{
				// TODO:提交体检数据并显示到界面
				healthInfo.height = Float.valueOf(mHeightEditText.getText().toString());
				healthInfo.weight = Float.valueOf(mWeightEditText.getText().toString());
				int index = countHealthScore();
				String hint = new String();
				switch (index)
				{
				case 0:
					hint = "过轻";
					if (!healthInfo.corporeitysList.contains("瘦"))
						healthInfo.corporeitysList.add("瘦");
					break;
				case 1:
					hint = "理想体重";
					if (!healthInfo.corporeitysList.contains("标准"))
						healthInfo.corporeitysList.add("标准");
					break;
				case 2:
					hint = "过重";
					if (!healthInfo.corporeitysList.contains("肥胖"))
						healthInfo.corporeitysList.add("肥胖");
					break;
				case 3:
					hint = "肥胖（第一度）";
					if (!healthInfo.corporeitysList.contains("肥胖"))
						healthInfo.corporeitysList.add("肥胖");
					break;
				case 4:
					hint = "肥胖（第二度）";
					if (!healthInfo.corporeitysList.contains("肥胖"))
						healthInfo.corporeitysList.add("肥胖");
					break;
				case 5:
					hint = "肥胖（第三度）";
					if (!healthInfo.corporeitysList.contains("肥胖"))
						healthInfo.corporeitysList.add("肥胖");
					break;
				default:
					break;
				}
				// NumberFormat numberFormat = new DecimalFormat("###.0");
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				final Context context = this;
				builder.setMessage("您的体型：" + hint + "!");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
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
			// 取消体检
			this.finish();
			break;

		default:
			break;
		}
	}

	// 获得健康指数
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
