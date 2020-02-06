package com.vio.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * @author vio
 * @date 2020-02-03   02:36
 */
@Configuration
//@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {

    private String host;
    private Integer port;
    private String username;
    private String password;

    public MailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage mailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("773713012@qq.com");
        message.setTo("");
        message.setSubject("HourseKeeping验证邮件");
        message.setText("你本次的验证码为：");
        return message;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}