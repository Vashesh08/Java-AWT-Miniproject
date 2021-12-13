package mpr;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;

public class Iphone extends Frame implements ActionListener,ItemListener {
	
	Label Ip_edition,Ip_model,Ip_memory,Ip_color,Ip_output,Ip_price;
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list;
	CheckboxGroup cg,cg1,cg2,cg3;
	Button b1,b2,b3,b4;
	String model,Icolor,memory,edition;
	double base_iphone,memory_iphone;
	Iphone()
	{  
		
		
		this.setSize(450,800);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBackground(new Color(168, 169, 173));
		Ip_edition = new Label("Please choose a edition?");
		Ip_edition.setBounds(25, 50, 250,40);
		Ip_edition.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_edition);
		
		b4 = new Button("Back to store");
		b4.setBounds(300,740,100,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,16));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
		list = new List(3,false);
		list.add("iphone 12");
		list.add("iphone 13");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		Ip_model = new Label("Please choose a model?");
		Ip_model.setBounds(25,130,250,20);
		Ip_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_model);
		
		cg = new CheckboxGroup();
		c1= new Checkbox("Mini",cg,false);
		c1.setBounds(25,170,50,12);
		c1.addItemListener(this);
		this.add(c1);
		
		c3= new Checkbox("Pro",cg,false);
		c3.setBounds(25,210,50,12);
		c3.addItemListener(this);
		this.add(c3);
		c4= new Checkbox("Pro max",cg,false);
		c4.setBounds(25,230,60,12);
		c4.addItemListener(this);
		this.add(c4);
		
		
		
		Ip_memory=new Label("Please choose a memory optiom?");
		Ip_memory.setBounds(25,260,250,20);
		Ip_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_memory);
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
		
		
		Ip_color=new Label("Chose a Color ");
		Ip_color.setBounds(25,410, 250,20);
		Ip_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_color);
		cg3 = new CheckboxGroup();
		c9= new Checkbox("RED",cg3,false);
		c9.setBounds(25,440,80,12);
		c9.addItemListener(this);
		this.add(c9);
		c10 = new Checkbox("ROSE-GOLD",cg3,false);
		c10.setBounds(25,470,80,12);
		c10.addItemListener(this);
		this.add(c10);
		c11= new Checkbox("BLUE",cg3,false);
		c11.setBounds(25,500,80,12);
		c11.addItemListener(this);
		this.add(c11);
		c12= new Checkbox("SPACE GREY",cg3,false);
		c12.setBounds(25,530,80,12);
		c12.addItemListener(this);
		this.add(c12);
		
		
		b1= new Button("DONE");
		b1.setBackground(Color.white);
		b1.setForeground(Color.DARK_GRAY);
		b1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b1.setBounds(160,570,80,40);
		b1.addActionListener(this);
		this.add(b1);
		
		b2= new Button("CLEAR");
		b2.setBackground(Color.GREEN);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(260,570,80,40);
		b2.addActionListener(this);
		this.add(b2);
		
		b3= new Button("CART");
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b3.setBounds(60,570,80,40);
		b3.addActionListener(this);
		this.add(b3);
		
		Ip_output = new Label();
		Ip_output.setBounds(25, 630,600,40);
		Ip_output.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_output);

		Ip_price = new Label();
		Ip_price.setBounds(25, 680,600,40);
		Ip_price.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_price);
		
		
		
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
			if(edition==null || model==null || memory==null || Icolor==null)
			{
				System.out.println("Please select all the options");
			}
			else
			{ double iptotal= base_iphone+memory_iphone;
			getcart ob = new getcart();
            new Cartdummy(iptotal,"add");
            ob.set_Iphone(edition+model+memory+Icolor,iptotal);
            Ip_output.setText("SELECTED CHOICE:"+edition+model+memory+Icolor);
            Ip_price.setText("Rs "+iptotal);
			      
		
		}
		}
			if(e.getSource()==b2)
			{

				this.dispose();
				new Iphone();	
			}
			if(e.getSource()==b3)
			{
				this.dispose();
				getcart oc= new getcart();
				oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
			    
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
		
		    model="Mini";
		   base_iphone=70000;
		}
		if(c2.getState()==true)
		{
		    model="13";
		    base_iphone=90000;
		    
		}
		if(c3.getState()==true)
		{
		    model="Pro";
		    base_iphone=100000;
		    
		}
		if(c4.getState()==true)
		{
		    model="Pro Max";
		    base_iphone=120000;
		}
		if(c1.getState()==false && c2.getState()==false && c3.getState()==false && c4.getState()==false)
		{
	
		}
		if(c5.getState()==true)
		{
		
		    memory="128GB";
		    memory_iphone=0;
		     
		}
		if(c6.getState()==true)
		{
		    memory="256GB";
		    memory_iphone=5000;
		    
		}
		if(c7.getState()==true)
		{
		    memory="512GB";
		    memory_iphone=10000;
		    
		}
		if(c8.getState()==true)
		{
		    memory="1 TB";
		    memory_iphone=20000;
		}
		
		if(c9.getState()==true)
		{
		
		    Icolor="RED";
		     
		}
		if(c10.getState()==true)
		{
		    Icolor="ROSE-GOLD";
		    
		}
		if(c11.getState()==true)
		{
		    Icolor="SPACE GREY";
		    
		}
		if(c12.getState()==true)
		{
		    Icolor="BLUE";
		    
		}
		
	}



	public static void main(String args[])
	{
		new Iphone();
	}
  
}
