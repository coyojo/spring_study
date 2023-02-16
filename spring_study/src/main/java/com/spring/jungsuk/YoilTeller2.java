package com.spring.jungsuk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller2 {
	
	@RequestMapping("/getYoli")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. �Է� 
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1: �Ͽ���,  2: ������  3: ȭ���� ... 
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		//3. ���
		response.setContentType("utf-8");
		response.setCharacterEncoding("text/html");
		PrintWriter out = response.getWriter(); // response��ü���� �������� ��� ��Ʈ���� ��´�.
		out.println(year + "��" + month + "��" + day +  "���� ");
		out.println(yoil + "�����Դϴ�.");
		
		
	}

}

