/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.EventObject;

public class DisplayAll extends JFrame implements ActionListener{  
	DisplayAll(){
		
	}
	public  void main(String[] args) {
		DisplayAll();
		JFrame frame2;//creating object of second JFrame
	    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
	    JTable table;//Creating object of JTable
	    Connection connection;//Creating object of Connection class
	    Statement statement;//Creating object of Statement class
		frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);
 
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("RegNo");
        defaultTableModel.addColumn("Subject");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("yoStudy");
        defaultTableModel.addColumn("mark");
 
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "root");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from student where reg_No IS NOT NULL";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
 
 
            while (resultSet.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String name = resultSet.getString("NAME");
                String gender = resultSet.getString("GENDER");
                String regiNo = resultSet.getString("REG_NO");
                String subject = resultSet.getString("SUBJECT");
                String age = resultSet.getString("AGE");
                String yoStudy = resultSet.getString("CLASS");
                String mark = resultSet.getString("MARK");
                
                defaultTableModel.addRow(new Object[]{name, gender, regiNo, subject, age, yoStudy, mark});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();
               } 
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
		}
	}
	private void DisplayAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton displayButton=new JButton("DISPLAY RECORDS");
		displayButton.setBounds(100,550,200,35);
		displayButton.addActionListener(this);
		if (arg0.getSource()==displayButton) {  //if authentic, navigate user to a new page  
            
            //create instance of the NewPage  
		      RegistrationForm page = new RegistrationForm();  
		            
		          //make page visible to the user  
		          page.setVisible(true);
		      }  
		
	}
}


