/**
 * 2012-6-20
 * 
 * 周坤
 * 
 * 用户健康信息
 * 
 * 修改
 * 2012-7-10
 * 
 * 郑泽
 * 
 *
 * */

package com.codestorm.medicine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

enum Corporeity
{ // 体质类型
	平和型, 气虚型, 阴虚型, 阳虚型, 湿热型, 气郁型, 痰湿型, 血瘀型, 特禀型
};

enum Age
{ // 年龄层类型
	儿童, 中年, 老年人, 孕妇
};

public class HealthInfo implements Serializable
{
	public String name;// 姓名
	public float height;// 身高cm
	public float weight;// 体重Kg
	public Age age; // 年龄
	public boolean sex; // 性别{男false 女true}
	public int healthScore; // 健康指数
	// public List<String> taboos; // 禁忌
	public Corporeity corporeity; // 中医体质
	private static HealthInfo healthInfo = null;

	public List<String> corporeitysList;// 不良体质(筛选条件)
	public List<String> medicalHistory;// 病史
	public List<String> mycommentary;
	public String disease;//

	// 私有构造函数，禁止直接实例化对象
	private HealthInfo()
	{

	}

	// 返回唯一的实例
	public static synchronized HealthInfo getHealthInfo()
	{
		if (healthInfo == null)
		{
			healthInfo = new HealthInfo();
			healthInfo.corporeitysList = new ArrayList<String>();
			healthInfo.medicalHistory = new ArrayList<String>();
			healthInfo.mycommentary = new ArrayList<String>();
			healthInfo.weight = -1; // 该用户第一次登陆时初始化身高体重数据为-1,判断用
			healthInfo.height = -1;
		}
		return healthInfo;
	}

	public static synchronized void setHealthInfo(HealthInfo hi)
	{
		if (hi != null)
		{
			healthInfo = hi;
		}
	}

	public String getCorporeity()
	{ // 返回体质情况
		if (this != null)
			return corporeity.toString();
		return "错误！"; // 不应该返回这个
	}

	public boolean firstLogin()
	{
		if (healthInfo != null)
		{ // 前置条件
			if (weight == -1 || height == -1) // 判断是否第一次运行
				return true;
		}
		return false;
	}

	public void setAge(int i)
	{ // 设定年龄层
		if (this != null)
			switch (i)
			{
			case 0:
				age = Age.儿童;
				break;
			case 1:
				age = Age.中年;
				break;
			case 2:
				age = Age.老年人;
				break;
			case 3:
				age = Age.孕妇;
				break;
			default:
				break;
			}
	}

	public void setSex(int i)
	{ // 设定性别
		if (this != null)
			switch (i)
			{
			case 0:
				sex = false;
				break;
			case 1:
				sex = true;
				break;
			default:
				break;
			}
	}

	public void setCorporeity(float score)
	{ // 测试用 体质算法
		if (this != null)
		{
			if (score < 40.0)
				corporeity = Corporeity.平和型;
			else if (score < 80.0)
				corporeity = Corporeity.气虚型;
			else if (score < 120.0)
				corporeity = Corporeity.气郁型;
			else if (score < 160.0)
				corporeity = Corporeity.湿热型;
			else if (score < 200.0)
				corporeity = Corporeity.特禀型;
			else if (score < 240.0)
				corporeity = Corporeity.痰湿型;
			else if (score < 280.0)
				corporeity = Corporeity.血瘀型;
			else if (score < 300.0)
				corporeity = Corporeity.阳虚型;
			else
				corporeity = Corporeity.阴虚型;
		}
	}

	public int getAge()
	{
		return age.ordinal();
	}

	public int getSex()
	{
		if (sex == false)
			return 0;
		return 1;
	}
}
