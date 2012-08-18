/**
 * 2012-6-20
 * 
 * ����
 * 
 * �û�������Ϣ
 * 
 * �޸�
 * 2012-7-10
 * 
 * ֣��
 * 
 *
 * */

package com.codestorm.medicine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

enum Corporeity
{ // ��������
	ƽ����, ������, ������, ������, ʪ����, ������, ̵ʪ��, Ѫ����, ������
};

enum Age
{ // ���������
	��ͯ, ����, ������, �и�
};

public class HealthInfo implements Serializable
{
	public String name;// ����
	public float height;// ���cm
	public float weight;// ����Kg
	public Age age; // ����
	public boolean sex; // �Ա�{��false Ůtrue}
	public int healthScore; // ����ָ��
	// public List<String> taboos; // ����
	public Corporeity corporeity; // ��ҽ����
	private static HealthInfo healthInfo = null;

	public List<String> corporeitysList;// ��������(ɸѡ����)
	public List<String> medicalHistory;// ��ʷ
	public List<String> mycommentary;
	public String disease;//

	// ˽�й��캯������ֱֹ��ʵ��������
	private HealthInfo()
	{

	}

	// ����Ψһ��ʵ��
	public static synchronized HealthInfo getHealthInfo()
	{
		if (healthInfo == null)
		{
			healthInfo = new HealthInfo();
			healthInfo.corporeitysList = new ArrayList<String>();
			healthInfo.medicalHistory = new ArrayList<String>();
			healthInfo.mycommentary = new ArrayList<String>();
			healthInfo.weight = -1; // ���û���һ�ε�½ʱ��ʼ�������������Ϊ-1,�ж���
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
	{ // �����������
		if (this != null)
			return corporeity.toString();
		return "����"; // ��Ӧ�÷������
	}

	public boolean firstLogin()
	{
		if (healthInfo != null)
		{ // ǰ������
			if (weight == -1 || height == -1) // �ж��Ƿ��һ������
				return true;
		}
		return false;
	}

	public void setAge(int i)
	{ // �趨�����
		if (this != null)
			switch (i)
			{
			case 0:
				age = Age.��ͯ;
				break;
			case 1:
				age = Age.����;
				break;
			case 2:
				age = Age.������;
				break;
			case 3:
				age = Age.�и�;
				break;
			default:
				break;
			}
	}

	public void setSex(int i)
	{ // �趨�Ա�
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
	{ // ������ �����㷨
		if (this != null)
		{
			if (score < 40.0)
				corporeity = Corporeity.ƽ����;
			else if (score < 80.0)
				corporeity = Corporeity.������;
			else if (score < 120.0)
				corporeity = Corporeity.������;
			else if (score < 160.0)
				corporeity = Corporeity.ʪ����;
			else if (score < 200.0)
				corporeity = Corporeity.������;
			else if (score < 240.0)
				corporeity = Corporeity.̵ʪ��;
			else if (score < 280.0)
				corporeity = Corporeity.Ѫ����;
			else if (score < 300.0)
				corporeity = Corporeity.������;
			else
				corporeity = Corporeity.������;
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
