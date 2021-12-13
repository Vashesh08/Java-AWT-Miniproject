package mpr;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Vector;
 
public class Apple_Pay extends Frame implements ActionListener/*,ItemListener*/{
	
	Label AP_Title, AP_UserId,AP_AuthPin, AP_Add1, AP_Add2, AP_Add3,N_pass, AP_OrderCnf,lbl_error;  
	TextField tf1, tf2,tf3,tf4,tf5,tf6;  
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list;
	CheckboxGroup cg,cg1,cg2,cg3;
	Button b1,b2,b3; 
	public static boolean fundcheck;
	String model,Mac_color,memory,edition;
	double base_macbook,memory_macbook,price;
	static public double deduct=-1.0;
	static String finalorder=" ";
	static Vector <String> v = new Vector<String>(16);
	Apple_Pay(double cost)
	{   this.setSize(600,800);
	    this.setVisible(true);
	    this.setLayout(null);
	    this.setBackground(new Color(0, 71, 171));   
	    this.setTitle("Newark Store");
		AP_Title = new Label("NEWARK PAY"); 
		AP_Title.setBounds(150, 80, 250,40);
		AP_Title.setForeground(new Color(255, 215, 0));
		AP_Title.setFont(new Font("Monospaced",Font.BOLD,40)); 
		this.add(AP_Title); 
		
		/*list = new List(3,false);
		list.add("M1");
		list.add("Intel i7");
		list.add("Intel i9");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);*/ 
		
		
		
		AP_UserId = new Label(" Newark_Id       :");
		AP_UserId.setBounds(10,175,250,20);
		AP_UserId.setForeground(new Color(255, 215, 0));
		AP_UserId.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
		this.add(AP_UserId);
		
		tf1 = new TextField();  
		tf1.setFont(new Font("TimesRoman",Font.BOLD,24));
        tf1.setBounds(275,170,250,35);   
        this.add(tf1);
		
		/*cg = new CheckboxGroup();
		c1= new Checkbox("Air",cg,false);
		c1.setBounds(25,170,50,12);
		c1.addItemListener(this);
		this.add(c1);*/
		
		/*c3= new Checkbox("Pro",cg,false);
		c3.setBounds(25,210,50,12);
		c3.addItemListener(this);
		this.add(c3);*/
        
        N_pass=new Label("Newark_Password  :");
         N_pass.setBounds(10,320,250,20);
        N_pass.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
        N_pass.setForeground(new Color(255, 215, 0));
		this.add(N_pass);
		

		tf2 = new TextField();    
		tf2.setBounds(275,315,250,35);  
		tf2.setFont(new Font("TimesRoman",Font.BOLD,24));
        this.add(tf2);
        
		
		
		
		
		
		AP_AuthPin=new Label("Newark_Pin  :");
		AP_AuthPin.setBounds(10,250,250,20);
		AP_AuthPin.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
		AP_AuthPin.setForeground(new Color(255, 215, 0));
		this.add(AP_AuthPin);
		

		tf3 = new TextField();    
        tf3.setBounds(275,245,250,35);  
        tf3.setFont(new Font("TimesRoman",Font.BOLD,24));
        tf3.setEchoChar('*');
        this.add(tf3);
        
        lbl_error=new Label();
		lbl_error.setBounds(10,400,250,20);
		lbl_error.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
		lbl_error.setForeground(new Color(255, 215, 0));
		this.add(lbl_error);
        
        /*AP_Add1=new Label("Address 1  :");
        AP_Add1.setBounds(10,320,150,20);
        AP_Add1.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
        AP_Add1.setForeground(new Color(255, 215, 0));
		this.add(AP_Add1);
		

		tf3 = new TextField();    
        tf3.setBounds(175,315,250,35);  
        tf3.setFont(new Font("TimesRoman",Font.BOLD,24));
        this.add(tf3);
        
        AP_Add2=new Label("Address 2  :");
        AP_Add2.setBounds(10,390,150,20);
        AP_Add2.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
		AP_Add2.setForeground(new Color(255, 215, 0));
        this.add(AP_Add2);
		

		tf4 = new TextField();    
		tf4.setBounds(175,385,250,35);  
		tf4.setFont(new Font("TimesRoman",Font.BOLD,24));
        this.add(tf4);
        
        AP_Add3=new Label("Address 3  :");
        AP_Add3.setBounds(10,460,150,20);
        AP_Add3.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
        AP_Add3.setForeground(new Color(255, 215, 0));
		this.add(AP_Add3);
		

		tf5 = new TextField();    
		tf5.setBounds(175,455,250,35);  
		tf5.setFont(new Font("TimesRoman",Font.BOLD,24));
        this.add(tf5);
        
        AP_Add4=new Label("Address 4  :");
        AP_Add4.setBounds(10,530,150,20);
        AP_Add4.setFont(new Font("Monospaced",Font.BOLD | Font.ITALIC,26));
        AP_Add4.setForeground(new Color(255, 215, 0));
		this.add(AP_Add4);
		

		tf6 = new TextField();    
		tf6.setBounds(175,525,250,35);  
		tf6.setFont(new Font("TimesRoman",Font.BOLD,24));
        this.add(tf6);
        */
		/*cg2 = new CheckboxGroup();
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
		this.add(c8);*/
		
		
		/*MB_color=new Label("Choose a Color ");
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
		//this.add(c12);*/
		
		
		b1= new Button("PAY "+cost);
		b1.setBackground(new Color(50, 205, 50));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("TimesRoman",Font.BOLD,20));
		b1.setBounds(80,620,350,40);
		b1.addActionListener(this);
		this.add(b1);
		
		    b3=new Button("Back to Cart");
			b3.setForeground(Color.white);
			b3.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
			b3.setBounds(100,520,180,25);
			b3.addActionListener(this);
		    this.add(b3);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*if(e.getSource()==list)
		{
			edition=list.getSelectedItem();
			c2= new Checkbox(edition,cg,false);
			c2.setBounds(25,190,100,12);
			c2.addItemListener(this);
			this.add(c2);
		}*/
		
		if(e.getSource()==b1)
		{
			String UID = tf1.getText();
			String UPASS =  tf2.getText();
			String UPIN = tf3.getText();
			
			
			String id="";
			String d="";
		     String pin="";
			FirstJDBC ob = new FirstJDBC();
			
			
			 Connection con = null;
		        PreparedStatement p = null;
		        ResultSet rs = null;
			
			   con = ob.connectDB();
			   try
			   {
				   String sql = "select * from appleid_database where Apple_ID="+'"'+UID+'"';
				   System.out.println(sql); 
				   p = con.prepareStatement(sql);
				    rs= p.executeQuery();
				    
				    
				    if(rs.next())
				    {    d = rs.getString("Apple_password");
				    System.out.println(d); 
				       pin = rs.getString("Newark_pin");
				       System.out.println(pin);
				       id = rs.getString("Apple_ID");
				    		 
				    }
				    
			  
				    
			   }
				catch(Exception sql)
				{
					sql.printStackTrace();
				}
			   
		
			
			if(d.equals(UPASS) && pin.equals(UPIN))
			{
				
			
				 System.out.println("Done");
				 getBalance();
				 if(Apple_Pay.deduct==-1.0)
				 {
					 b1.setVisible(false);
				 }
				 else
				 {   orderlist();
				     addorder();
					 pay_deduct(Login_Page.maild);
					 this.dispose();
					 new Thank_you();
					 System.out.println("Payment sucessful");
				 }
				
				
			}
			else
			{  
				if(id.equals(""))
				{
					lbl_error.setText("NO ACCOUNT !");
				}
				else
				{
				System.out.println(id); 
				lbl_error.setText("INCORRECT PASSWORD !");
				}
			}
			
		}
		
		if(e.getSource()==b3)
		{
			this.dispose();
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		}
			
		
		
	}
   
	 


	
	/*public void itemStateChanged(ItemEvent e) {
		
		if(c1.getState()==true)
		{
		
		    model="AIR";
		   base_macbook=70000;
		}
		if(c2.getState()==true)
		{
		    model="13";
		    base_macbook=90000;
		    
		}
		if(c3.getState()==true)
		{
		    model="Pro";
		    base_macbook=100000;
		    
		}
		
		if(c1.getState()==false && c2.getState()==false && c3.getState()==false)
		{
	
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
*/
	
	public static void pay_deduct(String ID)
	{
		 FirstJDBC obc = new FirstJDBC();
	      Connection con =obc.connectDB();
	      
	      PreparedStatement p = null;
	      String q ="UPDATE  bank_database SET Balance=? where email=?";
	      //ResultSet rs = null;
	      try
	      {
	      
	      p = con.prepareStatement(q);
	      
	      
		  p.setDouble(1,Apple_Pay.deduct);
		  p.setString(2,ID);
		  
		  
	      p.executeUpdate();
	      }
	      catch (SQLIntegrityConstraintViolationException o) 
	      {
	    	  Sign_Up l = new Sign_Up() ;
	    	  l.errorofrepeat();
	    	  
			// TODO: handle exception
		  }
	      catch(Exception sql)
	      {    
	    	  sql.printStackTrace();}
		}

	
	public void getBalance()
	{
		double balance=0.0;
	FirstJDBC ob = new FirstJDBC();
	
	
	 Connection con = null;
       PreparedStatement p = null;
       ResultSet rs = null;
	
	   con = ob.connectDB();
	   try
	   {
		   String sql = "select * from bank_database where email="+'"'+Login_Page.maild+'"';
		   System.out.println(sql); 
		   p = con.prepareStatement(sql);
		    rs= p.executeQuery();
		    
		    
		    if(rs.next())
		    {    balance = rs.getDouble("Balance");
		    System.out.println(balance); 
		      
		    		 
		    }
		    
	  
		    
	   }
		catch(Exception sql)
		{
			sql.printStackTrace();
		}
	   

	
	if(balance<Cartdummy.gtotal)
	{
		  lbl_error.setText("Insuffiecient funds");
		  fundcheck=false;
		  
		
		
	}
	else
	{  
	    	
	      Apple_Pay.deduct=balance-Cartdummy.gtotal;
	      System.out.println(Apple_Pay.deduct);
	      fundcheck= true;
    }
	}
	public static void orderlist()
	{
		
			for(int i = 0;i<4;i++)
			{
                 if(getcart.ipcost[i]!=0.0)
                 {
                	 v.add(getcart.ip[i]+" "+getcart.ipcost[i]);
                 }
			}
			for(int i=0; i<4 ;i++)
			{     if(getcart.idcost[i]!=0.0)
				   {v.add(getcart.id[i]+" "+getcart.idcost[i]);}
			}
			for(int i=0; i<4 ;i++)
			{    if(getcart.apcost[i]!=0.0)
				{ v.add(getcart.ap[i]+" "+getcart.apcost[i]);}
			}
			for(int i=0; i<4 ;i++)
			{      if(getcart.mccost[i]!=0.0)
				   {v.add(getcart.mc[i]+" "+getcart.mccost[i]);}
			}
			
			
		    finalorder = v.toString();
		    System.out.print(v.toString());
		
	}
	
	public static void addorder()
	{
		
		FirstJDBC obc = new FirstJDBC();
	      Connection con =obc.connectDB();
	      
	      PreparedStatement p = null;
	      String q ="INSERT INTO order_database "
		            + "VALUES(?,?,?,?)";
	      //ResultSet rs = null;
	      try
	      {
	      
	      p = con.prepareStatement(q);
	      Emailsend u = new Emailsend();
	      p.setString(1,Login_Page.maild);
		  p.setString(2,finalorder);
		  p.setString(3,Integer.toString(u.generate()));
		  p.setDouble(4,Cartdummy.gtotal);
		  
	      p.executeUpdate();
	      }
	     
	      catch(Exception sql)
	      {    
	    	  sql.printStackTrace();}
		}
	

	public static void main(String[] args)
	{
		new Apple_Pay(52.0);
	}

}