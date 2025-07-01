package com.yedam.app.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx =new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//xml 파일읽어드릴때 걍 편함, 스프링에선 안씀 classpath 논리적 경로
		Student kang = ctx.getBean(Student.class); //빈호출
		System.out.println(kang);
		
		ctx.close();
	}

}
