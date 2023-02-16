package com.spring.jungsuk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice { 
	//java파일 - > 실행시 마다 결과가 변함  - > 동적 리소스( 프로그램, 스트리밍) 
	// 이미지파일 자체 - > 실행시마다 이미지파일이 변하는게 아니므로 -> 정적 리소스  
	//클라이언트 :  서비스를 요청하는 애플리케이션
	// 서버 : 서비스(service)를 제공하는 애플리케이션
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
	int idx1 = (int)(Math.random()*6)+1;
	int idx2 = (int)(Math.random()*6)+1;
	
	response.setContentType("text/html");
	response.setCharacterEncoding("utf-8");
	PrintWriter out	= response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("</head>");
	out.println("<body>");
	out.println("<img src='resources/img/dice"+idx1+".jpg'>"); 
	out.println("<img src='resources/img/dice"+idx2+".jpg'>");
	out.println("</body>");
	out.println("</html>");
	}

}
