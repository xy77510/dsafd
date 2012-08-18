package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012-7-2
 * 	资讯列表
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.model.Information;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
	List<Information> informations=AnologServer.getNews(this);
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);
		ListView mListView = (ListView) findViewById(R.id.ListView);
		if(informations==null)
		{
			Log.i("ED", "information null");
		}
		
		ArrayList<HashMap<String, Object>> mlist = new ArrayList<HashMap<String, Object>>();
		// TODO 将资讯加入到资讯列表中
		for (Information information : informations)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("infoTitleTextView", information.title);
			map.put("infosummaryTextView", information.text);
			mlist.add(map);
		}

		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, mlist, R.xml.informationlist, new String[]
		{ "infoTitleTextView", "infosummaryTextView" }, new int[]
		{ R.id.infoTitleTextView, R.id.infosummaryTextView });
		mListView.setAdapter(mSimpleAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				// TODO 选择资讯
				Information.setInformation(arg2);
				if (Information.information != null)
				{
					intent.setClass(InformationActivity.this, MyInformationActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub

	}

}
