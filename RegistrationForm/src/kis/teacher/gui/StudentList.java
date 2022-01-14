package kis.teacher.gui;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import kis.databaseservices.KatikamuDbConnection;

import java.sql.*;
public class StudentList extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    
    JTable jtbl = new JTable(model);

    public StudentList() {
     //cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
    	model.addColumn("Number");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Registration Number");
        model.addColumn("Gender");
        model.addColumn("Age");
        model.addColumn("Class");
        model.addColumn("Registration Date");
        try {
        	Connection con = new KatikamuDbConnection().getDbConnection();
        	
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = pstm.executeQuery();
            
            int i = 1;
            while(rs.next()){
            	int rowNumber = i;
                model.addRow(new Object[]{
                		rowNumber,rs.getString("first_name")
                		, rs.getString("last_name"),rs.getString("registration_number"),rs.getString("gender"),
                		rs.getString("age"), rs.getString("class"),rs.getString("date_of_registration")});
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        
        this.pack();
        
        
    }
    public static void main(String[] args) {
        JFrame frame = new StudentList();
        frame.setTitle("List of Registered Students");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}