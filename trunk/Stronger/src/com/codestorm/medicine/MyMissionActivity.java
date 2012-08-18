package com.codestorm.medicine;

/*
 * 	郑泽
 * 	2012-6-29
 * 	任务列表窗口
 * */
import java.util.ArrayList;
import java.util.HashMap;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.Mission;
import com.codestorm.medicine.server.AnologServer;

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
import android.widget.Toast;

public class MyMissionActivity extends Activity implements OnClickListener
{
	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	Intent intent = new Intent();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);

		ListView listView = (ListView) findViewById(R.id.ListView); // 构造listview
		ArrayList<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		if(Mission.missionMap.isEmpty())
		{
			AnologServer.getTasks(this);
		}
		for (Mission mission : Mission.missionList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("titleTextView", mission.missiontitle);
			String tempstring = String.copyValueOf(mission.missionstring.toCharArray(), 0, 15) + "...";
			map.put("stringTextView", tempstring);
			maps.add(map);
		}
		if (maps.size() > 0)
		{
			SimpleAdapter listItemaAdapter = new SimpleAdapter(this, maps, R.xml.missionlayout, new String[]
			{ "titleTextView", "stringTextView" }, new int[]
			{ R.id.titleTextView, R.id.stringTextView });
			listView.setAdapter(listItemaAdapter);
			listView.setOnItemClickListener(new OnItemClickListener()
			{

				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
				{
					// TODO 任务选择
					Mission.setMission(arg2);
					if (Mission.mission != null)
					{
						intent.setClass(MyMissionActivity.this, MissionActivity.class);
						startActivity(intent);
					}

				}
			});
		} else
		{
			Toast.makeText(this, "没有适合您的任务", Toast.LENGTH_LONG).show();
		}
	}

	public void onClick(View v)
	{

	}

}
