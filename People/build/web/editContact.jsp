<%-- 
    Document   : editContact
    Created on : Dec 3, 2018, 10:59:17 AM
    Author     : macbookair
--%>

<%@page import="lt.bit.data.Person"%>
<%@page import="lt.bit.data.Contact"%>
<%@page import="lt.bit.db.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts</title>
    </head>
    <body>
        <h1>Edit Contact</h1>
    <%
            String idString = request.getParameter("id");
            Integer id = null;
            try {
                id = new Integer(idString);
            } catch (Exception ex) {
            }

            Contact c = DB.getContactById(id);
            Person p = DB.getByContact(c);
            Integer personId = null;
            if (c == null) {
                String contactIdString = request.getParameter("personId");
                try {
                    personId = new Integer(contactIdString);
                } catch (Exception ex) {
                }
                p = DB.getById(personId);
            }
            if (p == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>

        <form action="editContact" method="POST">
            <input type="hidden" name="id" value="<%=(c != null) ? c.getId() : ""%>" />
            <input type="hidden" name="personId" value="<%=p.getId()%>" />
            
            Contact type:  <input type="text" name="type" value="<%=(c != null) ? c.getType(): ""%>" /><br/>
            Contact: <input type="text" name="contact" value="<%=(c != null) ? c.getContact(): ""%>" /><br/>

            <input type="submit" value="Save" />
            <input type="reset" value="Reset" /><br/>

            <a href="indexContact.jsp?personId=<%=p.getId()%>" style="color:black" >Cancel</a><br/>
        </form>
    </body>
</html>
