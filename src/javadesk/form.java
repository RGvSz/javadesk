/**
 * 
 */
package javadesk;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class form extends JFrame implements ActionListener {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JButton b1;
	
	form()
	{
	setLayout(null);
	setSize(1000,1000);
	t1=new JTextField();
	t1.setBounds(500,200,200,30);
	t2=new JTextField();
	t2.setBounds(500,250,200,30);
	t3=new JTextField();
	t3.setBounds(500,300,200,30);
	t4=new JTextField();
	t4.setBounds(500,350,200,30);
	t5=new JTextField();
	t5.setBounds(500,400,200,30);
	t6=new JTextField();
	t6.setBounds(500,450,200,30);
	t7=new JTextField();
	t7.setBounds(500,500,200,30);
	b1=new JButton("submit");
	b1.setBounds(550,550,100,30);
	
	l1=new JLabel("Empolyee Code");
	l2=new JLabel("Full Name");
	l3=new JLabel("Age");
	l4=new JLabel("Designation");
	l5=new JLabel("Department");
	l6=new JLabel("Location");
	l7=new JLabel("Years of Experence");
	
	l1.setBounds(350,200,200,30);
	l2.setBounds(350,250,200,30);
	l3.setBounds(350,300,200,30);
	l4.setBounds(350,350,200,30);
	l5.setBounds(350,400,200,30);
	l6.setBounds(350,450,200,30);
	l7.setBounds(350,500,200,30);
	
	
	
	
	add(b1);
	b1.addActionListener(this);
	
	add(t1);
	add(t2);
	add(t3);
	add(t4);
	add(t5);
	add(t6);
	add(t7);
	
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(l6);
	add(l7);
	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			int code = Integer.parseInt(t1.getText());
			String name = t2.getText();
			int age = Integer.parseInt(t3.getText());
			String designation = t4.getText();
			String department = t5.getText();
			String location = t6.getText();
			int yoe = Integer.parseInt(t7.getText());
			
			System.out.println("Employee Code"+code);
		    System.out.println("Full Name"+name);
	        System.out.println("Age"+age);
	        System.out.println("Designation"+designation);
		    System.out.println("Department"+department);
	        System.out.println("Location"+location);
	        System.out.println("Years Of Experience"+yoe);
		
	        
	        
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");//
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kerala_camp","root","Shan@#123");

		
		String query =" insert into company(Id,Name,Age,Designation,Department,Location,Yearsofexperience) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,code);
		ps.setString(2,name);
		ps.setInt(3,age );
		ps.setString(4,designation);
		ps.setString(5,department);
		ps.setString(6,location);
		ps.setInt(7,yoe);
		
		int result = ps.executeUpdate();
		if(result==1)
		{
			System.out.println("Succesfully inserted");
			
		}
		else
			System.out.println("Error While insertion");
		Statement st=con.createStatement();
		ResultSet rs =st.executeQuery("select * from company");
		
		}catch(Exception l)
		{
			System.out.println(l);
		}
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		}
		}
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new form().setVisible(true);
	}

	}


