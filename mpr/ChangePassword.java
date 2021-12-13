package mpr;

import java.awt.*;

public class ChangePassword extends Frame{
             
	            Label l1,l2,l3;
	            TextField tf1,tf2,tf3;
	            
	
	       ChangePassword()
	       {   this.setVisible(true);
	           this.setSize(450,450);
	           this.setLayout(null);
	           this.setTitle("Change Pasword:");
	    	   
	    	   Label l1 = new Label("Enter your email:");
	    	   l1.setFont(new Font("Arial",Font.BOLD,15));
	    	   l1.setBounds(50,50,150,20);
	    	   l1.setBackground(Color.lightGray);
	    	   this.add(l1);
	    	   
	    	   Label l2 = new Label("Enter new Password:");
	    	   l2.setFont(new Font("Arial",Font.BOLD,15));
	    	   l2.setBounds(50,50,150,20);
	    	   l2.setBackground(Color.lightGray);
	    	   this.add(l2);
	    	   
	    	   
	    	   Label l3 = new Label("Reenter new Password:");
	    	   l3.setFont(new Font("Arial",Font.BOLD,15));
	    	   l3.setBounds(50,50,150,20);
	    	   l3.setBackground(Color.lightGray);
	    	   this.add(l3);
	    	   
	       }
	       public boolean change_verification()
	       {
	         boolean bool = true;
	         return bool;
	    
	       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new ChangePassword();
	}

}
