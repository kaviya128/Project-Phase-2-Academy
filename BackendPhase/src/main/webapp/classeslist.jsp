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
            <a href="/BackendPhase/clnew">Add New Classes</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/BackendPhase/cllist">List All Classes</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Classes</h2></caption>
            <tr>
                <th>ClassID</th>
                <th>ClassName</th>
                <th>ClassSection</th>
                <th>Actions</th>
                <th>Report</th>
            </tr>
            <c:forEach var="classes" items="${listClasses}">
                <tr>
                    <td><c:out value="${classes.classId}" /></td>
                    <td><c:out value="${classes.className}" /></td>
                     <td><c:out value="${classes.classSection}" /></td>
                    <td>
                        <a href="/BackendPhase/cledit?classId=<c:out value='${classes.classId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/BackendPhase/cldelete?classId=<c:out value='${classes.classId}' />">Delete</a>                     
                    </td>
                    <td>
                    <a href= "/BackendPhase/ReportServlet?className=<c:out value='${classes.className}' />" >SReport</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href= "/BackendPhase/RepoServlet?className=<c:out value='${classes.className}' />" >TReport</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <%@ include file = "footer.jsp" %>    
</body>
</html>
