package View;

import javax.swing.*;
import java.awt.*;

public class LoginView{
      
    public static JPanel getLoginView(){
        JPanel jPanelLoginView = new JPanel();
        jPanelLoginView.setLayout(null);

        JLabel jLabelTitulo =  new JLabel("Seja bem vindo ao sistema de company SA!", JLabel.CENTER);
        JLabel jLabelUsuario = new JLabel("Usuário", JLabel.LEFT);
        JTextField jTextFieldUsuario = new JTextField();
        JLabel jLabelSenha = new JLabel("Senha", JLabel.LEFT);
        JTextField jTextFieldSenha = new JTextField();
        JButton jButtonEntrar = new JButton("Entrar");

        criarComponetes(jPanelLoginView,jLabelTitulo,jLabelUsuario,jTextFieldUsuario,jLabelSenha,jTextFieldSenha, jButtonEntrar);
        criarEventos(jPanelLoginView,jLabelTitulo,jLabelUsuario,jTextFieldUsuario,jLabelSenha,jTextFieldSenha, jButtonEntrar);

        return jPanelLoginView;
    }

    private static void criarComponetes(JPanel jPanelLoginView, JLabel jLabelTitulo,JLabel jLabelUsuario,JTextField jTextFieldUsuario,JLabel jLabelSenha, JTextField jTextFieldSenha, JButton jButtonEntrar){
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 18) );

        jLabelTitulo.setBounds(20,100,660,40);
        jLabelUsuario.setBounds(250,220,200,20);
        jTextFieldUsuario.setBounds(250,240,200,40);
        jLabelSenha.setBounds(250,280,200,20);
        jTextFieldSenha.setBounds(250, 300, 200, 40);
        jButtonEntrar.setBounds(250, 350, 200, 40);

        jPanelLoginView.add(jLabelTitulo);
        jPanelLoginView.add(jLabelUsuario);
        jPanelLoginView.add(jTextFieldUsuario);
        jPanelLoginView.add(jLabelSenha);
        jPanelLoginView.add(jTextFieldSenha);
        jPanelLoginView.add(jButtonEntrar);

        //jPanelLoginView.setVisible(true);
    }

    private static void criarEventos(JPanel jPanelLoginView, JLabel jLabelTitulo,JLabel jLabelUsuario,JTextField jTextFieldUsuario,JLabel jLabelSenha, JTextField jTextFieldSenha, JButton jButtonEntrar){
        
    }

}
