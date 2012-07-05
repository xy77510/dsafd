/**
 * 
 *2012-6-27
 *
 * ����
 * 
 * �鿴����ҳ�棨��ת��ʱ��Ҫ����һ��bundle�����忴loadData������
 * 
 * */
package com.codestorm.medicine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.model.AnologServer;
import com.codestorm.medicine.model.CommentInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CommentsActivity extends Activity
{
	ListView mCommentsListView;
	List<CommentInfo> commentInfos;
	ArrayList<HashMap<String, String>> comments=new ArrayList<HashMap<String,String>>();
	SimpleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.comments);
		mCommentsListView=(ListView)findViewById(R.id.commentListView);
		loadData();
		loadComments();
	}
	
	//�ӷ�������ȡҩƷ����
	private void loadData()
	{
		Bundle bundle=this.getIntent().getExtras();
		String medicine=bundle.getString("medicine");
		commentInfos=AnologServer.getComments(medicine);		
	}
	
	//�����б�ؼ�
	private void loadComments()
	{
		HashMap<String, String> map;
		for(CommentInfo item:commentInfos)
		{
			map=new HashMap<String, String>();
			map.put("name", item.user);
			map.put("comment", item.text);
			comments.add(map);
		}
		adapter=new SimpleAdapter(this, comments, R.xml.comment, new String[]{"name","comment"}, new int[]{R.id.userTextView,R.id.commentTextView});
		mCommentsListView.setAdapter(adapter);
	}
	
	
	
}
