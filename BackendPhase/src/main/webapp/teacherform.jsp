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
        <c:if test="${teacher != null}">
            <form action="tupdate" method="post">
        </c:if>
        <c:if test="${teacher == null}">
            <form action="tinsert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${teacher != null}">
                        Edit Teacher
                    </c:if>
                    <c:if test="${teacher == null}">
                        Add New Teacher
                    </c:if>
                </h2>
            </caption>
                <c:if test="${teacher != null}">
                    <input type="hidden" name="teacherId" value="<c:out value='${teacher.teacherId}' />" />
                </c:if>           
            <tr>
                <th>teacherName: </th>
                <td>
                    <input type="text" name="teacherName" size="45"
                            value="<c:out value='${teacher.teacherName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>subjectName: </th>
                <td>
                    <input type="text" name="subjectName" size="45"
                            value="<c:out value='${teacher.subjectName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>className: </th>
                <td>
                    <input type="text" name="className" size="5"
                            value="<c:out value='${teacher.className}' />"
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