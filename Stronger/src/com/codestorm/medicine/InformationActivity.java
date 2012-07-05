package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012-7-2
 * 	资讯列表
 * */
import java.util.ArrayList;
import java.util.HashMap;

import com.codestorm.medicine.model.TempInformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class InformationActivity extends Activity implements OnClickListener
{
	TempInformation information1 = new TempInformation("1", "测试1", "测试资讯1", "测试资讯1"); // 测试资讯1，测试后删除
	TempInformation information2 = new TempInformation("2", "测试2", "测试资讯2", "测试资讯2"); // 测试资讯2,测试后删除
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);
		ListView mListView = (ListView) findViewById(R.id.listView);
		ArrayList<HashMap<String, Object>> mlist = new ArrayList<HashMap<String, Object>>();
		// TODO 将资讯加入到资讯列表中
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("infoTitleTextView", information1.text);
		map.put("infosummaryTextView", information1.summary);
		mlist.add(map);
		map = new HashMap<String, Object>();
		map.put("infoTitleTextView", information2.text);
		map.put("infosummaryTextView", information2.summary);
		mlist.add(map);
		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, mlist, R.xml.informationlist, new String[]
		{ "infoTitleTextView", "infosummaryTextView" }, new int[]
		{ R.id.infoTitleTextView, R.id.infosummaryTextView });
		mListView.setAdapter(mSimpleAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				// TODO 选择资讯
				switch (arg2)
				{
				case 0:
					;
					break;

				default:
					break;
				}
			}
		});
	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub

	}

}
