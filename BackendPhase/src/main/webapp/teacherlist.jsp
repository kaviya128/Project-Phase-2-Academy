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
            <a href="/BackendPhase/tnew">Add New Teacher</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/BackendPhase/tlist">List All Teacher</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>TeacherID</th>
                <th>TeacherName</th>
                <th>SubjectName</th>
                <th>ClassName</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="teacher" items="${listTeacher}">
                <tr>
                    <td><c:out value="${teacher.teacherId}" /></td>
                    <td><c:out value="${teacher.teacherName}" /></td>
                    <td><c:out value="${teacher.subjectName}" /></td>
                    <td><c:out value="${teacher.className}" /></td>
                    <td>
                        <a href="/BackendPhase/tedit?teacherId=<c:out value='${teacher.teacherId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/BackendPhase/tdelete?teacherId=<c:out value='${teacher.teacherId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
    <%@ include file = "footer.jsp" %>   
</body>
</html>
