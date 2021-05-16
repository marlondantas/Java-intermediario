package View.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

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

        JLabel jLabelDataNascimento = new JLabel("Data de nascimento: ",JLabel.LEFT);
        JFormattedTextField fieldFormattedTextFieldDataNascimento = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));

        JLabel jLabelEmail = new JLabel("E-mail: ", JLabel.LEFT);
        JTextField jTextFieldEmail  = new JTextField();
        JLabel jLabelCargo = new JLabel("Cargo: ",JLabel.LEFT);
        JComboBox jComboBoxCargo = new JComboBox();

        JLabel jLabelSalario = new JLabel("Salario: ", JLabel.LEFT);

        JFormattedTextField formattedTextFieldSalario = new  JFormattedTextField(new DecimalFormat("###0.00",new DecimalFormatSymbols(new Locale("pt","BR"))));

        JButton jButtonGravar = new JButton("Adicionar");

        criarComponetes(jPanelFuncionarioView, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome,jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);
        criarEventos(jPanelFuncionarioView, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome,jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);

        jPanelFuncionarioView.setVisible(true);

        return jPanelFuncionarioView;

    }

    private static void criarComponetes(JPanel jPanelFuncionarioView , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar ){
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 20) );
        formattedTextFieldSalario.setValue(0.00);

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelNome.setBounds(150, 80, 400, 20);
        jTextFieldNome.setBounds(150, 100, 400, 40);
        jLabelSobrenome.setBounds(150, 140, 400, 20);
        jTextFieldSobrenome.setBounds(150, 160, 400, 40);
        jLabelDataNascimento.setBounds(150,200,400,20);
        fieldFormattedTextFieldDataNascimento.setBounds(150, 220, 400, 40);
        jLabelEmail.setBounds(150, 260, 400, 20);
        jTextFieldEmail.setBounds(150, 280, 400, 40);
        jLabelCargo.setBounds(150, 320, 400,20);
        jComboBoxCargo.setBounds(150, 340, 400, 40);
        jLabelSalario.setBounds(150, 380, 400, 20);
        formattedTextFieldSalario.setBounds(150, 400, 400, 40);
        jButtonGravar.setBounds(560, 400, 130, 40);

        jPanelFuncionarioView.add(jLabelTitulo);
        jPanelFuncionarioView.add(jLabelNome);
        jPanelFuncionarioView.add(jTextFieldNome);
        jPanelFuncionarioView.add(jLabelSobrenome);
        jPanelFuncionarioView.add(jTextFieldSobrenome);
        jPanelFuncionarioView.add(jLabelDataNascimento);
        jPanelFuncionarioView.add(fieldFormattedTextFieldDataNascimento);
        jPanelFuncionarioView.add(jLabelEmail);
        jPanelFuncionarioView.add(jTextFieldEmail);
        jPanelFuncionarioView.add(jLabelCargo);
        jPanelFuncionarioView.add(jComboBoxCargo);
        jPanelFuncionarioView.add(jLabelSalario);
        jPanelFuncionarioView.add(formattedTextFieldSalario);
        jPanelFuncionarioView.add(jButtonGravar);

    }

    private static void criarEventos(JPanel jPanelFuncionarioView , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar){

    }


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
