package kis.auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import kis.databaseservices.KatikamuDbConnection;
import kis.student.gui.StudentWelcomeBoard;
import kis.teacher.gui.RegisterStudents;
import kis.teacher.gui.TeacherWelcomeBoard;

import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Login extends JFrame{

	private JFrame kisJFrame;
	private JTextField userNameTextField;
	private final JPasswordField passwordField = new JPasswordField();
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.kisJFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		kisJFrame =  new JFrame();
		kisJFrame.setTitle("KIS Login");
		kisJFrame.setBounds(100, 100, 450, 325);
		kisJFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		kisJFrame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToKatikamu = new JLabel("Welcome to Katikamu Information System ");
		lblWelcomeToKatikamu.setFont(new Font("Verdana", Font.BOLD, 13));
		lblWelcomeToKatikamu.setBounds(74, 12, 338, 15);
		kisJFrame.getContentPane().add(lblWelcomeToKatikamu);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setBounds(190, 39, 70, 15);
		kisJFrame.getContentPane().add(lblSignIn);
		
		JLabel lblSignInAs = new JLabel("Sign in as : ");
		lblSignInAs.setBounds(107, 81, 89, 15);
		kisJFrame.getContentPane().add(lblSignInAs);
		
		String[] userArray = {"Teacher", "Student"};
		comboBox = new JComboBox(userArray);
		comboBox.setBounds(239, 76, 126, 24);
		kisJFrame.getContentPane().add(comboBox);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(107, 124, 80, 15);
		kisJFrame.getContentPane().add(lblUsername);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(239, 122, 132, 29);
		kisJFrame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(107, 171, 70, 15);
		kisJFrame.getContentPane().add(lblPassword);
		passwordField.setBounds(239, 163, 132, 32);
		kisJFrame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setBackground(SystemColor.desktop);
		btnLogin.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent actionEvent) {
				String userType = String.valueOf(comboBox.getSelectedItem());
				String userName = userNameTextField.getText().toString();
				String userPassword = String.valueOf(passwordField.getPassword());
				
				KatikamuDbConnection db = new KatikamuDbConnection();
				try {
					Connection connection = db.getDbConnection();
					
					Statement statement = connection.createStatement();
					String userCheck = null;
					if(userType == "Teacher") {
						 userCheck = "SELECT * from teacher";
					}else {
						userCheck = "SELECT * from students";
					}
				
					ResultSet result = statement.executeQuery(userCheck);
					while(result.next()) {
						if(userName.equals(result.getString("username")) && userPassword.equals(result.getString("password"))) {
							System.out.println("You are welcome " +result.getString("first_name")+ " " + result.getString("last_name"));
							JOptionPane.showMessageDialog(kisJFrame, "Welcome " + result.getString("last_name")+ " " + result.getString("first_name"));
							kisJFrame.dispose();
							if(userType == "Teacher") {
								TeacherWelcomeBoard wb = new TeacherWelcomeBoard();
								wb.main(null);
							}else {
								StudentWelcomeBoard wb = new StudentWelcomeBoard();
								wb.main(null);
							}
							
						}else {
							System.out.println("Credentials not found for " + userName);
							
						}
					}
				}catch(SQLException e) {
					  System.out.println("Got exception while validating user "+e.getMessage());
					  
				  }
			}
			
		});
		btnLogin.setBounds(165, 234, 117, 25);
		kisJFrame.getContentPane().add(btnLogin);
		
		
	}
}
