/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.entidades;

/**
 *
 * @author Dom
 */
public class Aluno {
    private String matricula;
    private int codigo;
    private String nome;
    private char sexo;
    private int idade;
    private String curso;
    private char turno;
    private boolean conhecimentoIngles;
    private boolean conhecimentoJava;
    private boolean conhecimentoPhp;
    private boolean conhecimentoC;
    private boolean conhecimentoNet;
    private boolean conhecimentoSql;

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the turno
     */
    public char getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(char turno) {
        this.turno = turno;
    }

    /**
     * @return the conhecimentoIngles
     */
    public boolean isConhecimentoIngles() {
        return conhecimentoIngles;
    }

    /**
     * @param conhecimentoIngles the conhecimentoIngles to set
     */
    public void setConhecimentoIngles(boolean conhecimentoIngles) {
        this.conhecimentoIngles = conhecimentoIngles;
    }

    /**
     * @return the conhecimentoJava
     */
    public boolean isConhecimentoJava() {
        return conhecimentoJava;
    }

    /**
     * @param conhecimentoJava the conhecimentoJava to set
     */
    public void setConhecimentoJava(boolean conhecimentoJava) {
        this.conhecimentoJava = conhecimentoJava;
    }

    /**
     * @return the conhecimentoPhp
     */
    public boolean isConhecimentoPhp() {
        return conhecimentoPhp;
    }

    /**
     * @param conhecimentoPhp the conhecimentoPhp to set
     */
    public void setConhecimentoPhp(boolean conhecimentoPhp) {
        this.conhecimentoPhp = conhecimentoPhp;
    }

    /**
     * @return the conhecimentoC
     */
    public boolean isConhecimentoC() {
        return conhecimentoC;
    }

    /**
     * @param conhecimentoC the conhecimentoC to set
     */
    public void setConhecimentoC(boolean conhecimentoC) {
        this.conhecimentoC = conhecimentoC;
    }

    /**
     * @return the conhecimentoNet
     */
    public boolean isConhecimentoNet() {
        return conhecimentoNet;
    }

    /**
     * @param conhecimentoNet the conhecimentoNet to set
     */
    public void setConhecimentoNet(boolean conhecimentoNet) {
        this.conhecimentoNet = conhecimentoNet;
    }

    /**
     * @return the conhecimentoSql
     */
    public boolean isConhecimentoSql() {
        return conhecimentoSql;
    }

    /**
     * @param conhecimentoSql the conhecimentoSql to set
     */
    public void setConhecimentoSql(boolean conhecimentoSql) {
        this.conhecimentoSql = conhecimentoSql;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
