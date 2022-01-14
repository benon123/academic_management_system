package kis.student.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeTable extends JFrame{

	private JFrame frmStudentTimetable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable window = new TimeTable();
					window.frmStudentTimetable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentTimetable = new JFrame();
		frmStudentTimetable.setTitle("Student TimeTable");
		frmStudentTimetable.setBounds(100, 100, 450, 300);
		frmStudentTimetable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentTimetable.getContentPane().setLayout(null);
		
		JLabel lblTimetable = new JLabel("TimeTable");
		lblTimetable.setBounds(172, 31, 99, 15);
		frmStudentTimetable.getContentPane().add(lblTimetable);
	}

}
