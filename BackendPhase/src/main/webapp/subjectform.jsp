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
        <c:if test="${subject != null}">
            <form action="supdate" method="post">
        </c:if>
        <c:if test="${subject == null}">
            <form action="sinsert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${subject != null}">
                        Edit Subject
                    </c:if>
                    <c:if test="${subject == null}">
                        Add New Subject
                    </c:if>
                </h2>
            </caption>
                <c:if test="${subject != null}">
                    <input type="hidden" name="subjectId" value="<c:out value='${subject.subjectId}' />" />
                </c:if>           
           
            <tr>
                <th>subjectName: </th>
                <td>
                    <input type="text" name="subjectName" size="45"
                            value="<c:out value='${subject.subjectName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>className: </th>
                <td>
                    <input type="text" name="className" size="5"
                            value="<c:out value='${subject.className}' />"
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