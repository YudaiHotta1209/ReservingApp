package com.example.demo.domain.Meeting;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class Meeting {

	
	//ID
	private Long id;
	
	
	//集会室番号
	@NotBlank(message = "部屋番号を入力してください。")
	private String roomid;

	
	//ユーザー名
	@NotBlank(message = "ユーザーIDを入力してください。")
	private String username;

	
	//オーナー名
	@NotBlank(message = "利用者名を入力してください。")
	private String owner;
	
	//利用開始時間
	/* @DateTimeFormat(pattern= "yyyy/MM/dd HH:mm:ss") */
	@NotBlank
	private String start;
	
	//利用終了時間
	/* @DateTimeFormat(pattern= "yyyy/MM/dd HH:mm:ss") */
	@NotBlank
	private String end;
	
	//用途
	@NotBlank(message = "用途を選択してください。")
	private String title;
	
	//利用人数
	@Min(value = 1, message = "2以上の利用予定人数を入力してください。")
	@Max(value = 10, message = "8以下の利用予定人数を入力してください。")
	private Integer people;
	

	
	//備考欄
	@NotBlank(message = "要望事項がある場合は入力してください。")
	private String remarks;
	
	
	
	//-------------------id----------------------//	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
  //-------------------集会室番号----------------------//
    public String getRoomid() {
        return roomid;
    }
    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }
    
    
  //-------------------ユーザーID----------------------//
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
  //-------------------使用者名----------------------//
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
  //-------------------使用開始日時----------------------//
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
        
  //-------------------使用終了日時----------------------//
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    
    
  //-------------------用途----------------------//
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
  //-------------------使用人数----------------------//
    public  Integer getPeople() {
        return people;
    }
    public void setPeople(Integer people) {
        this.people = people;
    }
    
    
  //-------------------備考----------------------//
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}