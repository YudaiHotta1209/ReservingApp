package com.example.demo.controller.meeting.user;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.domain.Meeting.Meeting;
import com.example.demo.domain.Session.UsernameSession;
import com.example.demo.service.Meeting.user.UserMeetingService;

@Controller
@RequestMapping("/meetings")

/* ①セッションのオブジェクトの設定(names = {"usernamesession"}) */
@SessionAttributes(names = { "usernamesession" })
public class UserMeetingController {

	@Autowired
	private UserMeetingService userMeetingService;

//－－－－－－－－－－－－－－－－－－検索処理（履歴一覧表示）－－－－－－－－－－－－－－－－－－－－//

	/*
	 * セッションにusernameを格納し、画面遷移時に再検索。 ①ログイン画面からusernameを受け取る ②変数String nameにする
	 * ③Modelに渡す ④mapperクラスでModelに渡した変数で検索をかける ⑤結果を"meetings/list"に返す
	 * 
	 * session利用時
	 * 
	 * @SessionAttributeで指定した("")に記載のモデルに格納してから活用する
	 */

	/*
	 * セッション保持実装過程の必要処理 ①セッションのオブジェクトの設定(names = {"usernamesession"})・・・・・・・・・・・・・完了
	 * ②thymeleafからの値を受け取り、セッションへ格納 ・・・・・・・・・・・・・・・・・・・・完了
	 * ③コントローラーのメソッドにセッションへ格納された変数を使用するようコーディング・・・・完了
	 * ④ログイン時にセッションへ格納された変数で検索処理をかける＋画面戦時にも同様の処理・・・完了
	 * ④ログアウト時に、セッション情報の破棄・・・・・・・・・・・・・・・・・・・・・・・・・完了
	 */

	// ログインIDと一致した情報のみを抽出
	// 4/20
	// ①一覧表示
	// ログイン時にIDをもとに検索処理実行
	// →listページに検索結果を表示

	// ---"usernamesession"に保存するオブジェクトの設定---//
	@ModelAttribute("usernamesession")
	public UsernameSession UsernameSession() {
		// セッションに格納する属性名を指定＝UsernameSession
		return new UsernameSession();
	}

	// ログイン後にusernameを受け取る→セッションに格納→セッションに格納されたusernameで検索処理
	// ①ログイン画面からusernameを受け取る
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String add(@RequestParam("username") String username, Model model) {
		// ②セッションに格納
		// フロントからusernameを受け取り変数String usernameに変換→modelへ渡す
		model.addAttribute("usernamesession", username);
		// ③セッションusernamesessionに格納後にtopページへ移動
		return "top";
	}

	// セッションに格納されたusernameで検索処理をし、画面遷移時に検索結果一覧を表示
	// ①getmapping
	@GetMapping("/list")
	// ②セッションから値を取得
	public String list(SessionStatus sessionStatus, @SessionAttribute("usernamesession") String username, Model model) {
		// SessionStatusはセッションは期のために残す
		System.out.println("【DEBUG】001_TEST : " + username);
		// ③検索処理
		List<Meeting> meeting = userMeetingService.findAll(username);
		System.out.println("【DEBUG】002_TEST : " + username);
		model.addAttribute("meeting_info", meeting);
		System.out.println("【DEBUG】003_TEST : " + meeting);
		// ④listページへ画面遷移
		return "meetings/list";
	}

//－－－－－－－－－－－－－－－－－－検索処理（履歴一覧表示）－－－－－－－－－－－－－－－－－－－－//
	
	
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

	
//－－－－－－－－－－－－－－－－－－カレンダー処理（予約一覧表示）－－－－－－－－－－－－－－－－－－－－//	
	
   
	
	
	


//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－//
	// 新規登録画面表示(5/13正常動作中）
	@GetMapping("new")
	public String newMeeting(@ModelAttribute("meeting_info") Meeting meeting, Model model) {
		return "meetings/new";
	}

	/// CRUD処理///
	/// ↓
	/// ↓

	/// 4月20日・・・詳細と変更ボタンを押した際に「TooManyResultsException: Expected one result (or
	/// null) to be returned by selectOne(), but found: 2」
	/// のエラー表示を確認。usernameが同一のものが複数ある場合に発生。クラス名を変えても同じ事象が発生し効果なし。
	/// 4月21日・・・カラムにidを追加。auto_incrementを設定し解決
	/// --①詳細表示--///

//－－－－－－－－－－－－－－－－－－画面遷移－－－－－－－－－－－－－－－－－－－－//

//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("meeting_info", userMeetingService.selectOne(id));
		return "meetings/show";
	}

	/// --②-1編集（更新）--///
	/// 4月20日・・・詳細と変更ボタンを押した際に「TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2」
	/// のエラー表示を確認。usernameが同一のものが複数ある場合に発生。クラス名を変えても同じ事象が発生し効果なし。
	///
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, @ModelAttribute("meeting_info") Meeting meeting, Model model) {
		model.addAttribute("meeting_info", userMeetingService.selectOne(id));
		return "meetings/edit";
	}

	/// --②-2編集（更新）--///
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("meeting_info") @Validated Meeting meeting,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("meeting_info", meeting);
			return "meetings/edit";
		} else {
			meeting.setId(id);
			userMeetingService.update(meeting);
			return "redirect:/meetings/list";
		}
	}

	/// --③登録--///
	// 4月20日新規登録処理出来ず。
	// →トップページへのリダイレクト不可。
	@PostMapping
	public String create(@ModelAttribute("meeting_info") @Validated Meeting meeting, BindingResult result,Model model) {
		System.out.println("【DEBUG】insert01_TEST : " + meeting);
		if (result.hasErrors()) {
			System.out.println("【DEBUG】insert02_TEST : " + result);
			return "meetings/new";
		} else {
			userMeetingService.insert(meeting);

			return "redirect:/meetings/list";
		}
	}

	// --④削除処理--///
	// 削除処理後にmeetings/listに再アクセス処理
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		userMeetingService.delete(id);
		return "redirect:/meetings/list";
	}

//－－－－－－－－－－－－－－－－－－CRUD処理－－－－－－－－－－－－－－－－－－－－//	

}