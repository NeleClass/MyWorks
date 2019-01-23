<%-- 
    Document   : indexContact
    Created on : Dec 3, 2018, 10:54:17 AM
    Author     : macbookair
--%>

<%@page import="lt.bit.data.Contact"%>
<%@page import="lt.bit.data.Address"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts</title>
    </head>
    <%
        String contactIdString = request.getParameter("personId");
        Integer personId = null;
        try {
            personId = new Integer(contactIdString);
        } catch (Exception ex) {
        }

        Person p = DB.getById(personId);
        if (p == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    %> 
    <body>
        <h1>Contacts of <%=p.getFirstName()%> <%=p.getLastName()%> </h1>
        <table>

            <%
                for (Contact c : p.getContacts()) {
            %>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getType() %></td>
                <td><%= c.getContact() %></td>
                <td><a href="editContact.jsp?id=<%=c.getId()%>" style="color:palevioletred">Edit Contact</a></td>
                <td><a href="deleteContact?id=<%=c.getId()%>" style="color:violet">Delete Contact</a></td>

            </tr>
            <%
                }
            %>

        </table>
        <a href="index.jsp" style="color:violet">Back</a>
        <a href="editContact.jsp?personId=<%=p.getId()%>" style="color:palevioletred">Create new Contact</a>
    </body>
</html>
