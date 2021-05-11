package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.CargoDao;

public class CargoView{
    
    public static JPanel jPanel;
    public static JFrame jFrame;
    public static CargoDao cargoDao;

    public static JFrame criarComponetes(Statement instrucaoSQL){
        
        cargoDao = new CargoDao(instrucaoSQL);

        jFrame = new JFrame("Cargo");
        jFrame.setSize(500,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        jPanel = new JPanel();
        jPanel.setOpaque(true);
        jPanel.setBackground(Color.WHITE);
        jPanel.setLayout(null);

        //Campos para (editar, gravar, excluir) de nome do cargo
        
        //jLabel
        JLabel jLabelDescricao = new JLabel("Descricao:" , JLabel.CENTER);
        jLabelDescricao.setBounds(10, 10, 100, 50);
        jLabelDescricao.setLocation(10, 10);

        //JTextField 
        JTextField jTextFieldDescricao = new JTextField(30);
        jTextFieldDescricao.setBounds(200, 10, 100, 50);
        
        jLabelDescricao.setLabelFor(jTextFieldDescricao);

        JButton jButtonSalvar = new JButton("Salvar");
        jButtonSalvar.setSize(460, 50);
        jButtonSalvar.setLocation(10, 150);

        jButtonSalvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               SalvarCargo(jTextFieldDescricao.getText());      
            }
        });

        //lista dos nomes atuais, com id para excluir
        
        //add no jFrame
        jPanel.add(jLabelDescricao);
        jPanel.add(jTextFieldDescricao);
        jPanel.add(jButtonSalvar);

        jFrame.setContentPane(jPanel);

        return jFrame;
    }

    private static void SalvarCargo(String dsCargo){
        System.out.println("SalvarCargo: " + dsCargo);

        try {
            cargoDao.buscarTodos();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
