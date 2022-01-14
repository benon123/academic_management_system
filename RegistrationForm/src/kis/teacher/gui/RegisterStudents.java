package kis.teacher.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import kis.databaseservices.StudentRegistrationHandler;
import kis.student.gui.Student;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class RegisterStudents extends JFrame{

	private JFrame teacherDashBoardFrame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField registrationNumberTextField;
	private JTextField ageTextField;
	private JTextField textField;

	private void Reset() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		registrationNumberTextField.setText("");
		ageTextField.setText("");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterStudents window = new RegisterStudents();
					window.teacherDashBoardFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teacherDashBoardFrame = new JFrame();
		teacherDashBoardFrame.setTitle("KIS Register Students");
		teacherDashBoardFrame.setBounds(100, 100, 492, 415);
		teacherDashBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		teacherDashBoardFrame.getContentPane().setLayout(springLayout);

		JLabel lblRegisterStudents = new JLabel("Register Students");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegisterStudents, 10, SpringLayout.NORTH,
				teacherDashBoardFrame.getContentPane());
		teacherDashBoardFrame.getContentPane().add(lblRegisterStudents);

		JLabel lblFirstName = new JLabel("First Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 43, SpringLayout.NORTH,
				teacherDashBoardFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST,
				teacherDashBoardFrame.getContentPane());
		teacherDashBoardFrame.getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 16, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		teacherDashBoardFrame.getContentPane().add(lblLastName);

		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegistrationNumber, 11, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblRegistrationNumber, 0, SpringLayout.WEST, lblFirstName);
		teacherDashBoardFrame.getContentPane().add(lblRegistrationNumber);

		JLabel lblGender = new JLabel("Gender");
		springLayout.putConstraint(SpringLayout.WEST, lblGender, 11, SpringLayout.WEST,
				teacherDashBoardFrame.getContentPane());
		teacherDashBoardFrame.getContentPane().add(lblGender);

		JLabel lblAge = new JLabel("Age");
		springLayout.putConstraint(SpringLayout.WEST, lblAge, 0, SpringLayout.WEST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAge, -125, SpringLayout.SOUTH,
				teacherDashBoardFrame.getContentPane());
		teacherDashBoardFrame.getContentPane().add(lblAge);

		JLabel lblClass = new JLabel("Class");
		springLayout.putConstraint(SpringLayout.NORTH, lblClass, 21, SpringLayout.SOUTH, lblGender);
		springLayout.putConstraint(SpringLayout.WEST, lblClass, 0, SpringLayout.WEST, lblFirstName);
		teacherDashBoardFrame.getContentPane().add(lblClass);

		firstNameTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblRegisterStudents, 0, SpringLayout.WEST, firstNameTextField);
		firstNameTextField.setToolTipText("first name");
		springLayout.putConstraint(SpringLayout.WEST, firstNameTextField, 85, SpringLayout.EAST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, firstNameTextField, 0, SpringLayout.SOUTH, lblFirstName);
		teacherDashBoardFrame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lastNameTextField, 0, SpringLayout.WEST, firstNameTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, lastNameTextField, 0, SpringLayout.SOUTH, lblLastName);
		lastNameTextField.setColumns(10);
		teacherDashBoardFrame.getContentPane().add(lastNameTextField);

		registrationNumberTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, registrationNumberTextField, 0, SpringLayout.NORTH,
				lblRegistrationNumber);
		springLayout.putConstraint(SpringLayout.EAST, registrationNumberTextField, 0, SpringLayout.EAST,
				firstNameTextField);
		teacherDashBoardFrame.getContentPane().add(registrationNumberTextField);
		registrationNumberTextField.setColumns(10);

		String[] genderArray = { "gender", "Male", "Female" };
		JComboBox genderComboBox = new JComboBox(genderArray);
		springLayout.putConstraint(SpringLayout.NORTH, lblGender, 5, SpringLayout.NORTH, genderComboBox);
		springLayout.putConstraint(SpringLayout.NORTH, genderComboBox, 19, SpringLayout.SOUTH,
				registrationNumberTextField);
		springLayout.putConstraint(SpringLayout.WEST, genderComboBox, 0, SpringLayout.WEST, firstNameTextField);
		springLayout.putConstraint(SpringLayout.EAST, genderComboBox, 0, SpringLayout.EAST, firstNameTextField);
		teacherDashBoardFrame.getContentPane().add(genderComboBox);

		ageTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, ageTextField, -125, SpringLayout.SOUTH,
				teacherDashBoardFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, ageTextField, 0, SpringLayout.EAST, firstNameTextField);
		ageTextField.setColumns(10);
		teacherDashBoardFrame.getContentPane().add(ageTextField);

		String[] classArray = { "class", "P1", "P2", "P3", "P4", "P5", "P6", "P7" };
		JComboBox classComboBox = new JComboBox(classArray);
		springLayout.putConstraint(SpringLayout.NORTH, classComboBox, -5, SpringLayout.NORTH, lblClass);
		springLayout.putConstraint(SpringLayout.WEST, classComboBox, 0, SpringLayout.WEST, firstNameTextField);
		springLayout.putConstraint(SpringLayout.EAST, classComboBox, 0, SpringLayout.EAST, firstNameTextField);
		teacherDashBoardFrame.getContentPane().add(classComboBox);

		JLabel lblSubject = new JLabel("Subject");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 16, SpringLayout.SOUTH, lblAge);
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0, SpringLayout.WEST, lblFirstName);
		teacherDashBoardFrame.getContentPane().add(lblSubject);

		String[] subjectArray = { "subject", "Mathematics", "SST", "Science", "English" };
		JComboBox subjectComboBox = new JComboBox(subjectArray);
		springLayout.putConstraint(SpringLayout.NORTH, subjectComboBox, 11, SpringLayout.SOUTH, ageTextField);
		springLayout.putConstraint(SpringLayout.WEST, subjectComboBox, 0, SpringLayout.WEST, lblRegisterStudents);
		springLayout.putConstraint(SpringLayout.EAST, subjectComboBox, 0, SpringLayout.EAST, firstNameTextField);
		teacherDashBoardFrame.getContentPane().add(subjectComboBox);

		JButton btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -9, SpringLayout.EAST, firstNameTextField);
		btnSave.setForeground(SystemColor.text);
		btnSave.setBackground(new Color(0, 100, 0));
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String firstname = firstNameTextField.getText().toString();
				String lastname = lastNameTextField.getText().toString();
				String registrationNumber = registrationNumberTextField.getText().toString();
				String gender = String.valueOf(genderComboBox.getSelectedItem());
				String age = ageTextField.getText().toString();
				int convertedIntegerAge = Integer.parseInt(age);
				String studentClass = String.valueOf(classComboBox.getSelectedItem());
				String subject = String.valueOf(subjectComboBox.getSelectedItem());

				String lowerCaseFirstName = firstNameTextField.getText().toLowerCase();
				String trimmedLastName = lastNameTextField.getText().substring(0, 1).toLowerCase();
				String userName = trimmedLastName.concat(lowerCaseFirstName);

				Student student = new Student(firstname, lastname,userName, registrationNumber, gender, studentClass,
						subject, convertedIntegerAge);
				StudentRegistrationHandler handler = new StudentRegistrationHandler();
				
				boolean res = handler.registerStudent(student);
				
				if (java.util.Objects.equals(res, true)) {
					JOptionPane.showMessageDialog(null,
							"Student " + lastname + " " + firstname + " registered successfully");
					Reset();
					teacherDashBoardFrame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Oops, unable to register student!");
				}

				System.out.println(userName);
			}

		});
		teacherDashBoardFrame.getContentPane().add(btnSave);
		
		JButton buttonBack = new JButton("Cancel");
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				teacherDashBoardFrame.dispose();
				TeacherWelcomeBoard wb = new TeacherWelcomeBoard();
				wb.main(null);
			}
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, buttonBack);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 39, SpringLayout.EAST, buttonBack);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonBack, -39, SpringLayout.SOUTH, teacherDashBoardFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonBack, -331, SpringLayout.EAST, teacherDashBoardFrame.getContentPane());
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setBackground(new Color(139, 0, 0));
		teacherDashBoardFrame.getContentPane().add(buttonBack);

	}
}
