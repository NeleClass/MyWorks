<%-- 
    Document   : Forma
    Created on : Nov 26, 2018, 12:45:15 PM
    Author     : macbookair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HTML Forma</title>
    </head>
    <body>
        <h1>HTML Forma</h1>
        <form action="saveData" method="POST">
            <input type="text" name="firstName"/>
            <input type="text" name="lastName"/>
            <input type="submit" value="Save"/>
        </form>
        
    </body>
</html>
