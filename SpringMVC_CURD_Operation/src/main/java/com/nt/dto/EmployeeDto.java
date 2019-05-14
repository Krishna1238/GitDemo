package com.nt.dto;

public class EmployeeDto {
	private int empNo;
	private String empName;
	private String empDesig;
	private String empAddress;
	private int empSal;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empNo=" + empNo + ", empName=" + empName + ", empDesig=" + empDesig + ", empAddress="
				+ empAddress + ", empSal=" + empSal + "]";
	}
	

}
