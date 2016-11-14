//package camt.FitUp.Project.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MailConfig {
//
//    @Value("${email.host}")
//    private String host;
//
//    @Value("${email.from}")
//    private String from;
//
//    @Value("${email.subject}")
//    private String subject;
//
//    @Bean
//    public JavaMailSender javaMailService() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost(host);
//        return javaMailSender;
//    }
//
//    @Bean
//    public SimpleMailMessage simpleMailMessage() {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(from);
//        simpleMailMessage.setSubject(subject);
//        return simpleMailMessage;
//    }
//}