<%-- 
    Document   : editAddress
    Created on : Nov 29, 2018, 12:45:22 PM
    Author     : macbookair
--%>

<%@page import="lt.bit.data.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addresses</title>
    </head>
    <body>
        <h1>Edit address</h1>
        <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }

            Address a = DB.getAddressById(id);
            Person p = DB.getByAddress(a);
            Integer personId = null;
            if (a == null) {
                String addressIdString = request.getParameter("personId");
                try {
                    personId = new Integer(addressIdString);
                } catch (Exception ex) {
                }
                p = DB.getById(personId);
            }
            if (p == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>

        <form action="editAddress" method="POST">
            <input type="hidden" name="id" value="<%=(a != null) ? a.getId() : ""%>" />
            <input type="hidden" name="personId" value="<%=p.getId()%>" />
            Address: <input type="text" name="address" value="<%=(a != null) ? a.getAddress() : ""%>" /><br/>
            City:  <input type="text" name="city" value="<%=(a != null) ? a.getCity() : ""%>" /><br/>
            ZIP/ Postal Code: <input type="text" name="postalCode" value="<%=(a != null) ? a.getPostalCode() : ""%>" /><br/>

            <input type="submit" value="Save" />
            <input type="reset" value="Reset" /><br/>

            <a href="indexAddress.jsp?personId=<%=p.getId()%>" style="color:black" >Cancel</a><br/>
        </form>
    </body>
</html>
