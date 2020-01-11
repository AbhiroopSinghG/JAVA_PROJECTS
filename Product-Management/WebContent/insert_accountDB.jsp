<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>JINSERT Operation</title>
    </head>
    <body>
    
        <c:if test="${ empty param.uname or empty param.pword}">
            <c:redirect url="create_account.jsp" >
                <c:param name="errMsg" value="Please Enter Username and Password" />
            </c:redirect>
        </c:if>
        
        <sql:setDataSource var="dbCon" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="12345"></sql:setDataSource>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from users where username=?;
            <sql:param value="${param.uname}" />
        </sql:query>
        
        <c:forEach var="row" items="${result.rows}">
        <c:if test="${row.username!=null}">
            <c:redirect url="create_account.jsp" >
                <c:param name="errMsg" value="User Name already exists" />
            </c:redirect>
        </c:if>
        </c:forEach>
        
        <sql:update dataSource="${dbCon}" var="result">
            INSERT INTO users(username, password,cellphoneNo,email,address) VALUES (?,?,?,?,?);
            <sql:param value="${param.uname}" />
            <sql:param value="${param.pword}" />
            <sql:param value="${param.cphone}" />
            <sql:param value="${param.email}" />
            <sql:param value="${param.address}" />
        </sql:update>
        
        <c:if test="${result>=1}">
            <font size="5" color='green'> Congratulations ! Data inserted
            successfully.</font>
 
            <c:redirect url="create_account.jsp" >
                <c:param name="susMsg" value="Account created!" />
            </c:redirect>
        </c:if> 
 
    </body>
</html>