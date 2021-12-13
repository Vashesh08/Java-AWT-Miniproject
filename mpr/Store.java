package mpr;


import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Store extends Frame implements ActionListener
{
	Label heading,items;
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	
	public static boolean cart_visible=false;
	
	Store()
	{
		this.setSize(450,700);
		this.setLayout(null);
		this.setTitle("Welcome Page");
		this.setBackground(Color.gray);
		this.setVisible(true);
		this.addWindowListener(new MyListener());
		
		
		heading = new Label("Welcome ");
		heading.setBounds(150,50,250,50);
		heading.setFont(new Font("Arial",Font.BOLD,16));
		this.add(heading);
		
		
		items = new Label("What are you looking for");
		items.setBounds(25,150,250,50);
	    items.setFont(new Font("Arial",Font.BOLD,16));
	    this.add(items);
	    
	    b1= new Button("Iphone");
	    b1.setBounds(150,200,150,45);
	    b1.setFont(new Font("Arial",Font.BOLD,16));
	    b1.setBackground(Color.black);
	    b1.setForeground(Color.white);
	    b1.addActionListener(this);
	    this.add(b1);
	    
	    b2= new Button("Ipad");
	    b2.setBounds(150,260,150,45);
	    b2.setFont(new Font("Arial",Font.BOLD,16));
	    b2.setBackground(Color.black);
	    b2.setForeground(Color.white);
	    b2.addActionListener(this);
	    this.add(b2);
	    
	    
	    b3= new Button("MacBook");
	    b3.setBounds(150,320,150,45);
	    b3.setFont(new Font("Arial",Font.BOLD,16));
	    b3.setBackground(Color.black);
	    b3.setForeground(Color.white);
	    b3.addActionListener(this);
	    this.add(b3);
	    
	    b4= new Button("AirPods");
	    b4.setBounds(150,380,150,45);
	    b4.setFont(new Font("Arial",Font.BOLD,16));
	    b4.setBackground(Color.black);
	    b4.setForeground(Color.white);
	    b4.addActionListener(this);
	    this.add(b4);
	    
	    b5= new Button("View Cart");
	    b5.setBounds(150,440,150,45);
	    b5.setFont(new Font("Arial",Font.BOLD,16));
	    b5.setBackground(Color.black);
	    b5.setForeground(Color.white);
	    b5.addActionListener(this);
	    this.add(b5);
	    
	    b6= new Button("CHAT");
	    b6.setBounds(150,500,150,45);
	    b6.setFont(new Font("Arial",Font.BOLD,16));
	    b6.setBackground(Color.black);
	    b6.setForeground(Color.white);
	    b6.addActionListener(this);
	    
	    b7= new Button("Pay");
	    b7.setBounds(150,560,150,45);
	    b7.setFont(new Font("Arial",Font.BOLD,16));
	    b7.setBackground(Color.black);
	    b7.setForeground(Color.white);
	    b7.addActionListener(this);
	    
	    
	  
	    this.add(b6);
	    this.add(b7);
	    
	    
	    /*b8= new Button("Pay");
	    b8.setBounds(150,560,150,45);
	    b8.setFont(new Font("Arial",Font.BOLD,16));
	    b8.setBackground(Color.black);
	    b8.setForeground(Color.white);
	    b8.addActionListener(this);*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{  
		
			new Iphone();
			this.dispose();
			
		}
		
		if(e.getSource()==b2)
		{
			new Ipad();
			this.dispose();
		}
		if(e.getSource()==b3)
		{
			new MacBook();
			this.dispose();
		}
		if(e.getSource()==b4)
		{
			new Airpod();
			this.dispose();
		}
		if(e.getSource()==b5)
		{
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		    this.dispose();
		}
		if(e.getSource()==b6)
		{
			new Chatbox_final();
			this.dispose();
		}
		if(e.getSource()==b7)
		{   this.dispose();
			new Apple_Pay(Cartdummy.gtotal);
		}
		
	}
	public static void main(String[] args) {
		new Store();
	}
	
	
	
}

class MyListener extends WindowAdapter
{

	@Override
	public void windowClosing(WindowEvent e) {

	}
	
	public static void main(String[] args) {
		new Store();
	}
	
	
}
