/**
 * This interface contains method declarations to be used in implementing functionality
 * across the application
 */
package kis.interfaces;

import kis.student.gui.Student;
import kis.teacher.gui.Score;

public interface GenericInterface {
	
	public boolean registerStudent(Student student);
	public boolean recordStudentMarks(Score score);
	
}
