package com.example.booking88be.sendmail;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class randomcode {

    /**
     * random code 0000001 - 999999
     * @return String
     */
    public String getRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(1000000);
        return String.format("%06d", number);
    }
}
