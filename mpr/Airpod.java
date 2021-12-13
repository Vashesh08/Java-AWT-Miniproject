package mpr;


import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Airpod extends Frame implements ActionListener,ItemListener{
	
	Label Airpod_choice,Airpod_model,Airpod_price;
	Checkbox c1,c3,c4,c5,c6;
	List list;
	CheckboxGroup cg,cg1,cg2,cg3;
	Button b1,b2,b3,b4;
	String model;
	double base_airpod;
	boolean bool=false;
	Airpod()
	{   this.setSize(450,400);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBackground(new Color(168, 169, 173));
		
		Airpod_model = new Label("Please choose a model?");
		Airpod_model.setBounds(25,50,250,20);
		Airpod_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Airpod_model);
		
		cg = new CheckboxGroup();
		c1= new Checkbox("AirPods (3rd generation)",cg,false);
		c1.setBounds(25,90,200,17);
		c1.addItemListener(this);
		this.add(c1);
		
		c3= new Checkbox("AirPods Max",cg,false);
		c3.setBounds(25,110,200,17);
		c3.addItemListener(this);
		this.add(c3);
		
		c4= new Checkbox("AirPods Pro",cg,false);
		c4.setBounds(25,130,200,17);
		c4.addItemListener(this);
		this.add(c4);
		
		c5= new Checkbox("AirPods (2nd generation)",cg,false);
		c5.setBounds(25,150,200,17);
		c5.addItemListener(this);
		this.add(c5);
		
		c6= new Checkbox("AirPods (1st generation)",cg,false);
		c6.setBounds(25,170,200,17);
		c6.addItemListener(this);
		this.add(c6);
		
		b1= new Button("DONE");
		b1.setBackground(Color.white);
		b1.setForeground(Color.DARK_GRAY);
		b1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b1.setBounds(160,220,80,40);
		b1.addActionListener(this);
		this.add(b1);
		
		b2= new Button("CART");
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(60,220,80,40);
		b2.addActionListener(this);
		this.add(b2);
		
		b3= new Button("CLEAR");
		b3.setBackground(Color.GREEN);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,20));
		b3.setBounds(260,220,80,40);
		b3.addActionListener(this);
		this.add(b3);
		
		b4 = new Button("Back to store");
		b4.setBounds(300,300,100,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,16));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
		
		
		
	}
	
	@Override
	public void actionPerformed (ActionEvent e){
			
		if(e.getSource()==b1)
		{
			if(bool==true)
			{	
				Airpod_choice.setText("Selected  CHOICE: "+model);
				Airpod_price.setText("\nPrice: "+base_airpod);
				System.out.println("Selected  CHOICE"+" "+" "+model+" "+" "+" ");
				
				getcart ob = new getcart();
	            new Cartdummy(base_airpod,"add");
	            ob.set_Airpod(model,base_airpod);
			}
			else if(model==null){
				Airpod_choice = new Label("Please Select a choice");
				Airpod_choice.setBounds(50, 280, 400,40);
				Airpod_choice.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(Airpod_choice);
				Airpod_price = new Label();
				Airpod_price.setBounds(100, 320, 250,40);
				Airpod_price.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(Airpod_price);	
				model=null;
				base_airpod=0.0;
				bool=true;
			}

			else
			{ 
				getcart ob = new getcart();
	            new Cartdummy(base_airpod,"add");
	            ob.set_Airpod(model,base_airpod);
				Airpod_choice = new Label("Selected  CHOICE: "+model);
				Airpod_choice.setBounds(50, 280, 400,40);
				Airpod_choice.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(Airpod_choice);
				Airpod_price = new Label("\nPrice: "+base_airpod);
				Airpod_price.setBounds(100, 320, 250,40);
				Airpod_price.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(Airpod_price);	
				
				

				
				
				
				model=null;
				base_airpod=0.0;
				bool=true;
			}
		}
		if(e.getSource()==b2)
		{
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		    
		}    
		if(e.getSource()==b3)
		{   
			
		}
		
		if(e.getSource()==b4)
		{
			this.dispose();
			new Store();
		}
	}
   	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(this.c1.getState()==true)
		{
		
		    model="AirPods (3rd generation)";
		    base_airpod=18500;
		}
		if(this.c3.getState()==true)
		{
		    model="AirPods Max";
		    base_airpod=59900;
		    
		}
		if(this.c4.getState()==true)
		{
		    model="AirPods Pro";
		    base_airpod=24900;
		}

		if(c5.getState()==true)
		{
		
		    model="AirPods (2nd generation)";
		    base_airpod=12900;
		     
		}
		if(c6.getState()==true)
		{
		    model="AirPods (1st generation)";
		    base_airpod=8000;
		    
		}
		
	}



	public static void main(String[] args)
	{
		new Airpod();
	}

}