package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
class Work01ApplicationTests {
	@Autowired
	private DeptMapper deptMapper;
	@Test
	public void selectAll() {
		List<DeptVO> list = deptMapper.selectAll();
		for(DeptVO dept : list) {
			System.out.println(dept.getDepartmentName());
		}
		assertTrue(!list.isEmpty());
	}
	
	@Test
	public void selectOne() {
		DeptVO dept = DeptVO.builder().departmentId(190).build();
		DeptVO findVO = deptMapper.selecInfo(dept);
		System.out.println(findVO);
		assertEquals("Contracting",findVO.getDepartmentName());
	}
	@Test
	public void insertSelectKey() {
		DeptVO dept = DeptVO.builder().departmentName("jojeonmin").managerId(200).locationId(2500).build();
		int result= deptMapper.insertInfo(dept);
		System.out.println("부서번호 :" + dept.getDepartmentId());
		
		assertEquals(1,result);
	}

}
