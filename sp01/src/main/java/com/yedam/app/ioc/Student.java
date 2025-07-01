package com.yedam.app.ioc;

public class Student {
	private int ssn;
	private String name;
	private String School;
	public Student() {
		System.out.println("Student Instance 생성");
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	@Override
	public String toString() {//직렬화 시키는 함수
		return "Student [ssn=" + ssn + ", name=" + name + ", School=" + School + "]";
	}
}

