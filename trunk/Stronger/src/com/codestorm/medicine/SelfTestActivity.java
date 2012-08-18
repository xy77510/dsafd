package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012/6/22
 * 	科室后的自测界面
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

	TextView mTextView; // 题目文本输出框
	Button mYesButton, mNoButton, mReButton, mPushButton; // “是”按钮事件与“否”按钮事件

	HashMap<String, QuestionInfo> questions;
	QuestionInfo questionInfo;

	HealthInfo healthInfo = HealthInfo.getHealthInfo();
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
		AnologServer.iniQuestion(this);
		questions = QuestionInfo.getQuestions();
		questionInfo = questions.get("0");
		mTextView.setText(questionInfo.question); // 获取根题目文本
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		// 按下“是”按鈕
		case R.id.yesButton:
		{
			questionInfo = questions.get(questionInfo.yesNext);
			mTextView.setText(questionInfo.question); // 获取题目文本
			break;
		}
		// 按下“否”按鈕
		case R.id.noButton:
		{
			questionInfo = questions.get(questionInfo.noNext); // 转到“否”后的下一个题目
			mTextView.setText(questionInfo.question); // 获取题目文本
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
			healthInfo.disease = questionInfo.question;

			// 从服务器获得对应此病的药品信息列表
			List<Medicine> medicals = AnologServer.getMedicals(this, healthInfo.disease);

			if (medicals.isEmpty())
			{
				Toast.makeText(this, "抱歉，没有找到适合您的药品！", Toast.LENGTH_LONG).show();
			} else
			{
				intent = new Intent();
				intent.setClass(this, PushMedicineActivity.class);
				startActivity(intent);
				this.finish();
			}

			//
			// // 本机智能筛选
			// // sift(medicals);
			//
			// // 显示推荐药品
			// String string = new String();
			// if (medicals.isEmpty())
			// {
			// string += "抱歉，没有找到适合您的药品！";
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

		// 判断题目是否结束
		if ("".equals(questionInfo.yesNext))
		{
			mYesButton.setVisibility(View.INVISIBLE); // 隐藏“是”按钮
			mNoButton.setVisibility(View.INVISIBLE); // 隐藏“按”钮
			mReButton.setVisibility(View.VISIBLE); // 显示“重新测试”按钮
			mPushButton.setVisibility(View.VISIBLE); // 显示“推送药品”按钮
		}

	}

	// private List<Medicine> sift(List<Medicine> medicals)
	// {
	// HealthInfo healthInfo = HealthInfo.getHealthInfo();
	//
	// // 筛选
	// for (String corporeity : healthInfo.corporeitysList)
	// {
	//
	// for (Medicine medical : medicals)
	// {
	// // 根据禁忌
	// if (medical.taboos.contains(corporeity))
	// {
	// medicals.remove(medical);
	// continue;
	// }
	// // 根据状态筛选
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
