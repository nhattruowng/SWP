package com.example.booking88be.api;

import com.example.booking88be.entity.Booking;
import com.example.booking88be.entity.BookingDetail;
import com.example.booking88be.entity.CourtSlot;
import com.example.booking88be.entity.Customer;
import com.example.booking88be.sendmail.EmailService;
import com.example.booking88be.service.CustomerService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.example.booking88be.sendmail.randomcode;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
@ComponentScan(basePackages = {"com.example.booking88be.sendmail",
        "com.example.booking88be.api",
        "com.example.booking88be.service"})//"swp.booking.booking88be.demo"
public class EmailControler {

    // KHAI BAO CA BIEN
    List<BookingDetail> getBooking = new ArrayList<>();
    List<CourtSlot> courtSlots = new ArrayList<>();
    Customer customer = new Customer();
    private CustomerService customerService;
    private EmailService emailService;
    private String ramdomCode;


    //CONTRUCTER
    @Autowired
    public EmailControler(CustomerService customerService, EmailService emailService) {
        this.customerService = customerService;
        this.emailService = emailService;
    }


    /**
     * gui code random ve mail
     *
     * @param email
     */
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestParam String email) { // email.replaceAll("%40","@")
        ramdomCode = new randomcode().getRandomNumber();
        emailService.sendEmail(email.replace("%40", "@").substring(email.indexOf("=") + 1)
                , "Booking 88 ", "Your Code: " + ramdomCode + " :");
    }

    /**
     * gui bill ve mail
     *
     * @param email
     */

    @PostMapping("/sendBill")
    public void sendBill(@RequestBody String email) { // email.replaceAll("%40","@")
        ramdomCode = new randomcode().getRandomNumber();
        try {
            emailService.sendHtmlEmail(email.replace("%40", "@").substring(email.indexOf("=") + 1),
                    "Booking 88 ",
                    EmailService.getBill(new Booking()));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
