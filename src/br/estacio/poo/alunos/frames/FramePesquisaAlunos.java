/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;



import br.estacio.poo.alunos.dao.AlunoDAO;
import br.estacio.poo.alunos.entidades.Aluno;
import java.util.ArrayList;
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
public class FramePesquisaAlunos extends javax.swing.JInternalFrame {

    private FrameAlunos fa;
    public FramePesquisaAlunos(FrameAlunos f) {
         //fa= new FrameAlunos();  
        fa=f;
        initComponents();
        rbNome.setSelected(true);
    }
    
    private DefaultTableModel tmAlunos = new DefaultTableModel(null, new String[]{"Codig", "Nome","Curso"});
    private AlunoDAO alunoDAO = new AlunoDAO();
    
    public void mostrarAlunosCurso(List<Aluno> listU)
    {
        while (tmAlunos.getRowCount() > 0) {
            tmAlunos.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < alunoDAO.getListaCurso(tfPesquisa.getText()).size(); i++) 
            {
                tmAlunos.addRow(campos);
                tmAlunos.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmAlunos.setValueAt(listU.get(i).getNome(), i, 1);    
                tmAlunos.setValueAt(listU.get(i).getCurso(), i, 2);    
            }
       
    }
    
    public void mostrarAlunos(List<Aluno> listU)
    {
        while (tmAlunos.getRowCount() > 0) {
            tmAlunos.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < alunoDAO.getListaNome(tfPesquisa.getText()).size(); i++) 
            {
                tmAlunos.addRow(campos);
                tmAlunos.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmAlunos.setValueAt(listU.get(i).getNome(), i, 1);    
                tmAlunos.setValueAt(listU.get(i).getCurso(), i, 2);
            }
    }
    public void listarAlunos() 
    {   
            if (rbNome.isSelected())
                mostrarAlunos(alunoDAO.getListaNome(tfPesquisa.getText()));
            else
                mostrarAlunosCurso(alunoDAO.getListaCurso(tfPesquisa.getText()));
    }
    
     private Aluno alunoE = new Aluno();
    List<Aluno> aluno;
    ListSelectionModel lsmAlunos ;
    
    public void tbAlunoLinhaSelecionada(JTable tb) {
        
        aluno = alunoDAO.getListaNome(tfPesquisa.getText());
        if (tb.getSelectedRow() != -1) {
            //alunoE.setMatricula(aluno.get(tb.getSelectedRow()).getMatricula());
            
            alunoE.setCodigo(aluno.get(tb.getSelectedRow()).getCodigo());
            
            alunoE.setNome(aluno.get(tb.getSelectedRow()).getNome());
            
            alunoE.setCurso(aluno.get(tb.getSelectedRow()).getCurso());
            
            if(aluno.get(tb.getSelectedRow()).getTurno() == 'M')
            {
                alunoE.setTurno('M');
            }
            else if(aluno.get(tb.getSelectedRow()).getTurno() == 'T')
            {
                alunoE.setTurno('T');
            }
            else if(aluno.get(tb.getSelectedRow()).getTurno() == 'N')
            {
                alunoE.setTurno('N');
            }

            if (aluno.get(tb.getSelectedRow()).getSexo()=='M'){
                alunoE.setSexo('M');
            }
            else
            {
                alunoE.setSexo('F');
            }
            
            alunoE.setIdade((aluno.get(tb.getSelectedRow()).getIdade()));
            
            alunoE.setConhecimentoIngles(aluno.get(tb.getSelectedRow()).isConhecimentoIngles());
            alunoE.setConhecimentoJava(aluno.get(tb.getSelectedRow()).isConhecimentoJava());
            alunoE.setConhecimentoC(aluno.get(tb.getSelectedRow()).isConhecimentoPhp());
            alunoE.setConhecimentoPhp(aluno.get(tb.getSelectedRow()).isConhecimentoC());
            alunoE.setConhecimentoNet(aluno.get(tb.getSelectedRow()).isConhecimentoNet());
            alunoE.setConhecimentoSql(aluno.get(tb.getSelectedRow()).isConhecimentoSql());


        }
    }
   
    public void limpaTabela()
    {
        while (tmAlunos.getRowCount() > 0) {
            tmAlunos.removeRow(0);
        }
        tfPesquisa.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupBotao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();
        rbCurso = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        btPesquisar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        btSelecionar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbAlunos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbAlunos.setModel(tmAlunos);
        tbAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmAlunos = tbAlunos.getSelectionModel();
        lsmAlunos.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(! e.getValueIsAdjusting()){
                    tbAlunoLinhaSelecionada(tbAlunos);
                }
            }
        });
        jScrollPane1.setViewportView(tbAlunos);

        btGroupBotao.add(rbCurso);
        rbCurso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbCurso.setText("Curso");

        btGroupBotao.add(rbNome);
        rbNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbNome.setText("Nome");

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
                                .addComponent(rbCurso)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbNome)
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
                    .addComponent(rbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCurso)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        listarAlunos();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        fa.setAluno(alunoE.getCodigo(), alunoE.getNome(), alunoE.getSexo(), alunoE.getIdade(), alunoE.getCurso(), alunoE.getTurno(), alunoE.isConhecimentoIngles(),alunoE.isConhecimentoJava(), alunoE.isConhecimentoPhp(), alunoE.isConhecimentoC(), alunoE.isConhecimentoNet(), alunoE.isConhecimentoSql());
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
    private javax.swing.JRadioButton rbCurso;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
