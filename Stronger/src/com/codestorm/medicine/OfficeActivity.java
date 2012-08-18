package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012/6/27
 *  科室选择
 *  替代Departmentactivity
 * */
import java.util.ArrayList;
import java.util.HashMap;

import com.codestorm.medicine.model.Office;
import com.codestorm.medicine.model.TempOffice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class OfficeActivity extends Activity
{

	TempOffice tempOffice = new TempOffice();
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.listview);
		ListView listView = (ListView) findViewById(R.id.ListView);
		ArrayList<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		// TODO:获取科室列表
		for (Office office : tempOffice.getHashMap().get(com.codestorm.medicine.MedRegActivity.choice))
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("officeTextView", office.officestring);
			maps.add(map);
		}
		// TODO：将科室列表添加进listview中
		SimpleAdapter listItemAdapter = new SimpleAdapter(this, maps, R.xml.officelayout, new String[]
		{ "officeTextView" }, new int[]
		{ R.id.officeTextView });
		listView.setAdapter(listItemAdapter);
		listView.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				// TODO 科室选择
				switch (arg2)
				{
				case 1:
				{
					intent.setClass(OfficeActivity.this, SelfTestActivity.class);
					startActivity(intent);
				}
				default:
					break;
				}
			}

		});
	}

}
