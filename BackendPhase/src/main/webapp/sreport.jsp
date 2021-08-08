<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>class report</title>
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
    <form action="ReportServlet" method="post">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Class student Report</h2></caption>
            <tr>
                <th>studentID</th>
                <th>studentName</th>
                <th>rollNo</th>
                <th>className</th>
                
            </tr>
            <c:forEach var="report" items="${reportList}">
                <tr>
                    <td><c:out value="${report.studentId}" /></td>
                    <td><c:out value="${report.studentName}" /></td>
                     <td><c:out value="${report.rollNo}" /></td>
                      <td><c:out value="${report.className}" /></td>
                     
                       </tr>
            </c:forEach>
        </table>
    </div> 
    </form>
    <%@ include file = "footer.jsp" %>    
</body>
</html>
                     

