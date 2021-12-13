package mpr;

import java.awt.*;
import java.awt.event.*;


public class Thank_you   extends Frame implements ActionListener {
	
	
	Label l1;
	Button b1,b2;
	
	Thank_you()
	{
	
	

	
		    this.setSize(550,450);
		    this.setVisible(true);
		    this.setLayout(null);
		    this.setBackground(Color.orange);
		    
		    
		    
		    l1 =new Label("THANK YOU FOR SHOPPING WITH US",Label.CENTER);
			l1.setFont(new Font("Tahoma",Font.BOLD,25));
			l1.setForeground(Color.BLACK);
			l1.setBackground(Color.white);
			l1.setBounds(0,125,550,50);
			l1.setVisible(true);
			this.add(l1);
			
			
			
			b2 = new Button("EXIT");
			b2.setFont(new Font("Tahoma",Font.BOLD,15));
			b2.setForeground(Color.RED);
			b2.setBackground(Color.black);
			b2.setBounds(225,250,100,20);
			b2.addActionListener(this);;
			this.add(b2);		
			
			
			
			
	}
	
	
		    
		   
@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			System.exit(0);		}
		
	   }




public static void main(String[] args) {
	new Thank_you();
}
	

}

