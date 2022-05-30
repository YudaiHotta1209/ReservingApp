package com.example.demo.controller.Fullcarendar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.FullCalendar.DailySummary;
import com.example.demo.service.Meeting.user.UserMeetingService;
import com.fasterxml.jackson.databind.ObjectMapper;

//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－//

/*
 * 機能実装方法の手本 
 * （１）FullCalendar用のmodelを作成 
 * （２）DBから予約履歴を検索
 * （３）（２）を（１）で作成したmodelに代入 
 * （４）（２）のデータ（model）をRestControllerに渡す。
 * （５）予約情報の文字列にリンクタグを埋め込む。 
 * （６）データをJson化し、FullCalendarに渡す。 
 * （７）FullCalendarに表示
 * 
 * <参考資料>
 * ①https://teratail.com/questions/113448
 * ②https://qiita.com/spboot/items/8ff6ea715348d6155001#%E4%BD%BF%E3%81%A3%E3%81%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA%E3%81%A8%E3%83%90%E3%83%BC%E3%82%B8%E3%83%A7%E3%83%B3
 * 
 * 
 * ＜作業メモ＞
 * ①実装したいこと
 * ・テーブルに登録された予約情報をカレンダーへ出力
 * ・名前・予約日のみを表示
 * ・全ユーザーを出力
 * －－－－－－－－－－－→計3点
 * 
 * ②実装に向けて上記の手本をアレンジ
 * （１）FullCalendar用のmodelを作成 
 * （２）ログインID（username）をもとにDBから予約履歴を検索
 * 　　　※検索の際にSpringSecurityのログイン機能実装時に使用するModelクラス（CustomUserDetails)を活用
 * （３）（２）を（１）で作成したmodelに代入
 * （４） 
 * （５）
 * 
 */
//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－//
@Controller
@RestController
@RequestMapping("/Calendar")
public class RestCalenderController {

	@Autowired
	UserMeetingService userMeetingService;

	@GetMapping(value = "/Reserving")
	public String getReserving(){
		// @AuthenticationPrincipal＝SpringSecurityで認証されている
		// ユーザーの情報を受け取ることができるアノテーション

		String jsonMsg = null;
		// JackSonの値は空であると確認
		try {
			/*
			 * List<DailySummary> reservings= new ArrayList<DailySummary>(); DailySummary
			 * dailiSummary = new DailySummary();
			 * reservings.addAll(userMeetingService.findAllReserving());
			 */
			List<DailySummary> reservings= new ArrayList<DailySummary>();
//			List<DailySummary> dailySummary= new ArrayList<DailySummary>();
//			 dailySummary = userMeetingService.findAllReserving();
//			reservings.addAll(dailySummary);

             List<DailySummary>dailySummaries = userMeetingService.findAllReserving();			
			for(int i=0;  i<dailySummaries.size(); i++) {
				//dairySummariez = データ全体の個数
				 DailySummary dailySummary = new DailySummary();
				 dailySummary = dailySummaries.get(i);
				 //i = Long idを指す→連番で1つずつ
				 //ここからidごとに詳細ページリンクを表示させるようリンクを張る				 
				 System.out.println("【DEBUG】Calendar_TEST0：" + dailySummaries);
				 reservings.add(dailySummary);
			}
			/*
			 * dailySummary.setTitle("first event"); dailySummary.setStart("2022-05-13");
			 * reservings.add(dailySummary);
			 */
	         
	         
			
			/*
			 * ①DailySummary（Model)に検索結果を格納する 
			 * ②reservingsに検索結果を移す 
			 * ③DailySummaryを初期化
			 */
			
		
			// FullCalendarにエンコード済み文字列を渡す
			ObjectMapper mapper = new ObjectMapper();
			jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reservings);
			// writerWithDefaultPrettyPrinter().writeValueAsString()でフォーマットされたJACKSON(JSON)を出力
		} catch (IOException ioex) {
		}
		System.out.println(jsonMsg);
		return jsonMsg;
	}

}