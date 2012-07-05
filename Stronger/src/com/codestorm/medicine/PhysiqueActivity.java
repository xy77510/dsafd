/**
 * 
 * 2012-6-21
 * 
 * ����
 * 
 * ���ҳ��
 * 
 * */
package com.codestorm.medicine;

import java.util.ArrayList;
import com.codestorm.medicine.model.PhysiqueQuestion;

import android.app.Dialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class PhysiqueActivity extends ListActivity {

	ArrayList<PhysiqueQuestion> questions;
	float sum=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		questions = new ArrayList<PhysiqueQuestion>();
		Init();
		setListAdapter(new QuestionAdapter(getApplicationContext(), questions));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,0,0,R.string.head);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int item_id = item.getItemId();
		switch (item_id) {
		case 0:
		for(int index=0;index<questions.size();index++) {
			sum=sum+questions.get(index).getScore();			
	        }
		//TextView mTextView= (TextView)this.findViewById(R.id.dialogContentTextview);
		//mTextView.setText(getText(R.string.dialogContent)+String.valueOf(sum));
		//Toast.makeText(this, "rating:"+String.valueOf(sum),Toast.LENGTH_LONG).show();
		Dialog mDialog = new MyDialog(PhysiqueActivity.this,R.style.MyDialog,"�������ʷ���Ϊ��"+String.valueOf(sum));
		
		mDialog.show();
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
	}
	
	public void Init() {
		// ƽ����0
		questions.add(new PhysiqueQuestion(0, "������������", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(1, "������ƣ����", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(2, "��˵������������", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(3, "���е����Ʋ�����", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(4, "����һ�� �����ܲ��˺��䣨����ĺ��䣬�������յ������ȣ���", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(5, "������Ӧ�����Ȼ����ỷ���ı仯��", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(6, "������ʧ����", "ƽ����", 0));
		questions.add(new PhysiqueQuestion(7, "���������£���������", "ƽ����", 0));
		// ������1
		questions.add(new PhysiqueQuestion(0, "���ֽŷ�����", "������", 0));
		questions.add(new PhysiqueQuestion(1, "��θ�䲿����������ϥ��������", "������", 0));
		questions.add(new PhysiqueQuestion(2, "���е����䡢�·��ȱ��˴��ö���", "������", 0));
		questions.add(new PhysiqueQuestion(3, "����һ���˲��˺��䣨����ĺ��䣬�������յ������ȵȡ�","������", 0));
		questions.add(new PhysiqueQuestion(4, "���ȱ������׻���ð��", "������", 0));
		questions.add(new PhysiqueQuestion(5, "���ԣ��ȣ����Ķ�����е�����������³ԣ��ȣ���������","������", 0));
		questions.add(new PhysiqueQuestion(6, "��������ԣ��ȣ����Ķ��������׸�к�������ӣ���","������", 0));
		// ������2
		questions.add(new PhysiqueQuestion(0, "���е��ֽ��ķ�����", "������", 0));
		questions.add(new PhysiqueQuestion(1, "���о����塢���Ϸ�����", "������", 0));
		questions.add(new PhysiqueQuestion(2, "��Ƥ����ڴ�����", "������", 0));
		questions.add(new PhysiqueQuestion(3, "���ڴ�����ɫ��һ���˺���", "������", 0));
		questions.add(new PhysiqueQuestion(4, "�����ױ��ػ��������", "������", 0));
		questions.add(new PhysiqueQuestion(5, "���沿�������ƫ����", "������", 0));
		questions.add(new PhysiqueQuestion(6, "���е��۾���ɬ��", "������", 0));
		questions.add(new PhysiqueQuestion(7, "������Դ�����׳��麹��", "������", 0));
		// ������3
		questions.add(new PhysiqueQuestion(0, "������ƣ����", "������", 0));
		questions.add(new PhysiqueQuestion(1, "���������̣������̴٣��Ӳ�������", "������", 0));
		questions.add(new PhysiqueQuestion(2, "�������Ļ���", "������", 0));
		questions.add(new PhysiqueQuestion(3, "������ͷ�λ�վ��ʱ��ѣ��", "������", 0));
		questions.add(new PhysiqueQuestion(4, "���ȱ������׻���ð��", "������", 0));
		questions.add(new PhysiqueQuestion(5, "��ϲ������������˵����", "������", 0));
		questions.add(new PhysiqueQuestion(6, "��˵������������", "������", 0));
		questions.add(new PhysiqueQuestion(7, "����������׳��麹��", "������", 0));
		// ̵ʪ��4
		questions.add(new PhysiqueQuestion(0, "���е����ƻ򸹲�������", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(1, "���е�����ѧ�������ɻ�ˬ����", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(2, "����������������", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(3, "���ж��֬���ڶ��������", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(4, "���������ȱ����ף�����΢¡���������", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(5, "����������ĸо���", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(6, "��ƽʱ̵�࣬�ر����ʺ��ܸе���̵������", "̵ʪ��", 0));
		questions.add(new PhysiqueQuestion(7, "����̦���������̦���ĸо���", "̵ʪ��", 0));
		// ʪ����5
		questions.add(new PhysiqueQuestion(0, "���沿��ǲ�������л�������������", "ʪ����", 0));
		questions.add(new PhysiqueQuestion(1, "���������������", "ʪ����", 0));
		questions.add(new PhysiqueQuestion(2, "���е��ڿ����������ζ��", "ʪ����", 0));
		questions.add(new PhysiqueQuestion(3, "����ʹ��Ͳ�ˬ���нⲻ���ĸо���", "ʪ����", 0));
		questions.add(new PhysiqueQuestion(4, "��С��ʱ����з��ȸС���ɫŨ�����", "ʪ����", 0));
		questions.add(new PhysiqueQuestion(5, "������ɫ�ƣ��״���ɫ���ƣ��𣿣���Ů�Իش𣩣�", "ʪ����",	0));
		questions.add(new PhysiqueQuestion(6, "�������Ҳ�λ��ʪ��", "ʪ����", 0));
		// Ѫ����6
		questions.add(new PhysiqueQuestion(0, "���沿��ǲ�������л�������������", "Ѫ����", 0));
		questions.add(new PhysiqueQuestion(1, "���������������", "Ѫ����", 0));
		questions.add(new PhysiqueQuestion(2, "���е��ڿ����������ζ��", "Ѫ����", 0));
		questions.add(new PhysiqueQuestion(3, "����ʹ��Ͳ�ˬ���нⲻ���ĸо���", "Ѫ����", 0));
		questions.add(new PhysiqueQuestion(4, "��С��ʱ����з��ȸС���ɫŨ�����", "Ѫ����", 0));
		questions.add(new PhysiqueQuestion(5, "������ɫ�ƣ��״���ɫ���ƣ��𣿣���Ů�Իش𣩣�", "Ѫ����",	0));
		questions.add(new PhysiqueQuestion(6, "�������Ҳ�λ��ʪ��", "Ѫ����", 0));
		// ������7
		questions.add(new PhysiqueQuestion(0, "��û�и�ðʱҲ���������", "������", 0));
		questions.add(new PhysiqueQuestion(1, "��û�и�ðʱҲ���������������", "������", 0));
		questions.add(new PhysiqueQuestion(2, "�����򼾽ڱ仯���¶ȱ仯����ζ��ԭ����ȴ���������",	"������", 0));
		questions.add(new PhysiqueQuestion(3, "�����׹�������ҩ�ʳ���ζ�����ۻ��ڼ��ڽ��桢����仯ʱ����", "������", 0));
		questions.add(new PhysiqueQuestion(4, "����Ƥ��������ݡ������š�����顢������","������", 0));
		questions.add(new PhysiqueQuestion(5, "������������ֹ���񰣨�Ϻ�ɫ���㡢���ߣ���", "������",0));
		questions.add(new PhysiqueQuestion(6, "����Ƥ��һץ�ͺ죬������ץ����", "������", 0));
		// ������
		questions.add(new PhysiqueQuestion(0, "���е����Ʋ�����", "������", 0));
		questions.add(new PhysiqueQuestion(1, "�����׾�����š����ǲ�����", "������", 0));
		questions.add(new PhysiqueQuestion(2, "������ƸС����������", "������", 0));
		questions.add(new PhysiqueQuestion(3, "�����׸е����»��ܵ�������", "������", 0));
		questions.add(new PhysiqueQuestion(4, "��в�߲����鷿��ʹ��", "������", 0));
		questions.add(new PhysiqueQuestion(5, "����Ե�޹�̾����", "������", 0));
		questions.add(new PhysiqueQuestion(6, "���ʺ�������У�����֮��������֮������", "������", 0));
	}

}
