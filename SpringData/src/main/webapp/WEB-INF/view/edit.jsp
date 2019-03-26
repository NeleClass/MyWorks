

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.springdata.db.Persons"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Person</title>
    </head>
    <body>
        <h2>Edit Person information:</h2>
        <%
        
            Persons p = (Persons) request.getAttribute("persons");
          
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = (p != null && p.getBirthDate() != null) ? birthDateString = sdf.format(p.getBirthDate()) : "";
            String salaryString = (p != null && p.getSalary() != null) ? p.getSalary().toString() : "";
        %>
        <form action="/SpringData/persons/edit" method="POST">
            <input type="hidden" name="id" value="<%=(p != null) ? p.getId() : ""%>" />
            First name: <input type="text" name="firstName" value="<%=(p != null) ? p.getFirstName() : ""%>" /><br/>
            Last name: <input type="text" name="lastName" value="<%=(p != null) ? p.getLastName() : ""%>" /><br/>
            Birth date: <input type="text" name="birthDate" value="<%=birthDateString%>" /><br/>
            Salary: <input type="text" name="salary" value="<%=salaryString%>" /><br/>
            Company: <input type="text" name="company" value="<%=(p != null) ? p.getCompany() : ""%>" /><br/>
            <input type="submit" value="Save" />
            <input type="reset" value="Reset" />
            <button><a href="/SpringData/persons">Cancel</a></button>
        </form>
              
           
    </body>
</html>
