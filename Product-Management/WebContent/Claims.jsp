<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Claims Page</title>
    </head>
    <body>
        <form action="InsertClaimDB.jsp?serial=${param.serialNo}" method="post">
            <table border="0" cellspacing="2" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Claims</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label>Claim Date</label></td>
                        <td><input type="text" name="cdate"/></td>
                    </tr>
                    <tr>
                        <td><label>Description of issue</label></td>
                        <td><input type="text" name="cdesc"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Claim" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <font color="red"><c:if test="${not empty param.errMsg}">
            <c:out value="${param.errMsg}" />
        </c:if></font>
        <font color="green"><c:if test="${not empty param.susMsg}">
            <c:out value="${param.susMsg}" />
        </c:if></font>
    </body>
</html>