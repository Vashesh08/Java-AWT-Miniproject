package mpr;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ipad extends Frame implements ActionListener,ItemListener{
	
	Label Ip_edition,Ip_model,Ip_memory,Ip_color,output,accesories;
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list;
	CheckboxGroup cg,cg1,cg2,cg3;
	Button b1,b2,b3,b4;
	String Idcolor,Idmemory,Idedition,acc_final;
	String[] acc = new String[4]; 
	
	static String[] idbill = new String[5];
	static int z=0;
	 double fprice;
	 double base_ipad=0,a_price1=0,base_memory=0,a_price2=0,a_price3=0,a_price4=0,base_price=0;
	 
	Ipad(int z,String exceed)
	{
		 this.setSize(450,800);
		    this.setVisible(true);
		    this.setLayout(null);
		    this.setBackground(new Color(168, 169, 173));
		    Label l1= new Label("Exceeding:ITEM LIMIT 4");
		    new Store();
		    l1.setFont(new Font("Tahoma",Font.PLAIN,15));
		    l1.setBounds(25, 50, 250,40);
		    this.add(l1);
		    
		
	}
	 
	 
	 
	Ipad()
	{   this.setSize(450,800);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBackground(new Color(168, 169, 173));
		Ip_edition = new Label("Please choose a Ipad?");
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
		list.add("ipad mini");
		list.add("ipad (entry level)");
		list.add("ipad Air");
		list.add("Ipad Pro");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		Ip_model = new Label("Please choose Your Acessories ");
		Ip_model.setBounds(25,130,250,20);
		Ip_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_model);
		
		
		c1= new Checkbox("magic keyboard",false);
		c1.setBounds(25,170,250,12);
		c1.addItemListener(this);
		this.add(c1);
		
		c2= new Checkbox("apple pencil 2nd generation",false);
		c2.setBounds(25,190,200,12);
		c2.addItemListener(this);
		this.add(c2);
		
		c3= new Checkbox("protective case",false);
		c3.setBounds(25,210,250,12);
		c3.addItemListener(this);
		this.add(c3);
		c4= new Checkbox("Screen guard",false);
		c4.setBounds(25,230,260,12);
		c4.addItemListener(this);
		this.add(c4);
		
		
		
		Ip_memory=new Label("Please choose a memory optiom?");
		Ip_memory.setBounds(25,260,250,20);
		Ip_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_memory);
		cg2 = new CheckboxGroup();
		c5= new Checkbox("32GB",cg2,false);
		c5.setBounds(25,290,50,12);
		c5.addItemListener(this);
		this.add(c5);
		c6= new Checkbox("64GB",cg2,false);
		c6.setBounds(25,320,50,12);
		c6.addItemListener(this);
		this.add(c6);
		c7= new Checkbox("128GB",cg2,false);
		c7.setBounds(25,350,50,12);
		c7.addItemListener(this);
		this.add(c7);
		c8= new Checkbox("512GB",cg2,false);
		c8.setBounds(25,380,50,12);
		c8.addItemListener(this);
		this.add(c8);
		
		
		Ip_color=new Label("Chose a Color ");
		Ip_color.setBounds(25,410, 250,20);
		Ip_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_color);
		cg3 = new CheckboxGroup();
		c9= new Checkbox("RED",cg3,false);
		c9.setBounds(25,440,180,12);
		c9.addItemListener(this);
		this.add(c9);
		c10 = new Checkbox("ROSE-GOLD",cg3,false);
		c10.setBounds(25,470,180,12);
		c10.addItemListener(this);
		this.add(c10);
		c11= new Checkbox("BLUE",cg3,false);
		c11.setBounds(25,500,180,12);
		c11.addItemListener(this);
		this.add(c11);
		c12= new Checkbox("SPACE GREY",cg3,false);
		c12.setBounds(25,530,180,12);
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
		
		output=new Label();
		output.setBounds(25,640,600,20);
		output.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(output);
		accesories=new Label("i");
		accesories.setBounds(25,680,600,20);
		accesories.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(accesories);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==list)
			
		{
			if(list.getSelectedItem()==null)
			{
			output.setText("Please enter a Ipad Model ");
		
			}
			else
			{
				Idedition=list.getSelectedItem();
				if(Idedition.equals("ipad mini"))
				{
					base_price=40000.0;
					
				}  
				else if(Idedition.equals("ipad (entry level)"))
				{
					base_price=30000.0;
				
			    }
				else if(Idedition.equals("ipad Air"))
				{
					base_price=50000.0;
					
				}
				else if(Idedition.equals("Ipad Pro"))
				{
					base_price=90000.0;
				}
				}
				
		}
		
		if(e.getSource()==b1)
		{  
		
		if(base_price!=0.0 && base_memory!=0.0  )
			{ 
			
			//idbill[j]= Idedition+" "+Idmemory+" "+Idcolor+" "+fprice;
			fprice= base_memory+base_price+a_price1+a_price2+a_price3+a_price4;
				output.setText(Idedition+" "+Idmemory+" "+Idcolor+" "+fprice);
				accesories.setText(acc[0]+acc[1]+acc[2]+acc[3]);
				
             //Icount a =new Icount();	
             //Icount.price[1]=fprice;
             getcart ob = new getcart();
             new Cartdummy(fprice,"add");
             ob.set_Ipad(Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3]+")", fprice);
             
             z++;
             if(z>4)
             {
            	 this.dispose();
            	 new Ipad(z,"Ipad");
            	 
            	 
             }
	         //a.setPrice(fprice,Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3]+")");
	         //a.getPrice();y.artoutput(Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3], fprice);
	         
	         
			}
		else
		{
			output.setText("select all options");
		}
		
		}
		
		if(e.getSource()==b2)
		{
			int o = list.getSelectedIndex();
			list.deselect(o);
			c1.setState(false);
			c2.setState(false);
			c3.setState(false);
			c4.setState(false);
			c5.setState(false);
			c6.setState(false);
			c7.setState(false);
			c8.setState(false);
			c9.setState(false);
			c10.setState(false);
			c11.setState(false);
			c12.setState(false);
			this.dispose();
			new Ipad();
		}
		
		if(e.getSource()==b3)
		{
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
		
		    acc[0]="Magic keyboard  ";
		   a_price1=7000;
		}
		if(c1.getState()==false)
		{
		
		    acc[0]=" ";
		   a_price1=0;
		}
		
		if(c2.getState()==true)
		{
		    acc[1]="apple pencil 2nd generation  ";
		    a_price2=8000;
		    
		}
		if(c2.getState()==false)
		{
		
		    acc[1]=" ";
		   a_price2=0;
		}
		if(c3.getState()==true)
		{
		    acc[2]="protective Case  ";
		    a_price3=1000;
		    
		}
		if(c3.getState()==false)
		{
		
		    acc[2]=" ";
		   a_price3=0;
		}
		if(c4.getState()==true)
		{
		    acc[3]="Screen Guard";
		    a_price4=1000;
		}
		if(c4.getState()==false)
		{
		
		    acc[3]=" ";
		   a_price4=0;
		}
		if(c1.getState()==false && c2.getState()==false && c3.getState()==false && c4.getState()==false)
		{
			accesories.setText("Acessories: None");
			
		}
		
		if(c5.getState()==true)
		{
		
		    Idmemory="32GB";
		    base_memory=0.01;
		     
		}
		if(c6.getState()==true)
		{
		    Idmemory="64GB";
		    base_memory=5000.0;
		    
		}
		if(c7.getState()==true)
		{
		    Idmemory="128GB";
		    base_memory=10000.0;
		    
		}
		if(c8.getState()==true)
		{
		    Idmemory="512GB";
		    base_memory=20000.0;
		}
		
		/*if(c8.getState()==false && c7.getState()==false && c6.getState()==false && c5.getState()==false)
		{
			output.setText("select all options");
			
		}*/
		if(c9.getState()==true)
		{
		
		    Idcolor="RED";
		     
		}
		if(c10.getState()==true)
		{
		    Idcolor="ROSE-GOLD";
		    
		}
		if(c11.getState()==true)
		{
		    Idcolor="SPACE GREY";
		    
		}
		if(c12.getState()==true)
		{
		    Idcolor="BLUE";
		    
		}
		/*if(c9.getState()==false && c10.getState()==false && c11.getState()==false && c12.getState()==false)
		{
			output.setText("Select all options");
		}*/
		
	}
   
	
	
	


	public static void main(String[] args)
	{
		new Ipad();
	}
}