<%-- 
    Document   : listUsers
    Created on : 02-14-2020, 06:20:04 AM
    Author     : chiquillo
--%>

<%@page import="dsu.finalproject.models.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users </title>
    </head>
    <body>
        
        <div>
            <table>
                <%
                    List<User> listUsers = (List<User>)request.getAttribute("listUsers");
                    for(int i=0; i<listUsers.size(); i++){
                       out.print("<td>"+listUsers.get(i).getEmail() +"</td><br/>");
               
                    }
                %>
            </table>
        </div>
        
        
        <h1>List all users ${listUsers.get(0).getEmail()}</h1>
        
    </body>
</html>
