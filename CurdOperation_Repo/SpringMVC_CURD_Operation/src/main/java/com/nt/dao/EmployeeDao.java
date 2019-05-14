package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;
import com.nt.dto.EmployeeDto;

public interface EmployeeDao {
	
	public List<EmployeeBo> getAllEmpDetails();
	default int  deleteEmp(int empNo) {
		return 0;
	}
	public EmployeeBo geEmpByNo(int empNo) ;
	public int updateEmpData(EmployeeBo bo);
	public int insertNewData(EmployeeBo bo);
	
}
