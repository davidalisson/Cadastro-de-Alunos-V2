package br.estacio.poo.alunos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author francisco.newton
 */
public class ConnectionFactory 
{
    private Connection connection = null;
    private String database = "bdalunos";
    private String usuario = "fic";
    private String senha = "fic";
    private String url;
    
    public Connection getDerbyConnection()
    {
        url = "jdbc:derby://localhost:1527/"+database;
        if (connection == null)
        {
            return createConnection();
        }
        else
            return connection;
    }
    
    private Connection createConnection()
    {
        try
        {
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
}
