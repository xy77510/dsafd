package com.codestorm.medicine.model;

/*
 * 	郑泽
 * 	2012/6/25
 * 	药物类
 * */
public class Medicine
{
	public String name; // 药品名
	public String ID;//药品ID
	public String introduction;//药品介绍
	public String diseases;//疾病
	public String taboos;//禁忌
	public String manufacturer;//厂商
	public String promotion;//促销信息

	// 构造函数
	public Medicine(String medicalname,String id,String introduct,String disease,String taboo,String manufactur,String promotion)
	{
		name = medicalname;
		ID=id;
		introduction=introduct;
		diseases=disease;
		taboos=taboo;
		manufacturer=manufactur;
		this.promotion=promotion;
	}
}
