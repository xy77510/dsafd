package com.codestorm.medicine.model;


public class PhysiqueQuestion {


	public PhysiqueQuestion(int num, String content, String tizi, float score) {
		super();
		this.num = num;
		this.content = content;
		this.tizi = tizi;
		this.score = score;
	}
	private int num;
	private String content;
	private String tizi;
	private float score;
	

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTizi() {
		return tizi;
	}
	
	public void setTizi(String tizi) {
		this.tizi = tizi;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String toString() { 
/*    	if (rating>=3.0) { 
    		return(label.toUpperCase()); 
    	} */
    	return(content); 
    }

}
