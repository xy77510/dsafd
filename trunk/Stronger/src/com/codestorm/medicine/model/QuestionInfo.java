/**
 * 2012-6-22
 * 
 * ����
 * 
 * �����������
 * 
 * 
 * */
package com.codestorm.medicine.model;

import java.util.HashMap;


public class QuestionInfo
{
		public String questionID;//����ID
		public String question;//�����ı�
		public String yesNext;//���ǡ���Ӧ���¸�����
		public String noNext;//���񡱶�Ӧ���¸�����
		private static HashMap<String, QuestionInfo> questions=new HashMap<String, QuestionInfo>();
		
		//��ȡ����map
		public static HashMap<String, QuestionInfo> getQuestions()
		{
			return questions;
		}
		
		//���캯���������ã����Ժ�ɾ��
		public QuestionInfo(String ID,String question,String yes,String no)
		{
			questionID=ID;
			this.question=question;
			yesNext=yes;
			noNext=no;
			questions.put(questionID, this);			
		}
		
}
