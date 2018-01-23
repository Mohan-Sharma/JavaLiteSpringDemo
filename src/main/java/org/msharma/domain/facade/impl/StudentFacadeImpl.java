package org.msharma.domain.facade.impl;

import org.msharma.domain.facade.StudentFacade;
import org.msharma.domain.services.StudentService;
import org.msharma.presentation.dto.StudentDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Mohan Sharma Created on 22/01/18.
 */
@Component(value = "studentFacade")
public class StudentFacadeImpl implements StudentFacade
{
	@Resource
	private StudentService studentService;

	@Override
	public StudentDTO findStudentByRollNumber(int rollNumber)
	{
		return null;
	}

	@Override
	public List<StudentDTO> findStudentByFirstName(String firstName)
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.facade.StudentFacade#findAllStudents()
	 */
	@Override
	public List<StudentDTO> findAllStudents()
	{
		return studentService.findAllStudents();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.facade.StudentFacade#save(org.msharma.presentation.dto.StudentDTO)
	 */
	@Override
	public void save(StudentDTO student)
	{

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.facade.StudentFacade#saveAll(java.util.Collection)
	 */
	@Override
	public void saveAll(Collection<StudentDTO> students)
	{

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.facade.StudentFacade#count()
	 */
	@Override
	public Long count()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.msharma.domain.facade.StudentFacade#countByFirstName(java.util.String)
	 */
	@Override
	public Long countByFirstName(String firstName)
	{
		return null;
	}
}
