/**
 * 
 * 2012-6-26
 * 
 * ����
 * 
 * ���еķ�����ģ��ӿ�
 * 
 * */

package com.codestorm.medicine.model;

import java.util.ArrayList;
import java.util.List;

public class AnologServer
{
	//TODO:��ȡ��Ӧ��֢��ҩ��
	public static List<Medicine> getMedicals(String disease)
	{
		List<Medicine> medicals=new ArrayList<Medicine>();
		//TODO:��ʼ��ҩ��
		if(disease.equals("�ضȸ�ð"))
		{
			medicals.add(new Medicine("�׼Ӻ�", "H10940250", "", "�ضȸ�ð", "�������ܲ�ȫ|������|������","��һ����","�޴���"));
		}else if(disease.equals("���и�ð"))
		{
			medicals.add(new Medicine("������", "Z44022368", "", "���и�ð", "��Ѫѹ|���ಡ|�β�|����|����|�и�","�ڶ�����","�޴���"));
		}
		return medicals;
	}
	
	//TODO:��¼�ӷ�������ȡ��Ϣ
	public static boolean login()
	{
		HealthInfo healthInfo=HealthInfo.getHealthInfo();
		healthInfo.name="��۾�";
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
	
	//TODO:�ӷ�������ȡҩƷ��������Ϣ
	public static List<CommentInfo> getComments(String medicine)
	{
		List<CommentInfo>comments=new ArrayList<CommentInfo>();
		if(medicine.equals(""))
		{}
			comments.add(new CommentInfo("aaa","�úúúú�"));
			comments.add(new CommentInfo("bbb", "�úúúúú�"));
			return comments;
	}
	
	
}
