package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.CargoDao;
import Model.Cargo;

public class CargoViewConsultar {
    
    public static Cargo cargoAtual;
    
    public static JPanel getCargoViewConsultar(){
        JPanel jPanelCargoViewConsultar = new JPanel();
        jPanelCargoViewConsultar.setLayout(null);
        
        cargoAtual = new Cargo();

        JLabel jLabelTitulo = new JLabel("Consulta de cargos", JLabel.CENTER);
        JLabel jLabelCargo = new JLabel("Nome do cargo", JLabel.LEFT);
        JTextField JTextFieldCargo = new JTextField();
        JButton jButtonPesquisar = new JButton("Pesquisar cargo");
        JButton jButtonEditar = new JButton("Editar cargo");
        JButton jButtonExcluir = new JButton("Excluir cargo");
        DefaultListModel<Cargo> defaultListModelCargos = new DefaultListModel();
        JList<Cargo> jListCargo = new JList();

        criarComponetes(jPanelCargoViewConsultar, jLabelTitulo, jLabelCargo, JTextFieldCargo, jButtonPesquisar, jButtonEditar, jButtonExcluir, defaultListModelCargos, jListCargo, cargoAtual);
        criarEventos   (jPanelCargoViewConsultar, jLabelTitulo, jLabelCargo, JTextFieldCargo, jButtonPesquisar, jButtonEditar, jButtonExcluir, defaultListModelCargos, jListCargo, cargoAtual);

        jPanelCargoViewConsultar.setVisible(true);

        return jPanelCargoViewConsultar;
    }

    private static void criarComponetes(JPanel jPanelCargoViewEditar, JLabel jLabelTitulo, JLabel jLabelCargo,JTextField JTextFieldCargo,JButton jButtonPesquisar,JButton jButtonEditar,JButton jButtonExcluir,DefaultListModel<Cargo> defaultListModelCargos,JList<Cargo> jListCargo, Cargo cargoAtual){
        
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 20) );
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jListCargo.setModel(defaultListModelCargos);
        jListCargo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelCargo.setBounds( 150, 120, 400, 20);
        JTextFieldCargo.setBounds(150, 140, 400, 40);
        jButtonPesquisar.setBounds(560, 140, 130, 40);
        jListCargo.setBounds(150, 200, 400, 240);
        jButtonEditar.setBounds(560,360, 130, 40);
        jButtonExcluir.setBounds(560, 400, 130, 40);
        
        try {
            for (Cargo cargoFor: CargoDao.buscarTodos()) {
                defaultListModelCargos.addElement(cargoFor);
            }
        } catch (Exception e) {
            System.out.println("ERRO NA CONSULTA DOS CARGOS");
        }
        
        jPanelCargoViewEditar.add(jLabelTitulo);
        jPanelCargoViewEditar.add(jLabelCargo);
        jPanelCargoViewEditar.add(JTextFieldCargo);
        jPanelCargoViewEditar.add(jButtonPesquisar);
        jPanelCargoViewEditar.add(jListCargo);
        jPanelCargoViewEditar.add(jButtonEditar);
        jPanelCargoViewEditar.add(jButtonExcluir);

    }

    private static void criarEventos(JPanel jPanelCargoViewEditar, JLabel jLabelTitulo, JLabel jLabelCargo,JTextField JTextFieldCargo,JButton jButtonPesquisar,JButton jButtonEditar,JButton jButtonExcluir,DefaultListModel<Cargo> defaultListModelCargos,JList<Cargo> JListCargo, Cargo cargoAtual){
        jButtonPesquisar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jButtonEditar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("EDITAR: " + CargoViewConsultar.cargoAtual.getDsCargo());
            }
        });

        jButtonExcluir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("EXCLUIR: "+ CargoViewConsultar.cargoAtual.getDsCargo());
            }
        });

        JListCargo.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                CargoViewConsultar.cargoAtual = JListCargo.getSelectedValue();
                if(cargoAtual == null){
                    jButtonEditar.setEnabled(false);
                    jButtonExcluir.setEnabled(false);
                }else{
                    jButtonEditar.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                }
                
            }
            
        });

    }

}
