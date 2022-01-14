package kis.teacher.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import kis.auth.Login;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherWelcomeBoard extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherWelcomeBoard window = new TeacherWelcomeBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public TeacherWelcomeBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToKatikamu = new JLabel("Welcome Teacher !");
		lblWelcomeToKatikamu.setBounds(144, 12, 346, 15);
		frame.getContentPane().add(lblWelcomeToKatikamu);
		
		JButton btnRegisterStudents = new JButton("Register Students");
		btnRegisterStudents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisterStudents reg = new RegisterStudents();
				reg.main(null);
			}
			
		});
		btnRegisterStudents.setForeground(SystemColor.text);
		btnRegisterStudents.setBackground(SystemColor.desktop);
		btnRegisterStudents.setBounds(133, 54, 163, 25);
		frame.getContentPane().add(btnRegisterStudents);
		
		JButton btnViewStudents = new JButton("View Students");
		btnViewStudents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StudentList studentList = new StudentList();
				studentList.main(null);
			}
			
		});
		btnViewStudents.setForeground(SystemColor.text);
		btnViewStudents.setBackground(SystemColor.desktop);
		btnViewStudents.setBounds(133, 112, 163, 25);
		frame.getContentPane().add(btnViewStudents);
		
		JButton btnRecordStudentMarks = new JButton("Student Marks");
		btnRecordStudentMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddMarks addMarks = new AddMarks();
				addMarks.main(null);
			}
		});
		btnRecordStudentMarks.setForeground(SystemColor.text);
		btnRecordStudentMarks.setBackground(SystemColor.desktop);
		btnRecordStudentMarks.setBounds(133, 162, 163, 25);
		frame.getContentPane().add(btnRecordStudentMarks);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.main(null);
			}
			
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(SystemColor.desktop);
		btnLogout.setBounds(133, 210, 163, 25);
		frame.getContentPane().add(btnLogout);
	}
}
