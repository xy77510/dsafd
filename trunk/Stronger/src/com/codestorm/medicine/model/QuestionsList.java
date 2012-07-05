package com.codestorm.medicine.model;

import java.util.ArrayList;
import java.util.List;


public class QuestionsList {
	List<PhysiqueQuestion> phQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> yanxQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> yinxQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> qxQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> tsQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> srQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> xyQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> tbQuestions =new ArrayList<PhysiqueQuestion>();
	List<PhysiqueQuestion> qyQuestions =new ArrayList<PhysiqueQuestion>();
	public QuestionsList()
	{		
		//ƽ����0
		phQuestions.add(new PhysiqueQuestion(0,"������������","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(1,"������ƣ����","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(2,"��˵������������","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(3,"���е����Ʋ�����","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(4,"����һ�� �����ܲ��˺��䣨����ĺ��䣬�������յ������ȣ���","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(5,"������Ӧ�����Ȼ����ỷ���ı仯��","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(6,"������ʧ����","ƽ����",0));
		phQuestions.add(new PhysiqueQuestion(7,"���������£���������","ƽ����",0));
		//������1
		yanxQuestions.add(new PhysiqueQuestion(0,"���ֽŷ�����","������",0));
		yanxQuestions.add(new PhysiqueQuestion(1,"��θ�䲿����������ϥ��������","������",0));
		yanxQuestions.add(new PhysiqueQuestion(2,"���е����䡢�·��ȱ��˴��ö���","������",0));
		yanxQuestions.add(new PhysiqueQuestion(3,"����һ���˲��˺��䣨����ĺ��䣬�������յ������ȵȡ�","������",0));
		yanxQuestions.add(new PhysiqueQuestion(4,"���ȱ������׻���ð��","������",0));
		yanxQuestions.add(new PhysiqueQuestion(5,"���ԣ��ȣ����Ķ�����е�����������³ԣ��ȣ���������","������",0));
		yanxQuestions.add(new PhysiqueQuestion(6,"��������ԣ��ȣ����Ķ��������׸�к�������ӣ���","������",0));
		//������2
		yinxQuestions.add(new PhysiqueQuestion(0,"���е��ֽ��ķ�����","������",0));
		yinxQuestions.add(new PhysiqueQuestion(1,"���о����塢���Ϸ�����","������",0));
		yinxQuestions.add(new PhysiqueQuestion(2,"��Ƥ����ڴ�����","������",0));
		yinxQuestions.add(new PhysiqueQuestion(3,"���ڴ�����ɫ��һ���˺���","������",0));
		yinxQuestions.add(new PhysiqueQuestion(4,"�����ױ��ػ��������","������",0));
		yinxQuestions.add(new PhysiqueQuestion(5,"���沿�������ƫ����","������",0));
		yinxQuestions.add(new PhysiqueQuestion(6,"���е��۾���ɬ��","������",0));
		yinxQuestions.add(new PhysiqueQuestion(7,"������Դ�����׳��麹��","������",0));
		//������3
		qxQuestions.add(new PhysiqueQuestion(0,"������ƣ����","������",0));
		qxQuestions.add(new PhysiqueQuestion(1,"���������̣������̴٣��Ӳ�������","������",0));
		qxQuestions.add(new PhysiqueQuestion(2,"�������Ļ���","������",0));
		qxQuestions.add(new PhysiqueQuestion(3,"������ͷ�λ�վ��ʱ��ѣ��","������",0));
		qxQuestions.add(new PhysiqueQuestion(4,"���ȱ������׻���ð��","������",0));
		qxQuestions.add(new PhysiqueQuestion(5,"��ϲ������������˵����","������",0));
		qxQuestions.add(new PhysiqueQuestion(6,"��˵������������","������",0));
		qxQuestions.add(new PhysiqueQuestion(7,"����������׳��麹��","������",0));
		//̵ʪ��4
		tsQuestions.add(new PhysiqueQuestion(0,"���е����ƻ򸹲�������","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(1,"���е�����ѧ�������ɻ�ˬ����","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(2,"����������������","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(3,"���ж��֬���ڶ��������","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(4,"���������ȱ����ף�����΢¡���������","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(5,"����������ĸо���","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(6,"��ƽʱ̵�࣬�ر����ʺ��ܸе���̵������","̵ʪ��",0));
		tsQuestions.add(new PhysiqueQuestion(7,"����̦���������̦���ĸо���","̵ʪ��",0));
		//ʪ����5
		srQuestions.add(new PhysiqueQuestion(0,"���沿��ǲ�������л�������������","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(1,"���������������","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(2,"���е��ڿ����������ζ��","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(3,"����ʹ��Ͳ�ˬ���нⲻ���ĸо���","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(4,"��С��ʱ����з��ȸС���ɫŨ�����","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(5,"������ɫ�ƣ��״���ɫ���ƣ��𣿣���Ů�Իش𣩣�","ʪ����",0));
		srQuestions.add(new PhysiqueQuestion(6,"�������Ҳ�λ��ʪ��","ʪ����",0));
		//Ѫ����6
		xyQuestions.add(new PhysiqueQuestion(0,"���沿��ǲ�������л�������������","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(1,"���������������","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(2,"���е��ڿ����������ζ��","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(3,"����ʹ��Ͳ�ˬ���нⲻ���ĸо���","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(4,"��С��ʱ����з��ȸС���ɫŨ�����","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(5,"������ɫ�ƣ��״���ɫ���ƣ��𣿣���Ů�Իش𣩣�","Ѫ����",0));
		xyQuestions.add(new PhysiqueQuestion(6,"�������Ҳ�λ��ʪ��","Ѫ����",0));
		//������7
		tbQuestions.add(new PhysiqueQuestion(0,"��û�и�ðʱҲ���������","������",0));
		tbQuestions.add(new PhysiqueQuestion(1,"��û�и�ðʱҲ���������������","������",0));
		tbQuestions.add(new PhysiqueQuestion(2,"�����򼾽ڱ仯���¶ȱ仯����ζ��ԭ����ȴ���������","������",0));
		tbQuestions.add(new PhysiqueQuestion(3,"�����׹�������ҩ�ʳ���ζ�����ۻ��ڼ��ڽ��桢����仯ʱ����","������",0));
		tbQuestions.add(new PhysiqueQuestion(4,"����Ƥ��������ݡ������š�����顢������","������",0));
		tbQuestions.add(new PhysiqueQuestion(5,"������������ֹ���񰣨�Ϻ�ɫ���㡢���ߣ���","������",0));
		tbQuestions.add(new PhysiqueQuestion(6,"����Ƥ��һץ�ͺ죬������ץ����","������",0));
		//������
		qyQuestions.add(new PhysiqueQuestion(0,"���е����Ʋ�����","������",0));
		qyQuestions.add(new PhysiqueQuestion(1,"�����׾�����š����ǲ�����","������",0));
		qyQuestions.add(new PhysiqueQuestion(2,"������ƸС����������","������",0));
		qyQuestions.add(new PhysiqueQuestion(3,"�����׸е����»��ܵ�������","������",0));
		qyQuestions.add(new PhysiqueQuestion(4,"��в�߲����鷿��ʹ��","������",0));
		qyQuestions.add(new PhysiqueQuestion(5,"����Ե�޹�̾����","������",0));
		qyQuestions.add(new PhysiqueQuestion(6,"���ʺ�������У�����֮��������֮������","������",0));
	}
}
