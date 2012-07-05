/**
 * 
 * 2012-6-27
 * 
 * 周坤
 * 
 * 评论信息数据类
 * 
 * 
 * */
package com.codestorm.medicine.model;


public class CommentInfo
{
		public String user;//用户
		public String text;//评论内容
		
		public CommentInfo(String name,String comment)
		{
			user=name;
			text=comment;
		}
}
