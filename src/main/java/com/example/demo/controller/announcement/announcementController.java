package com.example.demo.controller.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Announcement.Announcement;
import com.example.demo.service.Announcement.AnnouncementService;


@Controller
@RequestMapping("/announcements")

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－ーーー
/*
 * <--管理者側から行う操作--> 
 * ①ユーザーが登録した予約情報を全件取得する 
 * 
 * <--既存機能の活用--> 
 * ①詳細表示 ②削除処理 ③変更処理
 */

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－－//

public class announcementController {

	@Autowired
	private AnnouncementService announcementService;
	
//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－－//	
	//①全ユーザー予約リスト表示
	@GetMapping
	public String list(Model model) {
		model.addAttribute("announce_info", announcementService.findAll());
		System.out.println("【DEBUG】Announce_TEST01 : " + model);
		return "top-board";
	}
	
    //②新規登録ページ表示
	@GetMapping("/comment-new")
	public String newMeeting(@ModelAttribute("announce_info") Announcement announcement, Model model) {
		return "Announce/comment-new";
	}

//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－－//	
	

	
//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//

	
	//①登録処理（データ登録）
	@PostMapping
	public String create(@ModelAttribute("announce_info") @Validated Announcement announcement, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Announcement/comment-new";
		} else {
			announcementService.insert(announcement);
			return "redirect:/announcements";
		}
	}		
	
	//⑤削除処理
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		announcementService.delete(id);
		return "redirect:/announcements"; 
	}
//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//
}