/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.TurmaDAO;
import br.estacio.poo.alunos.entidades.Aluno;
import br.estacio.poo.alunos.entidades.Turma;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dom
 */
public class FramePesquisaTurmas extends javax.swing.JInternalFrame {

    FrameTurmas ft ;
    public FramePesquisaTurmas(FrameTurmas f) {
        ft=f;
        initComponents();
    }

    private DefaultTableModel tmTurma = new DefaultTableModel(null, new String[]{"Codigo", "Disciplina","Professor"});
    private TurmaDAO turmaDAO = new TurmaDAO();
    
     public void mostrarTurmasProfessor(List<Turma> listU)
    {
        while (tmTurma.getRowCount() > 0) {
            tmTurma.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < turmaDAO.getListaProfessor(tfPesquisa.getText()).size(); i++) 
            {
                tmTurma.addRow(campos);
                tmTurma.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmTurma.setValueAt(listU.get(i).getDisciplina(), i, 1);    
                tmTurma.setValueAt(listU.get(i).getNomeProfessor(), i, 2);    
            }
       
    }
    
    public void mostrarTurmas(List<Turma> listU)
    {
        while (tmTurma.getRowCount() > 0) {
            tmTurma.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < turmaDAO.getListaNome(tfPesquisa.getText()).size(); i++) 
            {
                tmTurma.addRow(campos);
                tmTurma.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmTurma.setValueAt(listU.get(i).getDisciplina(), i, 1);    
                tmTurma.setValueAt(listU.get(i).getNomeProfessor(), i, 2);
            }
       
    }
    public void listarTurmas() 
    {   
        if(rbDisciplina.isSelected())
            mostrarTurmas(turmaDAO.getListaNome(tfPesquisa.getText()));
        else
            mostrarTurmas(turmaDAO.getListaProfessor(tfPesquisa.getText()));
    }
    private Turma turmaE = new Turma();
    List<Turma> turma;
    ListSelectionModel lsmTurma ;
    
    public void limpaTabela()
    {
        while (tmTurma.getRowCount() > 0) {
            tmTurma.removeRow(0);
        }
        tfPesquisa.setText("");
    }
    
    public void tbTurmaLinhaSelecionada(JTable tb) 
    {
        
        turma = turmaDAO.getListaNome(tfPesquisa.getText());
        if (tb.getSelectedRow() != -1) 
        {
            //alunoE.setMatricula(turma.get(tb.getSelectedRow()).getMatricula());
            
            turmaE.setCodigo(turma.get(tb.getSelectedRow()).getCodigo());
            
            turmaE.setDisciplina(turma.get(tb.getSelectedRow()).getDisciplina());
            
            turmaE.setNomeProfessor(turma.get(tb.getSelectedRow()).getNomeProfessor());
            
            turmaE.setCurso(turma.get(tb.getSelectedRow()).getCurso());
            
            if(turma.get(tb.getSelectedRow()).getTurno() == 'M')
            {
                turmaE.setTurno('M');
            }
            else if(turma.get(tb.getSelectedRow()).getTurno() == 'T')
            {
                turmaE.setTurno('T');
            }
            else if(turma.get(tb.getSelectedRow()).getTurno() == 'N')
            {
                turmaE.setTurno('N');
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupBotao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTurmas = new javax.swing.JTable();
        rbProfessor = new javax.swing.JRadioButton();
        rbDisciplina = new javax.swing.JRadioButton();
        btPesquisar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        btSelecionar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Turmas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbTurmas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbTurmas.setModel(tmTurma);
        tbTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTurma = tbTurmas.getSelectionModel();
        lsmTurma.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(! e.getValueIsAdjusting()){
                    tbTurmaLinhaSelecionada(tbTurmas);
                }
            }
        });
        jScrollPane1.setViewportView(tbTurmas);

        btGroupBotao.add(rbProfessor);
        rbProfessor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbProfessor.setText("Professor");

        btGroupBotao.add(rbDisciplina);
        rbDisciplina.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbDisciplina.setText("Disciplina");

        btPesquisar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tfPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btSelecionar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSelecionar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tfPesquisa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbProfessor)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbDisciplina)
                                    .addGap(28, 28, 28)
                                    .addComponent(btPesquisar))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbProfessor)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSelecionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
            listarTurmas();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        ft.setAluno(turmaE.getCodigo() ,turmaE.getDisciplina(), turmaE.getNomeProfessor(), turmaE.getCurso(), turmaE.getTurno());
        dispose();
        limpaTabela();
        
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.ButtonGroup btGroupBotao;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDisciplina;
    private javax.swing.JRadioButton rbProfessor;
    private javax.swing.JTable tbTurmas;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
