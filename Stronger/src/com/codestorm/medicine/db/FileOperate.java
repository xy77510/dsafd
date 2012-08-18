/**
 * 
 * 2012-7-25
 * 
 * ����
 * 
 * �ļ���д�࣬��Ҫ�Ƕ��˻���Ϣ���û���Ϣ���ж�д��
 * 
 * 2012-7-25
 * 
 * ֣��
 * 
 * �޸�
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

	// TODO:��ȡ�˻���Ϣ
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

	// TODO:д���˻���Ϣ
	public static boolean writeUser(Context context)
	{
		try
		{
			FileOutputStream file = context.openFileOutput("userinfo.dat", Context.MODE_PRIVATE);
			ObjectOutputStream out = new ObjectOutputStream(file);
			if (UserInfo.getUserInfo() == null)
				return false; // ǰ������
			out.writeObject(UserInfo.getUserInfo());
			out.flush();
			out.close();
			return true; // ��ȡ�ɹ�
		} catch (Exception e)
		{ // ��ȡʧ��
			e.printStackTrace();
			return false;
		}
	}

	// TODO:��ȡ�û���Ϣ
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

	// TODO:д���û���Ϣ
	public static boolean writeHealthInfo(Context context)
	{
		try
		{
			FileOutputStream file = context.openFileOutput("healthinfo.dat", Context.MODE_PRIVATE);
			ObjectOutputStream out = new ObjectOutputStream(file);
			HealthInfo healthInfo = HealthInfo.getHealthInfo();
			if (healthInfo == null)
				return false; // ǰ������
			out.writeObject(healthInfo);
			out.flush();
			out.close();
			return true; // �ɹ�
		} catch (Exception e)
		{ // ʧ��
			e.printStackTrace();
			return false;
		}
	}

	// TODO:д���������
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
			// д��ʧ��
			e.printStackTrace();
			return false;
		}
	}

	// TODO:��ȡ�������
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
