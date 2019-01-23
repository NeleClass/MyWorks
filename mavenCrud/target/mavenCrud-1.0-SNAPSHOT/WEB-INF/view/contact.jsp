<%-- 
    Document   : contacts
    Created on : Jan 16, 2019, 10:38:50 AM
    Author     : macbookair
--%>

<%@page import="lt.bit.mavencrud.Person"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.mavencrud.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Contacts</title>
    </head>
    <body>
        <h2>List of Contacts:</h2>

        <table>

            <%
                Person p = (Person) request.getAttribute("persons");
                List<Contact> cl = (List<Contact>) request.getAttribute("contact");
                for (Contact c : cl) {
            %>

            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getType() %></td>
                <td><%= c.getContact() %></td>
                
                <td><a style="text-decoration:none" href="contact/editContact?id=<%=c.getId()%>" style="color:palevioletred">Edit Contact</a></td>
                <td><a style="text-decoration:none" href="contact/deleteContact?id=<%=c.getId()%>" style="color:violet">Delete Contact</a></td>

            </tr>
            <% }%>
        </table>
        <button> <a style="text-decoration:none" href="persons" style="color:violet">Back</a></button>
     
        <button><a style="text-decoration:none" href="contact/editContact?personId=<%=p.getId()%>" style="color:palevioletred">Create new Contact</a></button>   
    </body>
</html>
