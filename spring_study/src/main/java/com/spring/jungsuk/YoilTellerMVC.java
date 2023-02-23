package com.spring.jungsuk;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//년원일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC")
	//public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(int year, int month, int day, Model model) throws IOException {
		
		//1. 유효성 검사
		if(!isValid(year,month,day))
			return "yoilError";
		
		//2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		//3. 출력 - 계산한 결과를 model에 저장( model에 저장하고 공유해줌)
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";   //WEB-INF/views/yoil.jsp
		
	
		
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1: 일요일,  2: 월요일  3: 화요일 ... 
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}

