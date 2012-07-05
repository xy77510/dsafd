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
		//平和质0
		phQuestions.add(new PhysiqueQuestion(0,"您精力充沛吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(1,"您容易疲乏吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(2,"您说话声音无力吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(3,"您感到闷闷不乐吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(4,"您比一般 人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(5,"您能适应外界自然和社会环境的变化吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(6,"您容易失眠吗？","平和质",0));
		phQuestions.add(new PhysiqueQuestion(7,"您容易忘事（健忘）吗？","平和质",0));
		//阳虚质1
		yanxQuestions.add(new PhysiqueQuestion(0,"您手脚发凉吗？","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(1,"您胃脘部、背部或腰膝部怕冷吗？","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(2,"您感到怕冷、衣服比别人穿得多吗？","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(3,"您比一般人不了寒冷（冬天的寒冷，夏天的冷空调、电扇等。","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(4,"您比别人容易患感冒吗？","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(5,"您吃（喝）凉的东西会感到不舒服或者怕吃（喝）凉东西吗？","阳虚质",0));
		yanxQuestions.add(new PhysiqueQuestion(6,"你受凉或吃（喝）凉的东西后，容易腹泻（拉肚子）吗？","阳虚质",0));
		//阴虚质2
		yinxQuestions.add(new PhysiqueQuestion(0,"您感到手脚心发热吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(1,"您感觉身体、脸上发热吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(2,"您皮肤或口唇干吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(3,"您口唇的颜色比一般人红吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(4,"您容易便秘或大便干燥吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(5,"您面部两潮红或偏红吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(6,"您感到眼睛干涩吗？","阴虚质",0));
		yinxQuestions.add(new PhysiqueQuestion(7,"您活动量稍大就容易出虚汗吗？","阴虚质",0));
		//气虚质3
		qxQuestions.add(new PhysiqueQuestion(0,"你容易疲乏吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(1,"您容易气短（呼吸短促，接不上气吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(2,"您容易心慌吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(3,"您容易头晕或站起时晕眩吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(4,"您比别人容易患感冒吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(5,"您喜欢安静、懒得说话吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(6,"您说话声音无力吗？","气虚质",0));
		qxQuestions.add(new PhysiqueQuestion(7,"您活动量就容易出虚汗吗？","气虚质",0));
		//痰湿质4
		tsQuestions.add(new PhysiqueQuestion(0,"您感到胸闷或腹部胀满吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(1,"您感到身体学生不轻松或不爽快吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(2,"您腹部肥满松软吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(3,"您有额部油脂分泌多的现象吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(4,"您上眼睑比别人肿（仍轻微隆起的现象）吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(5,"您嘴里有黏黏的感觉吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(6,"您平时痰多，特别是咽喉部总感到有痰堵着吗？","痰湿质",0));
		tsQuestions.add(new PhysiqueQuestion(7,"您舌苔厚腻或有舌苔厚厚的感觉吗？","痰湿质",0));
		//湿热质5
		srQuestions.add(new PhysiqueQuestion(0,"您面部或鼻部有油腻感或者油亮发光吗？","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(1,"你容易生痤疮或疮疖吗？","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(2,"您感到口苦或嘴里有异味吗？","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(3,"您大使黏滞不爽、有解不尽的感觉吗？","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(4,"您小便时尿道有发热感、尿色浓（深）吗？","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(5,"您带下色黄（白带颜色发黄）吗？（限女性回答）；","湿热质",0));
		srQuestions.add(new PhysiqueQuestion(6,"您的阴囊部位潮湿吗？","湿热质",0));
		//血瘀质6
		xyQuestions.add(new PhysiqueQuestion(0,"您面部或鼻部有油腻感或者油亮发光吗？","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(1,"你容易生痤疮或疮疖吗？","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(2,"您感到口苦或嘴里有异味吗？","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(3,"您大使黏滞不爽、有解不尽的感觉吗？","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(4,"您小便时尿道有发热感、尿色浓（深）吗？","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(5,"您带下色黄（白带颜色发黄）吗？（限女性回答）；","血瘀质",0));
		xyQuestions.add(new PhysiqueQuestion(6,"您的阴囊部位潮湿吗？","血瘀质",0));
		//特禀质7
		tbQuestions.add(new PhysiqueQuestion(0,"您没有感冒时也会打喷嚏吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(1,"您没有感冒时也会鼻塞、流鼻涕吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(2,"您有因季节变化、温度变化或异味等原因而咳喘的现象吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(3,"您容易过敏（对药物、食物、气味、花粉或在季节交替、气候变化时）吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(4,"您的皮肤容易起荨麻疹（风团、风疹块、风疙瘩）吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(5,"您的因过敏出现过紫癜（紫红色瘀点、瘀斑）吗？","特禀质",0));
		tbQuestions.add(new PhysiqueQuestion(6,"您的皮肤一抓就红，并出现抓痕吗？","特禀质",0));
		//气郁质
		qyQuestions.add(new PhysiqueQuestion(0,"您感到闷闷不乐吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(1,"您容易精神紧张、焦虑不安吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(2,"您多愁善感、感情脆弱吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(3,"您容易感到害怕或受到惊吓吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(4,"您胁肋部或乳房腹痛吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(5,"您无缘无故叹气吗？","气郁质",0));
		qyQuestions.add(new PhysiqueQuestion(6,"您咽喉部有异物感，且吐之不出、咽之不下吗？","气郁质",0));
	}
}
