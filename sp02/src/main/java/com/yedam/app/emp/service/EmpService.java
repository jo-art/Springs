package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

//실제로 사용자에게 제공하는기능 :Business layer영역
public interface EmpService {
	//전체사원정보조회
	public List<EmpVO> findAllList();
	//사원정보 단건 조회
	public EmpVO findInfoById(EmpVO empVO);
	//사원정보 단건 등록
	public int createInfo(EmpVO empVO);
	//단건 수정
	public Map<String,Object> modifyInfo(EmpVO empVO);
	//단건 삭제
	public Map<String,Object> removeInfo(int empId);
}
