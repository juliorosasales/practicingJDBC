package org.example.application;

import org.example.db.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args){

        Statement st = null;
        ResultSet rs = null;
        Connection conn = null;

        try{
            conn = DB.getConnection();

            st = conn.createStatement();
            rs = st .executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("id") + " - " + rs.getString("Name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConection();
        }

        System.out.println("\n");

        try{
            conn = DB.getConnection();

            st = conn.createStatement();
            rs = st .executeQuery("select * from seller");

            while (rs.next()){
                System.out.println(rs.getInt("id") + " - "
                        + rs.getString("Name") + " | "
                        + rs.getString("Email")+ " | "
                        + rs.getDate("BirthDate") + " | "
                        + rs.getDouble("BaseSalary") + " | "
                        + rs.getInt("DepartmentId"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConection();

        }



    }
}
