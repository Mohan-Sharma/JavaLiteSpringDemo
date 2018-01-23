package org.msharma.domain.services.impl;

import org.msharma.domain.model.Student;
import org.msharma.domain.services.StudentService;
import org.msharma.persistence.dao.StudentDao;
import org.msharma.presentation.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Mohan Sharma Created on 22/01/18.
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService
{
	@Resource
	private StudentDao studentDao;

	@Override
	public StudentDTO findStudentByRollNumber(int rollNumber)
	{
		Student student = studentDao.findStudentByRollNumber(rollNumber);
		return null;
	}

	@Override
	public List<StudentDTO> findStudentByFirstName(String firstName)
	{
		List<Student> students = studentDao.findStudentByFirstName(firstName);
		return null;
	}

	@Override
	public List<StudentDTO> findAllStudents()
	{
		List<Student> students = studentDao.findAllStudents();
		return null;
	}

	@Override
	public void save(Student student)
	{
		studentDao.save(student);
	}

	@Override
	public void saveAll(Collection<Student> students)
	{
		studentDao.saveAll(students);
	}

	@Override
	public Long count()
	{
		return studentDao.count();
	}

	@Override
	public Long countByFirstName(String firstName)
	{
		return studentDao.countByFirstName(firstName);
	}
}
