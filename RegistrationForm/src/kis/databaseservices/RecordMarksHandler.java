/**
 * Database Handler for persisting a student's mark into the database
 */
package kis.databaseservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import kis.interfaces.GenericInterface;
import kis.student.gui.Student;
import kis.teacher.gui.Score;

public class RecordMarksHandler implements GenericInterface{

	KatikamuDbConnection dbConnection = new KatikamuDbConnection();
	public boolean recordStudentMarks(Score score) {
		try {
			Connection connection = dbConnection.getDbConnection();
			   String query = "insert into student_marks (registration_number,subject, marks)  values (?,?, ?)";
			   PreparedStatement preparedStmt = connection.prepareStatement(query);
			      preparedStmt.setString(1, score.getRegistrationNumber());
			      preparedStmt.setString(2, score.getSubject());
			      preparedStmt.setInt(3, score.getSubjectScore());
			      
			      preparedStmt.execute();
				  connection.close();
			
			return true;
		}catch(SQLException sqlException) {
			System.out.println("Got exception while recording marks "+sqlException.getMessage());
			return false;
		}
	}

	@Override
	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
