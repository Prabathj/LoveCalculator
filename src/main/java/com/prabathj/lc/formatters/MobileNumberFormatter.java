package com.prabathj.lc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.prabathj.lc.dtomodels.support.MobileNumberDto;

public class MobileNumberFormatter implements Formatter<MobileNumberDto> {

	public String print(MobileNumberDto mDto, Locale locale) {
		
		String formattedMobile=mDto.getCountryCode()+"-"+mDto.getMobileNum();
		return formattedMobile;
	}

	public MobileNumberDto parse(String text, Locale locale) throws ParseException {
		
		MobileNumberDto parsedObj=new MobileNumberDto();
		parsedObj.setOrginalString(text);
		
		if(text.indexOf('-')==2) {
			String[] splData=text.split("-");
			parsedObj.setCountryCode(splData[0]);
			parsedObj.setMobileNum(splData[1]);
			
		}else if(text.indexOf('-')==-1){
			parsedObj.setCountryCode("94");
			parsedObj.setMobileNum(text);			
			
		}else{
			String[] splData=text.split("-");
			parsedObj.setCountryCode("94");
			parsedObj.setMobileNum(splData[1]);			
		}
		
		return parsedObj;
	}

}
