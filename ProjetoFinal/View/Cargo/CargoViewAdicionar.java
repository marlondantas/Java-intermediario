package View.Cargo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.CargoDao;
import Model.Cargo;

public class CargoViewAdicionar{
    
    public static JPanel getCargoViewAdicionar(){
        JPanel jPanelCargoView = new JPanel();
        jPanelCargoView.setLayout(null);

        JLabel jLabelTitulo =  new JLabel("Cadastro de cargo",JLabel.CENTER);;
        JLabel jLabelCargo = new JLabel("Nome do cargo",JLabel.LEFT);;
        JTextField jTextFieldCargo = new JTextField();
        JButton jButtonGravar =  new JButton("Adicionar cargo");;

        criarComponetes(jPanelCargoView, jLabelTitulo, jLabelCargo, jTextFieldCargo, jButtonGravar);
        
        System.out.println("Componentes criados");

        criarEventos(jPanelCargoView, jLabelTitulo, jLabelCargo, jTextFieldCargo, jButtonGravar);

        jPanelCargoView.setVisible(true);

        return jPanelCargoView;
    }

    private static void criarComponetes(JPanel jPanelCargoView,JLabel jLabelTitulo, JLabel jLabelCargo,JTextField jTextFieldCargo, JButton jButtonGravar ){
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 20) );
        
        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelCargo.setBounds(150, 120, 400, 20);
        jTextFieldCargo.setBounds(150, 140, 400, 40);
        jButtonGravar.setBounds(250, 380, 200, 40);
        
        //jTextFieldCargo
        jTextFieldCargo.setText("MEU TEXTO TESTE");

        jPanelCargoView.add(jLabelTitulo);
        jPanelCargoView.add(jLabelCargo);
        jPanelCargoView.add(jTextFieldCargo);
        jPanelCargoView.add(jButtonGravar);

    }
    
    private static void criarEventos(JPanel jPanelCargoView,JLabel jLabelTitulo, JLabel jLabelCargo,JTextField jTextFieldCargo, JButton jButtonGravar ){
        jButtonGravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jTextFieldCargo.getText().isEmpty()){                
                    try {
                        CargoDao.criarCargo(jTextFieldCargo.getText());
                        jTextFieldCargo.setText("");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        System.out.println("ERRO: " + e1.getMessage());
                    }
                }else{
                    System.out.println("CAMPO VAZIO!");
                }
            }
        });
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

}
