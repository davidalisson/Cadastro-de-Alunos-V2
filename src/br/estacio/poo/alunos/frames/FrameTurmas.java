/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.TurmaDAO;
import br.estacio.poo.alunos.entidades.Turma;
import javax.swing.JOptionPane;

/**
 *
 * @author Dom
 */
public class FrameTurmas extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrameTurmas
     */
    private Turma turma = new Turma();
    private TurmaDAO turmaDAO = new TurmaDAO();
    private FramePesquisaTurmas framePesquisarTurmas = new FramePesquisaTurmas(this);
    
    public FrameTurmas() {
        initComponents();
        camposEditaveis(false);
        outrosEditaveis(true);
    }
    public void cadastrarTurmas()
    {

        turma.setDisciplina(tfDisciplina.getText());
        turma.setNomeProfessor(tfProfessor.getText());
        turma.setCurso(cmbCurso.getSelectedItem().toString());
        if (rbManha.isSelected())
            turma.setTurno('M');
        else if (rbTarde.isSelected())
            turma.setTurno('T');
        else if (rbNoite.isSelected())
            turma.setTurno('N');
        
        if (tfDisciplina.getText().equals(""))
           JOptionPane.showMessageDialog(FrameTurmas.this, "Preencha o campo 'Disciplina'!");
        else if (tfProfessor.getText().equals(""))
           JOptionPane.showMessageDialog(FrameTurmas.this, "Preencha o campo 'Professor'!");
        else
        {
            
            turmaDAO.incluir(turma);
            JOptionPane.showMessageDialog(FrameTurmas.this, "Cadastro realizado com sucesso! ");
            limparCampos("");
            camposEditaveis(false);
            outrosEditaveis(true);
           
        }
    }
    public void camposEditaveis(boolean ativar)
    {
       tfDisciplina.setEditable(ativar);
       tfProfessor.setEditable(ativar);
       cmbCurso.setEnabled(ativar);
       rbManha.setEnabled(ativar);
       rbTarde.setEnabled(ativar);
       rbNoite.setEnabled(ativar); 
       //painelTurno.setEnabled(ativar);
       //btAlterar.setEnabled(ativar);
       //btExcluir.setEnabled(ativar);
       btGravar2.setEnabled(ativar);
       btCancelar.setEnabled(ativar);

   }
    public void outrosEditaveis(boolean ativar)
    {
       tfCodigo.setEditable(ativar);
       btBuscar.setEnabled(ativar);

   }
    public void limparCampos(String s)
    {
        //tfMatricula.setText("");
        tfDisciplina.setText(s);
        tfProfessor.setText(s);
        cmbCurso.setSelectedIndex(0);

    }
    public void verificaCampos()
    {
        
}
    
    public void buscarCodigo()
     {
         Turma t =  turmaDAO.consultar(Integer.parseInt(tfCodigo.getText()));

         if (t!=null)
        {
            turmaDAO.consultar(Integer.parseInt(tfCodigo.getText()));

            tfDisciplina.setText(t.getDisciplina());

            tfProfessor.setText(t.getNomeProfessor());

            cmbCurso.setSelectedItem(t.getCurso());

            if(t.getTurno() == 'M')
            {
                rbManha.setSelected(true);
            }
            else if(t.getTurno() == 'T')
            {
                rbTarde.setSelected(true);
            }
            else if(t.getTurno() == 'N')
            {
                rbNoite.setSelected(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Código não localizado!");      
            limparCampos("");
        }    
     }
        
    
    public void setAluno(int codigo, String disciplina, String professor, String curso, char turno)
    {
        tfCodigo.setText(String.valueOf(codigo));

        tfDisciplina.setText(disciplina);

        tfProfessor.setText(professor);

        cmbCurso.setSelectedItem(curso);

        if(turno == 'M')
        {
            rbManha.isSelected();
        }
        else if(turno == 'T')
        {
            rbTarde.isSelected();
        }
        else if(turno == 'N')
        {
            rbNoite.isSelected();
        }
    }
    
     private void excluirTurma(int codigo) {
        
            int resposta = JOptionPane.showConfirmDialog(this, "Excluir turma?", "Confimação", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                turmaDAO.excluir(codigo);
                JOptionPane.showMessageDialog(FrameTurmas.this, "Usuário excluido com sucesso");
                limparCampos("");
                camposEditaveis(false);
                limparCampos("");
                
                
            }
        }
    
     public void alterarTurma()
    {
        Turma t = new Turma();
        
        t.setCodigo(Integer.parseInt(tfCodigo.getText()));
        t.setDisciplina(tfDisciplina.getText());
        t.setNomeProfessor(tfProfessor.getText());
        t.setCurso(String.valueOf(cmbCurso.getSelectedItem()));
        if (rbManha.isSelected())
            t.setTurno('M');
        else if (rbTarde.isSelected())
            t.setTurno('T');
        else 
            t.setTurno('N');
        turmaDAO.alterar(t);
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotao = new javax.swing.ButtonGroup();
        lblCodigo = new javax.swing.JLabel();
        lblDisciplina = new javax.swing.JLabel();
        lblProfessor = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfDisciplina = new javax.swing.JTextField();
        tfProfessor = new javax.swing.JTextField();
        cmbCurso = new javax.swing.JComboBox();
        painelTurno = new javax.swing.JPanel();
        rbManha = new javax.swing.JRadioButton();
        rbTarde = new javax.swing.JRadioButton();
        rbNoite = new javax.swing.JRadioButton();
        lblTitulo = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btGravar2 = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Projeto Alunos -Cadastro de Turmas");

        lblCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCodigo.setText("Código:");

        lblDisciplina.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDisciplina.setText("Disciplina:");

        lblProfessor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblProfessor.setText("Professor:");

        lblCurso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCurso.setText("Curso:");

        lblTurno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTurno.setText("Turno:");

        tfCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoActionPerformed(evt);
            }
        });

        tfDisciplina.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tfProfessor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmbCurso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um curso...", "Sistemas de Informação", "Telemática", "Analise e Desnv. de Sistemas", "Redes de Computadores", "Jogos Digitais" }));

        painelTurno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoBotao.add(rbManha);
        rbManha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbManha.setText("Manhã");
        rbManha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbManhaActionPerformed(evt);
            }
        });

        GrupoBotao.add(rbTarde);
        rbTarde.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbTarde.setText("Tarde");

        GrupoBotao.add(rbNoite);
        rbNoite.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbNoite.setText("Noite");

        javax.swing.GroupLayout painelTurnoLayout = new javax.swing.GroupLayout(painelTurno);
        painelTurno.setLayout(painelTurnoLayout);
        painelTurnoLayout.setHorizontalGroup(
            painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTurnoLayout.createSequentialGroup()
                .addComponent(rbManha, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTarde, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(rbNoite, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTurnoLayout.setVerticalGroup(
            painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTurnoLayout.createSequentialGroup()
                .addGroup(painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbManha)
                    .addComponent(rbTarde)
                    .addComponent(rbNoite))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Titulos/Turmas.png"))); // NOI18N
        lblTitulo.setText("Cadastro de Turmas");

        btBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/buscar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btNovo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/novo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btGravar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btGravar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/gravar.png"))); // NOI18N
        btGravar2.setText("Gravar");
        btGravar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravar2ActionPerformed(evt);
            }
        });

        btPesquisar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btAlterar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/fechar.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBuscar))
                    .addComponent(tfDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(tfProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btNovo)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btGravar2)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btFechar)
                        .addGap(58, 58, 58))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfDisciplina, tfProfessor});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar2, btNovo, btPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfProfessor)
                            .addComponent(lblProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbCurso)
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar2)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFechar))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbCurso, tfCodigo, tfDisciplina, tfProfessor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar2, btNovo, btPesquisar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbManhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbManhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbManhaActionPerformed

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        camposEditaveis(true);
        outrosEditaveis(false);
        limparCampos("");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        camposEditaveis(false);
        outrosEditaveis(true);
        limparCampos("");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btGravar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravar2ActionPerformed
        if (btAlterar.isEnabled())
        {
        if (tfDisciplina.getText().equals(""))
           JOptionPane.showMessageDialog(FrameTurmas.this, "Preencha o campo 'Disciplina'!");
        else if (tfProfessor.getText().equals(""))
           JOptionPane.showMessageDialog(FrameTurmas.this, "Preencha o campo 'Professor'!");
        else
        {  
            alterarTurma();
            JOptionPane.showMessageDialog(FrameTurmas.this, "Alteração realizada com sucesso! ");
            outrosEditaveis(true);
            limparCampos("");
            camposEditaveis(false);
            
        }
        }else
            cadastrarTurmas();
        
    }//GEN-LAST:event_btGravar2ActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        FramePrincipal.getDesktop().add(framePesquisarTurmas);
      framePesquisarTurmas.setVisible(true);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if(tfCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Insira um código!");
            limparCampos("");
        }
        else
            buscarCodigo();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
          if(tfCodigo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
       else
        excluirTurma(Integer.parseInt(tfCodigo.getText()));
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(tfCodigo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
        else 
        {        
            camposEditaveis(true);
            outrosEditaveis(false);
       }
    }//GEN-LAST:event_btAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotao;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btGravar2;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JComboBox cmbCurso;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel painelTurno;
    private javax.swing.JRadioButton rbManha;
    private javax.swing.JRadioButton rbNoite;
    private javax.swing.JRadioButton rbTarde;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDisciplina;
    private javax.swing.JTextField tfProfessor;
    // End of variables declaration//GEN-END:variables
}
