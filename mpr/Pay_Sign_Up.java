package mpr;

import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pay_Sign_Up extends Frame implements ActionListener
{

	
	Label label_acctname,label_email,label_upi_id, label_password,label_upi_pass,label_heading,label_error,label_error2, label_error3, label_pin;
	TextField text_acctname,text_email,text_upi_id, text_password, text_upi_pass, text_pin; 
	Button b, b2, b3;	
	int a;
	String text;

	Pay_Sign_Up()
	{
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(700,600);
		this.setTitle("Newark Store Payment Gateway");
		this.setVisible(true);
		
		label_heading =new Label("Set Up Newark Payment",Label.CENTER);
		label_heading.setFont(new Font("Tahoma",Font.BOLD,25));
		label_heading.setForeground(Color.BLACK);
		label_heading.setBackground(Color.WHITE);
		label_heading.setBounds(0,25,700,50);
		label_heading.setVisible(true);
		
		this.add(label_heading);
		
		label_acctname= new Label("Account Name");
		label_acctname.setFont(new Font("Tahoma",Font.BOLD,22));
		label_acctname.setForeground(Color.white);
		label_acctname.setBounds(100,100,150,25);
		label_acctname.setVisible(true);	

		this.add(label_acctname);
		
		text_acctname = new TextField(20);
		text_acctname.setFont(new Font("Tahoma",Font.BOLD,18));
		text_acctname.setBounds(325,100,150,25);

		this.add(text_acctname);

		/*label_email= new Label("Email");
		label_email.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_email.setForeground(Color.white);
		label_email.setBounds(100,150,150,25);
		label_email.setVisible(true);
		
		this.add(label_email);

		text_email = new TextField(20);
		text_email.setFont(new Font("Tahoma",Font.BOLD,18));
		text_email.setBounds(325,150,150,25);

		this.add(text_email);*/

		label_upi_id = new Label("UPI id");
		label_upi_id.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_upi_id.setForeground(Color.white);
		label_upi_id.setBounds(100,200,225,25);
		label_upi_id.setVisible(true); 
		
		this.add(label_upi_id);

		text_upi_id = new TextField(20);
		text_upi_id.setFont(new Font("Tahoma",Font.BOLD,18));
		text_upi_id.setBounds(325,200,150,25);

		this.add(text_upi_id);

		label_password= new Label("Account Password");
		label_password.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_password.setForeground(Color.white);
		label_password.setBounds(100,150,150,25);
		label_password.setVisible(true);

		this.add(label_password);


		text_password = new TextField(20);
		text_password.setFont(new Font("Tahoma",Font.BOLD,18));
		text_password.setBounds(325,150,150,25);
		text_password.setEchoChar('*');

		this.add(text_password);

		label_upi_pass = new Label("UPI PIN");
		label_upi_pass.setFont(new Font("Serif",Font.BOLD,22));
		label_upi_pass.setForeground(Color.white);
		label_upi_pass.setBounds(100,250,200,25);
		label_upi_pass.setVisible(true);

		this.add(label_upi_pass);

		text_upi_pass = new TextField(20);
		text_upi_pass.setFont(new Font("Tahoma",Font.BOLD,18));
		text_upi_pass.setBounds(325,250,150,25);
		text_upi_pass.setEchoChar('*');

		this.add(text_upi_pass);

		/*label_pin = new Label("Email Code");
		label_pin.setFont(new Font("Serif",Font.BOLD,22));
		label_pin.setForeground(Color.white);
		label_pin.setBounds(100,350,200,25);
		label_pin.setVisible(true);

		this.add(label_pin);

		text_pin = new TextField(20);
		text_pin.setFont(new Font("Tahoma",Font.BOLD,18));
		text_pin.setBounds(325,350,150,25);

		this.add(text_pin);

		/*b2=new Button("Verify Email");
		b2.setForeground(Color.white);
		b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(480,150,150,25);
		b2.addActionListener(this);
		
		this.add(b2);*/
	
		b=new Button("Register");
		b.setForeground(Color.white);
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(200,400,100,25);
		b.addActionListener(this);
		this.add(b);

		label_error= new Label();
		label_error.setFont(new Font("Times New Roman",Font.ITALIC,22));
		label_error.setForeground(Color.white);
		label_error.setBounds(100,450,450,25);
		label_error.setVisible(true);

		this.add(label_error);	

		label_error2 = new Label("uppercase letter, one lowercase letter, one number and one ");
		label_error2.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error2.setForeground(Color.white);
		label_error2.setBounds(100,475,450,25);
			
		label_error3 = new Label("special character");
		label_error3.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error3.setForeground(Color.white);
		label_error3.setBounds(100,500,450,25);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b)
		{
			if (text_acctname.getText().equals("") || text_password.getText().equals("") || text_upi_pass.getText().equals("")  || text_upi_id.getText().equals(""))
			{
				label_error.setText("Please fill all fields");
			}
			else
			{    String name="";
				 String password="";
			     String upi_pin="";
			     String upi_id="";
			     double balance=0;
				FirstJDBC ob = new FirstJDBC();
				String s= text_acctname.getText();
				
				 Connection con = null;
			        PreparedStatement p = null;
			        ResultSet rs = null;
				
				   con = ob.connectDB();
				   try
				   {
					   String sql = "select * from  bank_database where Account_name="+'"'+s+'"';
					   System.out.println(sql); 
					   p = con.prepareStatement(sql);
					    rs= p.executeQuery();
					    
					    
					    if(rs.next())
					    {   name = rs.getString("Account_name"); 
					    	password = rs.getString("account_password");
					    System.out.println(password);
					       upi_id=rs.getString("upi_id");
					       upi_pin = rs.getString("upi_pin");
					       System.out.println(upi_pin); 
					       balance = rs.getDouble("Balance");
					    		 
					    }
					    
				  
					    
				   }
					catch(Exception sql)
					{
						sql.printStackTrace();
					}
				   
			
				if(name!="")
				{
					if(password.equals(text_password.getText()) && upi_id.equals(text_upi_id.getText()) && upi_pin.equals(text_upi_pass.getText()))
				
				{
		
					System.out.println("Verified"+balance);
					new Pay_Apple_ID();
					
				}
				else
				{
					
					System.out.println("Recheck your credential");
				}
				
			}
				else
				{
					System.out.println("No bank account found contact your bank");
				}
				
			}
		}
	    }
	
	//public boolean(String acc_name, String , String c, String d , )
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pay_Sign_Up();
	}

}
