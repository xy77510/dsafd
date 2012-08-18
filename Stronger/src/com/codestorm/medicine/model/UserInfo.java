/**
 * 2012-6-20
 * 
 * ����
 * 
 * �û��˻���Ϣ
 * 
 * 
 * */

package com.codestorm.medicine.model;

import java.io.Serializable;


public class UserInfo implements Serializable
{
	private static final long serialVersionUID = 7842127532109787107L;
	public String userName;//�û���
	public String userPassword;//����
	public String mail;//����
	private static UserInfo userInfo=null;
	
	//˽�й��캯������ֱֹ��ʵ��������
	private UserInfo()
	{
		// TODO Auto-generated constructor stub
		
	}
	//����Ψһ��ʵ��
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
