package com.yedam.app.di.anotation;

import org.springframework.stereotype.Component;

@Component //Spring Bean 으로 설정
public class MarshallSpeaker {
	public void on() {
		System.out.println("마샬스피커 on");
	}
	public void off() {
		System.out.println("마샬스피커 off");
	}
}
