<%-- 
    Document   : editAddress
    Created on : Dec 14, 2018, 4:43:20 PM
    Author     : Nele
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.mavencrud.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="lt.bit.mavencrud.Person"%>
<%@page import="lt.bit.mavencrud.Address"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addresses</title>
    </head>
    <body>
        <h1>Edit address:</h1>
        
        <%           
                   
            Person p = (Person) request.getAttribute("persons");
            Address a = (Address)request.getAttribute("address");  
        %>

        <form action="/mavenCrud/address/editAddress" method="POST">
            <input type="hidden" name="id" value="<%=(a != null) ? a.getId() : ""%>" />
            <input type="hidden" name="personId" value="<%=(p != null) ? p.getId() : ""%>" />
            Address: <input type="text" name="address" value="<%=(a != null) ? a.getAddress() : ""%>" /><br/>
            City:  <input type="text" name="city" value="<%=(a != null) ? a.getCity() : ""%>" /><br/>
            ZIP/ Postal Code: <input type="text" name="postalCode" value="<%=(a != null) ? a.getPostalCode() : ""%>" /><br/>

            <input type="submit" value="Save" />
            <input type="reset" value="Reset" />
            

            <button><a style="text-decoration:none" href="/mavenCrud/address?id=<%=p.getId()%>" style="color:black" >Cancel</a></button><br/> 
        </form>
  
    </body>
</html>
