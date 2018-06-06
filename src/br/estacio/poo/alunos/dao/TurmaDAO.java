/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.dao;

import br.estacio.poo.alunos.entidades.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dom
 */
public class TurmaDAO extends GenericoDAO
{
    
    public TurmaDAO()
    {
        
    }
    
    public boolean createTable()
    {
        String sql = "CREATE TABLE CADASTRO_TURMAS ( " +
            "id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) " +
            "CONSTRAINT PK_TURMAS PRIMARY KEY, " +
            "disciplina varchar(40), professor varchar(40), curso varchar(40), turno char(1) "+
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
    
        public void incluir(Turma turma)
    {
        String sql = "INSERT INTO CADASTRO_TURMAS (disciplina,professor,curso,turno) VALUES (?,?,?,?)" ;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, turma.getDisciplina());
            pstmt.setString(2, turma.getNomeProfessor());
            pstmt.setString(3, turma.getCurso());
            pstmt.setString(4, String.valueOf(turma.getTurno()));
            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }

    public Turma consultar(int codigo)
    {
        String sql = "SELECT * FROM CADASTRO_TURMAS WHERE ID = ?";
        Turma turma = null;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                turma = new Turma();
                turma.setCodigo(rs.getInt("id"));
                turma.setDisciplina(rs.getString("disciplina"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setCurso(rs.getString("curso"));
                turma.setTurno(rs.getString("turno").charAt(0));
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return turma;
    }

    public List<Turma> getLista() 
    {
        String sql = "SELECT * FROM CADASTRO_TURMAS";
        List<Turma> listaTurmas = new ArrayList();
        Turma turma;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                turma = new Turma();
                turma.setCodigo(rs.getInt("id"));
                turma.setDisciplina(rs.getString("disciplina"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setCurso(rs.getString("curso"));
                turma.setTurno(rs.getString("turno").charAt(0));
                
                listaTurmas.add(turma);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaTurmas;
    }

    public List<Turma> getListaNome(String nome)
    {
        String sql = "SELECT * FROM CADASTRO_TURMAS WHERE DISCIPLINA LIKE ?";
        List<Turma> listaTurmas = new ArrayList();
        Turma turma;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+nome+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                turma = new Turma();
                turma.setCodigo(rs.getInt("id"));
                turma.setDisciplina(rs.getString("disciplina"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setCurso(rs.getString("curso"));
                turma.setTurno(rs.getString("turno").charAt(0));
                listaTurmas.add(turma);
            }
            rs.close();
            pstmt.close();
        }
        
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaTurmas;
    }
    
    public List<Turma> getListaProfessor(String professor)
    {
        String sql = "SELECT * FROM CADASTRO_TURMAS WHERE PROFESSOR LIKE ?";
        List<Turma> listaTurmas = new ArrayList();
        Turma turma;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+professor+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                turma = new Turma();
                turma.setCodigo(rs.getInt("id"));
                turma.setDisciplina(rs.getString("disciplina"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setCurso(rs.getString("curso"));
                turma.setTurno(rs.getString("turno").charAt(0));
                listaTurmas.add(turma);
            }
            rs.close();
            pstmt.close();
        }
        
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaTurmas;
    }
    

    public boolean alterar(Turma turma)
    {
        String sql = "UPDATE CADASTRO_TURMAS SET disciplina=?, professor=?, curso=?, turno=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, turma.getDisciplina());
            pstmt.setString   (2, turma.getNomeProfessor());
            pstmt.setString(3, turma.getCurso());
            pstmt.setString(4, String.valueOf(turma.getTurno()));
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
        String sql = "DELETE FROM CADASTRO_TURMAS WHERE id=?";
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
