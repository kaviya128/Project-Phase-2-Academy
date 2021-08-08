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
        <c:if test="${classes != null}">
            <form action="clupdate" method="post">
        </c:if>
        <c:if test="${classes == null}">
            <form action="clinsert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${classes != null}">
                        Edit classes
                    </c:if>
                    <c:if test="${classes == null}">
                        Add New classes
                    </c:if>
                </h2>
            </caption>
                <c:if test="${classes != null}">
                    <input type="hidden" name="classId" value="<c:out value='${classes.classId}' />" />
                </c:if>           
            <tr>
                <th>className: </th>
                <td>
                    <input type="text" name="className" size="45"
                            value="<c:out value='${classes.className}' />"
                        />
                </td>
            </tr>
            
            <tr>
                <th>classSection: </th>
                <td>
                    <input type="text" name="classSection" size="5"
                            value="<c:out value='${classes.classSection}' />"
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