package kis.student.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import kis.auth.Login;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class StudentWelcomeBoard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWelcomeBoard window = new StudentWelcomeBoard();
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
	public StudentWelcomeBoard() {
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
		
		JLabel lblNewLabel = new JLabel("Welcome Student !");
		lblNewLabel.setBounds(158, 12, 145, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnViewMarks = new JButton("View Marks");
		btnViewMarks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				StudentMarks stdMarks = new StudentMarks();
				stdMarks.main(null);
			}
			
		});
		btnViewMarks.setForeground(SystemColor.text);
		btnViewMarks.setBackground(SystemColor.desktop);
		btnViewMarks.setBounds(163, 64, 117, 25);
		frame.getContentPane().add(btnViewMarks);
		
		JButton btnTimetable = new JButton("TimeTable");
		btnTimetable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TimeTable tb = new TimeTable();
				tb.main(null);
			}
			
		});
		btnTimetable.setForeground(Color.WHITE);
		btnTimetable.setBackground(SystemColor.desktop);
		btnTimetable.setBounds(163, 121, 117, 25);
		frame.getContentPane().add(btnTimetable);
		
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
		btnLogout.setBounds(163, 186, 117, 25);
		frame.getContentPane().add(btnLogout);
	}

}
