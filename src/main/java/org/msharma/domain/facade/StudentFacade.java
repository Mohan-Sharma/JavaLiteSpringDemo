package org.msharma.domain.facade;

import org.msharma.presentation.dto.StudentDTO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * This interface abstracts the user from the complex business services implementations
 * @author Mohan Sharma Created on 22/01/18.
 */
public interface StudentFacade
{
	/**
	 * This function is used to find a student whose roll_number matches the given roll number.
	 * @param rollNumber
	 * @return student satisfying the criteria
	 */
	StudentDTO findStudentByRollNumber(int rollNumber);

	/**
	 * This function is used to find all the students which first_name matches the given firstName.
	 * @param firstName
	 * @return list of student satisfying the criteria
	 */
	List<StudentDTO> findStudentByFirstName(String firstName);

	/**
	 * This function is used to find all the students.
	 * @return list of students
	 */
	List<StudentDTO> findAllStudents() throws SQLException, ClassNotFoundException;

	/**
	 * This function is used to save the Student.
	 * @param student
	 */
	void save(StudentDTO student);

	/**
	 * This function is used to save all the given students
	 * @param students
	 */
	void saveAll(Collection<StudentDTO> students);

	/**
	 * This function returns the count of all the students available.
	 * @return number of students in db.
	 */
	Long count();

	/**
	 * This function returns the count of all the student whose first name matches the given firstName
	 * @param firstName
	 * @return number of students satisfying the criteria in db.
	 */
	Long countByFirstName(String firstName);
}
