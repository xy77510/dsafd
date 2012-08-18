package com.codestorm.medicine;

import com.codestorm.medicine.model.HealthInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;

public class CollectMedicalHistory extends Activity implements OnClickListener
{
	
	private Button mCommitButton;
	private CheckBox mCheckBox1,mCheckBox2,mCheckBox3,mCheckBox4;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.medical_history);
		mCommitButton=(Button)findViewById(R.id.commitButton);
		mCommitButton.setOnClickListener(this);
		mCheckBox1=(CheckBox)findViewById(R.id.checkBox1);
		mCheckBox2=(CheckBox)findViewById(R.id.checkBox2);
		mCheckBox3=(CheckBox)findViewById(R.id.checkBox3);
		mCheckBox4=(CheckBox)findViewById(R.id.checkBox4);
	}


	public void onClick(View v)
	{
		if(v.getId()==mCommitButton.getId())
		{
			HealthInfo healthInfo=HealthInfo.getHealthInfo();
			if(mCheckBox1.isChecked())
			{
				healthInfo.corporeitysList.add("¹ýÃô");
			}
			if(mCheckBox2.isChecked())
			{
				healthInfo.corporeitysList.add("ÐÄÔà²¡");
			}
			if(mCheckBox3.isChecked())
			{
				healthInfo.corporeitysList.add("¸ßÑªÑ¹");
			}
			if(mCheckBox4.isChecked())
			{
				healthInfo.corporeitysList.add("ÌÇÄò²¡");
			}
			
			Intent intent=new Intent();
			intent.setClass(this, ExaminationActivity.class);
			startActivity(intent);
			this.finish();
		}
		
	}

}
