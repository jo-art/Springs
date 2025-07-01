package com.yedam.app.di;

public class SamsungTV { 
	private SonySpeaker speaker;//부품관계
	
	public SamsungTV(SonySpeaker speaker) {
		this.speaker=speaker;
	}
	public SamsungTV(){};//생성자방식
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker=speaker;
	} //세터방식, 유연하게 필드값을 제어할 때 
	
	public void powerOn() {
		speaker.on();
	}
	public void powerOff() {
		speaker.off();
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
