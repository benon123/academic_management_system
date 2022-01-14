/**
 * Holds the properties required for recording a student's marks
 */
package kis.teacher.gui;

public class Score {
	private String registrationNumber, subject;
	private int subjectScore;
	
	public Score(String registrationNumber, String subject, int subjectScore) {
		this.registrationNumber = registrationNumber;
		this.subject = subject;
		this.subjectScore = subjectScore;
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
	 * @return the subjectScore
	 */
	public int getSubjectScore() {
		return subjectScore;
	}

	/**
	 * @param subjectScore the subjectScore to set
	 */
	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}

	
	
}
