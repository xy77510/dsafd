/**
 * 2012-6-20
 * 
 * ����
 * 
 * �û�������Ϣ
 * 
 * 
 * */

package com.codestorm.medicine.model;

import java.util.List;


public class HealthInfo
{	
	public String name;//����
	public float height;// ���cm
	public float weight;// ����Kg
	public int age;// ����
	public boolean sex;// �Ա�{��false Ůtrue}
	public int healthScore;// ����ָ��
	public boolean state;//״̬{�и�}
	public List<String> taboos;//����
	public int corporeity;//����
	
	private static HealthInfo healthInfo=null;
	
	//˽�й��캯������ֱֹ��ʵ��������
	private HealthInfo()
	{
		
	}
	
	//����Ψһ��ʵ��
	public static synchronized HealthInfo getHealthInfo()
	{
		if(healthInfo==null)
		{
			healthInfo=new HealthInfo();
		}			
		return healthInfo;
	}
	
}
