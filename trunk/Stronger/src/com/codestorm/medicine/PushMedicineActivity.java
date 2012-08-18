package com.codestorm.medicine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.server.AnologServer;
import com.codestorm.medicine.model.Commentary;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.model.Medicine;

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

public class PushMedicineActivity extends Activity
{
	HealthInfo healthInfo = HealthInfo.getHealthInfo();
	List<Medicine> medicines;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);
		ListView listView = (ListView) findViewById(R.id.ListView);
		ArrayList<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		medicines = AnologServer.getMedicals(this, healthInfo.disease);

		for (Medicine medicine : medicines)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("officeTextView", medicine.name);
			maps.add(map);
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
				Medicine medicine = medicines.get(arg2);
				Bundle bundle = new Bundle();
				bundle.putString("name", medicine.name);
				bundle.putString("id", String.valueOf(medicine.ID));
				bundle.putString("effect", medicine.introduction);
				bundle.putString("taboo", medicine.taboos);
				bundle.putString("manufacturer", medicine.manufacturer);
				bundle.putString("promotion", medicine.promotion);
				Intent intent = new Intent();
				intent.putExtras(bundle);
				intent.setClass(PushMedicineActivity.this, MedicineView.class);
				startActivity(intent);
			}
		});

	}

}
