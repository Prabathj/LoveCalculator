package com.prabathj.lc.propertyeditors.credit;

import java.beans.PropertyEditorSupport;

import com.prabathj.lc.dtomodels.support.CreditCardDto;

//THIS PERFORM THE SAME TASK AS CreditCardFormatter

public class CreditCardPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		CreditCardDto cc=(CreditCardDto) getValue();
		String formattedCC= cc.getCcFirst()+"-"+cc.getCcSecond()+"-"+cc.getCcThird()+"-"+cc.getCcFourth();
		return formattedCC;
	}

	@Override
	public void setAsText(String ccInfo) throws IllegalArgumentException {
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

		setValue(ccDto);
	}

	
	
	
}
