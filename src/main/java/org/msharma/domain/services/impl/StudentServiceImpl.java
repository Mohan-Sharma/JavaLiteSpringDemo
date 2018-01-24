package org.msharma.domain.services.impl;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.msharma.domain.model.Student;
import org.msharma.domain.services.StudentService;
import org.msharma.persistence.dao.StudentDao;
import org.msharma.presentation.dto.StudentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mohan Sharma Created on 22/01/18.
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService
{
	@Resource
	private StudentDao studentDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#findStudentByRollNumber(int)
	 */
	@Override
	public StudentDTO findStudentByRollNumber(int rollNumber)
	{
		Student student = studentDao.findStudentByRollNumber(rollNumber);
		StudentDTO studentDTO = new StudentDTO();
		BeanUtils.copyProperties(student, studentDTO);
		return studentDTO;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#findStudentByFirstName(java.lang.String)
	 */
	@Override
	public List<StudentDTO> findStudentByFirstName(String firstName)
	{
		List<StudentDTO> studentData = Lists.newArrayList();
		List<Student> students = studentDao.findStudentByFirstName(firstName);
		if(CollectionUtils.isNotEmpty(students))
		{
			studentData =
					students
							.stream()
							.map(student -> {
								StudentDTO studentDTO = new StudentDTO();
								BeanUtils.copyProperties(student, studentDTO);
								return studentDTO;
							})
					.collect(Collectors.toList());
		}
		return studentData;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#findAllStudents()
	 */
	@Override
	public List<StudentDTO> findAllStudents() throws SQLException, ClassNotFoundException
	{
		List<StudentDTO> studentData = Lists.newArrayList();
		List<Student> students = studentDao.findAllStudents();
		if(CollectionUtils.isNotEmpty(students))
		{
			studentData =
					students
							.stream()
							.map(student -> {
								StudentDTO studentDTO = new StudentDTO();
								BeanUtils.copyProperties(student, studentDTO);
								return studentDTO;
							})
							.collect(Collectors.toList());
		}
		return studentData;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#save(org.msharma.presentation.dto.StudentDTO)
	 */
	@Override
	public void save(StudentDTO studentDto)
	{
		Student student = Student.create(studentDto.getRollNumber(), studentDto.getFirstName(), studentDto.getLastName());
		studentDao.save(student);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#saveAll(java.util.Collection)
	 */
	@Override
	public void saveAll(Collection<StudentDTO> studentData)
	{
		if(CollectionUtils.isNotEmpty(studentData))
		{
			List<Student> students =
					studentData
							.stream()
							.map(studentDTO -> (Student) Student.create(studentDTO.getRollNumber(), studentDTO.getFirstName(), studentDTO.getLastName()))
							.collect(Collectors.toList());
			studentDao.saveAll(students);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#count()
	 */
	@Override
	public Long count()
	{
		return studentDao.count();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.services.StudentService#countByFirstName(java.lang.String)
	 */
	@Override
	public Long countByFirstName(String firstName)
	{
		return studentDao.countByFirstName(firstName);
	}
}
