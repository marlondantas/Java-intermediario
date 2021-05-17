package View.Cargo;

import java.awt.Font;
import javax.swing.*;

import Model.Cargo;

public class CargoViewEditar {
    
    private static Cargo cargoAtual;

    public static JPanel getCargoViewEditar(Cargo cargoAtual){

        CargoViewEditar.cargoAtual = cargoAtual;

        JPanel jPanelCargoViewEditar = new JPanel();
        jPanelCargoViewEditar.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Editar cargos",JLabel.CENTER);
        JLabel jLabelCargo = new JLabel("Nome do cargo",JLabel.LEFT);
        JTextField  jTextFieldDescricao = new JTextField();
        JButton jButtonSalvar = new JButton("Salvar");

        criarComponetes(jPanelCargoViewEditar, jLabelTitulo, jLabelCargo, jTextFieldDescricao, jButtonSalvar);
        criarEventos(jPanelCargoViewEditar,jLabelTitulo, jLabelCargo, jTextFieldDescricao, jButtonSalvar);
        carregarDados(jPanelCargoViewEditar, jLabelTitulo, jLabelCargo, jTextFieldDescricao, jButtonSalvar, cargoAtual);
        
        return jPanelCargoViewEditar;
    }

    private static void criarComponetes(JPanel jPanelCargoViewEditar, JLabel jLabelTitulo, JLabel jLabelCargo, JTextField  jTextFieldDescricao, JButton jButtonSalvar){
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 20) );

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelCargo.setBounds(150, 120, 400, 20);
        jTextFieldDescricao.setBounds(150, 140, 400, 40);
        jButtonSalvar.setBounds(250, 380, 200, 40);

        jPanelCargoViewEditar.add(jLabelTitulo);
        jPanelCargoViewEditar.add(jLabelCargo);
        jPanelCargoViewEditar.add(jTextFieldDescricao);
        jPanelCargoViewEditar.add(jButtonSalvar);

        jPanelCargoViewEditar.setVisible(true);
    }

    private static void criarEventos(JPanel jPanelCargoViewEditar, JLabel jLabelTitulo, JLabel jLabelCargo, JTextField  jTextFieldDescricao, JButton jButtonSalvar){

    }

    private static void carregarDados(JPanel jPanelCargoViewEditar, JLabel jLabelTitulo, JLabel jLabelCargo, JTextField  jTextFieldDescricao, JButton jButtonSalvar,Cargo cargoAtual){

        jTextFieldDescricao.setText(cargoAtual.getDsCargo());

    }

}
