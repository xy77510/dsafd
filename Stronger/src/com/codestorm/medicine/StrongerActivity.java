/**
 * 2012-6-19
 * 
 * 周坤
 * 
 * 程序主页面，显示LOGO2秒，然后跳转到个人中心
 * 
 * */

package com.codestorm.medicine;

import java.util.Timer;
import java.util.TimerTask;

import com.codestorm.medicine.db.FileOperate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class StrongerActivity extends Activity
{
	Handler handler;
	Intent intent;
	Timer timer;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);		
		handler=new Handler()
		{

			@Override
			public void handleMessage(Message msg)
			{
				switch (msg.what)
				{
				case 5555:
					intent=new Intent();
					intent.setClass(StrongerActivity.this, LoginActivity.class);
					startActivity(intent);
					StrongerActivity.this.finish();
					break;

				default:
					break;
				}
			}		
			
		};
		TimerTask timerTask=new TimerTask()
		{
			
			@Override
			public void run()
			{
				Message message=new Message();
				message.what=5555;
				handler.sendMessage(message);
			}
		};
		timer=new Timer(true);
		timer.schedule(timerTask, 2000);		
	}
}