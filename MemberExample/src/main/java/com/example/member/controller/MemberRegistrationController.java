package com.example.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.member.model.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.member.model.Address;
import com.example.member.service.MemberService;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/member/register")
@SessionAttributes("regReq")
public class MemberRegistrationController {
	private static final String MEMBER_REGISTRATION_FORM 
//								= "member/registrationForm";
								= "member/registrationForm2";
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@ModelAttribute("regReq") 			// request handler methods 보다 먼저 호출됨
	public MemberRegistRequest formBacking(HttpServletRequest request) {
		MemberRegistRequest memRegReq = new MemberRegistRequest();
		Address address = new Address();
		address.setAddress2("서울시");
		memRegReq.setAddress(address);
		memRegReq.setPerformTime(10);
		return memRegReq;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return MEMBER_REGISTRATION_FORM;
	}
	
	/*  // formBacking() method 대신 아래와 같이 GET 처리 method에서 직접 객체 생성 및 초기화 가능  
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		// MemberRegistRequest 객체는 이미 생성되어 파라미터로 넘어옴
		Address address = new Address("01010", "", "");		// Address 객체 생성 및 초기화
		memRegReq.setAddress(address);
		return MEMBER_REGISTRATION_FORM;
	}
	*/
	


	@RequestMapping(method = RequestMethod.POST)
	public String register(
			@Valid @ModelAttribute("regReq") MemberRegistRequest memRegReq,
			BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
		System.out.println("command 객체: " + memRegReq);

		if (bindingResult.hasErrors()) {
			System.out.println("오류 발생");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Error: " + error.getDefaultMessage());
			}

			return MEMBER_REGISTRATION_FORM;
		}

		String mid = memberService.registerNewMember(memRegReq).getId();
		model.addAttribute("memberId", mid);
		List<MemberInfo> members=memberService.getMembers();
		model.addAttribute("members", members); //모든 멤버 정보 리스트

		// 현재 날짜와 시간을 "yyyy-MM-dd HH:mm:ss" 형식으로 변환하여 model에 추가
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		model.addAttribute("reqTime", formattedDateTime); // 현재 날짜 및 시간 추가

		sessionStatus.setComplete(); // 세션 종료
		return "member/registered";
	}

}
