/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbctraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author macbookair
 */
public class JDBCtraining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Persons_DB", "root", "root");
        String vardas = "Ona";
        //Statement st = con.createStatement();

        // st.execute("INSERT INTO persons(first_name,last_name,birth_date,salary)VALUES('Ona','Petraitiene','1964-06-21','500.00')");
        // st=con.createStatement();
        // st.execute("DELETE FROM persons WHERE id=6");
        //ResultSet rs = st.executeQuery("SELECT*FROM persons WHERE first_name='" + vardas + "'"); //negalima taip daryti!!!
        
        PreparedStatement pst = con.prepareStatement("SELECT*FROM persons WHERE first_name = ?");  //DAROME STAI TAIP!!!
        pst.setString(1, vardas);
        
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getDate(4));
            System.out.println(rs.getBigDecimal(5));
            System.out.println(" ");
        }

        rs.close();
        pst.close();
        //st.close();
        con.close();
    }

}
