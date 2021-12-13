package mpr;

import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pay_Apple_ID extends Frame implements ActionListener
{

	Label label_id,label_email,label_upi_id, label_password,label_confirmpassword,label_heading,label_error,label_error2, label_error3, label_pin;
	TextField text_id,text_email,text_upi_id, text_password, text_confirmpassword, text_pin; 
	Button b, b2;	
	int a;
	String text;
	
	Pay_Apple_ID()
	{
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(600,600);
		this.setTitle("Newark Store Payment Gateway Part 2");
		this.setVisible(true);
		
		label_heading =new Label("Set Up Newark Payment",Label.CENTER);
		label_heading.setFont(new Font("Tahoma",Font.BOLD,25));
		label_heading.setForeground(Color.BLACK);
		label_heading.setBackground(Color.WHITE);
		label_heading.setBounds(0,25,600,50);
		label_heading.setVisible(true);
		
		this.add(label_heading);
		
		label_id= new Label("Newark Id");
		label_id.setFont(new Font("Tahoma",Font.BOLD,22));
		label_id.setForeground(Color.white);
		label_id.setBounds(100,100,150,25);
		label_id.setVisible(true);	

		this.add(label_id);
		
		text_id = new TextField(20);
		text_id.setFont(new Font("Tahoma",Font.BOLD,18));
		text_id.setBounds(325,100,150,25);

		this.add(text_id);

		label_password= new Label("Set Password");
		label_password.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_password.setForeground(Color.white);
		label_password.setBounds(100,150,150,25);
		label_password.setVisible(true);
		
		this.add(label_password);

		text_password = new TextField(20);
		text_password.setFont(new Font("Tahoma",Font.BOLD,18));
		text_password.setBounds(325,150,150,25);
		//text_password.setEchoChar('*');
		
		this.add(text_password);
		
		label_confirmpassword = new Label("Confirm Password");
		label_confirmpassword.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_confirmpassword.setForeground(Color.white);
		label_confirmpassword.setBounds(100,200,225,25);
		label_confirmpassword.setVisible(true); 
		
		this.add(label_confirmpassword);

		text_confirmpassword = new TextField(20);
		text_confirmpassword.setFont(new Font("Tahoma",Font.BOLD,18));
		text_confirmpassword.setBounds(325,200,150,25);
		//text_confirmpassword.setEchoChar('*');
		
		this.add(text_confirmpassword);

		label_pin= new Label("Set Pin");
		label_pin.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_pin.setForeground(Color.white);
		label_pin.setBounds(100,250,150,25);
		label_pin.setVisible(true);

		this.add(label_pin);


		text_pin = new TextField(20);
		text_pin.setFont(new Font("Tahoma",Font.BOLD,18));
		text_pin.setBounds(325,250,150,25);
		
		this.add(text_pin);

		b=new Button("Register");
		b.setForeground(Color.white);
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(200,300,100,25);
		b.addActionListener(this);
		
		this.add(b);
		
		label_error= new Label();
		label_error.setFont(new Font("Times New Roman",Font.ITALIC,22));
		label_error.setForeground(Color.white);
		label_error.setBounds(100,350,450,25);
		label_error.setVisible(true);

		this.add(label_error);	

		label_error2 = new Label("uppercase letter, one lowercase letter, one number and one ");
		label_error2.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error2.setForeground(Color.white);
		label_error2.setBounds(100,375,450,25);
			
		label_error3 = new Label("special character");
		label_error3.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error3.setForeground(Color.white);
		label_error3.setBounds(100,400,450,25);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b)
		{
			label_error2.setVisible(false);
			label_error3.setVisible(false);
			if (text_id.getText().equals("") || text_password.getText().equals("") || text_confirmpassword.getText().equals("") || text_pin.getText().equals(""))
			{
				label_error.setText("Please fill all fields");
			}
			else if(text_password.getText().equals(text_confirmpassword.getText()) && !text_password.getText().equals(""))
			{	
				boolean strong_password = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", text_password.getText());
				System.out.println(strong_password);
				System.out.println(text_password.getText());
				if (strong_password)
				{
					text = text_pin.getText();
					boolean Pin = Pattern.matches("[0-9]{4}",text_pin.getText());
					if(Pin)
					{   
						create_AppleId(text_id.getText(), text_password.getText(), text_pin.getText());
						label_error.setText("Account Created Successfully");
						text_id.setText("");
						
					}
					else
					{
						label_error.setText("Invalid Pin");
					}
				}
				else{
					label_error.setText("Please enter a strong 8-digit password containing at least one ");	
					label_error.setFont(new Font("Times New Roman",Font.ITALIC,15));
					
					label_error2.setVisible(true);
					label_error3.setVisible(true);

					this.add(label_error2);	
					this.add(label_error3);	
						
					}	
			}
			else
			{
				label_error.setText("Password Mismatch");
			}
			text_password.setText("");
			text_confirmpassword.setText("");
			text_pin.setText("");
		}
	}
	public static void create_AppleId(String AppleId,String Password, String PIN)
	{
      FirstJDBC obc = new FirstJDBC();
      Connection con =obc.connectDB();
      
      PreparedStatement p = null;
      String q ="INSERT INTO appleid_database(Apple_ID,Apple_password,Newark_pin,email_id) "
	            + "VALUES(?,?,?,?)";
      //ResultSet rs = null;
      try
      {
      
      p = con.prepareStatement(q);
      
      p.setString(1,AppleId);
	  p.setString(2,Password);
	  p.setString(3,PIN);
	  p.setString(4,Sign_Up.registration_mail);
	  
      p.executeUpdate();
      }
      catch( Exception sql)
      {
    	  sql.printStackTrace();
      }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pay_Apple_ID();
	}

}