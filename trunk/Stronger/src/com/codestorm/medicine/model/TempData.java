package com.codestorm.medicine.model;

/*
 * 	֣��
 * 2012/6/25
 * ģ���õ��Բ���Ŀ��֮��ɾ��
 * */

public class TempData
{
	QuestionInfo questionInfo; // ��ǰ���Բ���Ŀ��

	// ���캯��������ģ����Ŀ��
	public TempData()
	{
		questionInfo = new QuestionInfo("0", "����", "1", "2");
		questionInfo = new QuestionInfo("1", "��ʹ", "3", "4");
		questionInfo = new QuestionInfo("2", "û��", "", "");
		questionInfo = new QuestionInfo("3", "�ضȸ�ð", "", "");
		questionInfo = new QuestionInfo("4", "�����Ը�ð", "", "");
		questionInfo = QuestionInfo.getQuestions().get("0"); // ����ǰ��Ŀָ������
	}

	public void setId(int x)
	{
		if (x == 1)
			questionInfo = QuestionInfo.getQuestions().get(questionInfo.yesNext); // ����ǰ��Ŀָ���ǡ�����Ŀ
		else
			questionInfo = QuestionInfo.getQuestions().get(questionInfo.noNext); // ����ǰ��Ŀָ�򡰷񡱵���Ŀ
	}

	public String getData()
	{
		return questionInfo.question; // ��ȡ��Ŀ�ı�
	}

	public String getId()
	{
		return questionInfo.yesNext; // ��ȡ��һ����Ŀ��id
	}
}
