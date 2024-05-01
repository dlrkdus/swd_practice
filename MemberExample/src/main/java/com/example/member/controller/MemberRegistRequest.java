package com.example.member.controller;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.member.model.Address;

public class MemberRegistRequest {

	private LocalDate reqTime;
	@NotBlank
	private String name;

	//비밀번호는 최소 8자 이상, 영문, 숫자, 특수문자를 하나 이상씩 포함해야 함
	@NotEmpty
	@Size(min=8)
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$")
	private String password;

	@Pattern(regexp="^01\\d{1}-\\d{3,4}-\\d{4}$")
	private String phone;

	@NotEmpty
	@Email //휴대폰번호와 이메일은 정해진 형식을 따라야 함
	private String email;

	@Valid
	private Address address;

	private String performerType;

	private String performTitle;

	@Max(value=20) // 기본 시간은 10분이고, 최대 20분까지 가능
	private int performTime;

	@Size(max=30)
	private String requestedTerm; //그 밖의 정보 추가 (요청사항 추가했습니다.)

	private boolean onlinePerform; // true/false 입력 (default: false)

	@NotEmpty 
	private String confirmPassword;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone(){ return phone; }

	public void setPhone(String phone){ this.phone=phone;}


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isOnlinePerform() {
		return onlinePerform;
	}

	public void setOnlinePerform(boolean onlinePerform) {
		this.onlinePerform = onlinePerform;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPerformerType() {
		return performerType;
	}

	public void setPerformerType(String performerType) {
		this.performerType = performerType;
	}

	public String getPerformTitle() {
		return performTitle;
	}

	public void setPerformTitle(String performTitle) {
		this.performTitle = performTitle;
	}

	public int getPerformTime(){
		return performTime;
	}
	public void setPerformTime(int performTime){
		this.performTime=performTime;
	}
	public String getRequestedTerm(){
		return requestedTerm;
	}
	public void setRequestedTerm(String requestedTerm){
		this.requestedTerm=requestedTerm;
	}

	@AssertTrue
	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}


	@Override
	public String toString() {
		return "MemberRegistRequest [name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", performerType=" + performerType + ", performTitle=" + performTitle +
				", performTime=" + performTime + ", requestedTerm=" + requestedTerm + ", isOnlinePerform=" + onlinePerform +  "]";
	}
}
