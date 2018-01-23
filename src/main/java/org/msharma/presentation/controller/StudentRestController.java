package org.msharma.presentation.controller;

import org.msharma.domain.facade.StudentFacade;
import org.msharma.presentation.dto.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
