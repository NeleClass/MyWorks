<%-- 
    Document   : indexAddress
    Created on : Dec 2, 2018, 3:10:45 PM
    Author     : macbookair
--%>

<%@page import="lt.bit.data.Person"%>
<%@page import="lt.bit.data.Address"%>
<%@page import="lt.bit.db.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Addresses</title>
    </head> 
    <%
        String personIdString = request.getParameter("personId");
        Integer personId = null;
        try {
            personId = new Integer(personIdString);
        } catch (Exception ex) {
        }

        Person p = DB.getById(personId);
        if (p == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    %> 
    <body>
        <h1>Addresses of <%=p.getFirstName()%> <%=p.getLastName()%></h1>
        <table>

            <%
                for (Address a : p.getAddresses()) {
            %>
            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getAddress()%></td>
                <td><%= a.getCity()%></td>
                <td><%= a.getPostalCode()%></td>
                <td><a href="editAddress.jsp?id=<%=a.getId()%>" style="color:palevioletred">Edit Address</a></td>
                <td><a href="deleteAddress?id=<%=a.getId()%>" style="color:violet">Delete Address</a></td>

            </tr>
            <%
                }
            %>

        </table>
        <a href="index.jsp" style="color:violet">Back</a>
        <a href="editAddress.jsp?personId=<%=p.getId()%>" style="color:palevioletred">Create new Address</a>
    </body>
</html>
