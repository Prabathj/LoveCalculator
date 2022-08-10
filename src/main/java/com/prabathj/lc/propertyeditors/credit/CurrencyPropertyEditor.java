package com.prabathj.lc.propertyeditors.credit;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class CurrencyPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		setValue(text.toUpperCase());
	}

	
}
