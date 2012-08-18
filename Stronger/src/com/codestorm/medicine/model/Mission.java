package com.codestorm.medicine.model;

/*
 * 	֣��
 * 	2012-7-21
 * 	������
 * 
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mission
{
	public static Mission mission; // ���ڼ�¼��ǰѡ�������
	public static HashMap<Integer, Mission> missionMap = new HashMap<Integer, Mission>();
	public static List<Mission> missionList=new ArrayList<Mission>();
	public int id;
	public String missiontitle; // �������
	public String missionstring; // ��������
	public String missiontag; // �����ǩ

	public Mission(int mi,String title, String ms, String mt)
	{ // ��������
		missiontitle = title;
		missionstring = ms;
		missiontag = mt;
		id = mi;
		missionMap.put(id, this);
	}

	public List<String> getTag()
	{ // �������ǩ��ֳ�list����
		List<String> ary = new ArrayList<String>();
		String[] strings = missiontag.split("|");
		for (String string : strings)
		{
			ary.add(string);
		}
		return ary;
	}

	public static void setMission(int i )
	{ // ѡ������
		mission = missionMap.get(i);
	}
}
