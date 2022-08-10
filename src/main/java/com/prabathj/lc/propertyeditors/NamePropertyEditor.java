package com.prabathj.lc.propertyeditors;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	//To Read
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("inside set");
		String modified=text.toUpperCase();
		setValue(modified);
	}

	//To Write
	@Override
	public String getAsText() {
		
		System.out.println("inside get");
		System.out.println((String) getValue());
		
		return null;
	}

	
	
}
