

import javax.swing.*;

import  java.sql.Connection;
import java.sql.DriverManager;

import java.io.Closeable;
import java.awt.event.ActionListener;
import java.awt.event.*;  
import java.sql.*;

public class RFORM  implements ActionListener 
{
	static final String JDBC_DRIVER="jdbc:mysql://localhost:3306/?user=root";
	 static final String DB_URL="jdbc:mysql://localhost:3306/examportal";
	 static final String USER="root";
	 static final String PASS = "apeksha777";	
	
	
	
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b ;
    
    RFORM()
    {
    	JFrame f = new JFrame("Registration  page");
    	l1 = new JLabel("enterno");
    	l1.setBounds(50,50,300,30);
    	l2 = new JLabel("name");
    	l2.setBounds(50,100,300,30);
    	l3 = new JLabel("gender");
    	l3.setBounds(50,150,300,30);
    	l4 = new JLabel("class");
    	l4.setBounds(50,200,100,30);
    	l5 = new JLabel("password");
    	l5.setBounds(50,250,100,30);
    	l6 = new JLabel("contactno");
    	l6.setBounds(50,300,100,30);
    	
    	t1= new JTextField(3);
    	t1.setBounds(200,50,100,30);
    	t2= new JTextField(20);
    	t2.setBounds(200,100,100,30);
    	t3= new JTextField(8);
    	t3.setBounds(200,150,100,30);
    	t4= new JTextField(8);
    	t4.setBounds(200,200,100,30);
    	t5= new JTextField(10);
    	t5.setBounds(200,250,100,30);
    	t6= new JTextField(12);
    	t6.setBounds(200,300,100,30);
    	
    	b = new JButton("Register");
    	b.setBounds(50,450,100,30);
    	
    	f.add(l1);
    	f.add(t1);
    	f.add(l2);
    	f.add(t2);
    	f.add(l3);
    	f.add(t3);
    	f.add(l4);
    	f.add(t4);
    	f.add(l5);
    	f.add(t5);
    	f.add(l6);
    	f.add(t6);
    	f.add(b);
    	b.addActionListener(this);
    	f.setSize(800,800);
    	f.setLayout(null);
    	f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e )
    {
    	if(e.getSource()==b)
    	{
    		String v1 =t1.getText();
    		String v2 =t2.getText();
    		String v3 =t3.getText();
    		String v4 =t4.getText();
    		String v5 =t5.getText();
    		String v6 =t6.getText();
 		Connection con = null;
    		Statement stmt= null; 
    		try 
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("data is inserting");
    		con=DriverManager.getConnection(DB_URL,USER,PASS);
    			System.out.println("connected to database successfully");
    			
    			stmt=con.createStatement();
    			String sql1 = "INSERT INTO register(enterno,name,gender,class,password,contactno) VALUES('"+v1+"' ,'"+v2+"', '"+v3+"', '"+v4+"', '"+v5+"', '"+v6+"')";
    			stmt.executeUpdate(sql1);
    			con.close();
    			((Closeable) con).close();
    		}
    		catch(Exception ae)
    		{
    			ae.printStackTrace();
   
    		}    		
    	}	
    }
    
	public static void main(String[] args) throws ClassNotFoundException,  SQLException  {
	 new  RFORM();

	}

}