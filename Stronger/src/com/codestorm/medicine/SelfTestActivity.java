package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012/6/22
 * 	科室后的自测界面
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

	TextView mTextView; // 题目文本输出框
	Button mYesButton, mNoButton, mReButton, mPushButton; // “是”按钮事件与“否”按钮事件
	TempData data = new TempData(); // 生成模拟题目
	// TempMedical medical = new TempMedical(); // 生成模擬藥品列表
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
		mTextView.setText(data.getData()); // 获取根题目文本
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// 按下“是”按鈕
		case R.id.yesButton:
		{
			data.setId(1); // 转到“是”后的下一个题目
			mTextView.setText(data.getData()); // 获取题目文本
			break;
		}
		// 按下“否”按鈕
		case R.id.noButton:
		{
			data.setId(0); // 转到“否”后的下一个题目
			mTextView.setText(data.getData()); // 获取题目文本
			break;
		}
		// 按下“重新測試”按鈕
		case R.id.reTestButton:
		{
			intent = new Intent();
			intent.setClass(this, SelfTestActivity.class);
			startActivity(intent);
			finish();
			break;
		}
		// 按下“推送藥品”按鈕
		case R.id.pushButton:
		{
			// TODO:推送服务

			// 获取病的名称
			String disease = data.getData();

			// 从服务器获得对应此病的药品信息列表
			List<Medicine> medicals = AnologServer.getMedicals(disease);

			// 本机智能筛选
			sift(medicals);
			
			// 显示推荐药品
			String string = new String();
			if(medicals.isEmpty())
			{
				string+="抱歉，没有找到适合您的药品！";
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

		// 判断题目是否结束
		if ("".equals(data.getId()))
		{
			mYesButton.setVisibility(View.INVISIBLE); // 隐藏“是”按钮
			mNoButton.setVisibility(View.INVISIBLE); // 隐藏“按”钮
			mReButton.setVisibility(View.VISIBLE); // 显示“重新测试”按钮
			mPushButton.setVisibility(View.VISIBLE); // 显示“推送药品”按钮
		}

	}

	private List<Medicine> sift(List<Medicine> medicals)
	{
		HealthInfo healthInfo = HealthInfo.getHealthInfo();
		
		// 筛选		
		for(String taboo:healthInfo.taboos)
		{

			for (Medicine medical : medicals)
			{
				//根据禁忌
				if(medical.taboos.contains(taboo))
				{
					medicals.remove(medical);
					continue;
				}
				//根据状态筛选
				if(medical.taboos.contains("孕妇"))
				{
					medicals.remove(medical);
					continue;
				}
				//根据年龄筛选
				if (healthInfo.age <= 3)
				{
					// 婴儿
					if(medical.taboos.contains("婴儿"))
					{
						medicals.remove(medical);
						continue;
					}
				} else if (healthInfo.age <= 12)
				{
					// 儿童
					if(medical.taboos.contains("儿童"))
					{
						medicals.remove(medical);
						continue;
					}
				} else if (healthInfo.age >= 60)
				{
					// 老年
					if(medical.taboos.contains("老年"))
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
