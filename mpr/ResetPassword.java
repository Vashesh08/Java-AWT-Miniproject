package mpr;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Pattern;
import java.awt.*;

public class ResetPassword extends Frame implements ActionListener {
	Label password_f,password_en,password_v,label_error4,label_error,label_error2,label_error3;
	TextField text_password_en,text_password_v;
	Button b2;
	String y;
	public static String email="";
	ResetPassword()
	{
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(800,600);
		this.setTitle("Forget Password");
		this.setVisible(true);
		
		
		
		
		
		password_f =new Label("Reset Password");
		password_f.setFont(new Font("Tahoma",Font.BOLD,25));
		password_f.setForeground(Color.BLACK);
		password_f.setBackground(Color.WHITE);
		password_f.setBounds(10,50,800,50);
		password_f.setVisible(true);
		
		this.add(password_f);
		
		
		
		password_en =new Label("New Password");
		password_en.setFont(new Font("Tahoma",Font.BOLD,25));
		password_en.setForeground(Color.white);
		password_en.setBounds(50,160,200,50);
		password_en.setVisible(true);
		
		this.add(password_en);
		
		
		text_password_en = new TextField();  
		text_password_en.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_password_en.setBounds(275,170,250,35);   
        this.add(text_password_en);
        
        password_v =new Label("confirm password");
		password_v.setFont(new Font("Tahoma",Font.BOLD,25));
		password_v.setForeground(Color.white);
		password_v.setBounds(50,230,200,50);
		password_v.setVisible(true);
		this.add(password_v);
		
		text_password_v = new TextField();  
		text_password_v.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_password_v.setBounds(275,230,250,35);   
        this.add(text_password_v);
        
        
        label_error4 =new Label();
		label_error4.setFont(new Font("Tahoma",Font.BOLD,25));
		label_error4.setForeground(Color.white);
		label_error4.setBounds(50,380,400,50);
		label_error4.setVisible(true);
		
		this.add(label_error4);
        
        
        
        
        
		
		 b2=new Button("Proceed");
			b2.setForeground(Color.white);
			b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
			b2.setBounds(575,280,150,25);
			b2.addActionListener(this);
			//b2.setVisible(false);
			this.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			if(text_password_en.getText().equals(text_password_v.getText()));
			{
			boolean strong_password = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", text_password_en.getText());
			if (strong_password)
			{    label_error4.setVisible(false);
				reset(text_password_v.getText());
				this.dispose();
				new Login_Page();
				}
			
			else
			{   label_error4.setVisible(true);
				label_error4.setText("Please enter a strong password");
				text_password_en.setText("");
				text_password_v.setText("");
			}
			
		}
			
		
	   }
	
	}
	
	public static void reset(String pass)
	{
		 FirstJDBC obc = new FirstJDBC();
	      Connection con =obc.connectDB();
	      
	      PreparedStatement p = null;
	      String q ="UPDATE  customer_id SET password=? where email_id=?";
	      //ResultSet rs = null;
	      try
	      {
	      
	      p = con.prepareStatement(q);
	      
	      
		  p.setString(1,pass);
		  p.setString(2,ForgotPassword.reset_email);
		  
		  
	      p.executeUpdate();
	      }
	      /*catch (SQLIntegrityConstraintViolationException o) 
	      {
	    	  Sign_Up l = new Sign_Up() ;
	    	  l.errorofrepeat();
	    	  
			// TODO: handle exception
		  }*/
	      catch(Exception sql)
	      {    
	    	  sql.printStackTrace();}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ResetPassword();
		

	}

}
