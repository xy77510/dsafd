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

	// ��ʼ������
	public void iniData(SQLiteDatabase db)
	{
		ContentValues values;
		// TODO:��ʼ���˻���Ϣ������
		
		// TODO:��ʼ���û���Ϣ

		// TODO:��ʼ������
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "ɢ��"	);
		values.put("text", "�Ҹ�ʱ����������ɢ�������Լ������Ǿ��׵ķ�Χ�������а�Ȼ����Ȥ����ᷢ�֣����ŵ��ķ·��ҵ�����Ϣ������֮����");
		values.put("tag", "��������|����");
		db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 1);
	    values.put("title", "��������");
	    values.put("text", "��ʱϥ�ǲ�Ҫ���������Ӿ��ȶ�������˫����ȭ���������ǰ��ڶ���ͦ�ز��й��ɵغ�����ÿ����200��400������������ƽ��У���ֹ�ձ���ǿ������������ʹ�����Ƽ������ȡ�");
	    values.put("tag", "�����ܲ�ȫ|��ʹ|��������");
	    db.insert("task_list", null, values);	    
	    values = new ContentValues();
	    values.put("id", 2);
	    values.put("title", "ӵ������");
	    values.put("text", "ӵ�����������ͷ����ڵĿ��ּ��أ����˾���ˬ�ʡ� ����֮�������������أ���ѹ�ּ�������ʧ�� ������ڹ�԰��ӵ��������������գ�������������������ֱ��Ŵ��������ӡ� ʲôҲ���룬���Լ�����һ�°ɡ� ");
	    values.put("tag", "ƣ��|����");
	    db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 3);
	    values.put("title", "����ֻ������");
	    values.put("text", "�������ʲô���Ľ�����Ʒ�������|��������ϣ�����ر������������ԭ�������������԰���ȼ�ո����֬�����������ٽ��³´�л�����һ����Ա�����ĳ�θ�������ˣ�ֻ�н����ĳ�θ����Ϊ���ṩ����Ĵ�л����������ֻ�������ɣ�������ů����������θů������Ϊ����������������");
	    values.put("tag", "��������|θ��|����|����");
	    db.insert("task_list", null, values);
	    values = new ContentValues();
	    values.put("id", 4);
	    values.put("title", "��С�ŵ����ӳԷ�");
	    values.put("text", "����С�����ӡ����˷��͵�ʱ�������ӷţ���ֱ�����ͺ������ﵹ���Է�ʱ��С�ŵ����ӣ�һ��һ�㣬�����ԡ�����������Ч���ƿ���ķ�������������Ľ�ʳ�ٶȣ�ʹƢθ���������ɵ�����ʳ� ");
	    values.put("tag", "��θ����|����");
	    db.insert("task_list", null, values);
	    
		// TODO:��ʼ����Ѷ
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "��Ѷ"	);
		values.put("text", "abcdefghijklmnopqrstuvwxyz");
		values.put("summary", "abcd......");
		db.insert("news_list", null, values);
		
		// TODO:��ʼ���������
		values=new ContentValues();
		values.put("id", 0);
		values.put("title", "�������"	);
		values.put("text", "abcdefghijklmnopqrstuvwxyz");
		db.insert("service_list", null, values);
		
		// TODO:��ʼ��ҩƷ
		values=new ContentValues();
		values.put("id", 0);
		values.put("name", "�׼Ӻ�");
		values.put("introduction", "��Ʒ���ڻ�����ͨ��ð�������Ը�ð����ķ��ȡ�ͷʹ����֫��ʹ�������硢�����顢���������ԡ���ʹ��֢״�� ");
		values.put("diseases", "��ͨ��ð|�����Ը�ð ");
		values.put("taboos", "�������ܲ�ȫ |��Ů ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		values=new ContentValues();
		values.put("id", 1);
		values.put("name", "������");
		values.put("introduction", "���Ƚⶾ����Ѫ���ʣ����ס������ȶ���ʢ���ʺ���ʹ���������ס�����������֤���� ");
		values.put("diseases", "�ȶ���ʢ|�ʺ���ʹ|��������|������");
		values.put("taboos", "��Ѫѹ|���ಡ|�β�|����|����|�и�|Ƣθ�麮 ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		values=new ContentValues();
		values.put("id", 2);
		values.put("name", "��������Ƭ");
		values.put("introduction", "���ȣ�к�𣬽ⶾ�����ڷ��ȸ�ð���ʺ���ʹ��ʵ����ʹ ");
		values.put("diseases", "���ȸ�ð");
		values.put("taboos", "Ƣθ�麮|��Ѫѹ|���ಡ|�β�|����|���� ");
		values.put("manufacturer", "null");
		values.put("promotion", "null");
		db.insert("product_list", null, values);
		
		// TODO:��ʼ������
		values=new ContentValues();
		values.put("id", "0");
		values.put("text", "�Ƿ��ȣ�"	);
		values.put("yes", "1");
		values.put("no", "2"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "1");
		values.put("text", "�Ƿ�������ʹ��"	);
		values.put("yes", "3");
		values.put("no", "4"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "2");
		values.put("text", "�Ƿ���ԣ�"	);
		values.put("yes", "4");
		values.put("no", "5"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "3");
		values.put("text", "�Ƿ���ԣ�"	);
		values.put("yes", "A");
		values.put("no", "B"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "4");
		values.put("text", "�Ƿ��ʺ�ʹ��"	);
		values.put("yes", "6");
		values.put("no", "7"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "5");
		values.put("text", "�Ƿ���̵��"	);
		values.put("yes", "C");
		values.put("no", "D"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "6");
		values.put("text", "�ʺ�������ʹ?"	);
		values.put("yes", "E");
		values.put("no", "F"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "7");
		values.put("text", "�ʺ�������ʹ?"	);
		values.put("yes", "G");
		values.put("no", "6"	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "A");
		values.put("text", "�����Ը�ð"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "B");
		values.put("text", "�ضȸ�ð"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "C");
		values.put("text", "�ʺ��Ⱦ"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "D");
		values.put("text", "û��"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "F");
		values.put("text", "�纮��ð"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		values=new ContentValues();
		values.put("id", "G");
		values.put("text", "��θ��ð"	);
		values.put("yes", "");
		values.put("no", ""	);
		db.insert("question_list", null, values);
		//TODO ��ʼ������
		values=new ContentValues();
		values.put("id", 0);
		values.put("user", "�����û�1");
		values.put("text", "��������1");
		values.put("time", "yyyy��MM��dd�� HH:mm:ss");
		values.put("product", "�׼Ӻ�");
		db.insert("commentary_list", null, values);
		values=new ContentValues();
		values.put("id", 1);
		values.put("user", "�����û�2");
		values.put("text", "��������2");
		values.put("time", "yyyy��MM��dd�� HH:mm:ss");
		values.put("product", "�׼Ӻ�");
		db.insert("commentary_list", null, values);
		values=new ContentValues();
		values.put("id", 2);
		values.put("user", "�����û�2");
		values.put("text", "��������2");
		values.put("time", "yyyy��MM��dd�� HH:mm:ss");
		values.put("product", "������");
		db.insert("commentary_list", null, values);
		
	}

}
