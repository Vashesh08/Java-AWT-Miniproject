package mpr;

import java.awt.*;
import java.awt.event.*;
import java.awt.Scrollbar.*;

public class Chatbot extends Frame implements ActionListener
{
	Label label_hello, label_greeting, label_greeting2;
	Label[] label_chat= new Label[20];
	Label[]  temp;
	
//	ScrollPane scrollB1, scrollB2;
	
	Button b;
	
	TextField User_Textfield;
	
	private static int comp_x=25, user_x=300, y=100, x_width=375, y_width=25;
	
	static int index_pos=0;	
	static int array_size=20;
	public void create_label(String arg)
	{
	if (index_pos==array_size)
		{
		temp = new Label[array_size];
		for(int i=0;i<index_pos;i++)
			{
			label_chat[i].setVisible(false);
			//temp[i]=label_chat[i];	
			}
		label_chat = temp;
		y=100;
		index_pos=0;
		}
	label_chat[index_pos] = new Label(arg, Label.RIGHT);
	label_chat[index_pos].setFont(new Font("Times New Roman",Font.BOLD,16));
	label_chat[index_pos].setForeground(Color.blue);
	label_chat[index_pos].setBounds(user_x,y,x_width,y_width);
	y+=27;
	label_chat[index_pos].setVisible(true);
		
	this.add(label_chat[index_pos]);
			
	index_pos++;	
	}
	
	public void create_comp_label(String arg)
	{
	if (index_pos==array_size)
		{
		temp = new Label[array_size];
		for(int i=0;i<index_pos;i++)
			{
			label_chat[i].setVisible(false);
			//temp[i]=label_chat[i];	
			}
		label_chat = temp;
		index_pos=0;
		y=100;
		}
	label_chat[index_pos] = new Label(arg, Label.LEFT);
	label_chat[index_pos].setFont(new Font("Times New Roman",Font.BOLD,16));
	label_chat[index_pos].setForeground(Color.GREEN);
	label_chat[index_pos].setBounds(comp_x,y,x_width,y_width);
	y+=27;
	label_chat[index_pos].setVisible(true);
		
	this.add(label_chat[index_pos]);
			
	index_pos++;	
	}
	
	Chatbot()
	{	
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(700,700);
		this.setTitle("Newark Helpdesk");
		this.setVisible(true);
		
		label_hello = new Label("Newark Helpdesk", Label.CENTER);
		label_hello.setFont(new Font("Times New Roman",Font.BOLD,25));
		label_hello.setForeground(Color.BLACK);
		label_hello.setBackground(Color.yellow);
		label_hello.setBounds(0,25, 700, 50);
		label_hello.setVisible(true);
		
		this.add(label_hello);
		
		//Add Username from database in the String
		String S = new String("Vashesh");
				
		create_comp_label("Hi "+S+",Thank you for reaching out to us.");	
		create_comp_label("What product do you have an issue with?");
	
		User_Textfield = new TextField();
		User_Textfield.setFont(new Font("Tahoma",Font.BOLD,18));
		User_Textfield.setBounds(10,660,550,25);
		
		this.add(User_Textfield);
		
		b=new Button("Send");
		b.setForeground(Color.white);
		b.setBackground(new Color(34,139,34));
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(570,660,110,25);
		b.addActionListener(this);
		this.add(b);
		
/*		Scrollbar scrollB1 = new Scrollbar(Scrollbar.HORIZONTAL, 0,10,0,1000);
		scrollB1.setBounds(0,585,600,15);
		scrollB1.setVisible(true);		
		scrollB1.addAdjustmentListener(new HorizontalAdjustmentListener());
		this.add(scrollB1,BorderLayout.EAST);
		

		Scrollbar scrollB2 = new Scrollbar(Scrollbar.VERTICAL, 0,10,0,1000);
		scrollB2.setBounds(585,0,600,600);
		scrollB2.setVisible(true);
		scrollB2.setLineIncrement(5);
		scrollB2.addAdjustmentListener(new VerticalAdjustmentListener());
		this.add(scrollB2,BorderLayout.SOUTH);
*/
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource()==b)
		{
			if (!User_Textfield.getText().equals("")){
			String UserString = User_Textfield.getText();
			create_label(UserString);
			String[] arrOfstr = UserString.split(" ");
			
			for(int k=0;k<arrOfstr.length;k++)
				{		
				System.out.println(arrOfstr[k]);
				switch(arrOfstr[k].toLowerCase()){
					case "airpods":	
						create_comp_label("Do you want to buy Airpods?y/n");
						String s=new String("airpods");
						break;
					case "iphone":
						create_comp_label("Do you want to buy Iphone?y/n");
						String s=new String("iphone");
						break;
					case "ipad":
						create_comp_label("Do you want to buy Ipad?y/n");
						String s=new String("ipad");
						break;
					case "macbook":
						create_comp_label("Do you want to buy Macbook?y/n");
						String s=new String("macbook");
						break;
					case "login":
						create_comp_label("Do you want to go to Login Page?y/n");
						String s=new String("login");
						break;
					case "store":
						create_label("Do you want to go to Store Home Page?y/n");
						String s=new String("store");
						break;
					case "cart":
						create_label("Do you want to go proceed to cart?y/n");
						String s=new String("cart");
						break;
					case "y":
						switch(s){
						case "airpods":	
							new Airpod();
							break;
						case "iphone":	
							new Iphone();
							break;
						case "ipad":	
							new Ipad();
							break;
						case "macbook":
							new MacBook();
							break;	
						case "login":	
							new Login_Page();
							break;
						case "store":	
							new Store();
							break;
						case "cart":
							getcart oc= new getcart();
							oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.apcost, getcart.apcost);
							break;
						}
					}
				}
			User_Textfield.setText("");
			}
		}
	}
	


	public static void main(String[] Args)
	{
	new Chatbot();
	}	
}

