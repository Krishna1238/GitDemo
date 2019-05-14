package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface EmployeeService {
	public List<EmployeeDto> fetchAllEmpDetails();
	public String deleteEmpData(int empNo);
	public EmployeeDto getEmpDetailsByNo(int empNo);
	public String updateEmpDetails(EmployeeDto dto);
	public String insertData(EmployeeDto dto);

}
