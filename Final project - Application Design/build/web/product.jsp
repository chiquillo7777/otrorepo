<%-- 
    Document   : product
    Created on : Feb 14, 2020, 10:41:29 AM
    Author     : carlos.chiquillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>add products</h1>
        
        <div class="dark">
            <form method="post" action="ProductController">
            <h3>Login</h3>
            Name: <input type="text" name="name" placeholder="Enter name"/><br/><br/>
            Description: <input type="text" name="description" placeholder="Enter description"/><br/><br/>
            Category <input type="text" name="category" placeholder="Enter description"/><br/><br/>
            Price: <input type="text" name="price" placeholder="Enter price"/><br/><br/>
            <input type="submit" name="operation" value="Add"/>
            <input type="submit" name="operation" value="Summary"/>
            </form>
        </div>
    </body>
</html>
