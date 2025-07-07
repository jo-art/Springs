package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	private EmpMapper empMapper;
	@Autowired
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper=empMapper;
	}
	@Override
	public List<EmpVO> findAllList() {
		// TODO Auto-generated method stub
		return empMapper.selectAll();
	}

	@Override
	public EmpVO findInfoById(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectInfo(empVO);
	}

	@Override
	public int createInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		int result = empMapper.insertInfo(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyInfo(EmpVO empVO) {
		Map<String,Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result =empMapper.updateInfo(empVO.getEmployeeId(), empVO);
		if(result ==1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", map);
		/*
		  {
		  		"result":true,
		  		"target":{"employee_id":100,...}
		  
		  }
		  */
		return map;
	}

	@Override
	public Map<String, Object> removeInfo(int empId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
	
		
		int result =empMapper.deleteInfo(empId);
		if(result ==1) {
			map.put("employeeId", empId);
		}
		

		 // { "employeeId":104 }

		return map;
	}

}
