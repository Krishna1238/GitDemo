package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.EmployeeBo;

public class EmployeeDaoImpl implements EmployeeDao {
	
	//Sql query for geting all employee details...
	public static final String GET_ALL_EMP_DATA="SELECT empno,empname,empdesig,empaddress,empsal FROM EMPLOYEE";
    public static final String DELETE_EMPLOYEE="DELETE FROM EMPLOYEE WHERE empno=?";
    public static final String GET_EMP_BY_NO="SELECT empno,empname,empdesig,empaddress,empsal FROM EMPLOYEE WHERE empno=?";
	public static final String UPDATE_EMP_DATA="UPDATE EMPLOYEE SET empname=?,empdesig=?,empaddress=?,empsal=? WHERE empno=?";
    public static final String INSERT_NEW_DATA="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
    
	JdbcTemplate jt;
	
	public EmployeeDaoImpl(JdbcTemplate jt) {
		this.jt = jt;
		
	}

	@Override
	public List<EmployeeBo> getAllEmpDetails() {
		List<EmployeeBo> listbo=null;
		
		 listbo=jt.query(GET_ALL_EMP_DATA, rs->{
			List<EmployeeBo> listdata=null;
			listdata=new ArrayList<>();
			while(rs.next()) {
				EmployeeBo empbo=new EmployeeBo();
				      empbo.setEmpNo(rs.getInt(1));
				     empbo.setEmpName(rs.getString(2));
				     empbo.setEmpDesig(rs.getString(3));
				     empbo.setEmpAddress(rs.getString(4));
				     empbo.setEmpSal(rs.getInt(5));
				      listdata.add(empbo);
				  
			}//while close
			return listdata;
		});
		
		return listbo;
	}
	
	@Override
	public int deleteEmp(int empNo) {
		int result=jt.update(DELETE_EMPLOYEE,empNo);
		 
		return result;
	}
	@Override
	public EmployeeBo geEmpByNo(int empNo) {
		EmployeeBo bo=null;
		  bo=new EmployeeBo();
	       bo=jt.query(GET_EMP_BY_NO, rm->{
	    	   EmployeeBo empbo=new EmployeeBo();
	    	   while(rm.next()) {
	    		   empbo.setEmpNo(rm.getInt(1));
	    		   empbo.setEmpName(rm.getString(2));
	    		   empbo.setEmpDesig(rm.getString(3));
	    		   empbo.setEmpAddress(rm.getString(4));
	    		   empbo.setEmpSal(rm.getInt(5));
	    	   }//while close
	    	    return empbo;
	    	   
	       },empNo);
		return bo;
	}

	@Override
	public int updateEmpData(EmployeeBo bo) {
		int result=jt.update(UPDATE_EMP_DATA,bo.getEmpName(),bo.getEmpDesig(),bo.getEmpAddress(),bo.getEmpSal(), bo.getEmpNo());
		return result;
	}

	@Override
	public int insertNewData(EmployeeBo bo) {
		int insert_result=jt.update(INSERT_NEW_DATA,bo.getEmpNo(),bo.getEmpName(),bo.getEmpDesig(),bo.getEmpAddress(),bo.getEmpSal());
		return insert_result;
	}

}
