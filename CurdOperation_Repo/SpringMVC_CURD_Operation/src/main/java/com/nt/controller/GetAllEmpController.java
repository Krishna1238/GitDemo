package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeService;

public class GetAllEmpController extends AbstractController {
	
	private EmployeeService empservice;

	public GetAllEmpController(EmployeeService service) {
		this.empservice = service;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   List<EmployeeDto> listdto=null;
		   //call service
		   listdto=empservice.fetchAllEmpDetails();
		   System.out.println(listdto);
		   ModelAndView mav=new ModelAndView();
		                 //add attribute name..
		                mav.addObject("listempDto",listdto);
		                //set view name..
		                mav.setViewName("emplist");
		                
		return mav;
	}

}
