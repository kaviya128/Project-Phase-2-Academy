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
        <c:if test="${student != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${student != null}">
                        Edit Student
                    </c:if>
                    <c:if test="${student == null}">
                        Add New Student
                    </c:if>
                </h2>
            </caption>
                <c:if test="${student != null}">
                    <input type="hidden" name="studentId" value="<c:out value='${student.studentId}' />" />
                </c:if>           
            <tr>
                <th>studentName: </th>
                <td>
                    <input type="text" name="studentName" size="45"
                            value="<c:out value='${student.studentName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>rollNo: </th>
                <td>
                    <input type="text" name="rollNo" size="45"
                            value="<c:out value='${student.rollNo}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>className: </th>
                <td>
                    <input type="text" name="className" size="5"
                            value="<c:out value='${student.className}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>