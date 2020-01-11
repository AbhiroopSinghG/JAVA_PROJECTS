<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>JINSERT Operation</title>
    </head>
    <body>
    
        <c:if test="${ empty param.uname or empty param.pname}">
            <c:redirect url="create_account.jsp" >
                <c:param name="errMsg" value="Please Enter Username and Product Name" />
            </c:redirect>
        </c:if>
        
        <sql:setDataSource var="dbCon" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="12345"></sql:setDataSource>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from users where username=?;
            <sql:param value="${param.uname}" />
        </sql:query>
        
        <c:choose>
        <c:when test="${result.rowCount == 0}">
            <c:redirect url="Register_Product.jsp" >
                <c:param name="errMsg" value="User Name does not exist" />
            </c:redirect>
        </c:when>
       </c:choose>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from products where productName=?;
            <sql:param value="${param.pname}" />
        </sql:query>
        
        <c:choose>
        <c:when test="${result.rowCount == 0}">
            <c:redirect url="Register_Product.jsp" >
                <c:param name="errMsg" value="Product does not exist" />
            </c:redirect>
        </c:when>
       </c:choose>
        
        <sql:update dataSource="${dbCon}" var="result">
            INSERT INTO product_registration(username, productName,serialNo,purchaseDate) VALUES (?,?,?,?);
            <sql:param value="${param.uname}" />
            <sql:param value="${param.pname}" />
            <sql:param value="${param.sno}" />
            <sql:param value="${param.purdate}" />
        </sql:update>
        
        <c:if test="${result>=1}">
            <font size="5" color='green'> Congratulations ! Data inserted
            successfully.</font>
 
            <c:redirect url="Register_Product.jsp" >
                <c:param name="susMsg" value="Congratulations ! Product Registered" />
            </c:redirect>
        </c:if> 
 
    </body>
</html>