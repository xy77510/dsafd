package com.codestorm.medicine.model;

/*
 * 	֣��
 * 	2012/6/25
 * 	ҩ����
 * */
public class Medicine
{
	public String name; // ҩƷ��
	public String ID;//ҩƷID
	public String introduction;//ҩƷ����
	public String diseases;//����
	public String taboos;//����
	public String manufacturer;//����
	public String promotion;//������Ϣ

	// ���캯��
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
