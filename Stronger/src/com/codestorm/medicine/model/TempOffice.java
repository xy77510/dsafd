package com.codestorm.medicine.model;

/*
 * 	֣��
 * 	2012/12/27
 *	ģ���ÿ����б�
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
		Office office = new Office("���Ǻ��");
		offices.add(office);
		office = new Office("�����ڿ�");
		offices.add(office);
		tempoffices.put("����", offices);
		offices = new ArrayList<Office>();
		office = new Office("���Ǻ��");
		offices.add(office);
		office = new Office("�����ڿ�");
		offices.add(office);
		office = new Office("��θ��");
		offices.add(office);
		tempoffices.put("ȫ��", offices);

	}

	public HashMap<String, List<Office>> getHashMap()
	{
		return tempoffices;
	}
}
