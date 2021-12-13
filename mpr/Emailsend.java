package mpr;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;


public class Emailsend  {
	
	public int b;
	public static int verify[]= new int[25];
	public static int o=0;
	int check=1;
	
	public static void sendMail(String recepient,int number)  throws Exception
	{
		System.out.println("Preparing to  send message");
		
	      String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		String myAccountEmail = "newarkstoresindia@gmail.com";
		String password ="Qwerty@1@2";
		
		
		Session session= Session.getInstance(properties, new Authenticator() {
			
				
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(myAccountEmail, password);
			}
				});
		
		Message message = prepareMessage(session,myAccountEmail,recepient,number);
        Transport.send(message);
	    System.out.println("Message send sucessfully");
		
		
		
	}

	private static Message prepareMessage(Session session,String myAccountEmail,String recepient,int number) {
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("My first Email Uing Java API");
			System.out.println(number);
			message.setText(Integer.toString(number));
			 o++;
			 System.out.print(o);
			 if(o>=25)
			 {
				 o=0;
			 }
			return message;
					
		}
		catch(Exception ex)
		{   System.out.println("Incorrect email");
			Logger.getLogger(Emailsend.class.getName()).log(Level.SEVERE,null,ex);
		}
		return null;
	
	}
	public int  generate()   
	{  
	int min = 2000;
	int max = 4000;   
    double a = Math.random()*(max-min+1)+min;   
	 b = (int)(Math.random()*(max-min+1)+min); 
	 System.out.println(b);
	 verify[o]=b;
	 System.out.println(verify[o]);
	 return b;
	
	 
	}  
	
	public int verified (String s )
	{
		System.out.println(Integer.parseInt(s));
		 for(int j=0;j<25;j++)
		 {   System.out.println("a"+verify[j]);
			 if(verify[j]==Integer.parseInt(s))
			 {  
				 check=0;
				
			 }
			 
			 
			 
		 }
		 return check;
		 
		
	}
	
	public static void main(String[] args) {
		

	}

}
