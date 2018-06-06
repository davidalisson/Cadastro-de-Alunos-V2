/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.main;

import br.estacio.poo.alunos.frames.FrameLogin;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fic
 */
public class CadastroAlunos {
    public static void main (String args[])
    {
        //JOptionPane.showMessageDialog(null, "Bem vindo ao Cadastro de Alunos");
         FrameLogin frame = new FrameLogin();
         frame.setVisible(true);
            
        try {  
            for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) 
            {  
                if ( "Windows".equals( info.getName() ) ) {  
                    UIManager.setLookAndFeel( info.getClassName() );  

                    break;  
                }  
            }  
        } catch ( UnsupportedLookAndFeelException exc ) {  
            exc.printStackTrace();  
        } catch ( ClassNotFoundException exc ) {  
            exc.printStackTrace();  
        } catch ( InstantiationException exc ) {  
            exc.printStackTrace();  
        } catch ( IllegalAccessException exc ) {  
            exc.printStackTrace();  
        }  
    }
}

    