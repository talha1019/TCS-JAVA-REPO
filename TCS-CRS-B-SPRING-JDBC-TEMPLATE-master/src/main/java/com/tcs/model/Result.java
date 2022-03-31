/**
 * 
 */
package com.tcs.model;

/**
 * @author springuser01
 *
 */
public class Result {
	private Integer id;
	private Integer studentId;
	private Integer courseId;
	private Integer professorId;
	private String courseGrade;
	private String timestamp;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the professorId
	 */
	public Integer getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the courseGrade
	 */
	public String getCourseGrade() {
		return courseGrade;
	}

	/**
	 * @param courseGrade the courseGrade to set
	 */
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", professorId="
				+ professorId + ",courseGrade=" + courseGrade + ",timestamp+ = " + timestamp + "]";
	}

}
