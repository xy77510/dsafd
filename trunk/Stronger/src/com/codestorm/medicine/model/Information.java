package com.codestorm.medicine.model;

import java.util.HashMap;

public class Information
{
	public static HashMap<Integer, Information> informationMap = new HashMap<Integer, Information>();
	public static Information information;
	public int id;
	public String title;
	public String text;
	public String summary;

	public Information(int _id, String _title, String _text, String _summary)
	{
		id = _id;
		title = _title;
		text = _text;
		summary = _summary;
		informationMap.put(id, this);
	}

	public static void setInformation(int i)
	{
		information = informationMap.get(i);
	}
}
