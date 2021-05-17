package View.Funcionario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.*;

import Model.Funcionario;

public class FuncionarioViewEditar {
    
    private static Funcionario funcionarioAtual;

    public static JPanel getFuncionarioViewEditar(Funcionario funcionarioAtual){
        JPanel jPanelFuncionarioViewEditar = new JPanel();
        jPanelFuncionarioViewEditar.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Editação de funcionario", JLabel.CENTER);
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
        JButton jButtonGravar = new JButton("Salvar");

        criarComponetes(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);
        criarEventos(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);

        carregarDados(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar, funcionarioAtual);
        
        jPanelFuncionarioViewEditar.setVisible(true);
        return jPanelFuncionarioViewEditar;
    }

    private static void criarComponetes(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar ){
        
        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelNome.setBounds(150, 80, 400, 20);
        jTextFieldNome.setBounds(150, 100, 400, 40);
        jLabelSobrenome.setBounds(150, 140, 400, 20);
        jTextFieldSobrenome.setBounds(150, 160, 400, 40);
        jLabelDataNascimento.setBounds(150, 200, 400, 20);
        fieldFormattedTextFieldDataNascimento.setBounds(150, 220, 400, 40);
        jLabelEmail.setBounds(150, 260, 400, 20);
        jTextFieldEmail.setBounds(150, 280, 400, 40);
        jLabelCargo.setBounds(150, 320, 400, 20);
        jComboBoxCargo.setBounds(150, 340, 400, 40);
        jLabelSalario.setBounds(150, 380, 400, 20);
        formattedTextFieldSalario.setBounds(150, 400, 400, 40);
        jButtonGravar.setBounds(560, 400, 130, 40);

        jPanelFuncionarioViewEditar.add(jLabelTitulo);
        jPanelFuncionarioViewEditar.add(jLabelNome);
        jPanelFuncionarioViewEditar.add(jTextFieldNome);
        jPanelFuncionarioViewEditar.add(jLabelSobrenome);
        jPanelFuncionarioViewEditar.add(jTextFieldSobrenome);
        jPanelFuncionarioViewEditar.add(jLabelDataNascimento);
        jPanelFuncionarioViewEditar.add(fieldFormattedTextFieldDataNascimento);
        jPanelFuncionarioViewEditar.add(jLabelEmail);
        jPanelFuncionarioViewEditar.add(jTextFieldEmail);
        jPanelFuncionarioViewEditar.add(jLabelCargo);
        jPanelFuncionarioViewEditar.add(jComboBoxCargo);
        jPanelFuncionarioViewEditar.add(jLabelSalario);
        jPanelFuncionarioViewEditar.add(formattedTextFieldSalario);
        jPanelFuncionarioViewEditar.add(jButtonGravar);

    }
    
    private static void criarEventos(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar ){

    }

    private static void carregarDados(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar, Funcionario funcionarioAtual){

        jTextFieldNome.setText(funcionarioAtual.getNomaFuncionario());
        jTextFieldSobrenome.setText(funcionarioAtual.getSobrenomeFuncionario());
        jTextFieldEmail.setText(funcionarioAtual.getDsEmail());

        fieldFormattedTextFieldDataNascimento.setText(funcionarioAtual.getDataNascimento().toString());

        //carregar os cargos -> jComboBoxCargo

        formattedTextFieldSalario.setText(funcionarioAtual.getVlSalario().toString());

    }

}
