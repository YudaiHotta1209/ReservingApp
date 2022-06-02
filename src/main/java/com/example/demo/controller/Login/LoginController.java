package com.example.demo.controller.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
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

}