package com.spring.jungsuk;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVCMAV {
	
	@RequestMapping("/getYoilMVC")
	//public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public ModelAndView main( // ��ȯ Ÿ���� ModelAndView
			int year, int month, int day) throws IOException {
		//ModelAndView�� �����ϰ� , �⺻ �並 ����
		ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError");
		
		//1. ��ȿ�� �˻�
		if(!isValid(year,month,day))
		return mv;
		
		//2. ���� ���
		char yoil = getYoil(year, month, day);
		
		//3. ��� - ����� ����� model�� ����( model�� �����ϰ� ��������)
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		//return "yoil";   //WEB-INF/views/yoil.jsp
		
		//4. �۾� ����� ������ view�� �̸��� ����
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
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1: �Ͽ���,  2: ������  3: ȭ���� ... 
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}

