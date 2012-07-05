/**
 * 2012-6-21
 * 
 * 周坤
 * 
 * 就诊记录数据类
 * 
 * */

package com.codestorm.medicine.model;

import java.util.Date;
import java.util.LinkedList;

public class MedicalRecords
{
	public Date date;// 记录日期
	public float healthScore;// 健康指数
	public MedicalCard medicalCard;// 病历单
	private static LinkedList<MedicalRecords> medicalRecords = new LinkedList<MedicalRecords>();// 就诊记录列表

	// 就诊记录构造函数
	public MedicalRecords(float score, MedicalCard medicalCard)
	{
		date = new Date();
		healthScore = score;
		this.medicalCard = medicalCard;
	}

	// 获取就诊记录
	public static LinkedList<MedicalRecords> getMedicalRecords()
	{
		return medicalRecords;
	}

}
