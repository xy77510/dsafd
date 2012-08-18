package com.codestorm.medicine.model;

/*
 * 		֣��
 * 		2012-7-27
 * 		������
 * 
 * */
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Commentary
{
	public static List<Commentary> commentaries = new ArrayList<Commentary>(); // �����б�
	public static String commentriesname;
	public String userString; // ���۵��û���
	public String timeString; // ���۵�ʱ��
	public String textString; // ���۵�����

	public Commentary(String user, String text)
	{
		userString = user;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss ");
		Date curDate = new Date(System.currentTimeMillis());
		timeString = formatter.format(curDate);
		textString = text;
	}
	
	public Commentary(String user, String text,String time)
	{
		userString = user;		
		timeString = time;
		textString = text;
	}
}
