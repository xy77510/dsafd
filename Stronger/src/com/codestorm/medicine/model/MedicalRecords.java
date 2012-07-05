/**
 * 2012-6-21
 * 
 * ����
 * 
 * �����¼������
 * 
 * */

package com.codestorm.medicine.model;

import java.util.Date;
import java.util.LinkedList;

public class MedicalRecords
{
	public Date date;// ��¼����
	public float healthScore;// ����ָ��
	public MedicalCard medicalCard;// ������
	private static LinkedList<MedicalRecords> medicalRecords = new LinkedList<MedicalRecords>();// �����¼�б�

	// �����¼���캯��
	public MedicalRecords(float score, MedicalCard medicalCard)
	{
		date = new Date();
		healthScore = score;
		this.medicalCard = medicalCard;
	}

	// ��ȡ�����¼
	public static LinkedList<MedicalRecords> getMedicalRecords()
	{
		return medicalRecords;
	}

}
