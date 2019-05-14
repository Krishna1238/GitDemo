<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty listempDto}">
		<table border="1" bgcolor="red">
			<tr bgcolor="blue">
				<th>empno</th>
				<th>empname</th>
				<th>empdesig</th>
				<th>empaddress</th>
				<th>empsal</th>
				<th>del</th>
				<th>update</th>
			</tr>
			<c:forEach var="empdto" items="${listempDto}">

				<tr bgcolor="cyan">
					<td><c:out value="${empdto.empNo }" /></td>
					<td><c:out value="${empdto.empName }" /></td>
					<td><c:out value="${empdto.empDesig }" /></td>
					<td><c:out value="${empdto.empAddress }" /></td>
					<td><c:out value="${empdto.empSal}" /></td>
					<td><a href="delete.htm?empNo=${empdto.empNo }">Delete</a>
					<td><a href="update.htm?empNo=${empdto.empNo }">Update</a>
				</tr>
			</c:forEach>


		</table>
	</c:when>
</c:choose><br></br>
<a href="insert.htm">Insert New Data</a><br></br>

<br></br>
   ${delete_result}
   ${update_data}
   ${data_inserted}



