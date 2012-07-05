/**
 * 2012-6-20
 * 
 * 周坤
 * 
 * 用户健康信息
 * 
 * 
 * */

package com.codestorm.medicine.model;

import java.util.List;


public class HealthInfo
{	
	public String name;//姓名
	public float height;// 身高cm
	public float weight;// 体重Kg
	public int age;// 年龄
	public boolean sex;// 性别{男false 女true}
	public int healthScore;// 健康指数
	public boolean state;//状态{孕妇}
	public List<String> taboos;//禁忌
	public int corporeity;//体质
	
	private static HealthInfo healthInfo=null;
	
	//私有构造函数，禁止直接实例化对象
	private HealthInfo()
	{
		
	}
	
	//返回唯一的实例
	public static synchronized HealthInfo getHealthInfo()
	{
		if(healthInfo==null)
		{
			healthInfo=new HealthInfo();
		}			
		return healthInfo;
	}
	
}
