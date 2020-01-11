<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert_registeredproductDB.jsp" method="post">
            <table border="0" cellspacing="2" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Register a Product</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label>User Name</label></td>
                        <td><input type="text" name="uname"/></td>
                    </tr>
                    <tr>
                        <td><label>Product Name</label></td>
                        <td><input type="text" name="pname"/></td>
                    </tr>
                    <tr>
                        <td><label>Serial Number</label></td>
                        <td><input type="text" name="sno"/></td>
                    </tr>
                    <tr>
                        <td><label>Purchase Date</label></td>
                        <td><input type="text" name="purdate"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
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