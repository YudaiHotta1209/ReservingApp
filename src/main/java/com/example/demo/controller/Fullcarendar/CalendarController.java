package com.example.demo.controller.Fullcarendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {
		
    ///カレンダー画面遷移
	@RequestMapping(path = "/Schedule", method = RequestMethod.GET)
	/* /Schedule/Reserving→/Scheduleのみに変更 */
    String getCalendar(Model model) {
		System.out.println("【DEBUG】010_TEST");
        return "FC/CommonCalendar";
    }
}