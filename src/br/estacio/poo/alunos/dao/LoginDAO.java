/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.dao;

import br.estacio.poo.alunos.frames.FrameLogin;
import java.sql.SQLException;

/**
 *
 * @author Dom
 */
public class LoginDAO extends GenericoDAO {
     
    private String nome;
    
    public boolean verificarSenha(String login, String senha)
    {
        String sql = "SELECT LOGIN,SENHA,NOME FROM CADASTRO_USUARIOS WHERE LOGIN=? AND SENHA=?";
        try 
        {
            boolean autenticado = false;
            
            this.pstmt = this.getConnection().prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                rs.getString("LOGIN");
                rs.getString("SENHA");
                nome = rs.getString("NOME");
                autenticado = true;
            }
            pstmt.close();
            
            return autenticado;
        }
        catch (SQLException e) 
        {
                throw new RuntimeException(e);
        }
    }
     public String getUsuarioLogado()
        {
            return nome;
        }
}
