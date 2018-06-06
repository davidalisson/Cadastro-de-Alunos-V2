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
public class TurmaAluno {
    private int codigo;
    private int codigoAluno;
    private int codigoTurma;
    private String nomeAluno;
    private String nomeDisc;
    private String nomeCurso;

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

    /**
     * @return the codigoAluno
     */
    public int getCodigoAluno() {
        return codigoAluno;
    }

    /**
     * @param codigoAluno the codigoAluno to set
     */
    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    /**
     * @return the codigoTurma
     */
    public int getCodigoTurma() {
        return codigoTurma;
    }

    /**
     * @param codigoTurma the codigoTurma to set
     */
    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    /**
     * @return the nomeAluno
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    /**
     * @param nomeAluno the nomeAluno to set
     */
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    /**
     * @return the nomeDisc
     */
    public String getNomeDisc() {
        return nomeDisc;
    }

    /**
     * @param nomeDisc the nomeDisc to set
     */
    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    /**
     * @return the nomeCurso
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * @param nomeCurso the nomeCurso to set
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
