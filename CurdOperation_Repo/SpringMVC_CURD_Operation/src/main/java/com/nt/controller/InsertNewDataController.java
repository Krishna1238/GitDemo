package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.Command;
import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeService;

public class InsertNewDataController extends SimpleFormController {
	private EmployeeService empservice;

	public InsertNewDataController(EmployeeService empservice) {
		this.empservice = empservice;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int empNo = 0;
		String empName = null;
		String empDesig = null;
		String empAddress = null;
		double empSal = 0.0;
		Command insert_cmd = new Command();
		/*
		 * insert_cmd.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
		 * insert_cmd.setEmpName(request.getParameter("empName"));
		 * insert_cmd.setEmpDesig(request.getParameter("empDesig"));
		 * insert_cmd.setEmpAddress(request.getParameter("empAddress"));
		 * insert_cmd.setEmpSal(Integer.parseInt(request.getParameter("empSal")));
		 */
		return insert_cmd;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		EmployeeDto dto = null;
		Command insert_cmd = null;
		String msg = null;
		List<EmployeeDto> listempDto = null;
		ModelAndView mav = null;
		
		// type cast command object data into command clsass..
				insert_cmd = (Command) command;
		
		//B.Logic related to validations...
				if(insert_cmd.getEmpNo()<=0) {
					errors.rejectValue("empNo","empNo.invalid");
					return showForm(request, response, errors);
				}
				if(insert_cmd.getEmpName().equals("")|| insert_cmd.getEmpName()==null) {
					errors.rejectValue("empName","empName.required");
					return showForm(request, response, errors);
				}
				 if(insert_cmd.getEmpDesig().equals("") || insert_cmd.getEmpDesig()==null) {
					 errors.rejectValue("empDesig", "empDesig.required");
					 return showForm(request, response, errors);
				 }
				 if(insert_cmd.getEmpAddress().equals("") ||insert_cmd.getEmpAddress()==null) {
					 errors.rejectValue("empAddress", "empaddress.required");
					 return showForm(request, response, errors);
				 }else {
					 
					 if(insert_cmd.getEmpAddress().length()<3) {
						 errors.rejectValue("empAddress","empAddress.minlength");
						 return showForm(request, response, errors);
					 }
					 
				 }
				 if(insert_cmd.getEmpSal()<=0) {
					 errors.rejectValue("empSal","empSal.required");
				 return showForm(request, response, errors);
				 }
		
		dto = new EmployeeDto();
		//insert_cmd = new Command();
		
		// copy cmd data to dto..
		BeanUtils.copyProperties(insert_cmd, dto);
		
		// call service method to insert data
		msg = empservice.insertData(dto);
		System.out.println("Helloooo.....");
		// call service to get inserted data..
		listempDto = empservice.fetchAllEmpDetails();
		mav=new ModelAndView();
		mav.addObject("listempDto", listempDto);
		mav.addObject("data_inserted", msg);
		mav.setViewName("emplist");
		return mav;
	}

}
