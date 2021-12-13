package mpr;
import java.util.Arrays;

public class getcart {
	
	static public String ip[]= new String[5];
	static public double ipcost[]= new double[5]; 
	static public String id[]= new String[5];
	static public double idcost[]= new double[5]; 
	static public String mc[]= new String[5];
	static public double mccost[]= new double[5]; 
	static public String ap[]= new String[5];
	static public double apcost[]= new double[5];  
	static int g=-1,f=-1,e=-1,h=-1;
	
	
	static 
	{
		for(int l=0;l<5;l++)
		{
			ip[l]="";
			ipcost[l]=0.00;
			id[l]="";
			idcost[l]=0.00;
			mc[l]="";
			mccost[l]=0.00;
			ap[l]="";
			apcost[l]=0.00;
		}
	}
	
	
	 public void  set_Ipad(String s,Double d)
	{         if(g<3)
	     {
		     g++;
		     id[g]=s;
			 idcost[g]=d;
	     } 		
			 
			 else
			 g=-1;
	
	//new Cartdummy(id, ap, mc, ip,idcost,ipcost,mccost,apcost);
		 
		 
	}
	 public void  set_Iphone(String s,Double d)
		{         if(f<3)
		     {
			     f++;
			     ip[f]=s;
				 ipcost[f]=d;
				
		     } 		 
				 
				 else
				 f=-1;
		
		//new Cartdummy(id, ap, mc, ip,idcost,ipcost,mccost,apcost);
			 
			 
		}
	 public void  set_Macbook(String s,Double d)
		{         if(e<3)
		     {
			     e++;
			     mc[e]=s;
				 mccost[e]=d;
		     } 		 
				 
				 else
				 e=-1;
		//new Cartdummy(id, ap, mc, ip,idcost,ipcost,mccost,apcost);
			 
		}
	 public void  set_Airpod(String s,Double d)
		{         if(h<3)
		     {
			     h++;
			     ap[h]=s;
				 apcost[h]=d;
		     } 		 
				 
				 else
				 h=-1;
			 
		//new Cartdummy(id, ap, mc, ip,idcost,ipcost,mccost,apcost);
		}
	 
	 public void create_Frame(String[]l, String[]m, String[]n,String[]o, double[]p, double[]q,double[]r,double[]s)
	 {
		 new Cartdummy(l,m,n,o,p,q,r,s);
		             
	 }
	
	 public void delete(int index)
	 {
		 if(index>=0 && index<4)
		 {   int u;
			 int a_index=index;
			 id[a_index]=" ";
			// getcart uy = new getcart();
			 
			  new  Cartdummy(idcost[a_index],"remove");
			 idcost[a_index]=0.0;
			 for(u=a_index;u<4;u++)
			 {
			 id[u]=id[u+1];
			 idcost[u]=idcost[u+1];
			 }
			 if(g==-1)
			 {
				 g=4;
			 }
			 else 
			 {
				g--;
			 }
			 
			 
			create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
			 
			 
			 
		 }
		 if(index>3 && index<8)
		 {
			 int a_index=index-4;
			 int u;
			 ip[a_index]=" ";
			// getcart uy = new getcart();
			 
			  new  Cartdummy(ipcost[a_index],"remove");
			 ipcost[a_index]=0.0;
			 for(u=a_index;u<4;u++)
			 {
				 ip[u]=ip[u+1];
				 ipcost[u]=ipcost[u+1];
			 }
			 if(f==-1)
			 {
				 f=4;
			 }
			 else 
			 {
				 f--;
			 }
			 
			create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		 }
		 if(index>7 && index<12)
		 {   int u;
			 int a_index=index-8;
			 mc[a_index]=" ";
			// getcart uy = new getcart();
			 
			  new  Cartdummy(mccost[a_index],"remove");
			 mccost[a_index]=0.0;
			 for(u=a_index;u<4;u++)
			 {
				 mc[u]=mc[u+1];
				 mccost[u]=mccost[u+1];
			 }
			 if(e==-1)
			 {
				 e=4;
			 }
			 else 
			 {
				 e--;
			 }
			 
			create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		 }
		 if(index>11 && index<16)
		 {   int u;
			 int a_index=index-12;
			 ap[a_index]=" ";
			// getcart uy = new getcart();
			 
			  new  Cartdummy(apcost[a_index],"remove");
			 apcost[a_index]=0.0;
			
			 
			 for(u=a_index;u<4;u++)
			 {
				 ap[u]=ap[u+1];
				 apcost[u]=apcost[u+1];
			 }
			 if(h==-1)
			 {
				 h=4;
			 }
			 else 
			 {
				 h--;
			 }
			create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		 }
	 }

	public static void main(String[] args) {
		getcart og=new getcart();
		System.out.println(getcart.ip[1]);
		og.send_Label(id,ap,mc,ip);
		
	}

}
	