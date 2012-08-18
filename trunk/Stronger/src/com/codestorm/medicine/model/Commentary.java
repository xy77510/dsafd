package com.codestorm.medicine.model;

/*
 * 		郑泽
 * 		2012-7-27
 * 		评论类
 * 
 * */
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Commentary
{
	public static List<Commentary> commentaries = new ArrayList<Commentary>(); // 评论列表
	public static String commentriesname;
	public String userString; // 评论的用户名
	public String timeString; // 评论的时间
	public String textString; // 评论的内容

	public Commentary(String user, String text)
	{
		userString = user;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
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
