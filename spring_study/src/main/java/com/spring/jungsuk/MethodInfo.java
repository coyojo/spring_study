package com.spring.jungsuk;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//1. YoilTeller 클래스의 객체를 생성 
		Class clazz = Class.forName("com.spring.jungsuk.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		//2. 모든 메서드 정보를 가져와서 배열에 저장 .
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName(); // 메서드의 이름 
			Parameter[] paramArr = m.getParameters(); //매개변수 목록 
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType();  // 메서드의 반환 타입 
			
			
			//StringJoiner ( "구분자" , "접두사", "접미사" ); 
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			
			
			//메서드의 매개변수도 여러개일 수 있으니 배열로 가져와 반복문 돌리기
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}