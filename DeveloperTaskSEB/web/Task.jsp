<%-- 
    Document   : Task
    Created on : Mar 12, 2019, 12:39:57 PM
    Author     : NeleN
--%>

<%@page import="java.util.List"%>
<%@page import="constructor.TaskConstructor"%>
<%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Developer Task</title>
    </head>

    <body>
        <%
            int i = 1;
            final Integer ak = 16807;
            final Integer bk = 48271;
            final Integer div = 2147483647;
            
          for (List numbers : TaskConstructor.getAll()){
            while (i < 5) {
            Integer a = numbers.getA;
            Integer b = numbers.getB;
            Double adiv = numbers.getAdiv;
            Double bdiv = numbers.getBdiv;
            }
          }%>
            
        <style> 
            table, th, td { 
                border: 1px solid black; 
                text-align: center;
            }
            th {
                background-color: yellowgreen;
            }
            body {
                background-image: url("https://i.ebayimg.com/images/g/K0UAAOSwGJlZNZoE/s-l1600.jpg");
                background-size: 90%;
                background-position-y: 45%;
            }
        </style>

        <h1>Užduotis:</h1>
        <h2>Parašyti konsolinę aplikaciją, priimančią du skaitinius parametrus, ir veikiančią pagal duotą aprašymą</h2>

        <form action="Task" method="POST">
            Parametras A: <input type="text" name="a" value="<%= a%>"/><br/>
            Parametras B: <input type="text" name="b" value="<%= b%>"/><br/>
            <input type="submit" value="Save" /><br/>
        </form>

        <table style="width:50%">
            <tr>
                <th> * </th>
                <th> A </th>
                <th> B </th>
            </tr>
            <tr>
                <th> <%=i%> </th>
                <td> <%=a%> </td>
                <td> <%=b%> </td>
            </tr>
           
        </table>
    </body>
</html>
