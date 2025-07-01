package com.yedam.app.di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringXMLMain {

	public static void main(String[] args) {
		//스프링방식 생성자 방식으로 메인을 변경하지않음
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		SamsungTV tv = ctx.getBean(SamsungTV.class);
		tv.powerOn();
		
		ctx.close();
	}

}
