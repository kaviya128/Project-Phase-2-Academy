<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>class treport</title>
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
    <form action= "RepoServlet" method="post">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Class teacher Report</h2></caption>
            <tr>
                <th>teacherID</th>
                <th>teacherName</th>
                <th>subjectName</th>
                <th>className</th>
                
            </tr>
            <c:forEach var="reports" items="${reportListt}">
                <tr>
                    <td><c:out value="${reports.teacherId}" /></td>
                    <td><c:out value="${reports.teacherName}" /></td>
                     <td><c:out value="${reports.subjectName}" /></td>
                      <td><c:out value="${reports.className}" /></td>
                     
                       </tr>
            </c:forEach>
        </table>
    </div> 
    </form>
    <%@ include file = "footer.jsp" %>    

</body>
</html>