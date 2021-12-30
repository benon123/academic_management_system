
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class RegistrationForm extends JFrame implements ActionListener {
    JFrame frame;
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel regNumberLabel=new JLabel("REGISTRATION NUMBER");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel subjctLabel=new JLabel("SUBJECT");
    JLabel ageLabel=new JLabel("AGE");
    JLabel yoStudyLabel=new JLabel("CLASS");
    JLabel markLabel=new JLabel("MARK");
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField regNoTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField subjctTextField=new JTextField();
    JTextField ageTextField=new JTextField();
    JTextField yoStudyTextField=new JTextField();
    JTextField markTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    JButton displayButton=new JButton("DISPLAY RECORDS");
 
 
    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(60,60,480,700);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        regNumberLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        subjctLabel.setBounds(20,270,100,70);
        ageLabel.setBounds(20,320,100,70);
        yoStudyLabel.setBounds(20,370,100,70);
        markLabel.setBounds(20,420,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        regNoTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
        confirmPasswordField.setBounds(180,243,165,23);
        subjctTextField.setBounds(180,293,165,23);
        ageTextField.setBounds(180,343,165,23);
        yoStudyTextField.setBounds(180,393,165,23);
        markTextField.setBounds(180,443,165,23);
        registerButton.setBounds(70,500,100,35);
        resetButton.setBounds(220,500,100,35);
        displayButton.setBounds(100,550,200,35); 
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(regNumberLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(subjctLabel);
        frame.add(ageLabel);
        frame.add(yoStudyLabel);
        frame.add(markLabel);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(regNoTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(subjctTextField);
        frame.add(ageTextField);
        frame.add(yoStudyTextField);
        frame.add(markTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(displayButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        displayButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","root");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
                Pstatement.setString(3,regNoTextField.getText());
                Pstatement.setString(4,passwordField.getText());
                Pstatement.setString(5,confirmPasswordField.getText());
                Pstatement.setString(6,subjctTextField.getText());
                Pstatement.setString(7,ageTextField.getText());
                Pstatement.setString(8,yoStudyTextField.getText());
                Pstatement.setString(9,markTextField.getText());
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
            genderComboBox.setSelectedItem("Male");
            regNoTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            subjctTextField.setText("");
            ageTextField.setText("");
            yoStudyTextField.setText("");
            markTextField.setText("");
        }
        if (e.getSource()==displayButton) {  //if authentic, navigate user to a new page  
            
            //create instance of the NewPage  
            DisplayAll page = new DisplayAll();  
              
            //make page visible to the user  
            page.setVisible(true);    
        }
 
    }
}