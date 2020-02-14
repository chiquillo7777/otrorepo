<%-- 
    Document   : test
    Created on : Feb 14, 2020, 12:25:28 PM
    Author     : carlos.chiquillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Categories</title>
    </head>
    
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
        <body >
        <h1>Product Categories</h1>
        
        <div class="dark">
            <form method="get" action="ProductController">
            <h3>Product Categories</h3>
            
            <input type="submit" name="operation" value="category"/>
            </form>
        </div>
    </body>
</html>
