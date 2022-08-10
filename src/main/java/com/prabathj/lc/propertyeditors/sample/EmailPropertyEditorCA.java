package com.prabathj.lc.propertyeditors.sample;

import java.beans.PropertyEditorSupport;

public class EmailPropertyEditorCA extends PropertyEditorSupport {


	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String updatedmail=text+"@gmail.com";
		
		setValue(updatedmail);
	}

	
}
