/**
 * 2012-6-20
 * 
 * 周坤
 * 
 * 用户账户信息
 * 
 * 
 * */

package com.codestorm.medicine.model;

import java.io.Serializable;


public class UserInfo implements Serializable
{
	private static final long serialVersionUID = 7842127532109787107L;
	public String userName;//用户名
	public String userPassword;//密码
	public String mail;//邮箱
	private static UserInfo userInfo=null;
	
	//私有构造函数，禁止直接实例化对象
	private UserInfo()
	{
		// TODO Auto-generated constructor stub
		
	}
	//返回唯一的实例
	public static synchronized  UserInfo getUserInfo()
	{
		if(userInfo==null)
		{
			userInfo=new UserInfo();
		}
		return userInfo;
	}
	public static synchronized void setUserInfo(UserInfo ui){
		if(ui!=null)
			userInfo=ui;
	}
}
