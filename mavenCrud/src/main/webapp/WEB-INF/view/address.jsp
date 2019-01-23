<%-- 
    Document   : address
    Created on : Dec 14, 2018, 5:01:24 PM
    Author     : Nele
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="lt.bit.mavencrud.Address"%>
<%@page import="lt.bit.mavencrud.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="lt.bit.mavencrud.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Addresses</title>
    <%--    <link rel="stylesheet" type="text/css" href="/css/style.css" /> --%>
    </head>
    <body>
        <h2>List of Addresses:</h2>

        <table>

            <%
                Person p = (Person) request.getAttribute("persons");
                List<Address> al = (List<Address>) request.getAttribute("address");
                for (Address a : al) {
            %>

            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getAddress()%></td>
                <td><%= a.getCity()%></td>
                <td><%= a.getPostalCode()%></td>
                <td><a style="text-decoration:none" href="address/editAddress?id=<%=a.getId()%>" style="color:palevioletred">Edit Address</a></td>
                <td><a style="text-decoration:none" href="address/deleteAddress?id=<%=a.getId()%>" style="color:violet">Delete Address</a></td>
            </tr>
            <% }%>
        </table>
        <button><a style="text-decoration:none" style="text-decoration:none" href="persons" style="color:violet">Back</a></button>

        <button><a style="text-decoration:none" href="address/editAddress?personId=<%=p.getId()%>" style="color:palevioletred">Create new Address</a></button>   
    </body>
</html>
