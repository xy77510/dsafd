package com.codestorm.medicine;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyDialog extends Dialog implements
		android.view.View.OnClickListener {
	Context context;
	Button okButton;
	Button noButton;
	TextView contentTextView;
	private String content;

	public MyDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public MyDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;

	}

	public MyDialog(Context context, int theme, String content) {
		super(context, theme);
		this.context = context;
		this.content = content;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog);
		okButton = (Button) findViewById(R.id.dialogButtonOk);
		okButton.setOnClickListener(this);
		contentTextView = (TextView) findViewById(R.id.dialogContentTextview);
		contentTextView.setText(content);
		noButton = (Button) findViewById(R.id.reButton);
		noButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.dialogButtonOk) {
			this.cancel();
		}
		if (v.getId() == R.id.reButton) {
			this.dismiss();
		}
	}

}