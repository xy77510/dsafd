package com.codestorm.medicine.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub
		String createTask, createNews, createService, createProduct, createQuestion,createCommentary;
		createTask = "CREATE TABLE task_list (id integer PRIMARY KEY AUTOINCREMENT,title VARCHAR(50),text varchar(500),tag varchar(50))";
		createNews = "CREATE TABLE news_list (id integer PRIMARY KEY AUTOINCREMENT,title VARCHAR(50),text varchar(500),summary varchar(100))";
		createService = "CREATE TABLE service_list (id integer PRIMARY KEY AUTOINCREMENT,title VARCHAR(50),text varchar(500))";
		createProduct = "CREATE TABLE product_list (id integer PRIMARY KEY,name VARCHAR(50),introduction varchar(500),diseases varchar(500),taboos varchar(500),manufacturer varchar(50),promotion varchar(500))";
		createQuestion = "CREATE TABLE question_list (id varchar(20) PRIMARY KEY,text VARCHAR(50),yes varchar(20),no varchar(20))";
//		createDepartment = "CREATE TABLE department_list (id integer PRIMARY KEY autoincrement,name VARCHAR(20),question varchar(20))";
		createCommentary="CREATE TABLE commentary_list (id integer PRIMARY KEY AUTOINCREMENT,user VARCHAR(20),text varchar(500),product varchar(20), time varchar(20))";
		db.execSQL(createTask);
		db.execSQL(createNews);
		db.execSQL(createService);
		db.execSQL(createProduct);
		db.execSQL(createQuestion);
//		db.execSQL(createDepartment);
		db.execSQL(createCommentary);
		
		iniData(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
	{
		// TODO Auto-generated method stub

	}

	// 初始化数据
	public void iniData(SQLiteDatabase db)
	{
		ContentValues values;
		// TODO:初始化账户信息和密码
		
		// TODO:初始化用户信息

		// TODO:初始化任务
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "散步"	);
		values.put("text", "找个时间在树林中散步，让自己融入那静谧的氛围里，体会其中盎然的生趣，你会发现，喧扰的心仿佛找到了栖息、安顿之所。");
		values.put("tag", "消化不良|肥胖");
		db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 1);
	    values.put("title", "倒行逆走");
	    values.put("text", "走时膝盖不要弯曲，步子均匀而缓慢，双手握拳，轻轻地向前后摆动，挺胸并有规律地呼吸。每天坚持200～400步，可以增加平衡感，防止驼背，强肾气，改善腰痛，改善记忆力等。");
	    values.put("tag", "肾功能不全|腰痛|记忆力差");
	    db.insert("task_list", null, values);	    
	    values = new ContentValues();
	    values.put("id", 2);
	    values.put("title", "拥抱大树");
	    values.put("text", "拥抱大树可以释放体内的快乐激素，令人精神爽朗。 而与之对立的肾上腺素，即压抑激素则消失。 你可以在公园里拥抱大树，看看天空，深呼吸。或者听着音乐抱着大树两分钟。 什么也别想，让自己放松一下吧。 ");
	    values.put("tag", "疲劳|紧张");
	    db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 3);
	    values.put("title", "今天只喝热饮");
	    values.put("text", "无论你吃什么样的健康饮品，比如茶|奶类等饮料，都务必保持宁热勿冷的原则。热饮不仅可以帮助燃烧更多的脂肪和热量，促进新陈代谢，而且还可以保护你的肠胃不受损伤，只有健康的肠胃才能为你提供有序的代谢动力！今天只喝热饮吧，让身体暖和起来，肠胃暖和起来为你带来正面的能量！");
	    values.put("tag", "消化不良|胃炎|肠炎|肥胖");
	    db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 4);
	    values.put("title", "用小号的勺子吃饭");
	    values.put("text", "换个小的勺子。炒菜放油的时候，用勺子放，别直接拿油壶往锅里倒；吃饭时用小号的勺子，一点一点，慢慢吃。这样可以有效的掌控你的放油量，减缓你的进食速度，使脾胃消化更轻松的消化食物。 ");
	    values.put("tag", "肠胃消化|肥胖");
	    db.insert("task_list", null, values);
	    
		// TODO:初始化资讯
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "资讯"	);
		values.put("text", "abcdefghijklmnopqrstuvwxyz");
		values.put("summary", "abcd......");
		db.insert("news_list", null, values);
		
		// TODO:初始化生活服务
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "生活服务"	);
		values.put("text", "abcdefghijklmnopqrstuvwxyz");
		db.insert("service_list", null, values);
		
		// TODO:初始化药品
		values=new ContentValues();
		values.put("id", 0);
		values.put("name", "白加黑");
		values.put("introduction", "本品用于缓解普通感冒及流行性感冒引起的发热、头痛、四肢酸痛、打喷嚏、流鼻涕、鼻塞、咳嗽、咽痛等症状。 ");
		values.put("diseases", "普通感冒|流行性感冒 ");
		values.put("taboos", "肝肾功能不全 |妇女 ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		values=new ContentValues();
		values.put("id", 1);
		values.put("name", "板蓝根");
		values.put("introduction", "清热解毒，凉血利咽，消肿。用于热毒壅盛，咽喉肿痛；扁桃腺炎、腮腺炎上述证候者 ");
		values.put("diseases", "热毒壅盛|咽喉肿痛|扁桃腺炎|腮腺炎");
		values.put("taboos", "高血压|心脏病|肝病|糖尿病|肾病|孕妇|脾胃虚寒 ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		values=new ContentValues();
		values.put("id", 2);
		values.put("name", "抗菌消炎片");
		values.put("introduction", "清热，泻火，解毒。用于风热感冒，咽喉肿痛，实火牙痛 ");
		values.put("diseases", "风热感冒");
		values.put("taboos", "脾胃虚寒|高血压|心脏病|肝病|糖尿病|肾病 ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		
		// TODO:初始化问题
		values=new ContentValues();
		values.put("id", "0");
		values.put("text", "是否发热？"	);
		values.put("yes", "1");
		values.put("no", "2"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "1");
		values.put("text", "是否身体酸痛？"	);
		values.put("yes", "3");
		values.put("no", "4"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "2");
		values.put("text", "是否咳嗽？"	);
		values.put("yes", "4");
		values.put("no", "5"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "3");
		values.put("text", "是否昏迷？"	);
		values.put("yes", "A");
		values.put("no", "B"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "4");
		values.put("text", "是否咽喉痛？"	);
		values.put("yes", "6");
		values.put("no", "7"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "5");
		values.put("text", "是否有痰？"	);
		values.put("yes", "C");
		values.put("no", "D"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "6");
		values.put("text", "咽喉两侧疼痛?"	);
		values.put("yes", "E");
		values.put("no", "F"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "7");
		values.put("text", "咽喉两侧疼痛?"	);
		values.put("yes", "G");
		values.put("no", "6"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "A");
		values.put("text", "流行性感冒"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "B");
		values.put("text", "重度感冒"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "C");
		values.put("text", "咽喉感染"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "D");
		values.put("text", "没事"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "F");
		values.put("text", "风寒感冒"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "G");
		values.put("text", "肠胃感冒"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		//TODO 初始化评论
		values=new ContentValues();
		values.put("id", 0);
		values.put("user", "测试用户1");
		values.put("text", "测试评论1");
		values.put("time", "yyyy年MM月dd日 HH:mm:ss");
		values.put("product", "白加黑");
		db.insert("commentary_list", null, values);
		values=new ContentValues();
		values.put("id", 1);
		values.put("user", "测试用户2");
		values.put("text", "测试评论2");
		values.put("time", "yyyy年MM月dd日 HH:mm:ss");
		values.put("product", "白加黑");
		db.insert("commentary_list", null, values);
		values=new ContentValues();
		values.put("id", 2);
		values.put("user", "测试用户2");
		values.put("text", "测试评论2");
		values.put("time", "yyyy年MM月dd日 HH:mm:ss");
		values.put("product", "板蓝根");
		db.insert("commentary_list", null, values);
		
	}

}
