package org.example.application;

import org.example.db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args){
        Connection conn = DB.getConnection();

        System.out.println("Conexao realizada com sucesso");
        System.out.println(DB.getConnection());
        DB.closeConection();
    }
}
