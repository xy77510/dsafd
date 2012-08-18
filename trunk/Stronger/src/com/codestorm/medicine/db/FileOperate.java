/**
 * 
 * 2012-7-25
 * 
 * 周坤
 * 
 * 文件读写类，主要是对账户信息和用户信息进行读写。
 * 
 * 2012-7-25
 * 
 * 郑泽
 * 
 * 修改
 * */
package com.codestorm.medicine.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.content.Context;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.UserInfo;

public class FileOperate
{

	// TODO:读取账户信息
	public static boolean readUser(Context context)
	{
		try
		{
			FileInputStream file = context.openFileInput("userinfo.dat");
			ObjectInputStream in = new ObjectInputStream(file);
			UserInfo.setUserInfo((UserInfo) in.readObject());
			in.close();
			return true;
		} catch (Exception e)
		{

			return false;
		}

	}

	// TODO:写入账户信息
	public static boolean writeUser(Context context)
	{
		try
		{
			FileOutputStream file = context.openFileOutput("userinfo.dat", Context.MODE_PRIVATE);
			ObjectOutputStream out = new ObjectOutputStream(file);
			if (UserInfo.getUserInfo() == null)
				return false; // 前提条件
			out.writeObject(UserInfo.getUserInfo());
			out.flush();
			out.close();
			return true; // 读取成功
		} catch (Exception e)
		{ // 读取失败
			e.printStackTrace();
			return false;
		}
	}

	// TODO:读取用户信息
	public static boolean readHealthInfo(Context context)
	{
		try
		{
			FileInputStream file = context.openFileInput("healthinfo.dat");
			ObjectInputStream in = new ObjectInputStream(file);
			HealthInfo.setHealthInfo((HealthInfo) in.readObject());
			in.close();
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	// TODO:写入用户信息
	public static boolean writeHealthInfo(Context context)
	{
		try
		{
			FileOutputStream file = context.openFileOutput("healthinfo.dat", Context.MODE_PRIVATE);
			ObjectOutputStream out = new ObjectOutputStream(file);
			HealthInfo healthInfo = HealthInfo.getHealthInfo();
			if (healthInfo == null)
				return false; // 前提条件
			out.writeObject(healthInfo);
			out.flush();
			out.close();
			return true; // 成功
		} catch (Exception e)
		{ // 失败
			e.printStackTrace();
			return false;
		}
	}

	// TODO:写入软件设置
	public static boolean writeOption(Context context, String s)
	{
		try
		{
			FileOutputStream file = context.openFileOutput("option.dat", Context.MODE_PRIVATE);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeUTF(s);
			out.flush();
			out.close();
			return true;
		} catch (Exception e)
		{
			// 写入失败
			e.printStackTrace();
			return false;
		}
	}

	// TODO:读取软件设置
	public static String[] readOption(Context context)
	{
		try
		{
			FileInputStream fileInputStream = context.openFileInput("option.dat");
			ObjectInputStream in = new ObjectInputStream(fileInputStream);
			String s = in.readUTF();
			in.close();
			return s.split("\\|");
		} catch (Exception e)
		{
			// TODO: handle exception
			return null;
		}

	}
}
