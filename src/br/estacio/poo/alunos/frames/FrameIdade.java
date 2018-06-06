/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.alunos.frames;

import javax.swing.JOptionPane;

/**
 *
 * @author Dom
 */
public class FrameIdade extends javax.swing.JDialog {

    /**
     * Creates new form FrameIdade
     */
    FrameAlunos fa;
    public FrameIdade(FrameAlunos f) {
        fa=f;
        setModal(true);
        
        initComponents();
        tfIdadeCalculada.setEditable(false);
    }

        int anoA;
        int anoN;
        int idade;
        String idadeCalc;
    
    public void verificaCampos()
    {
        
        try
        {
            if (lblAnoAtual.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Preencha o campo 'Ano Atual'");
            else if (lblAnoAtual.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Preencha o campo 'Ano de Nascimento'");
            else{

                anoA= Integer.parseInt(tfAnoAtual.getText());
                anoN= Integer.parseInt(tfAnoNasc.getText());
                idade = anoA-anoN;
                idadeCalc = String.valueOf(idade);
                tfIdadeCalculada.setText(idadeCalc);
                
                
                
                }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ops, digite apenas numeros nos campos 'Ano atual'\n"
                                                            + "e 'Ano de Nascimento'");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnoAtual = new javax.swing.JLabel();
        tfAnoAtual = new javax.swing.JTextField();
        lblAnoNasc = new javax.swing.JLabel();
        tfAnoNasc = new javax.swing.JTextField();
        btCalcular = new javax.swing.JButton();
        lblIdadeCalculada = new javax.swing.JLabel();
        tfIdadeCalculada = new javax.swing.JTextField();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAnoAtual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAnoAtual.setText("Ano atual:");

        tfAnoAtual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblAnoNasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAnoNasc.setText("Ano de Nascimento:");

        tfAnoNasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btCalcular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/estacio/poo/alunos/imagens/Botoes/calcular.png"))); // NOI18N
        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        lblIdadeCalculada.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblIdadeCalculada.setText("Idade Calculada:");

        tfIdadeCalculada.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfIdadeCalculada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdadeCalculadaActionPerformed(evt);
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblAnoNasc)
                        .addComponent(lblAnoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblIdadeCalculada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCalcular)
                    .addComponent(tfAnoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdadeCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCalcular, btFechar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfAnoAtual, tfAnoNasc});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfAnoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnoNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGap(16, 16, 16)
                .addComponent(btCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdadeCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdadeCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdadeCalculadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdadeCalculadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdadeCalculadaActionPerformed

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        verificaCampos();
        
    }//GEN-LAST:event_btCalcularActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
       fa.setIdade(tfIdadeCalculada.getText());
       dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel lblAnoAtual;
    private javax.swing.JLabel lblAnoNasc;
    private javax.swing.JLabel lblIdadeCalculada;
    private javax.swing.JTextField tfAnoAtual;
    private javax.swing.JTextField tfAnoNasc;
    private javax.swing.JTextField tfIdadeCalculada;
    // End of variables declaration//GEN-END:variables
}
