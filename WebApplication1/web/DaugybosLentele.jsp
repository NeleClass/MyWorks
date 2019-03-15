<%-- 
    Document   : DaugybosLentele
    Created on : Nov 23, 2018, 4:42:08 PM
    Author     : macbookair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int a=10; int b=10; %>
        <style> 
            table, th, td { 
                border: 1px solid black; 
                text-align: center;
            }
            th {
                background-color: yellowgreen;
            }
            body {
                background-image: url("https://st.depositphotos.com/1000938/2762/i/950/depositphotos_27626053-stock-photo-cat-isolated.jpg");
                background-position-x: 55%;
            }
        </style>
        <h1>Daugybos lentele</h1>

        <table style="width:50%"> 
            <tr>
                <th> * </th>
                    <% for (int i = 1; i < a; i++) {%>
                <th><%=i%></th>
                    <% }%>
            </tr>   

            <% for (int i = 1; i < b; i++) {%>
            <tr>
                <th><%=i%></th>
                    <% for (int j = 1; j < a; j++) {%>
                <td> <%= (i * j)%> </td>

                <% } %>
            </tr>
            <% }%>

        </table>
    </body>
</html>
