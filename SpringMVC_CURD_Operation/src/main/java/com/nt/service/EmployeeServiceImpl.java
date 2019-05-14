package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDto;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeDao dao;
	public EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDto> fetchAllEmpDetails() {
		
		List<EmployeeBo>  listbo=null;
		     //call dao method
		      listbo=dao.getAllEmpDetails();
		      List<EmployeeDto> listdto=new ArrayList();
		   listbo.forEach(bo->{
			   EmployeeDto dto=new EmployeeDto();
			   //copy bo to dto..
			   BeanUtils.copyProperties(bo, dto);
			   //add data to listdto
			    listdto.add(dto);
		   });
		
		return listdto;
	}
	
	@Override
	public String deleteEmpData(int empNo) {
		int result=dao.deleteEmp(empNo);
		if(result==0) {
			return "Data Not Found";
		}else
		 
		return "Data Deleted";
	}

	@Override
	public EmployeeDto getEmpDetailsByNo(int empNo) {
		EmployeeDto dto=null;
		  dto=new EmployeeDto();
		EmployeeBo bo=dao.geEmpByNo(empNo);
                BeanUtils.copyProperties(bo, dto);   		
		
		return dto;
	}



	@Override
	public String updateEmpDetails(EmployeeDto dto) {
		EmployeeBo bo=null;
		int count=0;
		bo=new EmployeeBo();
		//copy dto to bo
		BeanUtils.copyProperties(dto, bo);
		System.out.println("BO Data"+bo);
		//call dao..
		count=dao.updateEmpData(bo);
		if(count==0) {
			return "Data Not Found";
			
		}else
		 
		return "Employee Data Updated";
	}

	@Override
	public String insertData(EmployeeDto dto) {
		EmployeeBo bo=null;
		bo=new EmployeeBo();
		BeanUtils.copyProperties(dto, bo);
		   System.out.println("Service called....");
		int insert_values=dao.insertNewData(bo);
		System.out.println("hi called....");
		   if(insert_values==0) {
			   
			   return "Data not updated";
		   }else 
		
		return "Data Inserted successfully...";
	}
	
	

}
