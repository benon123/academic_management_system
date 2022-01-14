/**
 * This class defines the properties of the Student
 */
package kis.student.gui;

public class Student {
	private String firstName;
	private String lastName;
	private String userName;
	private String registrationNumber;
	private String gender;
	private String studentClass;
	private String subject;
	private int age;
	
	public Student(String firstName, String lastName, String userName, String registrationNumber, String gender, String studentClass, 
			String subject, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.registrationNumber = registrationNumber;
		this.gender = gender;
		this.studentClass = studentClass;
		this.subject = subject;
		this.age = age;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}


	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the studentClass
	 */
	public String getStudentClass() {
		return studentClass;
	}


	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
