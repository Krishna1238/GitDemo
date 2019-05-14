package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;
import com.nt.dao.EmployeeDaoImpl;
import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeService;

public class DeleteEmpController extends AbstractController {
	EmployeeService empservice;

	public DeleteEmpController(EmployeeService empservice) {
		this.empservice = empservice;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int empNo=Integer.parseInt(request.getParameter("empNo"));
		
		List<EmployeeDto> listdto=null;
		String msg=null;
		//create MAV object..
		ModelAndView mav=new ModelAndView();
		      msg=empservice.deleteEmpData(empNo);
		       listdto=empservice.fetchAllEmpDetails(); 
		     //adding attribute and view data..
		     mav.addObject("delete_result",msg);
		     mav.addObject("listempDto",listdto);
		     mav.setViewName("emplist");
		  
		return mav;
	}

	

}
