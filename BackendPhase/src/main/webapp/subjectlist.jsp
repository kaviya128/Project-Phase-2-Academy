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
            <a href="/BackendPhase/snew">Add New Subject</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/BackendPhase/slist">List All Subject</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>SubjectID</th>
                <th>SubjectName</th>
                <th>ClassName</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="subject" items="${listSubject}">
                <tr>
                    <td><c:out value="${subject.subjectId}" /></td>
                    <td><c:out value="${subject.subjectName}" /></td>
                    <td><c:out value="${subject.className}" /></td>
                    <td>
                        <a href="/BackendPhase/sedit?teacherId=<c:out value='${subject.subjectId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/BackendPhase/sdelete?teacherId=<c:out value='${subject.subjectId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
    <%@ include file = "footer.jsp" %>   
</body>
</html>
