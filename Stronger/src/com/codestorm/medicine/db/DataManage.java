/**
 * 
 * 2012-7-25
 * 
 * ����
 * 
 * ���ݹ�����
 * 
 * 
 * */
package com.codestorm.medicine.db;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataManage
{
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;
	private Context context;

	public static DataManage dataManage = null;

	private DataManage(Context context)
	{
		this.context = context;
		databaseHelper = new DatabaseHelper(context, "data.db", null, 1);
		db = databaseHelper.getReadableDatabase();
	}

	public static DataManage getDataManage(Context context)
	{
		if (dataManage == null)
		{
			dataManage = new DataManage(context);
		}
		return dataManage;
	}

	// �޸��˻���Ϣ
	public void changeUserInfo()
	{
		FileOperate.writeUser(context);
	}

	// �޸��û�������Ϣ
	public void changeHealthInfo()
	{
		FileOperate.writeHealthInfo(context);
	}

	// ��ȡ�˻���Ϣ
	public void getUserInfo()
	{
		FileOperate.readUser(context);
	}

	// ��ȡ�û���Ϣ
	public void getHealthInfo()
	{
		FileOperate.readHealthInfo(context);
	}

	// ��ȡ����
	public Cursor getTask()
	{
		String sqlString = "select * from task_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��ȡ��Ѷ
	public Cursor getNews()
	{
		String sqlString = "select * from news_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��ȡ�������
	public Cursor getService()
	{
		String sqlString = "select * from service_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��ȡ��Ʒ
	public Cursor getProduct()
	{
		String sqlString = "select * from product_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��ȡ����
	public Cursor getQuestion()
	{
		String sqlString = "select * from question_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��ȡ����
	public Cursor getCommentary(String product)
	{
		String sqlString = "select * from commentary_list where product='" + product + "'";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// ��������
	public boolean insertCommentary(String user, String text, String product)
	{
		ContentValues contentValues = new ContentValues();
		contentValues.put("user", user);
		contentValues.put("text", text);
		contentValues.put("product", product);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss ");
		Date curDate = new Date(System.currentTimeMillis());
		String time = formatter.format(curDate);
		contentValues.put("time", time);
		db.insert("commentary_list", null, contentValues);
		return true;
	}

	// �ر����ݿ�
	public void closeDB()
	{
		db.close();
		databaseHelper.close();
	}

}
