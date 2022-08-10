package com.prabathj.lc.formatters;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.prabathj.lc.dtomodels.support.CurrencyInfoDTO;

public class CurrencyFormatter implements Formatter<CurrencyInfoDTO> {

	public String print(CurrencyInfoDTO payInfo, Locale locale) {
		
		String formattedPay=payInfo.getCurrencyType()+" "+payInfo.getBillValue().toString();
		return formattedPay;
	}

	public CurrencyInfoDTO parse(String currency, Locale locale) throws ParseException {
		CurrencyInfoDTO payDto=new CurrencyInfoDTO();
		System.out.println(locale.getCountry());
		//Get currency instance from locale; This will have all currency related information
		Currency currentCurrency = Currency.getInstance(locale);
		if(currentCurrency!=null) {
			payDto.setCurrencyType(currentCurrency.getSymbol());
		}
		//String ammount=currency.substring(4);
		payDto.setBillValue(new BigDecimal(currency));
		
		return payDto;
	}

}
