package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;
@CrossOrigin(origins="*") //cors  설정
@Controller
public class ParameterController {
	// QueryString(질의문자열) : key=value&key=value&...
	// Content-type : application/x-www-form-urlencoded
	// Method : 상관없음
	
	//QueryString 1. 커맨드객체(어노테이션 없이 객체로 선언)
	@RequestMapping("comobj")
	@ResponseBody //AJAX
	public String commandObject(EmpVO empVO) {
		String result="";
		result +="Path: /comobj \n";
		result += "\t employee_id:"+empVO.getEmployeeId();
		result += "\t last_name:"+empVO.getLastName();
		return result;
	}
	//QueryString 2) @RequestParam(기본타입, 단일값)
	@RequestMapping("reqparam")
	@ResponseBody
	public String requestParam
	(@RequestParam Integer employeeId,String lastName) {
		String result="";
		result +="path: /reqparam \n";
		result +="\t employee_id :"+employeeId;
		result +="\t last_name :"+lastName;
		return result;
	}
	// @PathVariable : 경로에 값을 포함하는 방식, 단일 값
	// Method는 상관없음
	// Content-type도 상관없음
	@RequestMapping("path/{id}")
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result ="";
		result +="paht: /path/{id} \n";
		result += "\t id:"+id;
		return result; 
	}
	
	// @RequestBody : JSON 포맷, 배열 or 객체
	// Method : POST, PUT
	// Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public EmpVO requestBody(@RequestBody EmpVO empVO) {
		return empVO;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public List<EmpVO> resbodyList(@RequestBody List<EmpVO> list) {
		return list;
	}
	
}
