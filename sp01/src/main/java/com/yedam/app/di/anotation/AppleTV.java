package com.yedam.app.di.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
//@Data
//@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

//롬복을 기반으로 할때 생성자주입
//@RequiredArgsConstructor //final 로  선언된 필드로 생성자 구성
public class AppleTV {
	@Setter(onMethod_= {@Autowired})
	//생성자가 하나일 경우라서 어토와이드를 별도로 선언할 필요없음
	private  MarshallSpeaker speaker; //파이널 상수
	public void powerOn() {
		System.out.println("스피커 온");
	};
	public void powerOff() {
		System.out.println("스피커 오프");
	};
}
