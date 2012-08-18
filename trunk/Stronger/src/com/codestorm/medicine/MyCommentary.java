package com.codestorm.medicine;

/*
 * 		郑泽
 * 		2012-7-27
 * 		公共空间界面
 * 
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.model.Commentary;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MyCommentary extends Activity
{
	HealthInfo healthInfo = HealthInfo.getHealthInfo();

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);

		ListView listView = (ListView) findViewById(R.id.ListView);
		List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		for (String string : healthInfo.mycommentary)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("officeTextView", string);
			maps.add(map);
		}
		if (healthInfo.mycommentary.isEmpty())
		{
			Toast.makeText(this, "暂无收藏药品！", Toast.LENGTH_LONG).show();
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, maps, R.xml.officelayout, new String[]
		{ "officeTextView" }, new int[]
		{ R.id.officeTextView });
		listView.setAdapter(simpleAdapter);
		listView.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				// TODO Auto-generated method stub
				if (!healthInfo.mycommentary.isEmpty())
				{
					Commentary.commentriesname = healthInfo.mycommentary.get(arg2);
					AnologServer.getCommentary(MyCommentary.this, Commentary.commentriesname);
					Intent intent = new Intent();
					intent.setClass(MyCommentary.this, CommentaryActivity.class);
					startActivity(intent);
				}
			}
		});
	}

}
