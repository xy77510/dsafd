package com.codestorm.medicine.model;

/*
 * 	郑泽
 * 	2012/12/27
 *	模拟用科室列表
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TempOffice
{
	HashMap<String, List<Office>> tempoffices;

	public TempOffice()
	{
		tempoffices = new HashMap<String, List<Office>>();
		List<Office> offices = new ArrayList<Office>();
		Office office = new Office("耳鼻喉科");
		offices.add(office);
		office = new Office("呼吸内科");
		offices.add(office);
		tempoffices.put("鼻子", offices);
		offices = new ArrayList<Office>();
		office = new Office("耳鼻喉科");
		offices.add(office);
		office = new Office("呼吸内科");
		offices.add(office);
		office = new Office("肠胃科");
		offices.add(office);
		tempoffices.put("全部", offices);

	}

	public HashMap<String, List<Office>> getHashMap()
	{
		return tempoffices;
	}
}
