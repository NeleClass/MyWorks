<%-- 
    Document   : editContact
    Created on : Jan 16, 2019, 10:41:23 AM
    Author     : macbookair
--%>

<%@page import="lt.bit.mavencrud.Person"%>
<%@page import="lt.bit.mavencrud.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts</title>
    </head>
    <body>
        <h1>Edit contact:</h1>
        
        <%          
            Person p = (Person) request.getAttribute("persons");
            Contact c = (Contact)request.getAttribute("contact");  
        %>

        <form action="/mavenCrud/contact/editContact" method="POST">
            <input type="hidden" name="id" value="<%=(c != null) ? c.getId() : ""%>" />
            <input type="hidden" name="personId" value="<%=(p != null) ? p.getId() : ""%>" />
            Type: <input type="text" name="type" value="<%=(c != null) ? c.getType() : ""%>" /><br/>
            Contact:  <input type="text" name="contact" value="<%=(c != null) ? c.getContact() : ""%>" /><br/>
           

            <input type="submit" value="Save" />
            <input type="reset" value="Reset" />
            
            <button><a style="text-decoration:none" href="/mavenCrud/contact?id=<%=p.getId()%>" style="color:black" >Cancel</a></button><br/> 
        </form>
       
    </body>
</html>
