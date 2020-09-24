package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {
 
    public static Connection conector() {
        // var que irá conter informações de conexão
        java.sql.Connection conexao = null;
        
        // referencia ao driver carregado
        String driver = "com.mysql.jdbc.Driver";
        
        // var acesso ao bd
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        
        // informações de acesso
        String user = "root";
        String pass = "12345";
        
        // estabelecendo conexão com bd
        try {
            Class.forName(driver);
            
            conexao = DriverManager.getConnection(url, user, pass);
            
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
