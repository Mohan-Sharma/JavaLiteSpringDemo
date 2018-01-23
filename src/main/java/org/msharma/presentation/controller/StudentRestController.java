package org.msharma.presentation.controller;

import org.msharma.domain.facade.StudentFacade;
import org.msharma.presentation.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * This controller acts as the request handler for all student business service requests.
 * @author Mohan Sharma Created on 22/01/18.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentRestController
{
	@Resource
	private StudentFacade studentFacade;

	/**
	 * This is the base request handler which is invoked when the user hits "/student". This returns the
	 * basic student view.
	 * @param modelAndView
	 * @return the basic view.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getStudentHomePage(ModelAndView modelAndView)
	{
		modelAndView.setViewName("student");
		return modelAndView;
	}

	/**
	 * This handler returns all the students.
	 * @return list of students
	 */
	@RequestMapping(value = "/allstudents", method = RequestMethod.GET)
	public @ResponseBody List<StudentDTO> getAllStudent()
	{
		return studentFacade.findAllStudents();
	}

	/**
	 * This handler can be used to find a student by roll number
	 * @param rollNumber
	 * @return the fetched student
	 */
	@RequestMapping(value = "/findbyrollnumber", method = RequestMethod.GET)
	public @ResponseBody StudentDTO getStudentByRoll(@RequestParam int rollNumber)
	{
		return studentFacade.findStudentByRollNumber(rollNumber);
	}

	/**
	 * This handler can be used to find all the students having given name
	 * @param firstName
	 * @return list of students
	 */
	@RequestMapping(value = "/findallbyfirstname", method = RequestMethod.GET)
	public @ResponseBody List<StudentDTO> getAllStudentHavingName(@RequestParam String firstName)
	{
		return studentFacade.findStudentByFirstName(firstName);
	}

	/**
	 * This handler can be used to save the given student data.
	 * @param studentDTO
	 * @return the response of action
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody StudentDTO studentDTO)
	{
		studentFacade.save(studentDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * This handler can be used to save all the student data.
	 * @param students
	 * @return the response of action
	 */
	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity saveAll(@RequestBody List<StudentDTO> students)
	{
		studentFacade.saveAll(students);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * This handler can be used to get the count of all the students available
	 * @return list of students
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity count()
	{
		Long count = studentFacade.count();
		return new ResponseEntity(count, HttpStatus.OK);
	}

	/**
	 * This handler can be used to get the count of all the students having the given name.
	 * @return list of students
	 */
	@RequestMapping(value = "/countbyfirstname", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity countByFirstName(@RequestParam String firstName)
	{
		Long count = studentFacade.countByFirstName(firstName);
		return new ResponseEntity(count, HttpStatus.OK);
	}
}
