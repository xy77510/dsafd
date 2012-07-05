/**
 * 2012-6-22
 * 
 * 周坤
 * 
 * 问题的数据类
 * 
 * 
 * */
package com.codestorm.medicine.model;

import java.util.HashMap;


public class QuestionInfo
{
		public String questionID;//问题ID
		public String question;//问题文本
		public String yesNext;//“是”对应的下个内容
		public String noNext;//“否”对应的下个内容
		private static HashMap<String, QuestionInfo> questions=new HashMap<String, QuestionInfo>();
		
		//获取问题map
		public static HashMap<String, QuestionInfo> getQuestions()
		{
			return questions;
		}
		
		//构造函数，测试用，测试后删除
		public QuestionInfo(String ID,String question,String yes,String no)
		{
			questionID=ID;
			this.question=question;
			yesNext=yes;
			noNext=no;
			questions.put(questionID, this);			
		}
		
}
