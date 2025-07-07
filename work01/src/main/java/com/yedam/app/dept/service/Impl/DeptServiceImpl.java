package com.yedam.app.dept.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService{
	private DeptMapper deptMapper;
	@Autowired
	public DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper=deptMapper;
	}
	@Override
	public List<DeptVO> findAllList() {
		// TODO Auto-generated method stub
		return deptMapper.selectAll();
	}

	@Override
	public DeptVO findInfoById(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return deptMapper.selecInfo(deptVO);
	}

	@Override
	public int createInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		int result = deptMapper.insertInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	} 
	
	
}
