/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.UsuarioDAO;
import br.estacio.poo.alunos.entidades.Usuario;
import javax.swing.JOptionPane;


/**
 *
 * @author David
 */
public class FrameUsuarios extends javax.swing.JInternalFrame {

private UsuarioDAO usuarioDao =  new UsuarioDAO();
private Usuario usuario = new Usuario();


private FramePesquisaUsuarios framePesquisa = new FramePesquisaUsuarios(this);


public FrameUsuarios() 
    {
        initComponents(); 
        camposEditaveis(false);
        
    }

    public void cadastrarUsuarios()
    {

        usuario.setNome(tfNome.getText());
        usuario.setCpf(ftfCpf.getText());
        usuario.setTelefone(ftfTelefone.getText());
        usuario.setLogin(tfloginAcesso.getText());
        usuario.setSenha(String.valueOf(pfSenhaAcesso.getPassword()));
        if (tfNome.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Nome'!!!");
        else if (ftfCpf.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'CPF'!!!");
        else if (ftfTelefone.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Telefone'!!!");
        else if (tfloginAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Login de Acesso'!!!");
         else if (pfSenhaAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Senha de Acesso'!!!");
          else if (pfSenhaAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Confirmar Senha'!!!");
        else
        {
            if (pfSenhaAcesso.getText().equals(pfConfirmSenha.getText()))
             {
                usuarioDao.incluir(usuario);
                JOptionPane.showMessageDialog(FrameUsuarios.this, "Cadastro realizado com sucesso! ");
                limparCampos("");
                camposEditaveis(false);
                outrsEditaveis(true);
             }
            else
            {
                JOptionPane.showMessageDialog(FrameUsuarios.this, "As senhas não coincidem, por favor verifique novamente","Verificação de Senha", JOptionPane.ERROR_MESSAGE);
            }
             
        }
    }
    public void camposEditaveis(boolean ativar)
    {
        tfNome.setEditable(ativar);
        ftfCpf.setEditable(ativar);
        ftfTelefone.setEditable(ativar);
        tfloginAcesso.setEditable(ativar);
        pfSenhaAcesso.setEditable(ativar);
        pfConfirmSenha.setEditable(ativar);
        btGravar.setEnabled(ativar);
        btCancelar.setEnabled(ativar);
    }
    
    public void outrsEditaveis(boolean ativar)
    {
       tfCodigo.setEditable(ativar);
       btBuscar.setEnabled(ativar);
       btPesquisar.setEnabled(ativar);
       btAlterar.setEnabled(ativar);
       btExcluir.setEnabled(ativar);
    }
    
    public void limparCampos(String s)
    {
        tfNome.setText(s);
        ftfCpf.setText(s);
        ftfTelefone.setText(s);
        tfloginAcesso.setText(s);
        pfSenhaAcesso.setText(s);
        pfConfirmSenha.setText(s);
        
    }
    
    
     
     public void setUsuario(int codigo, String nome, String cpf, String telefone, String login, String senha)
    {
        tfCodigo.setText(String.valueOf(codigo));
        tfNome.setText(nome);
        ftfCpf.setText(cpf);
        ftfTelefone.setText(telefone);
        tfloginAcesso.setText(login);
        pfSenhaAcesso.setText(senha);
        btAlterar.setEnabled(true);
    }
     
    public void buscarCodigo()
    {
         Usuario u =  usuarioDao.consultar(Integer.parseInt(tfCodigo.getText()));
         
         if (u!=null)
         {
            usuarioDao.consultar(Integer.parseInt(tfCodigo.getText()));
            
            tfNome.setText(u.getNome());
            ftfCpf.setText(u.getCpf());
            ftfTelefone.setText(u.getTelefone());
            tfloginAcesso.setText(u.getLogin());
            pfSenhaAcesso.setText(u.getSenha());
            
         } else
            JOptionPane.showMessageDialog(this, "Código não localizado!");      
            
     }
     
    
    private void excluirUsuario(int codigo) {
        
            int resposta = JOptionPane.showConfirmDialog(this, "Excluir usuário?", "Confimação", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                usuarioDao.excluir(codigo);
                //btExcluir.setEnabled(false);
                //btAlterar.setEnabled(false);
                JOptionPane.showMessageDialog(FrameUsuarios.this, "Usuário excluido com sucesso");
                limparCampos("");
                camposEditaveis(false);
                
                
            }
        }
    
     public void alterarUsuario()
    {
        Usuario u = new Usuario();
        u.setCodigo(Integer.parseInt(tfCodigo.getText()));
        u.setNome(tfNome.getText());
        u.setCpf( ftfCpf.getText());
        u.setTelefone(ftfTelefone.getText());
        u.setLogin(tfloginAcesso.getText());
        u.setSenha( pfSenhaAcesso.getText());
        usuarioDao.alterar(u);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblLoginAcesso = new javax.swing.JLabel();
        lblSenhaAcesso = new javax.swing.JLabel();
        lblConfirmSenha = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfloginAcesso = new javax.swing.JTextField();
        pfSenhaAcesso = new javax.swing.JPasswordField();
        pfConfirmSenha = new javax.swing.JPasswordField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        btBuscar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Projeto Alunos -Cadastro de Usuários");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Titulos/Usuarios.png"))); // NOI18N
        lblTitulo.setText("Cadastro de Usuários do Sistema");

        lblCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCodigo.setText("Código:");

        lblNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblCpf.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCpf.setText("Cpf:");

        lblTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblLoginAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblLoginAcesso.setText("Login de acesso:");

        lblSenhaAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSenhaAcesso.setText("Senha de Acesso:");

        lblConfirmSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblConfirmSenha.setText("Confirmação de Senha:");

        tfCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tfNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tfloginAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pfSenhaAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pfConfirmSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        btGravar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/gravar.png"))); // NOI18N
        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
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

        btFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/fechar.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblConfirmSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLoginAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSenhaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfloginAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pfSenhaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pfConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btGravar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ftfCpf, ftfTelefone, pfConfirmSenha, pfSenhaAcesso, tfloginAcesso});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar, btPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfCpf)
                            .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfTelefone)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfloginAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoginAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pfSenhaAcesso)
                            .addComponent(lblSenhaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pfConfirmSenha)
                            .addComponent(lblConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btGravar)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btBuscar, ftfCpf, ftfTelefone, pfConfirmSenha, pfSenhaAcesso, tfCodigo, tfNome, tfloginAcesso});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar, btPesquisar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if(btAlterar.isEnabled())
        {
        
        if (tfNome.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Nome'!!!");
        else if (ftfCpf.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'CPF'!!!");
        else if (ftfTelefone.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Telefone'!!!");
        else if (tfloginAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Login de Acesso'!!!");
        else if (pfSenhaAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Senha de Acesso'!!!");
        else if (pfSenhaAcesso.getText().equals(""))
           JOptionPane.showMessageDialog(FrameUsuarios.this, "Preencha o campo 'Confirmar Senha'!!!");
        else{
            if (pfSenhaAcesso.getText().equals(pfConfirmSenha.getText()))
             {
            alterarUsuario();
            JOptionPane.showMessageDialog(FrameUsuarios.this, "Alteração realizada com sucesso! ");
            limparCampos("");
            camposEditaveis(false);
            outrsEditaveis(true);
             }else
                JOptionPane.showMessageDialog(FrameUsuarios.this, "As senhas não coincidem, por favor verifique novamente","Verificação de Senha", JOptionPane.ERROR_MESSAGE);
          }
        }
        else
            cadastrarUsuarios();
        
    }//GEN-LAST:event_btGravarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
      FramePrincipal.getDesktop().add(framePesquisa);
      framePesquisa.setVisible(true);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        camposEditaveis(true);
        outrsEditaveis(false);
        
        limparCampos("");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        try{
        if(tfCodigo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
        else{
            buscarCodigo();
            
        }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(FrameUsuarios.this, "Ops, apanas numeros no campo 'Código'");
            tfCodigo.setText("");
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        camposEditaveis(false);
        outrsEditaveis(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       if(tfCodigo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
       else
        excluirUsuario(Integer.parseInt(tfCodigo.getText()));
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
       if(tfCodigo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
       else 
       {
           camposEditaveis(true);
           btBuscar.setEnabled(false);
           tfCodigo.setEditable(false);
       }
    }//GEN-LAST:event_btAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConfirmSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblLoginAcesso;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenhaAcesso;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField pfConfirmSenha;
    private javax.swing.JPasswordField pfSenhaAcesso;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfloginAcesso;
    // End of variables declaration//GEN-END:variables
}
