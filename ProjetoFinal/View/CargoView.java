package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.CargoDao;
import Model.Cargo;

public class CargoView{
    
    public static JPanel jPanel;
    public static JFrame jFrame;
    

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

        //JTextField 
        JTextField jTextFieldID = new JTextField(30);
        jTextFieldID.setBounds(150, 10, 50, 50);


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
        jPanel.add(jTextFieldID);

        jFrame.setContentPane(jPanel);

        return jFrame;
    }

    public static void testComponetes(){
        
        System.out.println("testComponetes");
        testarCargo("null");
        

    }

    private static void testarCargo(String dsCargo){
        System.out.println("SalvarCargo: " + dsCargo);
        try {
            Cargo cargo = CargoDao.criarCargo(dsCargo);

            System.out.println(cargo.toString());

            cargo = CargoDao.buscarPorID(cargo.getIdCargo());

            cargo.setDsCargo("dsCargo");
            cargo = CargoDao.editarCargo(cargo);

            System.out.println(cargo.toString());

            //CargoDao.excluirCargo(cargo.getIdCargo());

            ArrayList<Cargo> todosCargos = CargoDao.buscarTodos();

            for (Cargo cargoFor: todosCargos) {
                System.out.println(cargoFor.toString());
            }

        } catch (Exception e) {
            //TODO: handle exception
        }

    }

    private static void SalvarCargo(String dsCargo){
        System.out.println("SalvarCargo: " + dsCargo);
        try {
            Cargo cargo = CargoDao.criarCargo(dsCargo);

            System.out.println(cargo.toString());

            cargo = CargoDao.buscarPorID(cargo.getIdCargo());

            cargo.setDsCargo("dsCargo");
            cargo = CargoDao.editarCargo(cargo);

            System.out.println(cargo.toString());

            CargoDao.excluirCargo(cargo.getIdCargo());

            ArrayList<Cargo> todosCargos = CargoDao.buscarTodos();

            for (Cargo cargoFor: todosCargos) {
                System.out.println(cargoFor.toString());
            }

        } catch (Exception e) {
            //TODO: handle exception
        }

    }

}
