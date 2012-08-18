/**
 * 
 * 2012-6-26
 * 
 * ����
 * 
 * ���еķ�����ģ��ӿ�
 * 
 * */

package com.codestorm.medicine.server;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.codestorm.medicine.db.DataManage;
import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.Commentary;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.Information;
import com.codestorm.medicine.model.Medicine;
import com.codestorm.medicine.model.Mission;
import com.codestorm.medicine.model.QuestionInfo;
import com.codestorm.medicine.model.UserInfo;

public class AnologServer
{
	// TODO:��¼�ӷ�������ȡ��Ϣ
	public static boolean login(String mail, String password)
	{
		UserInfo userInfo = UserInfo.getUserInfo();
		// ��֤����
		if (!(mail.equals(userInfo.userName) && password.equals(userInfo.userPassword)))
		{
			return false;
		}
		return true;
	}

	// TODO:��ȡ����
	public static void getTasks(Context context)
	{
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getTask();
		while (cursor.moveToNext())
		{
			Mission mission = new Mission(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
			Mission.missionList.add(mission);
		}
	}

	// TODO:��ȡ��Ѷ
	public static List<Information> getNews(Context context)
	{
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getNews();
		Information information;
		List<Information> informations = new ArrayList<Information>();
		while (cursor.moveToNext())
		{
			information = new Information(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
			informations.add(information);
		}
		return informations;
	}

	// // TODO:��ȡ�������
	// public static ��������model getService()
	// {
	//
	// }

	// ��ȡҩ��
	public static List<Medicine> getMedicals(Context context, String disease)
	{
		List<Medicine> medicals = new ArrayList<Medicine>();
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getProduct();
		while (cursor.moveToNext())
		{
			String name, introduction, diseases, taboos, manufacturer, promotion;
			int id = cursor.getInt(0);
			name = cursor.getString(1);
			introduction = cursor.getString(2);
			diseases = cursor.getString(3);
			taboos = cursor.getString(4);
			manufacturer = cursor.getString(5);
			promotion = cursor.getString(6);
			if (diseases.contains(disease))
			{
				medicals.add(new Medicine(name, id, introduction, diseases, taboos, manufacturer, promotion));
			}
		}
		return medicals;
	}

	// ��ȡ���͵�ҩƷ
	public static List<Medicine> getMyMedicals(Context context)
	{
		List<Medicine> medicals = new ArrayList<Medicine>();
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getProduct();
		while (cursor.moveToNext())
		{
			String name, introduction, diseases, taboos, manufacturer, promotion;
			int id = cursor.getInt(0);
			name = cursor.getString(1);
			introduction = cursor.getString(2);
			diseases = cursor.getString(3);
			taboos = cursor.getString(4);
			manufacturer = cursor.getString(5);
			promotion = cursor.getString(6);
			medicals.add(new Medicine(name, id, introduction, diseases, taboos, manufacturer, promotion));
		}
		return medicals;
	}

	// TODO:��ʼ������
	public static void iniQuestion(Context context)
	{
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getQuestion();
		while (cursor.moveToNext())
		{
			QuestionInfo questionInfo = new QuestionInfo(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
		}
	}

	// ��ȡ����
	public static void getCommentary(Context context, String medicine)
	{
		DataManage dataManage = DataManage.getDataManage(context);
		Cursor cursor = dataManage.getCommentary(medicine);
		Commentary.commentaries.clear();
		while (cursor.moveToNext())
		{
			Commentary commentary = new Commentary(cursor.getString(1), cursor.getString(2), cursor.getString(4));
			Commentary.commentaries.add(commentary);
		}
	}

	// ��������
	public static boolean insertCommentary(Context context, String user, String text, String product)
	{
		DataManage dataManage = DataManage.getDataManage(context);
		return dataManage.insertCommentary(user, text, product);
	}
}
