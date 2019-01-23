<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person edit</title>
    </head>
    <body>
        <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }
            Person p = DB.getById(id);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bds = "";
            if(p !=null && p.getBirthDate() != null){
            bds = sdf.format(p.getBirthDate());
            }
            
            String sal = "";
            if(p !=null && p.getSalary() !=null){
            sal = p.getSalary().toString();
            }
            
            
        %>
        
        <form action="edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : "" %>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : "" %>" /><br/>
            Last name:  <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : "" %>" /><br/>
            Birth Date (yyyy-MM-dd): <input type="date" name="birthDate" value="<%=(p !=null) ? bds : "" %>" /><br/>
            Salary:     <input type="number" name="salary" value="<%=(p !=null) ? sal : "" %>" /><br/>
            
            <input type="submit" value="Save" /><br/>
            <a href="index.jsp" style="color:black" >Cancel</a><br/>
        </form>
    </body>
</html>
