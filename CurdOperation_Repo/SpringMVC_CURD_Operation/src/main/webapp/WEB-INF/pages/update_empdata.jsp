<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <h1 style="color: red; text-align=center">Update Employee Data</h1>
    <body bgcolor="cyan">
    
    <form:form commandName="cmd">
      EmployeeNO: <form:input path="empNo" disabled="true"/><br>
      EmployeeName<form:input path="empName"/><br>
      EmployeeDesig<form:input path="empDesig"/><br>
      EmployeeAddress<form:input path="empAddress"/><br>
      EmployeeSalary<form:input path="empSal"/><br>
      <input type="submit" value="Modify"><br>
    
    </form:form>
    
   
    </body>