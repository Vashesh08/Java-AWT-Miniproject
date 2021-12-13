package mpr;

import java.awt.*;

public class Pay_Process extends Frame {

	Label paymentid,paymentpass,paymentpin,label_heading;
	TextField text_paymentid,text_paymentpass,text_paymentpin;
	Button b;
	
	Pay_Process()
	{
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(600,600);
		this.setTitle("Payment");
		this.setVisible(true);
		
		label_heading =new Label("Payment",Label.CENTER);
		label_heading.setFont(new Font("Tahoma",Font.BOLD,25));
		label_heading.setForeground(Color.BLACK);
		label_heading.setBackground(Color.LIGHT_GRAY);
		label_heading.setBounds(0,25,600,50);
		label_heading.setVisible(true);
		this.add(label_heading);
		
		
		paymentid= new Label("Newark Id");
		paymentid.setFont(new Font("Tahoma",Font.BOLD,22));
		//paymentid.setForeground(Color.white);
		paymentid.setBounds(100,100,150,25);
		paymentid.setVisible(true);	

		this.add(paymentid);
		
		text_paymentid= new TextField(20);
		text_paymentid.setFont(new Font("Tahoma",Font.BOLD,18));
		text_paymentid.setBounds(325,100,150,25);

		this.add(text_paymentid);

		paymentpass= new Label(" Password");
		paymentpass.setFont(new Font("Times New Roman",Font.BOLD,22));
		paymentpass.setForeground(Color.white);
		paymentpass.setBounds(100,150,150,25);
		paymentpass.setVisible(true);
		
		this.add(paymentpass);

		text_paymentpass = new TextField(20);
		text_paymentpass.setFont(new Font("Tahoma",Font.BOLD,18));
		text_paymentpass.setBounds(325,150,150,25);
		//text_password.setEchoChar('*');
		
		this.add(text_paymentpass);
		
		paymentpin= new Label(" Pin");
		paymentpin.setFont(new Font("Times New Roman",Font.BOLD,22));
		paymentpin.setForeground(Color.white);
		paymentpin.setBounds(100,250,150,25);
		paymentpin.setVisible(true);

		this.add(paymentpin);


		text_paymentpin = new TextField(20);
		text_paymentpin.setFont(new Font("Tahoma",Font.BOLD,18));
		text_paymentpin.setBounds(325,250,150,25);
		
		this.add(text_paymentpin);

		b=new Button("Register");
		b.setForeground(Color.white);
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(200,300,100,25);
		b.addActionListener(this);
		
		this.add(b);
	}
	public static void main(String[] args) {
		new Pay_Process();
	}
	
	
	
}
