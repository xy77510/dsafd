package com.codestorm.medicine;

/*
 * 		郑泽
 * 		2012/7/27
 * 		评论列表
 * 
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codestorm.medicine.model.Commentary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;

public class CommentaryActivity extends Activity implements OnClickListener
{
	Intent intent = new Intent();
	SimpleAdapter simpleAdapter;
	List<HashMap<String, Object>> maps;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 构建界面
		LayoutParams layoutParams1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		RelativeLayout relativeLayout = new RelativeLayout(this);
		relativeLayout.setLayoutParams(layoutParams1);
		relativeLayout.setBackgroundColor(getResources().getColor(R.color.mblue));
		// 构建产品名
		TextView mTextView = new TextView(this);
		mTextView.setText(Commentary.commentriesname);
		mTextView.setTextSize(25);
		mTextView.setId(1);
		mTextView.setTextColor(getResources().getColor(R.color.mmblue));
		LayoutParams layoutParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mTextView.setLayoutParams(layoutParams2);
		relativeLayout.addView(mTextView);
		if (Commentary.commentaries.size() > 0)
		{
			// 存在评论是，构建评论表
			ListView listView = new ListView(this);
			listView.setId(2);
			maps = new ArrayList<HashMap<String, Object>>();
			for (Commentary commentary : Commentary.commentaries)
			{
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("detailTextView", commentary.textString);
				map.put("timeTextView", commentary.timeString);
				map.put("userTextView", commentary.userString);
				maps.add(map);
			}
			simpleAdapter = new SimpleAdapter(this, maps, R.xml.commentarylayout, new String[]
			{ "detailTextView", "timeTextView", "userTextView" }, new int[]
			{ R.id.detailTextView, R.id.timeTextView, R.id.userTextView });
			listView.setAdapter(simpleAdapter);
			LayoutParams layoutParams3 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams3.addRule(RelativeLayout.BELOW, 1);
			listView.setLayoutParams(layoutParams3);
			relativeLayout.addView(listView);
		} else
		{ // 不存在评论时。输出无评论
			TextView newTextView = new TextView(this);
			newTextView.setId(2);
			newTextView.setText("目前还未有评论");
			LayoutParams layoutParams4 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams4.addRule(RelativeLayout.BELOW, 1);
			newTextView.setLayoutParams(layoutParams4);
			relativeLayout.addView(newTextView);

		}
		Button mButton = new Button(this);
		mButton.setText("发表评论");
		mButton.setId(3);
		mButton.setOnClickListener(this);
		mButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.btndrawable));
		mButton.setTextColor(getResources().getColorStateList(R.drawable.textdrawble));
		LayoutParams layoutParams5 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams5.addRule(RelativeLayout.BELOW, 2);
		layoutParams5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		mButton.setLayoutParams(layoutParams5);
		relativeLayout.addView(mButton);
		setContentView(relativeLayout);
	}

	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case 3:
			// TODO:发表评论
			intent.setClass(this, CommentActivity.class);
			startActivityForResult(intent, 1);
			break;

		default:
			break;
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{ // 获取子界面的返回值

		super.onActivityResult(requestCode, resultCode, data);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("detailTextView", Commentary.commentaries.get(Commentary.commentaries.size() - 1).textString);
		map.put("timeTextView", Commentary.commentaries.get(Commentary.commentaries.size() - 1).timeString);
		map.put("userTextView", Commentary.commentaries.get(Commentary.commentaries.size() - 1).userString);
		maps.add(map);
		simpleAdapter.notifyDataSetChanged();


	}

}
