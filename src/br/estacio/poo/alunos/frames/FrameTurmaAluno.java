/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.AlunoDAO;
import br.estacio.poo.alunos.dao.TurmaAlunoDAO;
import br.estacio.poo.alunos.dao.TurmaDAO;
import br.estacio.poo.alunos.entidades.Aluno;
import br.estacio.poo.alunos.entidades.Turma;
import br.estacio.poo.alunos.entidades.TurmaAluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dom
 */

public class FrameTurmaAluno extends javax.swing.JInternalFrame {

    private TurmaAluno turmaAluno = new TurmaAluno();
    private TurmaAlunoDAO turmaAlunoDAO = new TurmaAlunoDAO();
    public FrameTurmaAluno() {
        initComponents();
    }
    //tudo de aluno aqui em baixo
    private DefaultTableModel tmAlunos = new DefaultTableModel(null, new String[]{"Codig", "Nome"});
    private AlunoDAO alunoDAO = new AlunoDAO();
    
    public void mostrarAlunos(List<Aluno> listU)
    {
        while (tmAlunos.getRowCount() > 0) {
            tmAlunos.removeRow(0);
        }
        
            String[] campos = new String[]{null, null};
            for (int i = 0; i < alunoDAO.getListaNome(tfPesquisarAluno.getText()).size(); i++) 
            {
                tmAlunos.addRow(campos);
                tmAlunos.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmAlunos.setValueAt(listU.get(i).getNome(), i, 1);    
            }
       
    }
    public void listarAlunos() 
    {   
            mostrarAlunos(alunoDAO.getListaNome(tfPesquisarAluno.getText()));
    }
    
    
    //tudo de turmas aqui em baixo
    
    private DefaultTableModel tmTurma = new DefaultTableModel(null, new String[]{"Codigo", "Disciplina"});
    private TurmaDAO turmaDAO = new TurmaDAO();
    
    public void mostrarTurmas(List<Turma> listU)
    {
        while (tmTurma.getRowCount() > 0) {
            tmTurma.removeRow(0);
        }
        
            String[] campos = new String[]{null, null};
            for (int i = 0; i < turmaDAO.getListaNome(tfPesquisarTurma.getText()).size(); i++) 
            {
                tmTurma.addRow(campos);
                tmTurma.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmTurma.setValueAt(listU.get(i).getDisciplina(), i, 1);    
                
            }
       
    }
    
    public void listarTurmas() 
    {   
            mostrarTurmas(turmaDAO.getListaNome(tfPesquisarTurma.getText()));
    }
    
    public boolean VerificCamposTbAlunos()
    {
        if (tbAluno.getSelectedRow() != -1) {
            return true;
        }
        return false;
    }
    
    public boolean VerificCamposTbTurmas() 
    {
        if (tbAluno.getSelectedRow() != -1) {
            return true;
        }
        return false;
    }
    
    List<Aluno> aluno = alunoDAO.getLista();
    List<Turma> turma = turmaDAO.getLista();
    public void cadastrarTurmaAluno()
    {
        if(VerificCamposTbAlunos()&&VerificCamposTbTurmas())
        {
            turmaAluno.setCodigoAluno(aluno.get(tbAluno.getSelectedRow()).getCodigo());
            turmaAluno.setCodigoTurma(turma.get(tbTurma.getSelectedRow()).getCodigo());
            turmaAlunoDAO.incluir(turmaAluno);
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione um campo primeiro!!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private DefaultTableModel tmTurmaAluno = new DefaultTableModel(null, new String[]{"Codigo", "Aluno", "Disciplina","Curso"});
    //private TurmaDAO turmaDAO = new TurmaDAO();
    
    public void mostrarTurmasAlunos(List<TurmaAluno> listU)
    {
        while (tmTurmaAluno.getRowCount() > 0) {
            tmTurmaAluno.removeRow(0);
        }
        
            String[] campos = new String[]{null, null};
            for (int i = 0; i < turmaDAO.getLista().size(); i++) 
            {
                tmTurmaAluno.addRow(campos);
                tmTurmaAluno.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmTurmaAluno.setValueAt(listU.get(i).getNomeAluno(), i, 1);
                tmTurmaAluno.setValueAt(listU.get(i).getNomeDisc(), i, 2);
                tmTurmaAluno.setValueAt(listU.get(i).getNomeCurso(), i, 3);
                
            }
    }
    public void listarTurmasAlunos() 
    {   
            mostrarTurmasAlunos(turmaAlunoDAO.getLista());
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAluno = new javax.swing.JTable();
        tfPesquisarAluno = new javax.swing.JTextField();
        btPesquisarAluno = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTurma = new javax.swing.JTable();
        tfPesquisarTurma = new javax.swing.JTextField();
        btPesquisarTurma = new javax.swing.JButton();
        btMatricularAluno = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAlunosMatriculados = new javax.swing.JTable();
        btPesquisarAlunosMatriculados = new javax.swing.JButton();
        tfPesquisarAlunosMatriculados = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione um Aluno...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbAluno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbAluno.setModel(tmAlunos);
        jScrollPane1.setViewportView(tbAluno);

        tfPesquisarAluno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btPesquisarAluno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPesquisarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/pesquisar.png"))); // NOI18N
        btPesquisarAluno.setText("Pesquisar");
        btPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btPesquisarAluno))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione uma Turma...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbTurma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbTurma.setModel(tmTurma);
        jScrollPane2.setViewportView(tbTurma);

        tfPesquisarTurma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btPesquisarTurma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPesquisarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/pesquisar.png"))); // NOI18N
        btPesquisarTurma.setText("Pesquisar");
        btPesquisarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarTurmaActionPerformed(evt);
            }
        });

        btMatricularAluno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btMatricularAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/gravar.png"))); // NOI18N
        btMatricularAluno.setText("Matricular Aluno");
        btMatricularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMatricularAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(tfPesquisarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btPesquisarTurma)))
                    .addComponent(btMatricularAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(tfPesquisarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btMatricularAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos Matriculados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbAlunosMatriculados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbAlunosMatriculados.setModel(tmTurmaAluno);
        jScrollPane3.setViewportView(tbAlunosMatriculados);

        btPesquisarAlunosMatriculados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPesquisarAlunosMatriculados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/pesquisar.png"))); // NOI18N
        btPesquisarAlunosMatriculados.setText("Pesquisar");
        btPesquisarAlunosMatriculados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarAlunosMatriculadosActionPerformed(evt);
            }
        });

        tfPesquisarAlunosMatriculados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfPesquisarAlunosMatriculados, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisarAlunosMatriculados)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisarAlunosMatriculados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarAlunosMatriculados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMatricularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMatricularAlunoActionPerformed
       cadastrarTurmaAluno();
       JOptionPane.showMessageDialog(FrameTurmaAluno.this, "Aluno matriculado com sucesso!");
    }//GEN-LAST:event_btMatricularAlunoActionPerformed

    private void btPesquisarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarTurmaActionPerformed
        listarTurmas();
    }//GEN-LAST:event_btPesquisarTurmaActionPerformed

    private void btPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarAlunoActionPerformed
        listarAlunos();
    }//GEN-LAST:event_btPesquisarAlunoActionPerformed

    private void btPesquisarAlunosMatriculadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarAlunosMatriculadosActionPerformed
        listarTurmasAlunos();
    }//GEN-LAST:event_btPesquisarAlunosMatriculadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMatricularAluno;
    private javax.swing.JButton btPesquisarAluno;
    private javax.swing.JButton btPesquisarAlunosMatriculados;
    private javax.swing.JButton btPesquisarTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbAluno;
    private javax.swing.JTable tbAlunosMatriculados;
    private javax.swing.JTable tbTurma;
    private javax.swing.JTextField tfPesquisarAluno;
    private javax.swing.JTextField tfPesquisarAlunosMatriculados;
    private javax.swing.JTextField tfPesquisarTurma;
    // End of variables declaration//GEN-END:variables
}
