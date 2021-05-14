package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Funcionario;
import Controller.FuncionarioDao;

public class FuncionarioView {

    public static JPanel getFuncionarioView(){
        JPanel jPanelFuncionarioView = new JPanel();
        jPanelFuncionarioView.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Cadastro de funcionario", JLabel.CENTER);
        JLabel jLabelNome = new JLabel("Nome: ", JLabel.LEFT);
        JTextField jTextFieldNome  = new JTextField();
        JLabel jLabelSobrenome = new JLabel("Sobrenome: ",JLabel.LEFT);
        JTextField jTextFieldSobrenome = new JTextField();

        JFormattedTextField fieldFormattedTextFieldDataNascimento = new JFormattedTextField();

        JLabel jLabelEmail = new JLabel("E-mail: ", JLabel.LEFT);
        JTextField jTextFieldEmail  = new JTextField();
        JLabel jLabelCargo = new JLabel("Cargo: ",JLabel.LEFT);
        JComboBox jComboBoxCargo = new JComboBox();

        JLabel jLabelSalario = new JLabel("Salario: ", JLabel.LEFT);

        JFormattedTextField formattedTextFieldSalario = new  JFormattedTextField();

        JButton jButtonGravar = new JButton("Adicionar");


        return jPanelFuncionarioView;

    }

    private static void criarComponetes(){}
    private static void criarEventos(){}


    public static void testarComponentes(){
        try {
            testarFuncionario();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void testarFuncionario() throws SQLException{
        System.out.println("SalvarFuncionario: ");
        Funcionario funcionario = new Funcionario();

        funcionario.setNomaFuncionario("SUPERnomaFuncionario");
        funcionario.setSobrenomeFuncionario("nomaFuncionario");
        funcionario.setDsEmail("dsEmail");
        funcionario.setVlSalario(111.00);

        long millis=System.currentTimeMillis(); 
        Date data = new Date(millis);

        funcionario.setDataNascimento(data);
        funcionario.setCargo(CargoDao.buscarPorID(1));

        funcionario = FuncionarioDao.criarFuncionario(funcionario);

        ArrayList<Funcionario> FuncionarioTodos = new ArrayList<>();

        FuncionarioTodos = FuncionarioDao.buscarTodos();

        for(Funcionario funcionarioFor: FuncionarioTodos){
            System.out.println(funcionarioFor.toString());
        }

        FuncionarioDao.excluirFuncionario(5);
        
    }
}
