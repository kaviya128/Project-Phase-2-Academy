<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Academy Application</title>
</head>
<body>
    <center>
        <h1>Academy Management</h1>
        <h2>
            <a href="/BackendPhase/new">Add New Student</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/BackendPhase/list">List All Student</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>StudentID</th>
                <th>StudentName</th>
                <th>RollNo</th>
                <th>ClassName</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.studentId}" /></td>
                    <td><c:out value="${student.studentName}" /></td>
                    <td><c:out value="${student.rollNo}" /></td>
                    <td><c:out value="${student.className}" /></td>
                    <td>
                        <a href="/BackendPhase/edit?studentId=<c:out value='${student.studentId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/BackendPhase/delete?studentId=<c:out value='${student.studentId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <%@ include file = "footer.jsp" %>  
</body>
</html>
