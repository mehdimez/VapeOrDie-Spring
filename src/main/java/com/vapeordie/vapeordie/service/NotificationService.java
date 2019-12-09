package com.vapeordie.vapeordie.service;

import com.vapeordie.vapeordie.model.Data;
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
        mail.setText("Hello "+user.getFirstName()+" "+user.getLastName()+",\n your order in our VapeOrDie store has been confirmed, we will contact you via Email or via the mobile phone you provided.\n Thank you.\n \n Order id: "+order.getIdOrder());
        javaMAilSender.send(mail);
    }

    public void sendFeedback(Data data){
        // send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("vapeordie123@gmail.com");
        mail.setFrom("no-reply@vapeOrdie.com");
        mail.setSubject("User message");
        mail.setText("User Email: "+data.getEmail()+"\n"+"Message: "+data.getMessage());
        javaMAilSender.send(mail);
    }
}
