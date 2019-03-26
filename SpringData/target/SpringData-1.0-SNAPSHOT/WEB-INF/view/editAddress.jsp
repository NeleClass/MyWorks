

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="lt.bit.springdata.db.Persons"%>
<%@page import="lt.bit.springdata.db.Addresses"%>
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
//            String idString = request.getParameter("id");
//            String personIdString = request.getParameter("personId");
//            Integer id = null;
//            Integer personId = null;
          
//            try {
//                id = new Integer(idString);
//            } catch (Exception ex) {
//            }
//            
//            try {
//                personId = new Integer (personIdString);
//            } catch (Exception ex){
//            }
//            
//            Person p = null;
//            
//                try{
//                p = em.find(Person.class, personId);
//                } catch (Exception ex){
//                }
            Persons p = (Persons) request.getAttribute("persons");
            Addresses a = (Addresses)request.getAttribute("address");
            
//                try{
//                a = em.find(Address.class, id);
//                } catch (Exception ex){
//                }
//            
//                if (a==null){
//                    a=new Address();
//                }
//                if (p==null){
//                p=a.getPerson();
//                }
            
        %>

        <form action="/mavenCrud/address/editAddress" method="POST">
            <input type="hidden" name="id" value="<%=(a != null) ? a.getId() : ""%>" />
        <%--    <input type="hidden" name="personId" value="<%=p.getId()%>" /> --%>
            Address: <input type="text" name="address" value="<%=(a != null) ? a.getAddresses() : ""%>" /><br/>
            City:  <input type="text" name="city" value="<%=(a != null) ? a.getCity() : ""%>" /><br/>
            ZIP/ Postal Code: <input type="text" name="postalCode" value="<%=(a != null) ? a.getPostalCode() : ""%>" /><br/>

            <input type="submit" value="Save" />
            <input type="reset" value="Reset" />
            

        <%--    <a href="address?id=<%=p.getId()%>" style="color:black" >Cancel</a><br/> --%>
        </form>
       
    </body>
</html>
