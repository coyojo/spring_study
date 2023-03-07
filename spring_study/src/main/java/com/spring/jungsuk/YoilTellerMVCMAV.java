package com.spring.jungsuk;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//년원일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVCMAV {
	
	@RequestMapping("/getYoilMVC")
	//public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public ModelAndView main( // 반환 타입이 ModelAndView
			int year, int month, int day) throws IOException {
		//ModelAndView를 생성하고 , 기본 뷰를 지정
		ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError");
		
		//1. 유효성 검사
		if(!isValid(year,month,day))
		return mv;
		
		//2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		//3. 출력 - 계산한 결과를 model에 저장( model에 저장하고 공유해줌)
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		//return "yoil";   //WEB-INF/views/yoil.jsp
		
		//4. 작업 결과를 보여줄 view의 이름을 지정
		mv.setViewName("yoil");
		
		return mv;
		
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

