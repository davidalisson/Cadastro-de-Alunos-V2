package br.estacio.poo.alunos.dao;

import br.estacio.poo.alunos.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco.newton
 */
public class UsuarioDAO extends GenericoDAO
{
    
    public UsuarioDAO()
    {
        
    }
    
    public boolean createTable()
    {
        String sql = "CREATE TABLE CADASTRO_USUARIOS ( " +
            "id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) " +
            "CONSTRAINT PK_USUARIOS PRIMARY KEY, " +
            "nome varchar(40), cpf varchar(14), telefone varchar(13), login varchar(16), senha varchar(16) "+
            ")";
        try 
        {
            this.pstmt = this.getConnection().prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            System.out.println( "Criada tabela no banco de dados!" );
        }
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
        return true;
    }
    
    public void incluir(Usuario usuario)
    {
        String sql = "INSERT INTO CADASTRO_USUARIOS (nome,cpf,telefone,login,senha) VALUES (?,?,?,?,?)" ;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setString(4, usuario.getLogin());
            pstmt.setString(5, usuario.getSenha());
            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }

    public Usuario consultar(int codigo)
    {
        String sql = "SELECT * FROM CADASTRO_USUARIOS WHERE ID = ?";
        Usuario usuario = null;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public List<Usuario> getLista() 
    {
        String sql = "SELECT * FROM CADASTRO_USUARIOS";
        List<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                listaUsuarios.add(usuario);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public List<Usuario> getListaNome(String nome)
    {
        String sql = "SELECT * FROM CADASTRO_USUARIOS WHERE NOME LIKE ?";
        List<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+nome+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                listaUsuarios.add(usuario);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }
    public List<Usuario> getListaTelefone(String telefone)
    {
        String sql = "SELECT * FROM CADASTRO_USUARIOS WHERE TELEFONE LIKE ?";
        List<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+telefone+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                listaUsuarios.add(usuario);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }


    public boolean alterar(Usuario usuario)
    {
        String sql = "UPDATE CADASTRO_USUARIOS SET nome=?, cpf=?, telefone=?, login=?, senha=? WHERE id=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setString(4, usuario.getLogin());
            pstmt.setString(5, usuario.getSenha());
            
            pstmt.setInt(6, usuario.getCodigo());
            
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public boolean excluir(int codigo)
    {
        String sql = "DELETE FROM CADASTRO_USUARIOS WHERE id=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, codigo);
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
}
