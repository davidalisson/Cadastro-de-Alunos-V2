/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.dao;


/**
 *
 * @author Dom
 */


import br.estacio.poo.alunos.entidades.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco.newton
 */
public class AlunoDAO extends GenericoDAO
{
    
    public AlunoDAO()
    {
        
    }
    
    public boolean createTable()
    {
        String sql = "CREATE TABLE CADASTRO_ALUNOS ( " +
            "id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) " +
            "CONSTRAINT PK_ALUNOS PRIMARY KEY, " +
            "nome varchar(40), sexo char(1), idade int, curso varchar(30), turno char(1), "+
            "coningles boolean,conjava boolean,conc boolean,conphp boolean, connet boolean, consql boolean)";
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
    
    public void incluir(Aluno aluno)
    {
        String sql = "INSERT INTO CADASTRO_ALUNOS (nome,sexo,idade,curso,turno,coningles,conjava,conc,"
                + "conphp,connet,consql) VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, String.valueOf(aluno.getSexo()));
            pstmt.setInt(3, aluno.getIdade());
            pstmt.setString(4, aluno.getCurso());
            pstmt.setString(5, String.valueOf(aluno.getTurno()));
            pstmt.setBoolean(6, aluno.isConhecimentoIngles());
            pstmt.setBoolean(7, aluno.isConhecimentoJava());
            pstmt.setBoolean(8, aluno.isConhecimentoC());
            pstmt.setBoolean(9, aluno.isConhecimentoPhp());
            pstmt.setBoolean(10, aluno.isConhecimentoNet());
            pstmt.setBoolean(11, aluno.isConhecimentoSql());
            
            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }

    public Aluno consultar(int codigo)
    {
        String sql = "SELECT * FROM CADASTRO_ALUNOS WHERE ID = ?";
        Aluno aluno = null;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setTurno(rs.getString("turno").charAt(0));
                aluno.setConhecimentoIngles(rs.getBoolean("coningles"));
                aluno.setConhecimentoJava(rs.getBoolean("conjava"));
                aluno.setConhecimentoPhp(rs.getBoolean("conphp"));
                aluno.setConhecimentoC(rs.getBoolean("conc"));
                aluno.setConhecimentoNet(rs.getBoolean("connet"));
                aluno.setConhecimentoSql(rs.getBoolean("consql"));
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return aluno;
    }

    public List<Aluno> getLista() 
    {
        String sql = "SELECT * FROM CADASTRO_ALUNOS";
        List<Aluno> listaAlunos = new ArrayList();
        Aluno aluno;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setTurno(rs.getString("turno").charAt(0));
                aluno.setConhecimentoIngles(rs.getBoolean("coningles"));
                aluno.setConhecimentoJava(rs.getBoolean("conjava"));
                aluno.setConhecimentoPhp(rs.getBoolean("conphp"));
                aluno.setConhecimentoC(rs.getBoolean("conc"));
                aluno.setConhecimentoNet(rs.getBoolean("connet"));
                aluno.setConhecimentoSql(rs.getBoolean("consql"));
                listaAlunos.add(aluno);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaAlunos;
    }

    public List<Aluno> getListaNome(String nome)
    {
        String sql = "SELECT * FROM CADASTRO_ALUNOS WHERE NOME LIKE ?";
        List<Aluno> listaAlunos = new ArrayList();
        Aluno aluno;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+nome+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setTurno(rs.getString("turno").charAt(0));
                aluno.setConhecimentoIngles(rs.getBoolean("coningles"));
                aluno.setConhecimentoJava(rs.getBoolean("conjava"));
                aluno.setConhecimentoPhp(rs.getBoolean("conphp"));
                aluno.setConhecimentoC(rs.getBoolean("conc"));
                aluno.setConhecimentoNet(rs.getBoolean("connet"));
                aluno.setConhecimentoSql(rs.getBoolean("consql"));
                listaAlunos.add(aluno);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaAlunos;
    }
    
    public List<Aluno> getListaCurso(String curso)
    {
        String sql = "SELECT * FROM CADASTRO_ALUNOS WHERE CURSO LIKE ?";
        List<Aluno> listaAlunos = new ArrayList();
        Aluno aluno;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, "%"+curso+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setTurno(rs.getString("turno").charAt(0));
                aluno.setConhecimentoIngles(rs.getBoolean("coningles"));
                aluno.setConhecimentoJava(rs.getBoolean("conjava"));
                aluno.setConhecimentoPhp(rs.getBoolean("conphp"));
                aluno.setConhecimentoC(rs.getBoolean("conc"));
                aluno.setConhecimentoNet(rs.getBoolean("connet"));
                aluno.setConhecimentoSql(rs.getBoolean("consql"));
                listaAlunos.add(aluno);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaAlunos;
    }

    
    public boolean alterar(Aluno aluno)
    {
        String sql = "UPDATE CADASTRO_ALUNOS SET nome=?, sexo=?, idade=?, curso=?, turno=?,coningles=?,conjava=?,conphp=?,conc=?,connet=?,consql=? WHERE id=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString   (2, String.valueOf(aluno.getSexo()));
            pstmt.setInt(3, aluno.getIdade());
            pstmt.setString(4, aluno.getCurso());
            pstmt.setString(5, String.valueOf(aluno.getTurno()));
            pstmt.setBoolean(6, aluno.isConhecimentoIngles());
            pstmt.setBoolean(7, aluno.isConhecimentoJava());
            pstmt.setBoolean(8, aluno.isConhecimentoC());
            pstmt.setBoolean(9, aluno.isConhecimentoPhp());
            pstmt.setBoolean(10, aluno.isConhecimentoNet());
            pstmt.setBoolean(11, aluno.isConhecimentoSql());
            
            pstmt.setInt(12, aluno.getCodigo());
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
        String sql = "DELETE FROM CADASTRO_ALUNOS WHERE id=?";
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


