/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.UsuarioDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author fic
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    private FrameTurmas frameTurmas;
    private FrameUsuarios frameUsuarios;
    private FrameSobre frameSobre;
    private FrameAlunos frameAlunos;
    private FrameTurmaAluno frameTurmaAluno;
     private static FramePrincipal p;
     
     public static FramePrincipal getInstancia()
     {
         if (p == null)
             p = new FramePrincipal();
         return p;
     }
     public static JDesktopPane getDesktop()
     {
         return getInstancia().desktop;
         
     }
    public FramePrincipal() {
        initComponents();
        setLayout(new BorderLayout());
        add(desktop, "Center");
        add(painelStatus, BorderLayout.SOUTH);
        setExtendedState(MAXIMIZED_BOTH);
        dataAtual();
        desktop.setBackground(Color.WHITE);
        
        //lblNomeUsuario.setText(frameLogin.());
        
        
        frameTurmas = new FrameTurmas();
        frameTurmas.setVisible(false);
        
        frameUsuarios = new FrameUsuarios();
        frameUsuarios.setVisible(false);
        
        frameAlunos = new FrameAlunos();
        frameAlunos.setVisible(false);
        
        frameTurmaAluno = new FrameTurmaAluno();
        frameTurmaAluno.setVisible(false);
    }
    
   
    private String nomeMes[]= {"Janeiro", "Fevereiro", "Março", "Abril","Maio","Junho",
                               "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    public void dataAtual()
    {
    Calendar data = new GregorianCalendar().getInstance();  
    lblStatus.setText("Sistema de Cadastro de Alunos - "+data.get(Calendar.DATE)+
            " de "+nomeMes[data.get(Calendar.MONTH)]+" de " +data.get(Calendar.YEAR));
    
    }
    
    public void setUsuarioLogado(String s)
    {
        lblNomeUsuario.setText(s);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblImagem = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        painelStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        itemMenuAlunos = new javax.swing.JMenuItem();
        itemMenuTurmas = new javax.swing.JMenuItem();
        itemMenuUsuarios = new javax.swing.JMenuItem();
        menuMatriculas = new javax.swing.JMenu();
        itemMenuMatricularAlunos = new javax.swing.JMenuItem();
        itemMenuMatricularAlunos1 = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        itemMenualuno = new javax.swing.JMenuItem();
        itemMenuTurma = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        itemMenuSobre = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        menuLogof = new javax.swing.JMenu();
        itemMenuLogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO-2014.2: Cadastro de Alunos");
        setName("Cadastro de Alunos"); // NOI18N

        desktop.setBackground(new java.awt.Color(204, 204, 204));
        desktop.setForeground(new java.awt.Color(255, 255, 255));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Fundo/imagemAlunos.gif"))); // NOI18N

        lblTitulo1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lblTitulo1.setText("Cadastro de Alunos V2 -  Estácio - POO 2014.2");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(desktopLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        desktop.setLayer(lblImagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(lblTitulo1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblStatus.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblStatus.setText("Cadastro de Alunos:");

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUsuario.setText("Usuário:");

        lblNomeUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelStatusLayout = new javax.swing.GroupLayout(painelStatus);
        painelStatus.setLayout(painelStatusLayout);
        painelStatusLayout.setHorizontalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelStatusLayout.createSequentialGroup()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelStatusLayout.setVerticalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        menuCadastros.setMnemonic('c');
        menuCadastros.setText("Cadastros");

        itemMenuAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        itemMenuAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/Alunos.png"))); // NOI18N
        itemMenuAlunos.setText("Alunos");
        itemMenuAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlunosActionPerformed(evt);
            }
        });
        menuCadastros.add(itemMenuAlunos);

        itemMenuTurmas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        itemMenuTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/Turmas.png"))); // NOI18N
        itemMenuTurmas.setText("Turmas");
        itemMenuTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuTurmasActionPerformed(evt);
            }
        });
        menuCadastros.add(itemMenuTurmas);

        itemMenuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        itemMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/Usuarios.png"))); // NOI18N
        itemMenuUsuarios.setText("Usuários");
        itemMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuUsuariosActionPerformed(evt);
            }
        });
        menuCadastros.add(itemMenuUsuarios);

        barraMenu.add(menuCadastros);

        menuMatriculas.setMnemonic('m');
        menuMatriculas.setText("Matriculas");

        itemMenuMatricularAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        itemMenuMatricularAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/matricularAluno.png"))); // NOI18N
        itemMenuMatricularAlunos.setText("Matricular Alunos");
        itemMenuMatricularAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuMatricularAlunosActionPerformed(evt);
            }
        });
        menuMatriculas.add(itemMenuMatricularAlunos);

        itemMenuMatricularAlunos1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        itemMenuMatricularAlunos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/lançamentoDeNotas.png"))); // NOI18N
        itemMenuMatricularAlunos1.setText("Lançamento de Notas");
        itemMenuMatricularAlunos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuMatricularAlunos1ActionPerformed(evt);
            }
        });
        menuMatriculas.add(itemMenuMatricularAlunos1);

        barraMenu.add(menuMatriculas);

        menuConsultas.setMnemonic('n');
        menuConsultas.setText("Consultas");

        itemMenualuno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        itemMenualuno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/consulta.png"))); // NOI18N
        itemMenualuno.setText("Aluno");
        menuConsultas.add(itemMenualuno);

        itemMenuTurma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itemMenuTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/consulta.png"))); // NOI18N
        itemMenuTurma.setText("Turmas de Alunos");
        menuConsultas.add(itemMenuTurma);

        barraMenu.add(menuConsultas);

        menuSistema.setMnemonic('s');
        menuSistema.setText("Sistema");

        itemMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        itemMenuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/sobre.png"))); // NOI18N
        itemMenuSobre.setText("Sobre");
        itemMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSobreActionPerformed(evt);
            }
        });
        menuSistema.add(itemMenuSobre);

        itemMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        itemMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/sair.png"))); // NOI18N
        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSairActionPerformed(evt);
            }
        });
        menuSistema.add(itemMenuSair);

        barraMenu.add(menuSistema);

        menuLogof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/logof.png"))); // NOI18N
        menuLogof.setMnemonic('l');
        menuLogof.setText("Logoff");
        menuLogof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogofActionPerformed(evt);
            }
        });

        itemMenuLogoff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemMenuLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Menus/sair.png"))); // NOI18N
        itemMenuLogoff.setText("Sair");
        itemMenuLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuLogoffActionPerformed(evt);
            }
        });
        menuLogof.add(itemMenuLogoff);

        barraMenu.add(menuLogof);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktop)
                    .addComponent(painelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlunosActionPerformed
        desktop.add(frameAlunos);
        frameAlunos.setVisible(true);
    }//GEN-LAST:event_itemMenuAlunosActionPerformed

    private void itemMenuTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuTurmasActionPerformed
        desktop.add(frameTurmas);
        frameTurmas.setVisible(true);
    }//GEN-LAST:event_itemMenuTurmasActionPerformed

    private void itemMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuUsuariosActionPerformed
        desktop.add(frameUsuarios);
        frameUsuarios.setVisible(true);
    }//GEN-LAST:event_itemMenuUsuariosActionPerformed

    private void itemMenuMatricularAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuMatricularAlunosActionPerformed
        desktop.add(frameTurmaAluno);
        frameTurmaAluno.setVisible(true);
    }//GEN-LAST:event_itemMenuMatricularAlunosActionPerformed

    private void itemMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSobreActionPerformed
       frameSobre = new FrameSobre(this,true);
       frameSobre.setLocationRelativeTo(this);
        frameSobre.setVisible(true);
    }//GEN-LAST:event_itemMenuSobreActionPerformed

    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        
        int opcao=JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Mensagem" ,JOptionPane.YES_NO_OPTION );
        if (opcao==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_itemMenuSairActionPerformed

    private void menuLogofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogofActionPerformed
        
    }//GEN-LAST:event_menuLogofActionPerformed

    private void itemMenuMatricularAlunos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuMatricularAlunos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenuMatricularAlunos1ActionPerformed

    private void itemMenuLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuLogoffActionPerformed
       FrameLogin login = new FrameLogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_itemMenuLogoffActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem itemMenuAlunos;
    private javax.swing.JMenuItem itemMenuLogoff;
    private javax.swing.JMenuItem itemMenuMatricularAlunos;
    private javax.swing.JMenuItem itemMenuMatricularAlunos1;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuSobre;
    private javax.swing.JMenuItem itemMenuTurma;
    private javax.swing.JMenuItem itemMenuTurmas;
    private javax.swing.JMenuItem itemMenuUsuarios;
    private javax.swing.JMenuItem itemMenualuno;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuLogof;
    private javax.swing.JMenu menuMatriculas;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JPanel painelStatus;
    // End of variables declaration//GEN-END:variables
}
