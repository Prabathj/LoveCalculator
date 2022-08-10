package com.prabathj.lc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.prabathj.lc.dtomodels.support.CreditCardDto;

public class CreduCardFormatter implements Formatter<CreditCardDto> {

	public String print(CreditCardDto cc, Locale locale) {
		
		String formattedCC= cc.getCcFirst()+"-"+cc.getCcSecond()+"-"+cc.getCcThird()+"-"+cc.getCcFourth();
		return formattedCC;
	}

	public CreditCardDto parse(String ccInfo, Locale locale) throws ParseException {
		CreditCardDto ccDto=new CreditCardDto();
		
		if(ccInfo.length()!=19) {
			ccDto.setCcFirst("    ");
			ccDto.setCcSecond("    ");
			ccDto.setCcSecond("    ");
			ccDto.setCcSecond("    ");
		}else{
			String[] splitCC=ccInfo.split("-");
			ccDto.setCcFirst(splitCC[0]);
			ccDto.setCcSecond(splitCC[1]);
			ccDto.setCcThird(splitCC[2]);
			ccDto.setCcFourth(splitCC[3]);			
		}
		return ccDto;
	}

}
