/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.UsuarioDAO;
import br.estacio.poo.alunos.entidades.Usuario;
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
public class FramePesquisaUsuarios extends javax.swing.JInternalFrame {

    private DefaultTableModel tmUsuarios = new DefaultTableModel(null, new String[]{"Codig", "Nome","Telefone"});
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    FrameUsuarios fu;
    
    public FramePesquisaUsuarios(FrameUsuarios f) 
    {

        fu=f;
        initComponents();
        rbNome.setSelected(true);
    }
    
    
    
    public void mostrarUsuariosTel(List<Usuario> listU)
    {
        while (tmUsuarios.getRowCount() > 0) {
            tmUsuarios.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < usuarioDAO.getListaTelefone(tfPesquisa.getText()).size(); i++) 
            {
                tmUsuarios.addRow(campos);
                tmUsuarios.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmUsuarios.setValueAt(listU.get(i).getNome(), i, 1);    
                tmUsuarios.setValueAt(listU.get(i).getTelefone(), i, 2);    
            }
    }
    
    public void mostrarUsuarios(List<Usuario> listU)
    {
        while (tmUsuarios.getRowCount() > 0) {
            tmUsuarios.removeRow(0);
        }
        
            String[] campos = new String[]{null, null,null};
            for (int i = 0; i < usuarioDAO.getListaNome(tfPesquisa.getText()).size(); i++) 
            {
                tmUsuarios.addRow(campos);
                tmUsuarios.setValueAt(listU.get(i).getCodigo(), i, 0);
                tmUsuarios.setValueAt(listU.get(i).getNome(), i, 1);    
                tmUsuarios.setValueAt(listU.get(i).getTelefone(), i, 2);    
            }
    }
    public void listarUsuarios() 
    { 
            if(rbNome.isSelected())
                mostrarUsuarios(usuarioDAO.getListaNome(tfPesquisa.getText()));
            else
                mostrarUsuariosTel(usuarioDAO.getListaTelefone(tfPesquisa.getText()));
    }

    private Usuario usuarioE = new Usuario();
    List<Usuario> usuario ;
    ListSelectionModel lsmUsuario ;
    
    public void tbAlunoLinhaSelecionada(JTable tb) {
        usuario = usuarioDAO.getListaNome(tfPesquisa.getText());
        if (tb.getSelectedRow() != -1) {
            
            usuarioE.setCodigo(usuario.get(tb.getSelectedRow()).getCodigo());
            usuarioE.setNome(usuario.get(tb.getSelectedRow()).getNome());
            usuarioE.setCpf(usuario.get(tb.getSelectedRow()).getCpf());
            usuarioE.setTelefone(usuario.get(tb.getSelectedRow()).getTelefone());
            usuarioE.setLogin(usuario.get(tb.getSelectedRow()).getLogin());
            usuarioE.setSenha(usuario.get(tb.getSelectedRow()).getSenha());
            
        }
    }        
    public void limpaTabela()
    {
        while (tmUsuarios.getRowCount() > 0) {
            tmUsuarios.removeRow(0);
        }
        tfPesquisa.setText("");
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupPesq = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        rbTelefone = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        btPesquisar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        btSelecionar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tbUsuarios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbUsuarios.setModel(tmUsuarios);
        tbUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmUsuario = tbUsuarios.getSelectionModel();
        lsmUsuario.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(! e.getValueIsAdjusting()){
                    tbAlunoLinhaSelecionada(tbUsuarios);
                }
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        btGroupPesq.add(rbTelefone);
        rbTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbTelefone.setText("Telefone");

        btGroupPesq.add(rbNome);
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbTelefone)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbNome)
                                    .addGap(40, 40, 40)
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
                .addComponent(rbTelefone)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSelecionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap(21, Short.MAX_VALUE))
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
        if (tfPesquisa.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Por favor, insira o nome");
        else
        listarUsuarios();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
         fu.setUsuario(usuarioE.getCodigo(),usuarioE.getNome(), usuarioE.getCpf(), usuarioE.getTelefone(), usuarioE.getLogin(), usuarioE.getSenha());
         dispose();
         limpaTabela();
    }//GEN-LAST:event_btSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.ButtonGroup btGroupPesq;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbTelefone;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
