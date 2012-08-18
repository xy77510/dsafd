/**
 * 2012-6-27
 * 
 * ����
 * 
 * ��ϸҩƷ��Ϣ����(�����ҳ����ת��ʱ��Ҫ����һ��bundle���������ݿ�loadData����)
 * 
 * */
package com.codestorm.medicine;

import com.codestorm.medicine.db.DataManage;
import com.codestorm.medicine.db.FileOperate;
import com.codestorm.medicine.model.Commentary;
import com.codestorm.medicine.model.HealthInfo;
import com.codestorm.medicine.server.AnologServer;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MedicineView extends Activity implements OnClickListener
{
	TextView mMedicineNameTextView;// ҩƷ��
	TextView mIDTextView;// ҩƷ���
	TextView mEffectTextView;// ��Ч
	TextView mTabooTextView;// ����
	TextView mManufacturerTextView;// ����
	TextView mPromotionTextView;// ������Ϣ
	Button mCommentsButton;// �鿴����
	Button mSrcButton;//��ת������ƽ̨
	Button mCollectButton;//�ղذ�ť
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.medicine_view);

		mMedicineNameTextView = (TextView) findViewById(R.id.medicineNameTextView);
		mIDTextView = (TextView) findViewById(R.id.idTextView);
		mEffectTextView = (TextView) findViewById(R.id.effectTextView);
		mTabooTextView = (TextView) findViewById(R.id.tabooTextView);
		mManufacturerTextView = (TextView) findViewById(R.id.manufacturerTextView);
		mPromotionTextView = (TextView) findViewById(R.id.promotionTextView);
		mPromotionTextView.setOnClickListener(this);
		mCommentsButton = (Button) findViewById(R.id.commentsButton);
		mCommentsButton.setOnClickListener(this);
		mSrcButton=(Button)findViewById(R.id.srcButton);
		mSrcButton.setOnClickListener(this);
		mCollectButton=(Button)findViewById(R.id.collectButton);
		mCollectButton.setOnClickListener(this);
		loadData();
	}

	// ��bundle�л�ȡ��Ϣ
	public void loadData()
	{
		Bundle bundle = this.getIntent().getExtras();
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
			// ת������ҳ��
			intent = new Intent();
			Commentary.commentriesname = mMedicineNameTextView.getText().toString();
			AnologServer.getCommentary(this,Commentary.commentriesname);
			intent.setClass(MedicineView.this, CommentaryActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("medicine", mMedicineNameTextView.getText().toString());
			startActivity(intent);
			break;
		case R.id.srcButton:
			// TODO:ת������ƽ̨
//			Uri uri = Uri.parse("http://www.baidu.com");
//			Intent it  = new Intent(Intent.ACTION_VIEW,uri);
//			startActivity(it);
			
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_WEB_SEARCH);
			intent.putExtra(SearchManager.QUERY,mMedicineNameTextView.getText().toString());
			startActivity(intent);
			break;
		case R.id.collectButton:
			HealthInfo healthInfo=HealthInfo.getHealthInfo();
			if(healthInfo.mycommentary.contains(mMedicineNameTextView.getText().toString()))
			{
				Toast.makeText(this, "���Ѿ��ղظò�Ʒ��", Toast.LENGTH_LONG).show();
			}else {
				healthInfo.mycommentary.add(mMedicineNameTextView.getText().toString());
				FileOperate.writeHealthInfo(this);
				Toast.makeText(this, "�ղسɹ���", Toast.LENGTH_LONG).show();
			}
			
		default:
			break;
		}

	}

}
