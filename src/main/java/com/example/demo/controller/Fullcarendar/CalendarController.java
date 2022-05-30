package com.example.demo.controller.Fullcarendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {
		
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
	 * 
	 */
	//－－－－－－－－－－－－－－－－－－メモ－－－－－－－－－－－－－－－－－－－－//

//－－－－－－－－－－－－－－－－－－カレンダー処理（予約一覧表示）－－－－－－－－－－－－－－－－－－－－//	
	

    ///画面遷移
	@RequestMapping(path = "/Schedule", method = RequestMethod.GET)
	/* /Schedule/Reserving→/Scheduleのみに変更 */
    String getCalendar(Model model) {
		System.out.println("【DEBUG】010_TEST");
        return "FC/CommonCalendar";
    }
}