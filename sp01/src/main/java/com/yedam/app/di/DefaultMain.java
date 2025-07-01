package com.yedam.app.di;

public class DefaultMain {
//기존 자바 방식 
	public static void main(String[] args) {
		SonySpeaker speaker = new SonySpeaker();
		//SamsungTV tv = new SamsungTV(speaker);
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker);
		tv.powerOn();
	}

}
