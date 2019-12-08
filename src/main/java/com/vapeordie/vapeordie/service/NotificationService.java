package com.vapeordie.vapeordie.service;

import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.model.User;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMAilSender;

    @Autowired
        public NotificationService(JavaMailSender javaMAilSender){
            this.javaMAilSender = javaMAilSender;
    }

    public void sendNotification(User user, OrderProduct order) throws MailException {
        // send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("no-reply@vapeOrdie.com");
        mail.setSubject("Order confirmation");
        mail.setText("Hello "+user.getFirstName()+" "+user.getLastName()+", your order in our VapeOrDie store has been confirmed, we will contact you via Email or via the mobile phone you provided. Thank you. Order id: "+order.getIdOrder());
        javaMAilSender.send(mail);
    }
}
