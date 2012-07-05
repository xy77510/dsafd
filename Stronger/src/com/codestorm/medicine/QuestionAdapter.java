package com.codestorm.medicine;

import java.util.ArrayList;

import com.codestorm.medicine.model.PhysiqueQuestion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class QuestionAdapter extends ArrayAdapter<PhysiqueQuestion> {
	
	private Context context;
	private ArrayList<PhysiqueQuestion> items;

	public QuestionAdapter(Context context, ArrayList<PhysiqueQuestion> items) {
		super(context, R.layout.physique, items);
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RatingBar rate;
		final ViewHolder holder;
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.physique, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		OnRatingBarChangeListener listener = new OnRatingBarChangeListener() {
			
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Integer pos = (Integer) ratingBar.getTag(); 
				PhysiqueQuestion row = items.get(pos); 
	            row.setScore(rating); 
	            
	            holder.getLabel().setText(row.toString());
			}
		};
		PhysiqueQuestion row = items.get(position);
		holder.getLabel().setText(row.toString());
		rate = holder.getRate();
		rate.setOnRatingBarChangeListener(listener);
		rate.setTag(new Integer(position));
		rate.setRating(row.getScore());
		return convertView;
	}
	
	private class ViewHolder {
		
		private View base;
		private RatingBar rate;
		private TextView label;
		
		public ViewHolder(View base) {
			this.base = base;
		}

		public RatingBar getRate() {
			if(rate == null) {
				rate = (RatingBar) base.findViewById(R.id.ratingBar);
			}
			return rate;
		}

		public TextView getLabel() {
			if(label == null) {
				label = (TextView) base.findViewById(R.id.textView);
			}
			return label;
		}
		
	}

}