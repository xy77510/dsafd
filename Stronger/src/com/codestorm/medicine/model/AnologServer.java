/**
 * 
 * 2012-6-26
 * 
 * 周坤
 * 
 * 所有的服务器模拟接口
 * 
 * */

package com.codestorm.medicine.model;

import java.util.ArrayList;
import java.util.List;

public class AnologServer
{
	//TODO:获取对应病症的药单
	public static List<Medicine> getMedicals(String disease)
	{
		List<Medicine> medicals=new ArrayList<Medicine>();
		//TODO:初始化药单
		if(disease.equals("重度感冒"))
		{
			medicals.add(new Medicine("白加黑", "H10940250", "", "重度感冒", "肝肾功能不全|妊娠期|哺乳期","第一厂商","无促销"));
		}else if(disease.equals("流行感冒"))
		{
			medicals.add(new Medicine("板蓝根", "Z44022368", "", "流行感冒", "高血压|心脏病|肝病|糖尿病|肾病|孕妇","第二厂商","无促销"));
		}
		return medicals;
	}
	
	//TODO:登录从服务器获取信息
	public static boolean login()
	{
		HealthInfo healthInfo=HealthInfo.getHealthInfo();
		healthInfo.name="马慧君";
		healthInfo.height=171;
		healthInfo.weight=56;
		healthInfo.age=20;
		healthInfo.sex=false;
		healthInfo.healthScore=1;
		healthInfo.corporeity=0;
		healthInfo.state=false;
		healthInfo.taboos=new ArrayList<String>();
		return true;
	}
	
	//TODO:从服务器获取药品的评论信息
	public static List<CommentInfo> getComments(String medicine)
	{
		List<CommentInfo>comments=new ArrayList<CommentInfo>();
		if(medicine.equals(""))
		{}
			comments.add(new CommentInfo("aaa","好好好好好"));
			comments.add(new CommentInfo("bbb", "好好好好好好"));
			return comments;
	}
	
	
}
