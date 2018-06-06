/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.AlunoDAO;
import br.estacio.poo.alunos.entidades.Aluno;

import javax.swing.JOptionPane;


/**
 *
 * @author Dom
 */
public class FrameAlunos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrameAlunos
     */
   
    private AlunoDAO alunoDAO = new AlunoDAO();
    private FramePesquisaAlunos framePesquisarAlunos = new FramePesquisaAlunos(this);
    private FrameIdade fi = new FrameIdade(this);
    
    public FrameAlunos() {
        initComponents();
        camposEditaveis(false);
        outrosEditaveis(true);
       //cmbCurso = new JComboBox(nomesCbCurso);
    }
    
    public void cadastrarAluno()
    {
        Aluno aluno = new Aluno();
        aluno.setMatricula(tfMatricula.getText().trim());
        aluno.setNome(tfNome.getText().trim());
        aluno.setCurso(cmbCurso.getSelectedItem().toString());

        if (rbManha.isSelected())
            aluno.setTurno('M');
        else if (rbTarde.isSelected())
            aluno.setTurno('T');
        else if (rbNoite.isSelected())
            aluno.setTurno('N');

        aluno.setIdade(Integer.parseInt(tfIdade.getText()));

        if(rbMasculino.isSelected())
            aluno.setSexo('M');
        else
            aluno.setSexo('F');

        if(chbConhecIngles.isSelected())
            aluno.setConhecimentoIngles(true);
        else
            aluno.setConhecimentoIngles(false);

        if(chbConhecJava.isSelected())
            aluno.setConhecimentoJava(true);
        else
            aluno.setConhecimentoJava(false);

        if(chbConhecPhp.isSelected())
            aluno.setConhecimentoPhp(true);
        else
            aluno.setConhecimentoPhp(false);

        if(chbConhecC.isSelected())
            aluno.setConhecimentoC(true);
        else
            aluno.setConhecimentoC(false);

        if(chbConhecNet.isSelected())
            aluno.setConhecimentoNet(true);
        else
            aluno.setConhecimentoNet(false);

        if(chbConhecSql.isSelected())
            aluno.setConhecimentoSql(true);
        else
            aluno.setConhecimentoSql(false);

        if (tfNome.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameAlunos.this, "Preencha o campo 'Nome'!!!");
                else if (tfIdade.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameAlunos.this, "Preencha o campo 'Idade'!!!");
                else
                {
                    try{
                    alunoDAO.incluir(aluno);
                    JOptionPane.showMessageDialog(FrameAlunos.this, "Cadastro realizado com sucesso! ");
                    limparCampos(false,"");
                    camposEditaveis(false);
                        outrosEditaveis(true);
                    btCalcular.setEnabled(false);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, " Ops, digite apenas numeros no campo 'Idade'! ");
                    }
                }
    }

    public void setIdade(String s)
    {
        tfIdade.setText(s);
    }
    
    
    public void camposEditaveis(boolean ativar)
    {
       tfNome.setEditable(ativar);
       rbMasculino.setEnabled(ativar);
       rbFeminino.setEnabled(ativar);
       tfIdade.setEditable(ativar);
       btCalcular.setEnabled(ativar);
       cmbCurso.setEnabled(ativar);
       painelTurno.setEnabled(ativar);
       rbManha.setEnabled(ativar);
       rbTarde.setEnabled(ativar);
       rbNoite.setEnabled(ativar); 
       chbConhecIngles.setEnabled(ativar);
       chbConhecJava.setEnabled(ativar);
       chbConhecC.setEnabled(ativar);
       chbConhecPhp.setEnabled(ativar);
       chbConhecNet.setEnabled(ativar);
       chbConhecSql.setEnabled(ativar);
       //btAlterar.setEnabled(ativar);
       //btExcluir.setEnabled(ativar);
       btGravar2.setEnabled(ativar);
       btCancelar.setEnabled(ativar);

   }
   
    public void outrosEditaveis(boolean ativar)
    {
       tfMatricula.setEditable(ativar);
       btBuscar.setEnabled(ativar);

   }
    
    public void limparCampos(boolean check, String s)
    {
    //tfMatricula.setText("");
    tfNome.setText(s);
    tfIdade.setText(s);
    cmbCurso.setSelectedIndex(0);
    chbConhecIngles.setSelected(check);
    chbConhecJava.setSelected(check);
    chbConhecPhp.setSelected(check);
    chbConhecC.setSelected(check);
    chbConhecNet.setSelected(check);
    chbConhecSql.setSelected(check);
}
    
    public void verificaCampos()
    {

            
}

    public void buscarCodigo()
    {
        Aluno a =  alunoDAO.consultar(Integer.parseInt(tfMatricula.getText()));

        if (a!=null)
        {
            alunoDAO.consultar(Integer.parseInt(tfMatricula.getText()));

            tfNome.setText(a.getNome());

            if (a.getSexo() == 'M')
                rbMasculino.setSelected(true);
            else
                rbFeminino.setSelected(true);

            cmbCurso.setSelectedItem(a.getCurso());

            if(a.getTurno() == 'M')
                rbManha.setSelected(true);
            else if(a.getTurno() == 'T')
                rbTarde.setSelected(true);
            else if(a.getTurno() == 'N')
                rbNoite.setSelected(true);
            
            tfIdade.setText(String.valueOf(a.getIdade()));

            chbConhecIngles.setSelected(a.isConhecimentoIngles());
            chbConhecJava.setSelected(a.isConhecimentoJava());
            chbConhecPhp.setSelected(a.isConhecimentoPhp());
            chbConhecC.setSelected(a.isConhecimentoC());
            chbConhecNet.setSelected(a.isConhecimentoNet());
            chbConhecSql.setSelected(a.isConhecimentoSql());
            //teste = a.getCurso();
        } else
        JOptionPane.showMessageDialog(this, "Código não localizado!");      

}
        
        
    public void setAluno(int codigo,String nome, char sexo, int idade, String curso, char turno,boolean conhecimentoIngles,boolean conhecimentoJava,
        boolean conhecimentoPhp, boolean conhecimentoC, boolean conhecimentoNet, boolean conhecimentoSql)
            {
        //tfMatricula.setText(matricula);
        tfMatricula.setText(String.valueOf(codigo));
                
        tfNome.setText(nome);

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
            rbNoite.setSelected(true);
        }

        if (sexo == 'M'){
            rbMasculino.setSelected(true);
        }
        else
        {
        rbFeminino.setSelected(true);
        }

        tfIdade.setText(String.valueOf(idade));

        chbConhecIngles.setSelected(conhecimentoIngles);
        chbConhecJava.setSelected(conhecimentoJava);
        chbConhecPhp.setSelected(conhecimentoPhp);
        chbConhecC.setSelected(conhecimentoC);
        chbConhecNet.setSelected(conhecimentoNet);
        chbConhecSql.setSelected(conhecimentoSql);

}
     
    private void excluirAluno(int codigo) 
    {
        
        int resposta = JOptionPane.showConfirmDialog(this, "Excluir aluno?", "Confimação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            alunoDAO.excluir(codigo);
            JOptionPane.showMessageDialog(FrameAlunos.this, "Aluno excluido com sucesso");
            limparCampos(false,"");
            camposEditaveis(false);


        }
    }
    
     public void alterarAluno()
    {
        Aluno a = new Aluno();
        
        a.setCodigo(Integer.parseInt(tfMatricula.getText()));
        
        a.setNome(tfNome.getText());
        
        if (rbMasculino.isSelected())
            a.setSexo('M');
        if (rbFeminino.isSelected())
            a.setSexo('F');
        a.setIdade(Integer.parseInt(tfIdade.getText()));
        a.setCurso(String.valueOf(cmbCurso.getSelectedItem()));
        if (rbManha.isSelected())
            a.setTurno('M');
        else if (rbTarde.isSelected())
            a.setTurno('T');
        else 
            a.setTurno('N');
        a.setConhecimentoIngles(chbConhecIngles.isSelected());
        a.setConhecimentoJava(chbConhecJava.isSelected());
        a.setConhecimentoPhp(chbConhecPhp.isSelected());
        a.setConhecimentoC(chbConhecC.isSelected());
        a.setConhecimentoNet(chbConhecNet.isSelected());
        a.setConhecimentoSql(chbConhecSql.isSelected());
        alunoDAO.alterar(a);
       
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        grupoTurno = new javax.swing.ButtonGroup();
        lblMatricula = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        lblIdade = new javax.swing.JLabel();
        tfIdade = new javax.swing.JTextField();
        lblAnos = new javax.swing.JLabel();
        btCalcular = new javax.swing.JButton();
        lblCurso = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox();
        lblTurno = new javax.swing.JLabel();
        painelTurno = new javax.swing.JPanel();
        rbManha = new javax.swing.JRadioButton();
        rbTarde = new javax.swing.JRadioButton();
        rbNoite = new javax.swing.JRadioButton();
        painelConhec = new javax.swing.JPanel();
        chbConhecIngles = new javax.swing.JCheckBox();
        chbConhecJava = new javax.swing.JCheckBox();
        chbConhecC = new javax.swing.JCheckBox();
        chbConhecPhp = new javax.swing.JCheckBox();
        chbConhecSql = new javax.swing.JCheckBox();
        chbConhecNet = new javax.swing.JCheckBox();
        lblTitulo = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btGravar2 = new javax.swing.JButton();

        lblMatricula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblMatricula.setText("Matrícula:");

        tfMatricula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lblSexo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSexo.setText("Sexo:");

        grupoSexo.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbMasculino.setText("Masculino");

        grupoSexo.add(rbFeminino);
        rbFeminino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbFeminino.setText("Feminino");

        lblIdade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblIdade.setText("Idade:");

        tfIdade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblAnos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAnos.setText("Anos");

        btCalcular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/calcular.png"))); // NOI18N
        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        lblCurso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCurso.setText("Cuso:");

        cmbCurso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um curso...", "Sistemas de Informação", "Análise e Desenvolvimento de Sistemas", "Redes de Computadores", "Telemática", "Jogos Digitais" }));

        lblTurno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTurno.setText("Turno:");

        grupoTurno.add(rbManha);
        rbManha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbManha.setText("Manhã");

        grupoTurno.add(rbTarde);
        rbTarde.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbTarde.setText("Tarde");

        grupoTurno.add(rbNoite);
        rbNoite.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbNoite.setText("Noite");

        javax.swing.GroupLayout painelTurnoLayout = new javax.swing.GroupLayout(painelTurno);
        painelTurno.setLayout(painelTurnoLayout);
        painelTurnoLayout.setHorizontalGroup(
            painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbManha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTarde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNoite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        painelConhec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conhecimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        chbConhecIngles.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecIngles.setText("Ingles");

        chbConhecJava.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecJava.setText("Java");

        chbConhecC.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecC.setText("Linguagem C");

        chbConhecPhp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecPhp.setText("PHP");

        chbConhecSql.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecSql.setText(".NET");

        chbConhecNet.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbConhecNet.setText("SQL");

        javax.swing.GroupLayout painelConhecLayout = new javax.swing.GroupLayout(painelConhec);
        painelConhec.setLayout(painelConhecLayout);
        painelConhecLayout.setHorizontalGroup(
            painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConhecLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelConhecLayout.createSequentialGroup()
                        .addComponent(chbConhecIngles)
                        .addGap(18, 18, 18)
                        .addComponent(chbConhecJava)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelConhecLayout.createSequentialGroup()
                        .addComponent(chbConhecPhp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbConhecSql)))
                .addGap(24, 24, 24)
                .addGroup(painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbConhecC)
                    .addComponent(chbConhecNet, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelConhecLayout.setVerticalGroup(
            painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConhecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbConhecJava)
                    .addComponent(chbConhecIngles)
                    .addComponent(chbConhecC))
                .addGap(15, 15, 15)
                .addGroup(painelConhecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbConhecPhp)
                    .addComponent(chbConhecSql)
                    .addComponent(chbConhecNet))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Titulos/Alunos.png"))); // NOI18N
        lblTitulo.setText("Cadastro de Alunos");

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

        btGravar2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btGravar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/gravar.png"))); // NOI18N
        btGravar2.setText("Gravar");
        btGravar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btGravar2)
                                .addGap(60, 60, 60)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblIdade, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTurno, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbFeminino))
                                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(painelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(painelConhec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblAnos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(17, 17, 17))))
                            .addComponent(lblMatricula)
                            .addComponent(lblSexo))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFechar)
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar2, btNovo, btPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatricula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMasculino)
                            .addComponent(rbFeminino)
                            .addComponent(lblSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnos)
                            .addComponent(lblIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTurno)
                                .addGap(155, 155, 155))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelConhec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar2)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFechar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btFechar, btGravar2, btNovo, btPesquisar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfIdade, tfMatricula, tfNome});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btGravar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravar2ActionPerformed
        if (btAlterar.isEnabled())
        {
            if (tfNome.getText().equals(""))
               JOptionPane.showMessageDialog(FrameAlunos.this, "Preencha o campo 'Nome'!!!");
            else if (tfIdade.getText().equals(""))
               JOptionPane.showMessageDialog(FrameAlunos.this, "Preencha o campo 'Idade'!!!");
            else
            {
                try
                {
                    alterarAluno();
                    JOptionPane.showMessageDialog(FrameAlunos.this, "Alteração realizada com sucesso! ");
                    outrosEditaveis(true);
                    limparCampos(false,"");
                    camposEditaveis(false);
                    btCalcular.setEnabled(false);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this, " Ops, digite apenas numeros no campo 'Idade'! ");
                }
            }
        }else
            cadastrarAluno();
    }//GEN-LAST:event_btGravar2ActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        camposEditaveis(true);
        outrosEditaveis(false);
        limparCampos(false, "");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        FramePrincipal.getDesktop().add(framePesquisarAlunos);
        framePesquisarAlunos.setVisible(true);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        camposEditaveis(false);
        outrosEditaveis(true);
        limparCampos(false, "");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if(tfMatricula.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Insira uma Matícula!");
            limparCampos(false, "");
        }
        else
            buscarCodigo();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
          if(tfMatricula.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
       else
        excluirAluno(Integer.parseInt(tfMatricula.getText()));
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(tfMatricula.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insira um código!");
        else 
        {
            camposEditaveis(true);
            outrosEditaveis(false);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        
        fi.setVisible(true);
    }//GEN-LAST:event_btCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btGravar2;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JCheckBox chbConhecC;
    private javax.swing.JCheckBox chbConhecIngles;
    private javax.swing.JCheckBox chbConhecJava;
    private javax.swing.JCheckBox chbConhecNet;
    private javax.swing.JCheckBox chbConhecPhp;
    private javax.swing.JCheckBox chbConhecSql;
    private javax.swing.JComboBox cmbCurso;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.ButtonGroup grupoTurno;
    private javax.swing.JLabel lblAnos;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel painelConhec;
    private javax.swing.JPanel painelTurno;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbManha;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JRadioButton rbNoite;
    private javax.swing.JRadioButton rbTarde;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
