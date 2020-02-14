<%-- 
    Document   : productByCategory
    Created on : Feb 14, 2020, 11:49:47 AM
    Author     : carlos.chiquillo
--%>

<%@page import="dsu.finalproject.models.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
            .dark{
                padding: 15px;
                background: #e6e6e6;
                margin-top: 10px;
                margin-bottom: 10px;
                float: left;
                width:50%;
            }
           
        </style>
    </head>
    <body>
        <h1>This is the List of products by category</h1>
        
        
        
        <div>
            <table class="dark">
                <%
                    List<String> listCategories = (List<String>)request.getAttribute("listcategories");
                    for(int i=0; i<listCategories.size(); i++){
                       out.print("<tr><td>"+listCategories.get(i) +"</td></tr>");
               
                    }
                %>
            </table>
        </div>
    </body>
</html>
