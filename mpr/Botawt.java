package mpr;
import java.awt.*;
import java.awt.event.*;
public class Botawt extends Frame implements ActionListener {
	
	   Label l1,l2,l3;
	   TextField tf1;
	   Button b1;
	   
	   
	   public Botawt ()
	   {
		  
		    this.setVisible(true);
		    this.setResizable(false);
		    this.setLayout(null);
		    this.setSize(600, 600);
		    this.setTitle("Chatbot");
		    
		    l1 = new Label("BOT");
		    l1.setBounds(50, 100, 30, 15);
		    this.add(l1);
		    
		    
		    l2 = new Label("Hey");
		    l2.setBounds(100,100,300,15);
		    this.add(l2);
		    
		    l3 = new Label("YOU");
		    l3.setBounds(50,150,30,15);
		    this.add(l3);
		    
		    tf1= new TextField();
		    tf1.setBounds(100,150,300,20);
		    this.add(tf1);
		    
		    
		    b1 = new Button("ENTER");
		    b1.setBounds(420, 150, 50, 20);
		    this.add(b1);
		    
		    b1.addActionListener(this);
	   }
	   

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			String input = tf1.getText();
			if(input.equalsIgnoreCase("HI"))
			{
				l2.setText("HEY");
				tf1.setText("");
				
			}
			else if(input.equalsIgnoreCase("OPEN STORE"))
			{
				l2.setText("OKAY");
				new Store();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("BYE"))
			{
				this.dispose();
			}
			else if(input.equalsIgnoreCase("BUY MACBOOK"))
			{
				new MacBook();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("BUY IPAD"))
			{
				new Ipad();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("BUY IPHONE"))
			{
				new Iphone();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("BUY AIRPODS"))
			{
				new Airpod();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("LOGIN"))
			{
				new Login_Page();
				tf1.setText("");
			}
			else if(input.equalsIgnoreCase("VIEW CART"))
			{
				getcart oc= new getcart();
				oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.apcost, getcart.apcost);
				tf1.setText("");
			}
				
				
		}
		
		
	}


	public static void main(String[] args) {
	 new Botawt();

	}

}
