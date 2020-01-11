<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>Product List</title>
        <style>
           table{
           text-align:center;
           border:1px solid black;
           }
        </style>
    </head>
    <body>     
        <h1>Product List (<a href="Register_Product.jsp">Add new</a>)</h1>
        <sql:setDataSource var="dbCon" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="12345"></sql:setDataSource>
        
        <sql:query dataSource="${dbCon}" var="result">
            SELECT * from product_registration where username=?;
        <sql:param value="${param.LoggedUser}" />
        </sql:query>
        
        <table>    
        <c:forEach var="row" items="${result.rows}">
        <tr> <th>Product name</th> <th> Serial Number </th> <th> Purchase Date </th> </tr>  
        <tr><td><c:out value="${row.ProductName}" /></td><td><c:out value="${row.serialNo}" /></td><td><c:out value="${row.purchaseDate}" /></td><td> <a href="Claims.jsp?serialNo=${row.serialNo}">Add Claim</a></td></tr>
        <sql:query dataSource="${dbCon}" var="result2">
            SELECT * from product_claim where serialNo=?;
        <sql:param value="${row.serialNo}" />
        </sql:query>       
       <tr> <th>Claim date</th> <th> Description </th> <th> Approval Status </th> </tr>      
        <c:forEach var="row2" items="${result2.rows}">
         <tr><td><c:out value="${row2.date_claim}" /></td><td><c:out value="${row2.issue}" /></td> <td><c:out value="${row2.status}" /></td></tr>
        </c:forEach>
        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
        </c:forEach>        
        </table>
 
 
    </body>
</html>