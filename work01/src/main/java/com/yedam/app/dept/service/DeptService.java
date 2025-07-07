package com.yedam.app.dept.service;

import java.util.List;

public interface DeptService {

	//전체조회
	public List<DeptVO> findAllList();
	//단건조회
	public DeptVO findInfoById(DeptVO deptVO);
	//단건 등록
	public int createInfo(DeptVO deptVO);
}
