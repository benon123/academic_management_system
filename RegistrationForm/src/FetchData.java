
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class FetchData implements ActionListener {
 
    JFrame frame1;//creating object of first JFrame
    JLabel regNoLabel;//creating object of JLabel
    JTextField regNoTextField;//creating object of JTextfield
    JButton fetchButton;//creating object of JButton
    JButton resetButton;//creating object of JButton
    
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    int flag=0;
 
 
    FetchData() {
 
        frame1 = new JFrame();
        frame1.setTitle("Search Database");//setting the title of first JFrame
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
        frame1.setSize(500, 300);//setting the size of first JFrame
        frame1.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
 
        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
 
      //Setting the property of JLabel and adding it to the first JFrame
        regNoLabel = new JLabel("Enter Registration Number");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame1.add(regNoLabel, bagConstraints);
 
      //Setting the property of JTextfield and adding it to the first JFrame
        regNoTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame1.add(regNoTextField, bagConstraints);
 
      //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);
 
      //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        resetButton = new JButton("Reset Data");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        frame1.add(resetButton, bagConstraints);
 
        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);
 
 
        frame1.setVisible(true);//Setting the visibility of First JFrame
        frame1.validate();//Performing relayout of the First JFrame
 
 
    }
 
    public static void main(String[] args) {
        new FetchData();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if (e.getSource() == fetchButton) {
 
            String regNumber = regNoTextField.getText().toString();//getting text of username text field and storing it in a String variable
            frameSecond(regNumber);//passing the text value to frameSecond method
 
        }
        if (e.getSource() == resetButton) {
            regNoTextField.setText("");//resetting the value of username text field
        }
 
    }
 
 
    public void frameSecond(String regNumber) {
    
     //setting the properties of second JFrame
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
        defaultTableModel.addColumn("Class");
        defaultTableModel.addColumn("Mark");
 
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "root");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from student where reg_No = '" + regNumber + "'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
 
 
            while (resultSet.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String name = resultSet.getString("NAME");
                String gender = resultSet.getString("GENDER");
                String regiNo = resultSet.getString("REG_NO");
                String subject = resultSet.getString("SUBJECT");
                String age = resultSet.getString("AGE");
                String yoStudy = resultSet.getString("yoStudy");
                String mark = resultSet.getString("MARK");
                
                if (regNumber.equalsIgnoreCase(regiNo)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{name, gender, regiNo, subject, age, yoStudy, mark});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();
                    break;
                }
 
            }
 
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such student Found");//When invalid username is entered
            }
 
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 
 
    }
}