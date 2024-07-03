package com.example.booking88be.demo;


import com.example.booking88be.sendmail.EmailService;
import org.springframework.stereotype.Service;
import com.example.booking88be.sendmail.randomcode;


@Service
public class DemoEmail {

    private EmailService emailService;

    private String code =new randomcode().getRandomNumber();

//    @Autowired
//    public DemoEmail(EmailService emailService) {
//        this.emailService = emailService;
//    }
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendEmail() {
//        emailService.sendEmail("truonglnse172659@fpt.edu.vn", "Booking 88 ", "Your Code: "+ code);
//        System.out.println("Your Code:"+ code);
//    }

}