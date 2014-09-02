package com.cn.shop.util;

import java.io.IOException;   
import java.util.Date;   
import java.util.Properties;   
    
import javax.mail.Authenticator;   
import javax.mail.Message;   
import javax.mail.MessagingException;   
import javax.mail.Multipart;   
import javax.mail.PasswordAuthentication;   
import javax.mail.Session;   
import javax.mail.Transport;   
import javax.mail.internet.AddressException;   
import javax.mail.internet.InternetAddress;   
import javax.mail.internet.MimeBodyPart;   
import javax.mail.internet.MimeMessage;   
import javax.mail.internet.MimeMultipart;   

public class EmailAttachmentSender {
	
	 public static void sendEmailWithAttachments(String host, String port,  
	            final String userName, final String password, String toAddress,  
	            String subject, String message, String[] attachFiles)  
	            throws AddressException, MessagingException {  
	        // sets SMTP server properties  
	        Properties properties = new Properties();  
	        properties.put("mail.smtp.host", host);  
	        properties.put("mail.smtp.port", port);  
	        properties.put("mail.smtp.auth", "true");  
	        properties.put("mail.smtp.starttls.enable", "true");  
	        properties.put("mail.user", userName);  
	        properties.put("mail.password", password);  
	  
	        // creates a new session with an authenticator  
	        Authenticator auth = new Authenticator() {  
	            public PasswordAuthentication getPasswordAuthentication() {  
	                return new PasswordAuthentication(userName, password);  
	            }  
	        };  
	        Session session = Session.getInstance(properties, auth);  
	  
	        // creates a new e-mail message  
	        Message msg = new MimeMessage(session);  
	  
	        msg.setFrom(new InternetAddress(userName));  
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };  
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);  
	        msg.setSubject(subject);  
	        msg.setSentDate(new Date());  
	  
	        // creates message part  
	        MimeBodyPart messageBodyPart = new MimeBodyPart();  
	        messageBodyPart.setContent(message, "text/html;charset=UTF-8");  
	  
	        // creates multi-part  
	        Multipart multipart = new MimeMultipart();  
	        multipart.addBodyPart(messageBodyPart);  
	  
	        // adds attachments  
	        if (attachFiles != null && attachFiles.length > 0) {  
	            for (String filePath : attachFiles) {  
	                MimeBodyPart attachPart = new MimeBodyPart();  
	  
	                try {  
	                    attachPart.attachFile(filePath);  
	                } catch (IOException ex) {  
	                    ex.printStackTrace();  
	                }  
	  
	                multipart.addBodyPart(attachPart);  
	            }  
	        }  
	  
	        // sets the multi-part as e-mail's content  
	        msg.setContent(multipart);  
	  
	        // sends the e-mail  
	        Transport.send(msg);  
	  
	    }  
	  
	    /** 
	     * 测试发带附件邮件 
	     */  
	    public  void send(String toMail , String username  ) {  
	        // 发件人信息  
	        String host = "smtp.126.com";  
	        String port = "25";  
	        String mailFrom = "nietaooldman@126.com";  
	        String password = "tao8419552";  
	  
	        // 收件人信息  
	        String mailTo = toMail;  
	        String subject = "注册认证";  
	        
	      //  String message = "这是一封由javaMail自动发出的测试邮件，请勿回复。<a href=\"http://hao.360.cn/?360sd\">百度一下</a>";  
	        
	        String message = "这是一封由淘淘商城自动发出的验证邮件，请尽快验证。<a href=\"http://localhost:8080/Shop/from/user_save!usersave?username="+ username + "\">确定注册</a>"; 
	       
	  
	        // 附件  
	      //  String[] attachFiles = new String[1];  
	       // attachFiles[0] = "D:/JavaWeb/javamail/java-mail-1.4.4.jar";  
	        
	        String[] attachFiles = null;
	      
	        try {  
	            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,  
	                    subject, message, attachFiles);  
	            System.out.println("邮件发送成功.");  
	        } catch (Exception ex) {  
	            System.out.println("发送失败");  
	            ex.printStackTrace();  
	        }  
	    }  

}
