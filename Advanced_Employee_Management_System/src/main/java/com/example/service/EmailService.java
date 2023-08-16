//package com.example.service;
//
//import java.util.Random;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.custom_exception.ResourceNotFoundException;
//import com.example.email.Email;
//import com.example.pojo.Admin;
//import com.example.pojo.EmailVerification;
//import com.example.repository.EmailRepository;
//import com.example.service.IEmail.IEmailService;
//
//@Service
//@Transactional
//public class EmailService implements IEmailService {
//		
//	@Autowired
//	private Email emailSender;
//	
//	@Autowired
//	private EmailRepository emailrepo;
//		
//	
//	
////	@Override
////	public String getVerification(Admin request) {
////		
////		Random r = new Random();
////		int random=0;
////		while(random<1001) {
////		 random= r.nextInt(9998);
////		}
////		String password = Integer.toString(random);
////		emailSender.sendEmail(request.getEmail(), "null", "Your OTP for Hosing Society Portal is "+password);
////		
////		EmailVerification ev = new EmailVerification(request.getEmail(),password);
////		emailrepo.save(ev);
////		
////		return request.getEmail();
////	}
////	
////		@Override
////		public EmailVerification getVerify(Admin request, String otp) throws ResourceNotFoundException {
////			EmailVerification ev =  emailrepo.findByEmailAndPassword(request.getEmail(),otp).orElseThrow(()->(new ResourceNotFoundException("Wrong Otp ")));
////			return ev;
////			
////		}
//
//	
//
//		
//
//
//	}
//	
//
