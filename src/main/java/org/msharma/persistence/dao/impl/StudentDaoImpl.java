package org.msharma.persistence.dao.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.msharma.domain.model.Student;
import org.msharma.persistence.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * This class implements {@link StudentDao} and provides the way to interact with the DB.
 * @author Mohan Sharma Created on 22/01/18.
 */
@Component(value = "studentDao")
public class StudentDaoImpl implements StudentDao
{
	@Value("${development.driver}")
	private String driver;
	@Value("${development.username}")
	private String username;
	@Value("${development.password}")
	private String password;
	@Value("${development.url}")
	private String url;


	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#findStudentByRollNumber(int)
	 */
	@Override
	public Student findStudentByRollNumber(int rollNumber)
	{
		openConnection();
		Student student = Student.findFirst("roll_number = ?", rollNumber);
		closeConnection();
		return student;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#findStudentByFirstName(java.lang.String)
	 */
	@Override
	public List<Student> findStudentByFirstName(String firstName)
	{
		openConnection();
		List<Student> students = Student.where("first_name = ?", firstName);
		closeConnection();
		return students;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#findAllStudents()
	 */
	@Override
	public List<Student> findAllStudents()
	{
		openConnection();
		List<Student> students = Student.findAll();
		closeConnection();
		return students;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#save(org.msharma.domain.model.Student)
	 */
	@Override
	public void save(Student student)
	{
		openConnection();
		student.saveIt();
		closeConnection();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#saveAll(java.util.Collection)
	 */
	@Override
	public void saveAll(Collection<Student> students)
	{
		openConnection();
		if(CollectionUtils.isNotEmpty(students))
			students.forEach(student -> student.saveIt());
		closeConnection();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#count()
	 */
	@Override
	public Long count()
	{
		openConnection();
		Long count = Student.count();
		closeConnection();
		return count;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.persistence.dao.StudentDao#countByFirstName(java.lang.String)
	 */
	@Override
	public Long countByFirstName(String firstName)
	{
		openConnection();
		Long count = Student.count("first_name = ?", firstName);
		closeConnection();
		return count;
	}

	/**
	 * This functions is used to close JavaLite ActiveJDBC connection
	 */
	private void closeConnection()
	{
		Base.close();
	}

	/**
	 * This functions is used to open JavaLite ActiveJDBC connection
	 */
	private void openConnection()
	{
		Base.open(driver, url, username, password);
	}
}
