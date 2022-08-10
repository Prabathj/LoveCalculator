package com.prabathj.lc.controllers.creditControllers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Currency;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prabathj.lc.dtomodels.BillPaymentDto;
import com.prabathj.lc.dtomodels.support.CreditCardDto;
import com.prabathj.lc.dtomodels.support.CurrencyInfoDTO;
import com.prabathj.lc.propertyeditors.credit.CurrencyPropertyEditor;

@Controller
public class CreditController {

	
	@RequestMapping("/payment")
	public String paymentStart(@ModelAttribute("billInfo") BillPaymentDto billDto) {
		CreditCardDto ccinfo=new CreditCardDto();
		ccinfo.setCcFirst("    ");
		ccinfo.setCcSecond("    ");
		ccinfo.setCcThird("    ");
		ccinfo.setCcFourth("    ");
		billDto.setCcNo(ccinfo);
		
		CurrencyInfoDTO ammount=new CurrencyInfoDTO();
		ammount.setCurrencyType("USD");
		ammount.setBillValue(new BigDecimal("0000.00"));
		billDto.setAmmountInfo(ammount);
		
		return "bill-payment";
	}
	
	@RequestMapping("/bill-process")
	public String processPayment(@ModelAttribute("billInfo") BillPaymentDto billDto){
		
		return "payment-info";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dtBinder)
	{
		
		//In built  property editors
				
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor=new CustomDateEditor(dateFormat, false);
		dtBinder.registerCustomEditor(LocalDate.class,"billDate", dateEditor);
		
		NumberFormat numFormat=new DecimalFormat("##,###.00");
		CustomNumberEditor numberEditor=new CustomNumberEditor(BigDecimal.class,numFormat, false);
		dtBinder.registerCustomEditor(BigDecimal.class, "ammount",numberEditor);
		
		CurrencyPropertyEditor ccPropert=new CurrencyPropertyEditor();
		dtBinder.registerCustomEditor(Currency.class,ccPropert);
		
	}
}
