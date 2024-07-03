//package com.example.demo.api;
//
//import com.example.demo.entity.Account;
//import com.example.demo.model.*;
//import com.example.demo.service.AuthenticationService;
//import com.example.demo.service.EmailService;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@SecurityRequirement(name="api")
//@CrossOrigin("*")
//public class AuthenticationAPI {
//    @Autowired
//    AuthenticationService authenticationService;///git branch
//    @Autowired
//    EmailService emailService;
//
//    @GetMapping("test")
//    public ResponseEntity test() {
//        return ResponseEntity.ok("test");
//    }
//
//    @GetMapping("Admin_only")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity getAdmin() {
//        return ResponseEntity.ok("ok" );
//    }
//
//    @PostMapping("Register")
//    public ResponseEntity Register(@RequestBody RegisterRequest responseRequest) {
//        Account account = authenticationService.register(responseRequest);
//        return ResponseEntity.ok(account);
//    }
//
//    @PostMapping("send-mail")
//    public void sendMail() {
//        EmailDetail emailDetail = new EmailDetail();
//        emailDetail.setRecipient("trancaodiepnct@gmail.com");
//        emailDetail.setSubject("test123");
//        emailDetail.setMsgBody("aaa");
//        emailService.sendMailTemplate(emailDetail);
//    }
//
//    @GetMapping("GetAll")
//    public ResponseEntity Getallaccount() {
//        List<Account> account = authenticationService.all();
//        return ResponseEntity.ok(account);
//    }
//
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
//        Account account = authenticationService.login(loginRequest);
//        return ResponseEntity.ok(account);
//    }
//
//    @PostMapping("/login-google")
//    public ResponseEntity<AccountResponse> loginGg(@RequestBody LoginGoogleRequest loginGoogleRequest) {
//        return ResponseEntity.ok(authenticationService.loginGoogle(loginGoogleRequest));
//    }
//
//    @PostMapping("/forgot-password")
//    public void forgotpassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
//        authenticationService.forgotPassword(forgotPasswordRequest);
//    }
//    @PostMapping("/reset-password-password")
//    public void resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
//        authenticationService.resetPassword(resetPasswordRequest);
//    }
//}
