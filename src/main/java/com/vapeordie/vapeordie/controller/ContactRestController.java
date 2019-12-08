package com.vapeordie.vapeordie.controller;

import com.vapeordie.vapeordie.model.Category;
import com.vapeordie.vapeordie.model.Data;
import com.vapeordie.vapeordie.model.Product;
import com.vapeordie.vapeordie.service.Contact.ContactService;
import com.vapeordie.vapeordie.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Observable;
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ContactRestController {
    private Logger logger = LoggerFactory.getLogger(OrderProductRestController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/contact")
    public void sendEmail(@RequestBody Data message) {
        System.out.println("hiiiiiiiiii");
        // send notification
        try {
            notificationService.sendFeedback(message);
        } catch (MailException ex) {
            logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Erreur email: " + ex.getMessage());
        }

    }}
