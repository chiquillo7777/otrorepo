<%-- 
    Document   : login
    Created on : 02-14-2020, 07:40:48 AM
    Author     : chiquillo
--%>

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
        <h1>Login Page</h1>
        
        <div class="dark">
            <form method="post" action="UserController">
            <h3>Login</h3><br/>
            Email: <input type="email" name="email" placeholder="Enter email"/><br/><br/>
            Password: <input type="password" name="password" placeholder="Enter password"/><br/><br/>
            <input type="submit" name="operation" value="login"/>
            </form>
            <br/>
            <a href="register.html">Create account</a>
        </div>
        <br/>
        
    </body>
</html>
