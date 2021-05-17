package View.Funcionario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.FuncionarioDao;
import Model.Funcionario;
import View.SistemaView;

public class FuncionarioViewConsultar {

    public static Funcionario funcionarioAtual;

    public static JPanel getCargoViewConsultar(){
        JPanel jPanelFuncionarioViewConsultar = new JPanel();
        jPanelFuncionarioViewConsultar.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Consulta  de Funcionarios",JLabel.CENTER);
        JLabel jLabelFuncionario = new JLabel("Nome do Funcionario", JLabel.LEFT);
        JTextField jTextFieldFuncionario = new JTextField();
        JButton jButtonPesquisar = new JButton("Pesquisa Funcionario");
        JButton jButtonEditar = new JButton("Editar Funcionario");
        JButton jButtonExcluir = new JButton("Excluir Funcionario");

        DefaultListModel<Funcionario> defaultListModelFuncionario = new DefaultListModel();
        JList<Funcionario> jListFuncionario = new JList<>();

        criarComponetes(jPanelFuncionarioViewConsultar, jLabelTitulo, jLabelFuncionario, jTextFieldFuncionario, jButtonPesquisar, jButtonEditar, jButtonExcluir, defaultListModelFuncionario, jListFuncionario);
        criarEventos(jPanelFuncionarioViewConsultar, jLabelTitulo, jLabelFuncionario, jTextFieldFuncionario, jButtonPesquisar, jButtonEditar, jButtonExcluir, defaultListModelFuncionario, jListFuncionario);

        jPanelFuncionarioViewConsultar.setVisible(true);
        return jPanelFuncionarioViewConsultar;
    }

    private static void criarComponetes( JPanel jPanelFuncionarioViewConsultar, JLabel jLabelTitulo, JLabel jLabelFuncionario, JTextField jTextFieldFuncionario, JButton jButtonPesquisar, JButton jButtonEditar,JButton jButtonExcluir, DefaultListModel<Funcionario> defaultListModelFuncionario, JList<Funcionario> jListFuncionario){

        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(), Font.PLAIN,20));
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jListFuncionario.setModel(defaultListModelFuncionario);
        jListFuncionario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        atualizarLista(defaultListModelFuncionario);

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelFuncionario.setBounds(150, 120, 400, 20);
        jTextFieldFuncionario.setBounds(150, 140, 400, 40);
        jButtonPesquisar.setBounds(560, 140, 130, 40);
        jListFuncionario.setBounds(150, 200, 400, 240);
        jButtonEditar.setBounds(560, 360, 130, 40);
        jButtonExcluir.setBounds(560, 400, 130, 40);

        jPanelFuncionarioViewConsultar.add(jLabelTitulo);
        jPanelFuncionarioViewConsultar.add(jLabelFuncionario);
        jPanelFuncionarioViewConsultar.add(jTextFieldFuncionario);
        jPanelFuncionarioViewConsultar.add(jButtonPesquisar);
        jPanelFuncionarioViewConsultar.add(jListFuncionario);
        jPanelFuncionarioViewConsultar.add(jButtonEditar);
        jPanelFuncionarioViewConsultar.add(jButtonExcluir);


    }

    private static void criarEventos(JPanel jPanelFuncionarioViewConsultar, JLabel jLabelTitulo, JLabel jLabelFuncionario, JTextField jTextFieldFuncionario, JButton jButtonPesquisar, JButton jButtonEditar,JButton jButtonExcluir, DefaultListModel<Funcionario> defaultListModelFuncionario, JList<Funcionario> jListFuncionario){

        jButtonPesquisar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pesquisar por like
            }
        });

        jButtonEditar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SistemaView.funcionarioEditar(FuncionarioViewConsultar.funcionarioAtual);
                return;
                //System.out.println("EDITAR: " + CargoViewConsultar.cargoAtual.getDsCargo());
            }
        });

        jButtonExcluir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    FuncionarioDao.excluirFuncionario(FuncionarioViewConsultar.funcionarioAtual.getIdFuncionario());
                    atualizarLista(defaultListModelFuncionario);
                    JOptionPane.showMessageDialog(null,"Apagado com sucesso!");

                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null,"Aconteceu um erro");
                    System.out.println("FuncionarioViewConsultar > jButtonExcluir.addActionListener > Erro:\n" + ee.getMessage());
                    //TODO: handle exception
                }


                //System.out.println("EXCLUIR: "+ CargoViewConsultar.cargoAtual.getDsCargo());
            }
        });
        
        jListFuncionario.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                FuncionarioViewConsultar.funcionarioAtual = jListFuncionario.getSelectedValue();
                if(funcionarioAtual == null){
                    jButtonEditar.setEnabled(false);
                    jButtonExcluir.setEnabled(false);
                }else{
                    jButtonEditar.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                }
                
            }
            
        });
    }

    private static void atualizarLista(DefaultListModel<Funcionario> defaultListModelFuncionario){

        defaultListModelFuncionario.clear();
        try {
            for (Funcionario funcionarioFor : FuncionarioDao.buscarTodos()) {
                defaultListModelFuncionario.addElement(funcionarioFor);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

}
