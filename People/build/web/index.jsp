<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.data.Person"%>
<%@page import="lt.bit.db.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of persons</title>
    </head>
    <body>
        <table>
          <%  
                for (Person p : DB.getAll()) {
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
            
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getFirstName()%></td>
                <td><%=p.getLastName()%></td>
                <td><%=bds%></td>
                <td><%=sal%></td>
                
                <td><a href="edit.jsp?id=<%=p.getId()%>" style="color:green">Edit</a></td>
                <td><a href="delete?id=<%=p.getId()%>" style="color:red">Delete</a></td>
                <td><a href="indexAddress.jsp?personId=<%=p.getId()%>" style="color:rosybrown">Addresses</a></td>
                <td><a href="indexContact.jsp?personId=<%=p.getId()%>" style="color:violet">Contacts</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="edit.jsp" style="color:palevioletred">Create new</a>
    </body>
</html>
