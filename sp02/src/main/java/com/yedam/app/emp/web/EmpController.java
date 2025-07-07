package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller 
//DispatcherServlet 이 활용한 정보를 등록하는 Bean 
//route : 사용자의 요청(endpint)와 그에 대한 처리
// uri + http method => Service => Response(view or data)
@RequiredArgsConstructor

public class EmpController {
	//해당 controller 에 제공하는 서비스 목록 
	//롬복으로 기반으로 해서 생성자 주입 하는 방식
	//final로 선언되면 생성자 반드시 필요
	private final EmpService empService;
	
	//GET : 조회, 빈페이지,데이터조작(삭제)
	//POST : 데이터 조작(등록, 수정)
	//HTTP 메서드를 의도에 맞게 사용하는 것이 바로 "정통적인 방식"
	
	//전체조회 :GET
	@GetMapping("empList")
	public String empList(Model model) { //1) URI+ METHOD
		// 모델 객체를 쓰는 이유 화면에 보여주기 위함
		
		//2)  수행 기능
		List<EmpVO> list=empService.findAllList();
		
		//2-1) View 에 전달할 데이터 담기
		model.addAttribute("emps",list);
		
		//3) 응답 형태 :View
		return "emp/list";
		
		//classpath:/template/	emp/list		.html
		//prefix				return			suffix
	}
	//단건조회 :GET 데이터를 가져올때  pathVariavl(선택적) or queryString | empInfo?employeeId=100
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO= empService.findInfoById(empVO); 
		model.addAttribute("emp",findVO);
		return "emp/info";
	}
	
	//등록 - 페이지:GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
		//classpath:/templates/emp/insert.html
	}
	//등록 -처리 :POST => <form/> submit /QueryString
	@PostMapping("empInsert") //바디를 사용한다는 의미
	public String empInsertProcess(EmpVO empVO) { //커맨드 객체
		int eid = empService.createInfo(empVO);
		String url = null;
		if(eid>-1) {
			//정상적으로 등록
			url ="redirect:empInfo?employeeId="+eid;
		}else {
			//등록되지 않은 경우
			url="redirect:empList";
		}
		return url;
	}
	//수정 - 페이지:GET<=>단건조회 ,비밀번호 예외
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO= empService.findInfoById(empVO); 
		model.addAttribute("emp",findVO);
		return "emp/update";
	}
	//수정 - 처리:POST +AJAX +JSON
	@PostMapping("empUpdate")
	@ResponseBody //Ajax => Model  사용하지 않음			
	public Map<String,Object> empUpdateProcess(@RequestBody EmpVO empVO) {//JSON
		return  empService.modifyInfo(empVO);
	}
	
	//삭제 - 처리:GET=>QueryString ,전용페에지가 따로 없음 , 회원탈퇴 예외
	//: empDelete?employeeId=value
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.removeInfo(employeeId);
		return "redirect:empList";
	}
	
}
