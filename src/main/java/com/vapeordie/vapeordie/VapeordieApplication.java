package com.vapeordie.vapeordie;

import com.vapeordie.vapeordie.model.Role;
import com.vapeordie.vapeordie.model.User;
import com.vapeordie.vapeordie.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class VapeordieApplication {

    public static void main(String[] args) {
        SpringApplication.run(VapeordieApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.saveRole(new Role("USER"));
            accountService.saveRole(new Role("ADMIN"));
            Stream.of("user1@gmail", "user2@gmail", "user3@gmail", "admin@gmail.com").forEach(r -> {
                accountService.saveUser(new User("aziz", "bourguiba",r,"123456", null, null));

            });
        };
    }*/
    @Bean
    BCryptPasswordEncoder getBCPE ()
    {
        return new  BCryptPasswordEncoder() ;
    }

}
