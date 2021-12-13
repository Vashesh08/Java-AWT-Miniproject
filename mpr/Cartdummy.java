package mpr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;


public class Cartdummy extends Frame implements ActionListener{
	
	Label[] ipad_items = new Label[5];
	
	Label[] iphone_items = new Label[5];
	
	Label[] macbook_items = new Label[5];
	
	Label[] airpod = new Label[5];
	
	Button[] deletion = new Button[20];
	
	Button proceed;
	
	Label error;
	
	int main_counter =0;
	
	double [] cart = new double[20];
	
	
	
	public static double gtotal=0.0;
	
	
	Button b1;
	Button b2;
	Label total,display;
	//TextField tf1;
	 Cartdummy(String[]a, String[]b, String[]c,String[]d, double[]ipad_cost, double[]iphone_cost,double[]macbook_cost,double[]airpod_cost)
	{  
		
		this.setVisible(true);
			
	    this.setSize(1500,1500);
	    this.setLayout(null);
	    int x=50;
	    int y=0;
	    error = new Label("Cant select more than 4 of each items");
	    error.setVisible(false);
	    error.setBounds(25, 520, 100, 20);
	    this.add(error);
	    
	    /*tf1 = new TextField(2);
	    tf1.setBounds(1010,50,25,20);
	    this.add(tf1);*/
	    
	    
	   /* b2 = new Button("REMOVE");
	    b2.setBounds(920,50,80,20);
	    this.add(b2);
	  
	    b2.addActionListener(this);*/
	    y=y+30;
	    Label header0 = new Label("iPads in your cart");
		header0.setFont(new Font("Arial",Font.BOLD,12));
		header0.setBounds(25,y,780,20);
		this.add(header0);
		for(int i=0;i<4;i++,x=x+50)
		{ 
			
			y=x;
			//try
		//{
			    ipad_items[i]= new Label();
			    ipad_items[i].setBounds(25,x, 780, 20);
			    ipad_items[i].setBackground(Color.LIGHT_GRAY);
			    System.out.println(i+" "+x); 
			   
			    
			    ipad_items[i].setFont(new Font("Arial",Font.BOLD,12));
			    
			    deletion[i]= new Button("DELETE");
			    deletion[i].setFont(new Font("Arial",Font.PLAIN,12));
			    deletion[i].setBounds(870,x,50,18);
			    deletion[i].addActionListener(this);
			    this.add(deletion[i]);
			    

			       
			    if(ipad_cost[i]!=0.00)
			    {    
			    	ipad_items[i].setText(i+")"+a[i]+" "+"Price"+" "+ "Rs  "+ipad_cost[i]);
			    }
			    else
			    {    deletion[i].setVisible(false);
			    	 ipad_items[i].setText(null);
				     ipad_items[i].setVisible(false);
			    	
			    }
			   
			    this.add(ipad_items[i]);
			    
		//}
			//catch(ArrayIndexOutOfBoundsException e)
			//{
				error.setVisible(false);
			//}
		
		}
		Label header1 = new Label("iPhones in your cart");
		header1.setFont(new Font("Arial",Font.BOLD,12));
		header1.setBounds(25,y+30,780,20);
		this.add(header1);
		
		
		for(int i=0;i<4;i++,x=x+50)
		{   y=x;   
			System.out.println("hey");
		       System.out.println(getcart.mc[1]);
			 iphone_items[i]= new Label();
			    iphone_items[i].setBounds(25,x, 780, 20);
			    iphone_items[i].setBackground(Color.LIGHT_GRAY);
			    deletion[i+4]= new Button("DELETE");
			    deletion[i+4].setFont(new Font("Arial",Font.PLAIN,12));
			    deletion[i+4].setBounds(870,x,50,18);
			    deletion[i+4].addActionListener(this);
			    this.add(deletion[i+4]);
			    if(iphone_cost[i]!=0.00)
			    {
			    iphone_items[i].setText((i+4)+")"+" "+d[i]+" "+"Price"+" "+ "Rs "+"  "+iphone_cost[i]);
			    }
			    else
			    {    deletion[i+4].setVisible(false);
			    	iphone_items[i].setText(null);
			    	iphone_items[i].setVisible(false);
			    }
			    
			    iphone_items[i].setFont(new Font("Arial",Font.BOLD,12));
			    System.out.println(i+" "+x);  
			 
			    this.add(iphone_items[i]);	  
		}
		Label header2 = new Label("MacBooks  in your cart");
		header2.setFont(new Font("Arial",Font.BOLD,12));
		header2.setBounds(25,y+30,780,20);
		this.add(header2);
		for(int i=0;i<4;i++,x=x+50)
		{   y=x;
			System.out.println(getcart.mc[0]);
			macbook_items[i]= new Label();
			macbook_items[i].setBounds(25,x,780, 20);
			macbook_items[i].setBackground(Color.LIGHT_GRAY);
			macbook_items[i].setFont(new Font("Arial",Font.BOLD,12));
			 deletion[i+8]= new Button("DELETE");
			    deletion[i+8].setFont(new Font("Arial",Font.PLAIN,12));
			    deletion[i+8].setBounds(870,x,50,18);
			    deletion[i+8].addActionListener(this);
			    this.add(deletion[i+8]);
			    System.out.println(macbook_cost[i]);  
			    if(macbook_cost[i]!=0.00)
				{
			    macbook_items[i].setText((i+8)+")"+" "+c[i]+"Price"+ "  "+"Rs "+" "+macbook_cost[i]);
				}
			    else
			    {    deletion[i+8].setVisible(false);
			    	macbook_items[i].setText(null);
			    	macbook_items[i].setVisible(false);
			    }
			    this.add(macbook_items[i]);	  
		}
		Label header3 = new Label("Airpods in your cart");
		header3.setFont(new Font("Arial",Font.BOLD,12));
		header3.setBounds(25,y+30,780,20);
		this.add(header3);
		for(int i=0;i<4;i++,x=x+50)
		{
			airpod[i]= new Label();
			airpod[i].setBounds(25,x,780, 20);
			airpod[i].setBackground(Color.LIGHT_GRAY);
			airpod[i].setFont(new Font("Arial",Font.BOLD,12));
			    System.out.println(b[i]);
			    deletion[i+12]= new Button("DELETE");
			    deletion[i+12].setFont(new Font("Arial",Font.PLAIN,12));
			    deletion[i+12].setBounds(870,x,50,18);
			    deletion[i+12].addActionListener(this);
			    this.add(deletion[i+12]);
			    if(airpod_cost[i]!=0.00)
			    {
			    airpod[i].setText((i+12)+")"+""+b[i]+" "+"Price"+"  " +"Rs "+" "+airpod_cost[i]);
			    }
			    else
			    {   deletion[i+12].setVisible(false);
			    	airpod[i].setText(null);
			    	airpod[i].setVisible(false);
			    }
			    this.add(airpod[i]);	  
		}
		b1 = new Button("GO BACK");
		b1.setBounds(900,560,60,20);
		b1.addActionListener(this);
		this.add(b1);
		
		Label ORDERHEADING= new Label("ORDER DETAILS");
		ORDERHEADING.setFont(new Font("serif",Font.BOLD,30));
		ORDERHEADING.setBounds(940,25,250,40);
		this.add(ORDERHEADING);
		
	
	
		
		total= new Label("Order Total:  "+gtotal);
		
		total.setBounds(960,70, 160, 20);
		this.add(total);
		
	    proceed = new Button("PROCEED TO PAY");
	    proceed.setFont(new Font("serif",Font.BOLD,25));
	    proceed.setBackground(Color.GREEN);
	    proceed.setForeground(Color.WHITE);
		proceed.setBounds(980,120,280, 40);
		proceed.addActionListener(this);
		this.add(proceed);
		
		
		
		
		
          		
	}
	Cartdummy(double t,String s)
	{
	   if(s.equals("add"))
	   {	gtotal=gtotal+t;}
	   else if (s.equals("remove"))
	   {   if(gtotal!=0)
		   gtotal=gtotal-t;
	   else
	   {
		   System.out.println("Nothing to be removed");
	   }
	   }
	   
		
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			this.dispose();
		}
		
		/*if(e.getSource()==b2)
		{
			getcart ob = new getcart();
			ob.delete(Integer.parseInt(tf1.getText()));
			this.dispose();
			
		}*/
		if(e.getSource()==deletion[0])
		{
			getcart ob = new getcart();
			ob.delete(0);
			this.dispose();
			
		}
		if(e.getSource()==deletion[1])
		{
			getcart ob = new getcart();
			ob.delete(1);
			this.dispose();
			
		}
		if(e.getSource()==deletion[2])
		{
			getcart ob = new getcart();
			ob.delete(2);
			this.dispose();
			
		}
		if(e.getSource()==deletion[3])
		{
			getcart ob = new getcart();
			ob.delete(3);
			this.dispose();
			
		}
		if(e.getSource()==deletion[4])
		{
			getcart ob = new getcart();
			ob.delete(4);
			this.dispose();
			
		}
		
		if(e.getSource()==deletion[5])
		{
			getcart ob = new getcart();
			ob.delete(5);
			this.dispose();
			
		}
		if(e.getSource()==deletion[6])
		{
			getcart ob = new getcart();
			ob.delete(6);
			this.dispose();
			
		}
		if(e.getSource()==deletion[7])
		{
			getcart ob = new getcart();
			ob.delete(7);
			this.dispose();
			
		}
		if(e.getSource()==deletion[8])
		{
			getcart ob = new getcart();
			ob.delete(8);
			this.dispose();
			
		}
		if(e.getSource()==deletion[9])
		{
			getcart ob = new getcart();
			ob.delete(9);
			this.dispose();
			
		}
		if(e.getSource()==deletion[10])
		{
			getcart ob = new getcart();
			ob.delete(10);
			this.dispose();
			
		}
		if(e.getSource()==deletion[11])
		{
			getcart ob = new getcart();
			ob.delete(11);
			this.dispose();
			
		}
		if(e.getSource()==deletion[12])
		{
			getcart ob = new getcart();
			ob.delete(12);
			this.dispose();
			
		}
		if(e.getSource()==deletion[13])
		{
			getcart ob = new getcart();
			ob.delete(13);
			this.dispose();
			
		}
		if(e.getSource()==deletion[14])
		{
			getcart ob = new getcart();
			ob.delete(14);
			this.dispose();
			
		}
		if(e.getSource()==deletion[15])
		{
			getcart ob = new getcart();
			ob.delete(15);
			this.dispose();
			
		}
		if(e.getSource()==proceed)
		{   this.dispose();
			new Apple_Pay(gtotal);
			String forder=Arrays.toString(getcart.ap);
			System.out.println(forder);
		}
		
			
	}
	
	public  void remove()
	{
		
		this.dispose();
		
		
	}
	


	public static void main(String[] args) {
		
		
		

	}

}
