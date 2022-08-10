package com.prabathj.lc.dtomodels;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.prabathj.lc.dtomodels.support.CommunicationDto;
import com.prabathj.lc.validators.Age;

public class RegistrationInfoDTO {
	@NotEmpty
	private String name;
	private String userName;
	private char[] password;
	private String country;
	private List<String> hobbies;
	private String gender;
	
	//Since the front-end text box String value converted to int by Spring[ remember the difference between int & INTEGER], if there is any not numeric character
	//need to validate field else will get error. Use developed validation annotation using Validation API
	@Age(min=20,max=50,message="{agemsg}")
	private Integer uAge;
	
	@Valid					//Specify to cascade any error details
	private CommunicationDto commInfo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate regDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getuAge() {
		return uAge;
	}
	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}
	public CommunicationDto getCommInfo() {
		return commInfo;
	}
	public void setCommInfo(CommunicationDto commInfo) {
		this.commInfo = commInfo;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
	
	
}
