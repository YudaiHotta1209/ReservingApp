package com.example.demo.domain.FullCalendar;

/**
 * FullCalendar用Event Object
 * 
 * @see https://fullcalendar.io/docs/event_data/Event_Object/
 */

public class DailySummary {

	/*
	 * カレンダーに表示する内容
	 */
	
	/* 用途 */
	private String title;

	/* 使用日 */
	private String start;

	
	/* 使用開始時間 */ 
	private String TimeStart;
	  
	/* 使用終了時間 */
	private String TimeEnd;
	 
	
	
	
	
	
	//-------------------用途----------------------//
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
//-------------------使用日----------------------//	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
	
	
	//-------------------使用開始時間----------------------//		
	public String getTimeStart() {
		return TimeStart;
	}
	public void setTimeStart(String TimeStart) {
		this.TimeStart = TimeStart;
	}

	
	
	//-------------------使用終了時間----------------------//	
	public String getTimeEnd() {
		return TimeEnd;
	}
	public void setTimeEnd(String TimeEnd) {
		this.TimeEnd = TimeEnd;
	}

}