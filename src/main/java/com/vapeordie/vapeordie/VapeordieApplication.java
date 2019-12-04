package com.vapeordie.vapeordie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VapeordieApplication {

    public static void main(String[] args) {
        SpringApplication.run(VapeordieApplication.class, args);
    } @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.saveRole(new Role("USER"));
            accountService.saveRole(new Role("ADMIN"));
            Stream.of("user1@gmail", "user2@gmail", "user3@gmail", "admin@gmail.com").forEach(r -> {
                accountService.saveUser(new User("aziz", "bourguiba",r,"123456", null, null));

            });
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE ()
    {
        return new  BCryptPasswordEncoder() ;
    }

}
