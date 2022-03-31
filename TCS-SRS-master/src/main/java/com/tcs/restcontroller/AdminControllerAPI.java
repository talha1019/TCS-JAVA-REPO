/**
 * 
 */
package com.tcs.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.dao.AdminstrationDAO;
import com.tcs.model.Courses;
import com.tcs.model.Professor;
import com.tcs.model.Student;

/**
 * @author springuser01
 *
 */
@RestController
public class AdminControllerAPI {
	@Autowired
	private AdminstrationDAO adminDAO;

	/**
	 * Get Student Report Card
	 * 
	 * @param id
	 * @throws No student found for ID
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/report/{id}")
	@ResponseBody
	public ResponseEntity getReport(@PathVariable Long id) {

		Student student = adminDAO.createReport(id);

		if (student == null) {
			return new ResponseEntity("No Report found for ID " + id, HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity(student, HttpStatus.NOT_FOUND);

	}

	/**
	 * Approved Student
	 * 
	 * @param id
	 * @throws No student found for ID
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT, value = "/put/student/{id}")
	@ResponseBody
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Student student) {

		student = adminDAO.update(id, student);

		if (null == student) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		} else if (student.getStudentApproval() == false) {
			return new ResponseEntity("Student Not Approved Successfully" + " " + student, HttpStatus.OK);

		} else
			return new ResponseEntity("Student Approved Successfully" + " " + student, HttpStatus.OK);
	}

	/**
	 * Post Professor data
	 * 
	 * @param Proffesor object
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/post/professor")
	@ResponseBody
	public ResponseEntity createProfessor(@RequestBody Professor professor) {

		adminDAO.addProfessor(professor);

		return new ResponseEntity(professor, HttpStatus.OK);
	}

	/**
	 * Post Course data
	 * 
	 * @param Course Object
	 * @throws No student found for ID
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/post/courses")
	@ResponseBody
	public ResponseEntity createCourses(@RequestBody Courses courses) {

		adminDAO.addCourses(courses);

		return new ResponseEntity(courses, HttpStatus.OK);
	}

	/**
	 * Delete course Data
	 * 
	 * @param id
	 * @throws No student found for ID
	 */
	// This method is using to delete the course
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/delete/course/{id}")
	@ResponseBody
	public ResponseEntity deleteCourse(@PathVariable Long id) {

		if (null == adminDAO.deleteCourse(id)) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity("Deleted Successfully" + " : " + id, HttpStatus.OK);

	}

}
