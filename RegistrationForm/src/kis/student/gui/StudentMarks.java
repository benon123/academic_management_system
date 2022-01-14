package kis.student.gui;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import kis.databaseservices.KatikamuDbConnection;

import java.sql.*;
public class StudentMarks extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    
    JTable jtbl = new JTable(model);

    public StudentMarks() {
     //cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
    	model.addColumn("Number");
        model.addColumn("Registration Number");
        model.addColumn("Subject");
        model.addColumn("Marks");
        try {
        	Connection con = new KatikamuDbConnection().getDbConnection();
        	
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM student_marks where id = id");
            ResultSet smark = pstm.executeQuery();
            
            int i = 1;
            while(smark.next()){
            	int rowNumber = i;
                model.addRow(new Object[]{
                		rowNumber,smark.getString("registration_number"),smark.getString("subject"),
                		smark.getString("marks")});
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
        JFrame frame = new StudentMarks();
        frame.setTitle("List of  Students Marks");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}