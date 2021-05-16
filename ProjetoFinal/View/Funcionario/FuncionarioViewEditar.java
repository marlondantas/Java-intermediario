package View.Funcionario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.*;

import Model.Funcionario;

public class FuncionarioViewEditar {
    
    public Funcionario funcionario;

    public static JPanel getFuncionarioViewEditar(){
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

        criarComponetes(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);
        criarEventos(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar);

        jPanelFuncionarioViewEditar.setVisible(true);
        return jPanelFuncionarioViewEditar;
    }

    private static void criarComponetes(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar ){

    }
    
    private static void criarEventos(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar ){

    }

}
