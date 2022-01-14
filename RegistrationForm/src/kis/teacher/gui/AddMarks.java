package kis.teacher.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kis.databaseservices.RecordMarksHandler;
import kis.databaseservices.StudentRegistrationHandler;
import kis.student.gui.Student;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class AddMarks {

	private JFrame frmAddStudentMarks;
	private JTextField marksTextField;
	private JTextField registrationNumberTextField;

	private void Reset() {
		registrationNumberTextField.setText("");
		marksTextField.setText("");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks window = new AddMarks();
					window.frmAddStudentMarks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddMarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddStudentMarks = new JFrame();
		frmAddStudentMarks.setTitle("Add Student Marks");
		frmAddStudentMarks.setBounds(100, 100, 450, 300);
		frmAddStudentMarks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentMarks.getContentPane().setLayout(null);
		
		JLabel lblAddStudentMarks = new JLabel("Add Student Marks");
		lblAddStudentMarks.setBounds(143, 12, 146, 15);
		frmAddStudentMarks.getContentPane().add(lblAddStudentMarks);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(22, 92, 70, 15);
		frmAddStudentMarks.getContentPane().add(lblSubject);
		
		String[] subjectArray = {"", "SST","MATHS","SCIENCE","ENGLISH"};
		JComboBox subjectComboBox = new JComboBox(subjectArray);
		subjectComboBox.setBounds(241, 87, 114, 24);
		frmAddStudentMarks.getContentPane().add(subjectComboBox);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setBounds(22, 142, 70, 15);
		frmAddStudentMarks.getContentPane().add(lblMarks);
		
		marksTextField = new JTextField();
		marksTextField.setBounds(241, 140, 114, 19);
		frmAddStudentMarks.getContentPane().add(marksTextField);
		marksTextField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(SystemColor.text);
		btnSave.setBackground(new Color(0, 128, 0));
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String registrationNumber = registrationNumberTextField.getText().toString();
				String subject = String.valueOf(subjectComboBox.getSelectedItem());
				String score = marksTextField.getText().toString();
				int parsedScore = Integer.parseInt(score);
				
				Score studentScore = new Score(registrationNumber,subject, parsedScore
						);
				RecordMarksHandler handler = new RecordMarksHandler();
				
				boolean res = handler.recordStudentMarks(studentScore);
				
				if (java.util.Objects.equals(res, true)) {
					JOptionPane.showMessageDialog(null,
							"added successfully");
					Reset();
				} else {
					JOptionPane.showMessageDialog(null, "Oops, unable to add marks!");
				}
			}
			
		});
		btnSave.setBounds(172, 204, 117, 25);
		frmAddStudentMarks.getContentPane().add(btnSave);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		lblRegistrationNumber.setBounds(22, 41, 153, 15);
		frmAddStudentMarks.getContentPane().add(lblRegistrationNumber);
		
		registrationNumberTextField = new JTextField();
		registrationNumberTextField.setBounds(241, 39, 114, 19);
		frmAddStudentMarks.getContentPane().add(registrationNumberTextField);
		registrationNumberTextField.setColumns(10);
	}

}
