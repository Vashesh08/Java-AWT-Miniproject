package mpr;

import java.awt.*;
import java.awt.event.*;

public class MacBook extends Frame implements ActionListener,ItemListener{
	
	Label MB_edition,MB_model,MB_memory,MB_color,MB_selected_choice,MB_price;  
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list;
	CheckboxGroup cg,cg1,cg2,cg3;
	Button b1,b2,b3,b4; 
	String model,Mac_color,memory,edition;
	double base_macbook,memory_macbook,price;
	MacBook()
	{   this.setSize(500,800);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBackground(new Color(168, 169, 173));
		MB_edition = new Label("Please choose a edition");
		MB_edition.setBounds(25, 50, 250,40);
		MB_edition.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_edition);
		
		list = new List(3,false);
		list.add("M1");
		list.add("Intel i7");
		list.add("Intel i9");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		MB_model = new Label("Choose a model");
		MB_model.setBounds(25,130,250,20);
		MB_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_model);
		
		cg = new CheckboxGroup();
		c1= new Checkbox("Air",cg,false);
		c1.setBounds(25,170,50,12);
		c1.addItemListener(this);
		this.add(c1);
		
		c3= new Checkbox("Pro",cg,false);
		c3.setBounds(25,210,50,12);
		c3.addItemListener(this);
		this.add(c3);
		
		
		MB_selected_choice= new Label();
		MB_selected_choice.setBounds(25,650, 400,20);
		this.add(MB_selected_choice);
		
		
		
		
		
		MB_memory=new Label("Choose a memory option");
		MB_memory.setBounds(25,260,250,20);
		MB_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_memory);
		cg2 = new CheckboxGroup();
		c5= new Checkbox("128GB",cg2,false);
		c5.setBounds(25,290,50,12);
		c5.addItemListener(this);
		this.add(c5);
		c6= new Checkbox("256GB",cg2,false);
		c6.setBounds(25,320,50,12);
		c6.addItemListener(this);
		this.add(c6);
		c7= new Checkbox("512GB",cg2,false);
		c7.setBounds(25,350,50,12);
		c7.addItemListener(this);
		this.add(c7);
		c8= new Checkbox("1 TB",cg2,false);
		c8.setBounds(25,380,50,12);
		c8.addItemListener(this);
		this.add(c8);
		
		
		MB_color=new Label("Choose a Color ");
		MB_color.setBounds(25,410, 250,20);
		MB_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_color);
		cg3 = new CheckboxGroup();
		c9= new Checkbox("SILVER",cg3,false);
		c9.setBounds(25,440,80,12);
		c9.addItemListener(this);
		this.add(c9);
		c10 = new Checkbox("ROSE-GOLD",cg3,false);
		c10.setBounds(25,470,120,12);
		c10.addItemListener(this); 
		this.add(c10);
		c11= new Checkbox("SPACE GREY",cg3,false);
		c11.setBounds(25,500,120,12);
		c11.addItemListener(this);
		this.add(c11);
		//c12= new Checkbox("SPACE GREY",cg3,false);
		//c12.setBounds(25,530,80,12);
		//c12.addItemListener(this);
		//this.add(c12);
		
		
		b1= new Button("DONE");
		b1.setBackground(Color.white);
		b1.setForeground(Color.DARK_GRAY);
		b1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b1.setBounds(160,570,80,40);
		b1.addActionListener(this);
		this.add(b1);
		
		b2= new Button("CART");
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(60,570,80,40);
		b2.addActionListener(this);
		this.add(b2);
		
		b3= new Button("CLEAR");
		b3.setBackground(Color.GREEN);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b3.setBounds(260,570,80,40);
		b3.addActionListener(this);
		this.add(b3);
		
		b4 = new Button("Back to store");
		b4.setBounds(320,700,100,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,16));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==list)
		{
			edition=list.getSelectedItem();
			c2= new Checkbox(edition,cg,false);
			c2.setBounds(25,190,100,12);
			c2.addItemListener(this);
			this.add(c2);
		}
		if(e.getSource()==b1)
		{
			if(edition==null || model==null || memory==null || Mac_color==null)
			{
				MB_selected_choice.setText("Please select all the options ");
				//MB_selected_choice.setBounds(25,650, 400,20);
				MB_selected_choice.setFont(new Font("Arial",Font.PLAIN,16));
				//this.add(MB_selected_choice);
			}
			else
			{   System.out.println("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color+price);
				MB_selected_choice.setText("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color);
				//MB_selected_choice.setBounds(25,650, 450,20);
				System.out.println("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color);
				MB_selected_choice.setFont(new Font("Arial",Font.PLAIN,16));
				//this.add(MB_selected_choice);
				double mactotal= base_macbook+memory_macbook;
				getcart ob = new getcart();
	            new Cartdummy(price,"add");
	            ob.set_Macbook(edition+" " +model+" "+memory+" "+Mac_color+" ",price);
				MB_price=new Label("Price : "+price); 
				MB_price.setBounds(25,700, 450,20);
				MB_price.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(MB_price);
			cg.setSelectedCheckbox(null); 
		} 
		}
		
		if(e.getSource()==b2)
		{
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		    
		}    
		if(e.getSource()==b3)
		{
			this.dispose();
		}
		if(e.getSource()==b4)
		{
			this.dispose();
			new Store();
		}
		
	}
   
	 


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(c1.getState()==true)
		{
		
		    model="AIR";
		   base_macbook=70000;
		}
		if(c2.getState()==true)
		{
		    model="M1";
		    base_macbook=90000;
		    
		}
		if(c3.getState()==true)
		{
		    model="Pro";
		    base_macbook=100000;
		    
		}
		
		
		if(c5.getState()==true)
		{
		
		    memory="128GB";
		    memory_macbook=0;
		     
		}
		if(c6.getState()==true)
		{
		    memory="256GB";
		    memory_macbook=5000;
		    
		}
		if(c7.getState()==true)
		{
		    memory="512GB";
		    memory_macbook=10000;
		    
		}
		if(c8.getState()==true)
		{
		    memory="1 TB";
		    memory_macbook=20000;
		    
		}
		
		if(c9.getState()==true)
		{
		
		    Mac_color="SILVER";
		     
		}
		if(c10.getState()==true)
		{
		    Mac_color="ROSE-GOLD";
		    
		}
		if(c11.getState()==true)
		{
		    Mac_color="SPACE GREY";
		    
		}
		//if(c12.getState()==true)
		//{
		//    Mac_color="BLUE";
		    
		//}
		
		price=base_macbook+memory_macbook;
		
	}



	public static void main(String[] args)
	{
		new MacBook();
	}

}
