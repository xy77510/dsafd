/**
 * 
 * 2012-7-25
 * 
 * 周坤
 * 
 * 数据管理类
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

	// 修改账户信息
	public void changeUserInfo()
	{
		FileOperate.writeUser(context);
	}

	// 修改用户健康信息
	public void changeHealthInfo()
	{
		FileOperate.writeHealthInfo(context);
	}

	// 获取账户信息
	public void getUserInfo()
	{
		FileOperate.readUser(context);
	}

	// 获取用户信息
	public void getHealthInfo()
	{
		FileOperate.readHealthInfo(context);
	}

	// 获取任务
	public Cursor getTask()
	{
		String sqlString = "select * from task_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 获取资讯
	public Cursor getNews()
	{
		String sqlString = "select * from news_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 获取生活服务
	public Cursor getService()
	{
		String sqlString = "select * from service_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 获取产品
	public Cursor getProduct()
	{
		String sqlString = "select * from product_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 获取问题
	public Cursor getQuestion()
	{
		String sqlString = "select * from question_list";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 获取评论
	public Cursor getCommentary(String product)
	{
		String sqlString = "select * from commentary_list where product='" + product + "'";
		Cursor cursor = db.rawQuery(sqlString, null);
		return cursor;
	}

	// 插入评论
	public boolean insertCommentary(String user, String text, String product)
	{
		ContentValues contentValues = new ContentValues();
		contentValues.put("user", user);
		contentValues.put("text", text);
		contentValues.put("product", product);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
		Date curDate = new Date(System.currentTimeMillis());
		String time = formatter.format(curDate);
		contentValues.put("time", time);
		db.insert("commentary_list", null, contentValues);
		return true;
	}

	// 关闭数据库
	public void closeDB()
	{
		db.close();
		databaseHelper.close();
	}

}
