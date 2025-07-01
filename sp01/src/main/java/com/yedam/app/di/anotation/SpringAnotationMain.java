package com.yedam.app.di.anotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:AnotationContext.xml");
		LGTV tv = ctx.getBean(LGTV.class);
		tv.powerOn();
		
		AppleTV secondTV = ctx.getBean(AppleTV.class);
		secondTV.powerOn();
		ctx.close();
	}
}
