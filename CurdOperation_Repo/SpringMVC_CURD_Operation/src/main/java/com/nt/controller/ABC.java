
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

public class UpdateEmpController extends SimpleFormController{
	private EmployeeService empservice;
private EmployeeService empservice2;
	
	
	public UpdateEmpController(EmployeeService empservice) {
		this.empservice = empservice;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		   Command cmd=new Command();
		   int empid=0;
		   EmployeeDto empdto=null;
		   System.out.println("formBacking called");
		   //geting empno from jsp..
		   empid=Integer.parseInt(request.getParameter("empNo"));
		     empdto=empservice.getEmpDetailsByNo(empid);
    		  BeanUtils.copyProperties(empdto, cmd);
		      
		return cmd;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		  Command cmd=null;
		  EmployeeDto dto=null;
		  List<EmployeeDto> listdto=null;
		  String resultMsg=null;
		  ModelAndView mav=null;
		  //type caste command Object data to Command class object..
		  cmd=(Command)command;
		 
		  dto=new EmployeeDto();
		  //copy command class data to dto 
		  BeanUtils.copyProperties(cmd, dto);
		  System.out.println("onSubmit called");
		  //call servie to update new employee data..
		  resultMsg=empservice.updateEmpDetails(dto);
		    //call service to get all updated record...
		    listdto=empservice.fetchAllEmpDetails();
		    //create and return mav object
		    mav=new ModelAndView();
		    mav.addObject("listempDto",listdto);
		    mav.addObject("update_data",resultMsg);
		    mav.setViewName("emplist");
		    
		
		return mav;
	}

  public void Add(int a,int b){
      System.out.println("Addition"+a+b);
    System.out.println("This is addition method");

}


public void mul(int a,int b){
      System.out.println("Multiplication"+a8b);
    
System.out.println("This is multiplication method1");
System.out.println("This is multiplication method2");
}




}