package com.prabathj.lc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prabathj.lc.dtomodels.FeedBackDto;

@Service
public class LCSendEmailServiceImpl implements LCSendEmailServiceInterface {

	@Autowired
	private JavaMailSender mailSender; 
	
	@Override
	public void processEmail(String user, String email, String result) {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("upali.jayarathne.1996@gmail.com");
		mail.setSubject("Love Calculator Result");
		mail.setText("Hi "+user+", The Result predicted by LC app is"+result);
		
		mailSender.send(mail);
	}

	
}
