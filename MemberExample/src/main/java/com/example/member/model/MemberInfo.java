package com.example.member.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class MemberInfo {


	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private Address address;
	private String performerType;
	private String performTitle;
	private int performTime;
	private String requestedTerm;
	private boolean onlinePerform;



	public MemberInfo(String id, String name, String password, String phone,String email, Address address, String performerType,
					  String performTitle,int performTime,String requestedTerm, boolean onlinePerform) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email=email;
		this.address = address;
		this.performerType = performerType;
		this.performTitle = performTitle;
		this.performTime=performTime;
		this.requestedTerm=requestedTerm;
		this.onlinePerform = onlinePerform;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
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

	public boolean isOnlinePerform() {
		return onlinePerform;
	}

	public void setOnlinePerform(boolean onlinePerform) {
		this.onlinePerform = onlinePerform;
	}

	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}

}
