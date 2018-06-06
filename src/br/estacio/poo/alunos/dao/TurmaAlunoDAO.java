/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.dao;

import br.estacio.poo.alunos.entidades.TurmaAluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dom
 */
public class TurmaAlunoDAO extends GenericoDAO {
    
    public boolean createTable()
    {
        String sql = "CREATE TABLE CADASTRO_TURMA_ALUNO ( " +
            "id_turma_aluno integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) " +
            "CONSTRAINT PK_TURMA_ALUNOS PRIMARY KEY, " +
            "codaluno int, codturma int"+
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
    
    public void incluir(TurmaAluno turmaAluno)
    {
        String sql = "INSERT INTO CADASTRO_TURMA_ALUNO (codaluno,codturma) VALUES (?,?)" ;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            //pstmt.setInt(1, turmaAluno.getCodigo());
            pstmt.setInt(1, turmaAluno.getCodigoAluno());
            pstmt.setInt(2, turmaAluno.getCodigoTurma());
            
            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
/*
    public TurmaAluno consultar(int codigo)
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
*/
    public List<TurmaAluno> getLista() 
    {
        String sql = "SELECT CADASTRO_ALUNOS.NOME, CADASTRO_ALUNOS.CURSO, CADASTRO_TURMAS.DISCIPLINA, CADASTRO_TURMA_ALUNO.* FROM CADASTRO_TURMA_ALUNO, CADASTRO_ALUNOS,"
                +   " CADASTRO_TURMAS WHERE CADASTRO_TURMA_ALUNO.CODALUNO"
                +   " = CADASTRO_ALUNOS.ID AND CADASTRO_TURMA_ALUNO.CODTURMA = CADASTRO_TURMAS.ID AND codturma = ?";
        List<TurmaAluno> listaTurmaAluno = new ArrayList();
        TurmaAluno turmaAluno;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                turmaAluno = new TurmaAluno();
                turmaAluno.setCodigo(rs.getInt("id_turma_aluno"));
                turmaAluno.setCodigoAluno(rs.getInt("CADASTRO_ALUNOS.ID"));
                turmaAluno.setCodigoTurma(rs.getInt("CADASTRO_TURMAS.ID"));
                turmaAluno.setNomeAluno(rs.getString("CADASTRO_ALUNOS.NOME"));
                turmaAluno.setNomeDisc(rs.getString("CADASTRO_TURMAS.DISCIPLINA"));
                turmaAluno.setNomeCurso(rs.getString("CADASTRO_ALUNOS.CURSO"));
                
                listaTurmaAluno.add(turmaAluno);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaTurmaAluno;
    }

    public boolean excluir(int codigo)
    {
        String sql = "DELETE FROM CADASTRO_USUARIOS WHERE id_turma_aluno=?";
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
