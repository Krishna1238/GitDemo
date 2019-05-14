package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.Command;

public class EmpValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Command.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
	   //typecasting...
		Command cmd=(Command)command;
	     //form validations..
		if(cmd.getEmpNo()<=0)
			errors.rejectValue("empNo","empNo.invalid");
		if(cmd.getEmpName().equals("")|| cmd.getEmpName()==null)
			errors.rejectValue("empName","empName.required");
		 if(cmd.getEmpDesig().equals("") || cmd.getEmpDesig()==null)
			 errors.rejectValue("empDesig", "empDesig.required");
		 if(cmd.getEmpAddress().equals("") ||cmd.getEmpAddress()==null) {
			 errors.rejectValue("empAddress", "empAddress.required");
		 }else {
			 
			 if(cmd.getEmpAddress().length()<3) {
				 errors.rejectValue("empAddress","empAddress.minlength");
			 }
			 
		 }
		 if(cmd.getEmpSal()<=0)
			 errors.rejectValue("empSal","empSal.required");
		
	}

}
