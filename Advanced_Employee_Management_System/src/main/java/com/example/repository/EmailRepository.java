//package com.example.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.email.Email;
//import com.example.pojo.EmailVerification;
//
//public interface EmailRepository extends JpaRepository<EmailVerification, Long>{
//
//	Optional<EmailVerification> findByEmailAndPassword(String email, String otp);
//
//	
//
//}
