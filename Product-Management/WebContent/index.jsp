<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CheckLogin.jsp" method="post">
            <table border="0" cellspacing="2" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label>User Name</label></td>
                        <td><input type="text" name="uname"/></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="text" name="pword"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Log In" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="create_account.jsp">New User? Create an account</a>
        <font color="red"><c:if test="${not empty param.errMsg}">
            <c:out value="${param.errMsg}" />
            <a href="index.jsp">Go Back</a>
        </c:if></font>
        <font color="green"><c:if test="${not empty param.susMsg}">
            <c:out value="${param.susMsg}" />
            <a href="index.jsp">Go Back</a>
        </c:if></font>
    </body>
</html>