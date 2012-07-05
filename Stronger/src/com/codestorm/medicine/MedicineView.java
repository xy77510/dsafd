/**
 * 2012-6-27
 * 
 * 周坤
 * 
 * 详细药品信息界面(向这个页面跳转的时候要传递一个bundle，具体内容看loadData方法)
 * 
 * */
package com.codestorm.medicine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MedicineView extends Activity implements OnClickListener
{
	TextView mMedicineNameTextView;//药品名
	TextView mIDTextView;//药品编号
	TextView mEffectTextView;//功效
	TextView mTabooTextView;//禁忌
	TextView mManufacturerTextView;//厂商
	TextView mPromotionTextView;//促销信息
	Button mCommentsButton;//查看评论
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.medicine_view);
		
		mMedicineNameTextView=(TextView)findViewById(R.id.medicineNameTextView);		
		mIDTextView=(TextView)findViewById(R.id.idTextView);
		mEffectTextView=(TextView)findViewById(R.id.effectTextView);
		mTabooTextView=(TextView)findViewById(R.id.tabooTextView);
		mManufacturerTextView=(TextView)findViewById(R.id.manufacturerTextView);
		mPromotionTextView=(TextView)findViewById(R.id.promotionTextView);
		mPromotionTextView.setOnClickListener(this);
		mCommentsButton=(Button)findViewById(R.id.commentsButton);
		mCommentsButton.setOnClickListener(this);
		loadData();
	}
	
	//从bundle中获取信息
	public void loadData()
	{
		Bundle bundle=this.getIntent().getExtras();
		mMedicineNameTextView.setText(bundle.getString("name"));
		mIDTextView.setText(bundle.getString("ID"));
		mEffectTextView.setText(bundle.getString("effect"));
		mTabooTextView.setText(bundle.getString("taboo"));
		mManufacturerTextView.setText(bundle.getString("manufacturer"));
		mPromotionTextView.setText(bundle.getString("promotion"));
	}
	
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.commentsButton:
			//转到评论页面
			intent=new Intent();
			intent.setClass(MedicineView.this, CommentsActivity.class);
			Bundle bundle=new Bundle();
			bundle.putString("medicine", mMedicineNameTextView.getText().toString());
			startActivity(intent);
			break;
		case R.id.promotionTextView:
			//TODO:转到电商平台
		default:
			break;
		}
		
	}
	
	

}
