<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>JINSERT Operation</title>
    </head>
    <body>
    
        <c:if test="${ empty param.cdate or empty param.cdesc}">
            <c:redirect url="Claims.jsp" >
                <c:param name="errMsg" value="Please Enter Claim date and Description." />
            </c:redirect>
        </c:if>
        
        <sql:setDataSource var="dbCon" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="12345"></sql:setDataSource>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from product_claim where serialNo=?;
            <sql:param value="${param.serial}" />
        </sql:query>
        
        <c:choose>
        <c:when test="${result.rowCount > 3}">
            <c:redirect url="Claims.jsp" >
                <c:param name="errMsg" value="Can't submit more than 3 claims" />
            </c:redirect>
        </c:when>
       </c:choose>
        
        <sql:update dataSource="${dbCon}" var="result">
            INSERT INTO product_claim(date_claim, issue,serialNo) VALUES (?,?,?);
            <sql:param value="${param.cdate}" />
            <sql:param value="${param.cdesc}" />
            <sql:param value="${param.serial}" />
        </sql:update>
        
        <c:if test="${result>=1}">
            <font size="5" color='green'> Congratulations ! Data inserted
            successfully.</font>
 
            <c:redirect url="Claims.jsp" >
                <c:param name="susMsg" value="Congratulations ! Claim submitted" />
            </c:redirect>
        </c:if> 
 
    </body>
</html>