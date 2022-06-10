package com.example.demo.domain.Announcement;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Announcement {

	
	//ID
	private Long id;
	
	//日時
	@NotBlank
	private String day_post;

	
	//コメント内容
	@NotBlank(message = "コメントを入力してください。")
	@Size(max = 40)
	private String message;
}