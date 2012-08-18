package com.codestorm.medicine.model;

/*
 * 	郑泽
 * 	2012-7-21
 * 	任务类
 * 
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mission
{
	public static Mission mission; // 用于记录当前选择的任务
	public static HashMap<Integer, Mission> missionMap = new HashMap<Integer, Mission>();
	public static List<Mission> missionList=new ArrayList<Mission>();
	public int id;
	public String missiontitle; // 任务标题
	public String missionstring; // 任务内容
	public String missiontag; // 任务标签

	public Mission(int mi,String title, String ms, String mt)
	{ // 构造任务
		missiontitle = title;
		missionstring = ms;
		missiontag = mt;
		id = mi;
		missionMap.put(id, this);
	}

	public List<String> getTag()
	{ // 将任务标签拆分成list返回
		List<String> ary = new ArrayList<String>();
		String[] strings = missiontag.split("|");
		for (String string : strings)
		{
			ary.add(string);
		}
		return ary;
	}

	public static void setMission(int i )
	{ // 选择任务
		mission = missionMap.get(i);
	}
}
