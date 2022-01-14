/**
 * Database Handler for persisting a student record into the database
 */
package kis.databaseservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import kis.interfaces.GenericInterface;
import kis.student.gui.Student;
import kis.teacher.gui.Score;

public class StudentRegistrationHandler implements GenericInterface{

	KatikamuDbConnection dbConnection = new KatikamuDbConnection();
	public boolean registerStudent(Student student) {
		try {
			 Connection connection = dbConnection.getDbConnection();
			   String query = "insert into students (first_name, last_name,fullname, username,password, registration_number, gender,class,subject, age, date_of_registration)  values (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
			        
			   long millis = System.currentTimeMillis();
			   
			   Date registrationDate = new Date(millis);
			   
			   String lname = student.getLastName();
			   String fname = student.getFirstName();
			   
			   String fullName = lname.concat(" ").concat(fname);
			   
			   String password = "kt@21";
			   String studentPassword = password.concat(student.getUserName());
			   
			        PreparedStatement preparedStmt = connection.prepareStatement(query);
				      preparedStmt.setString(1, student.getFirstName());
				      preparedStmt.setString(2, student.getLastName());
				      preparedStmt.setString(3, fullName);
				      preparedStmt.setString(4, student.getUserName());
				      preparedStmt.setString(5, studentPassword);
				      preparedStmt.setString(6,  student.getRegistrationNumber());
				      preparedStmt.setString(7, student.getGender());
				      preparedStmt.setString(8, student.getStudentClass());
				      preparedStmt.setString(9, student.getSubject());
				      preparedStmt.setInt(10, student.getAge());
				      preparedStmt.setDate(11, registrationDate); 
				      preparedStmt.execute();
					  connection.close();
					  
			        return true;
		}catch(SQLException e)
		{
			System.out.println("Got exception while registering "+e.getMessage());
			return false;
		}
	}
	@Override
	public boolean recordStudentMarks(Score score) {
		// TODO Auto-generated method stub
		return false;
	}

}
