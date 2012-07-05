package com.codestorm.medicine.model;

/*
 * 	郑泽
 * 2012/6/25
 * 模拟用的自测题目，之后删除
 * */

public class TempData
{
	QuestionInfo questionInfo; // 当前的自测题目类

	// 构造函数，生成模拟题目树
	public TempData()
	{
		questionInfo = new QuestionInfo("0", "发热", "1", "2");
		questionInfo = new QuestionInfo("1", "酸痛", "3", "4");
		questionInfo = new QuestionInfo("2", "没事", "", "");
		questionInfo = new QuestionInfo("3", "重度感冒", "", "");
		questionInfo = new QuestionInfo("4", "病毒性感冒", "", "");
		questionInfo = QuestionInfo.getQuestions().get("0"); // 将当前题目指向树根
	}

	public void setId(int x)
	{
		if (x == 1)
			questionInfo = QuestionInfo.getQuestions().get(questionInfo.yesNext); // 将当前题目指向“是”的题目
		else
			questionInfo = QuestionInfo.getQuestions().get(questionInfo.noNext); // 将当前题目指向“否”的题目
	}

	public String getData()
	{
		return questionInfo.question; // 获取题目文本
	}

	public String getId()
	{
		return questionInfo.yesNext; // 获取下一个题目的id
	}
}
