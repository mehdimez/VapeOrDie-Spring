package com.vapeordie.vapeordie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VapeordieApplication {

    public static void main(String[] args) {
        SpringApplication.run(VapeordieApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder getBCPE ()
    {
        return new  BCryptPasswordEncoder() ;
    }

}
