package com.vio.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author vio
 * @date 2020-02-03   02:44
 */
@Service
public class MailService {
    @Autowired
    private MailSender sender;
    @Autowired
    private SimpleMailMessage message;

    public boolean sendValidateCode(String userEmail,String code){
        message.setText(code);
        message.setTo(userEmail);
        sender.send(message);
        return true;
    }
}
