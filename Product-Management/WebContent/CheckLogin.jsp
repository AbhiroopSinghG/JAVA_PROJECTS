<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>JINSERT Operation</title>
    </head>
    <body>
    
        <c:if test="${ empty param.uname or empty param.pword}">
            <c:redirect url="index.jsp" >
                <c:param name="errMsg" value="Please Enter Username and Password" />
            </c:redirect>
        </c:if>
        
        <sql:setDataSource var="dbCon" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="12345"></sql:setDataSource>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from users where username=?;
            <sql:param value="${param.uname}" />
        </sql:query>
        
        <c:choose>
        <c:when test="${result.rowCount == 0}">
            <c:redirect url="index.jsp" >
                <c:param name="errMsg" value="User Name does not exist" />
            </c:redirect>
        </c:when>
       </c:choose>
        
        <c:forEach var="row" items="${result.rows}">
        <c:if test="${row.password!=param.pword}">
            <c:redirect url="index.jsp" >
                <c:param name="errMsg" value="Incorrect Password" />
            </c:redirect>
        </c:if>
        </c:forEach>
        
        <c:redirect url="ProductList.jsp" >
                <c:param name="LoggedUser" value="${param.uname}" />
        </c:redirect>        
 
    </body>
</html>