package com.example.demo.controller.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	/* トップページ画面遷移 */
    @GetMapping
    public String top() {
        return "top";
    }

	/* ログインページ表示 */
    @GetMapping("/login")
    public String showLoginForm() {
        return "Login/form";
    }

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "Login/logout";
    }

	
	/*
	 * @RequestMapping("/login") public ModelAndView loginForm(ModelAndView mav) {
	 * // 画面に出力するViewを指定 mav.setViewName("Login/form"); // ModelとView情報を返す return
	 * mav; }
	 * 
	 * // 「/login」へPOST送信された場合
	 * 
	 * @RequestMapping(value = "/loginform", method = RequestMethod.GET) //
	 * POSTデータ（必須）を受け取る public ModelAndView login(@RequestParam String
	 * username, @RequestParam String password, ModelAndView mav) { //
	 * Viewに渡す変数をModelに格納 //th:text="${id}"に渡す mav.addObject("username",
	 * "Your USERNAME is " + username + ".");
	 * 
	 * //th:text="${pass}"に渡す mav.addObject("password", "PASS is " + password +
	 * "."); // 画面に出力するViewを指定 mav.setViewName("top"); // ModelとView情報を返す return
	 * mav; }
	 * 
	 * 
	 * 
	 * 
	 * // case001 「初回作動」
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * login() { System.out.println("【DEBUG】001_TEST"); return "Login/login"; }
	 * 
	 * 
	 * 
	 * @GetMapping("/logout") public String showLogoutForm() { return
	 * "Login/logout"; }
	 */

}