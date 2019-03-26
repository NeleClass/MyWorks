
<%@page import="java.util.List"%>
<%@page import="lt.bit.springdata.db.Contacts"%>
<%@page import="lt.bit.springdata.db.Persons"%>
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
                Persons p = (Persons) request.getAttribute("persons");
                List<Contacts> cl = (List<Contacts>) request.getAttribute("contact");
                for (Contacts c : cl) {
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
        <button><a style="text-decoration:none" style="text-decoration:none" href="persons" style="color:violet">Back</a></button>

      <%--  <button><a style="text-decoration:none" href="contact/editContact?id=<%=p.getId()%>" style="color:palevioletred">Create new Contact</a></button>   --%>
    </body>
</html>
