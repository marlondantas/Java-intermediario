package quatro;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class InterfaceGrafica {
    public static void main(String[] args) {
        
        int largura = 100;
        int altura = 50;
        int eixoX = 10;
        int eixoY = 10;

        //JFrame
        JFrame jframe = new JFrame("InterfaceGrafica MAIN");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 1500);
        jframe.setLayout(null);


        //JMenuBar
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jmenu = new JMenu("Menu");
        JMenuItem jmenuItem = new JMenuItem("INICIO");

        jmenu.add(jmenuItem);
        jMenuBar.add(jmenu);

        jframe.setJMenuBar(jMenuBar);

        //JTextArea
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(eixoX, eixoY, largura, altura);
        
        jframe.add(jTextArea);
        eixoY = eixoY + 50;
        
        //JLabel
        JLabel jLabel = new JLabel("ALOHA WORLD",JLabel.CENTER);
        jLabel.setBounds(eixoX, eixoY, largura, altura);

        jLabel.setText("ALOHA WORLD");

        jframe.add(jLabel); 
        eixoY = eixoY + 50;

        //JCheckBox
        JCheckBox jCheckBox = new JCheckBox("checkbox");
        jCheckBox.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jCheckBox);
        eixoY = eixoY + 50;

        //JTextField
        JTextField jTextField = new JTextField();
        jTextField.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jTextField);
        eixoY = eixoY + 50;

        //JPasswordField
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jPasswordField);
        eixoY = eixoY + 50;

        //JButton
        JButton jButton = new JButton("botao");
        jButton.setBounds(eixoX, eixoY, largura, altura);
        
        jButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(null,"ALOHA WORLD");
            } 
          } );


        jframe.add(jButton);
        eixoY = eixoY + 50;

        //JRadioButton
        JRadioButton jRadioButton = new JRadioButton("radioButton");
        jRadioButton.setBounds(eixoX, eixoY, largura, altura);
        
        jframe.add(jRadioButton);
        eixoY = eixoY + 50;

        //JList
        String[] itens = new String[2];
        
        itens[0] = "ITEM 1";
        itens[1] = "ITEM 2";

        JList jList = new JList(itens);
        jList.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jList);
        eixoY = eixoY + 50;

        //JComboBox
        JComboBox jComboBox = new JComboBox(itens);
        jComboBox.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jComboBox);
        eixoY = eixoY + 50;

        //JOptionPane
        //JOptionPane.showMessageDialog(null,"ALOHA WORLD");

        //JScrollBar
        JScrollBar jScrollBar = new JScrollBar(JScrollBar.HORIZONTAL,50,1,0,100);
        jScrollBar.setBounds(eixoX, eixoY, largura, altura);

        jframe.add(jScrollBar);
        eixoY = eixoY + 50;

        //JProgressBar
        JProgressBar jProgressBar = new JProgressBar(JProgressBar.HORIZONTAL,1,100);
        jProgressBar.setBounds(eixoX, eixoY, largura, altura);
        jProgressBar.setValue(50);

        jframe.add(jProgressBar);
        eixoY = eixoY + 50;

        //JFileChooser
        JFileChooser jFileChooser = new JFileChooser();

        // int retorno = jFileChooser.showOpenDialog(null);

        // if(retorno == JFileChooser.APPROVE_OPTION){
        //     File file = jFileChooser.getSelectedFile();
        //     System.out.println("ARQUIVO ENCONTRADO: \n" + file.getPath());
        // }else{
        //     System.out.println("NENHUM ARQUIVO ENCONTRADO");
        // }


        jframe.setVisible(true);

    }
}
