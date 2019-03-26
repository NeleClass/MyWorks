

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.springdata.db.Addresses"%>
<%@page import="lt.bit.springdata.db.Persons"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Addresses</title>
    </head>
    <body>
        <h2>List of Addresses:</h2>

        <table>

            <%
                Persons p = (Persons) request.getAttribute("persons");
                List<Addresses> al = (List<Addresses>) request.getAttribute("address");
                for (Addresses a : al) {
            %>

            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getAddresses()%></td>
                <td><%= a.getCity()%></td>
                <td><%= a.getPostalCode()%></td>
                <td><a style="text-decoration:none" href="address/editAddress?id=<%=a.getId()%>" style="color:palevioletred">Edit Address</a></td>
                <td><a style="text-decoration:none" href="address/deleteAddress?id=<%=a.getId()%>" style="color:violet">Delete Address</a></td>
            </tr>
            <% }%>
        </table>
        <button><a style="text-decoration:none" style="text-decoration:none" href="persons" style="color:violet">Back</a></button>

      <%--  <button><a style="text-decoration:none" href="address/editAddress?id=<%=p.getId()%>" style="color:palevioletred">Create new Address</a></button>   --%>
    </body>
</html>
