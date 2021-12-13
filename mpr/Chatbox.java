package mpr;

import java.awt.*;
import java.awt.event.*;

public class Chatbox extends Frame implements ActionListener
{
	Label label_hello, label_greeting, label_greeting2;
	Label[] label_chat= new Label[20];
	Label[]  temp;
	String s=" ";
	String a=" ";
	boolean bool=true;
	int v=0;
	
//	ScrollPane scrollB1, scrollB2;
	
	Button b;
	
	TextField User_Textfield;
	private static int complaint_id=121314151;
	private int comp_x=25, user_x=300, y=100, x_width=375, y_width=25;
	
	int index_pos=0;	
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
			if (label_chat[i]!=null)
					{label_chat[i].setVisible(false);}
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
	
	Chatbox()
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
		create_comp_label("Type the product you want to buy or have ");	
		create_comp_label("issues with?");
		
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
			if (bool==false) {
				for(int k=0;k<arrOfstr.length;k++)
				{	
				if (v==0) 
					{v++;}
				else {
					a=arrOfstr[k];
				}
				switch(a){
				case "y":
					switch(s){
					case "airpods":	
					case "airpod":
						this.dispose();
						new Airpod();
						break;
					case "iphone":
						this.dispose();
						new Iphone();
						break;
					case "ipad":
						this.dispose();	
						new Ipad();
						break;
					case "macbook":
						this.dispose();
						new MacBook();
						break;	
					case "login":	
						if(Login_Page.bt==true)
						{
						this.dispose();		
						new Login_Page();
						}
						else
						{
							create_comp_label("You are already logged in,STUPID!");
							create_comp_label("Anyways do you want to register your friends too ??y/n");
							s= "register";
						}
						break;	
					case "register":
						this.dispose();
					    new Sign_Up();
						break;
					case "store":
						this.dispose();	
						new Store();
						break;
					case "cart":
						this.dispose();
						getcart oc= new getcart();
						oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.apcost, getcart.apcost);
						break;
					case "airpods_warranty":
						replacement_label("airpods");
						s=" ";
						break;
					case "iphone_warranty":
						replacement_label("iphone");
						s=" ";
						break;
					case "ipad_warranty":
						replacement_label("ipad");
						s=" ";
						break;
					case "macbook_warranty":
						replacement_label("macbook");
						s=" ";
						break;
					}
					break;
				case "n":
					switch(s){
					case "register":
						create_comp_label("Sorry you don't have an option, you have to register a friend"); 
						create_comp_label("Haha just joking"); 
						this.dispose();
						new Store();
						break;
					case "airpods":	
					case "airpod":
						create_comp_label("Okay, is your airpods in warranty?y/n"); 
						s="airpods_warranty";
						break;
					case "airpods_warranty":
						complaint_label();
						s = " ";
						break;
					case "iphone":	
						create_comp_label("Okay, is your iphone in warranty?y/n"); 
						s="iphone_warranty";								
						break;
					case "iphone_warranty":
						complaint_label();
						s = " ";
						break;
					case "ipad":	
						create_comp_label("Okay, is your ipad in warranty?y/n"); 
						bool=false;
						s="ipad_warranty";								
						break;
					case "ipad_warranty":
						complaint_label();
						s = " ";
						break;							
					case "macbook":
						create_comp_label("Okay, is your macbook in warranty?y/n"); 
						s="macbook_warranty";												
						break;
					case "macbook_warranty":
						complaint_label();
						s = " ";
						break;
					case "store":	
						create_comp_label("Type in your request again."); 
						break;
					case "cart":
						create_comp_label("Type in your request again."); 
						break;
						}
					break;
				}
			}
			}
			else {
			for(int k=0;k<arrOfstr.length;k++)
				{		
				switch(arrOfstr[k].toLowerCase()){
					case "airpod":	
					case "airpods":
						create_comp_label("Do you want to buy Airpods?y/n");
						s=new String("airpods");
						break;
					case "iphone":
						create_comp_label("Do you want to buy Iphone?y/n");
						s=new String("iphone");
						break;
					case "ipad":
						create_comp_label("Do you want to buy Ipad?y/n");
						 s=new String("ipad");
						break;
					case "macbook":
						create_comp_label("Do you want to buy Macbook?y/n");
						s=new String("macbook");
						break;
					case "login":
						create_comp_label("Do you want to go to Login Page?y/n");
						s=new String("login");
						break;						
					case "store":
						create_comp_label("Do you want to go to Store Home Page?y/n");
						s=new String("store");
						break;
					case "cart":
						create_comp_label("Do you want to go proceed to cart?y/n");
						s=new String("cart");
						break;
					case "n":
						a="n";
						bool=false;
						create_comp_label("Describe your issue");
						break;
					case "y":
						a="y";
						switch(s){
						case "airpods":	
						case "airpod":
							this.dispose();
							new Airpod();
							break;
						case "iphone":
							this.dispose();
							new Iphone();
							break;
						case "ipad":
							this.dispose();	
							new Ipad();
							break;
						case "macbook":
							this.dispose();
							new MacBook();
							break;	
						case "login":	
							if(Login_Page.bt==true)
							{
							this.dispose();		
							new Login_Page();
							}
							else
							{
								create_comp_label("You are already logged in,STUPID!");
								create_comp_label("Anyways do you want to register your friends too ??y/n");
								s= "register";
							}
							break;	
						case "register":
							this.dispose();
						    new Sign_Up();
							break;
						case "store":
							this.dispose();	
							new Store();
							break;
						case "cart":
							this.dispose();
							getcart oc= new getcart();
							oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.apcost, getcart.apcost);
							break;
						case "airpods_warranty":
							replacement_label("airpods");
							s=" ";
							break;
						case "iphone_warranty":
							replacement_label("iphone");
							s=" ";
							break;
						case "ipad_warranty":
							replacement_label("ipad");
							s=" ";
							break;
						case "macbook_warranty":
							replacement_label("macbook");
							s=" ";
							break;
						}
						break;
				}
				}
			
			}
			User_Textfield.setText("");
			}
		}
	}
	
	public void replacement_label(String t){
					create_comp_label("A complaint has been generated.");
					create_comp_label("Your complain will be verified by us");
					create_comp_label("and if faulty, your airpods will be replaced");
					create_comp_label("by us within 3-7 working days.");
					create_comp_label("The following is your complaint_id "+complaint_id);
					complaint_id++;
					v=0;
					bool=true;
	}

	public void complaint_label(){
					create_comp_label("A complaint has been generated.");
					create_comp_label("Our Support Executive will get in touch");
					create_comp_label("with you within the next 24 hours");							
					create_comp_label("The following is your complaint_id "+complaint_id);
					complaint_id++;
					v=0;
					bool=true;
	}

	public static void main(String[] Args)
	{
	new Chatbox();
	}	
}