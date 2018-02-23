package cisa_impresores;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
    
 public void Email(String subject, String messages) throws CisaExceptions{
      String to = "linusdufe@gmail.com";//change accordingly
      String from = "linusdufe@gmail.com";//change accordingly
      String host = "localhost";//or IP address

     //Get the session object
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

     //compose the message
      try{
          
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         message.setSubject(subject);
         message.setText(messages);

         // Send message
         Transport.send(message);
         System.out.println("Missatge enviat correctament....");

      }catch (MessagingException mex) {mex.printStackTrace();}
   }
}
