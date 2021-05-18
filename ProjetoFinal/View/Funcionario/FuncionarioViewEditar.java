package View.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Model.Cargo;
import Model.Funcionario;
import View.SistemaView;
import Controller.CargoDao;
import Controller.FuncionarioDao;

public class FuncionarioViewEditar {
    
    private static Funcionario funcionarioAtual;

    public static JPanel getFuncionarioViewEditar(Funcionario funcionarioAtual){
        FuncionarioViewEditar.funcionarioAtual = funcionarioAtual;

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

        DefaultComboBoxModel<Cargo> defaultListModelCargo = new DefaultComboBoxModel();
        JComboBox jComboBoxCargo = new JComboBox();

        JLabel jLabelSalario = new JLabel("Salario: ", JLabel.LEFT);

        JFormattedTextField formattedTextFieldSalario = new  JFormattedTextField(new DecimalFormat("###0.00",new DecimalFormatSymbols(new Locale("pt","BR"))));
        JButton jButtonGravar = new JButton("Salvar");

        criarComponetes(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar,defaultListModelCargo);
        criarEventos(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar,defaultListModelCargo);

        carregarDados(jPanelFuncionarioViewEditar, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome, jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar, funcionarioAtual);
        
        jPanelFuncionarioViewEditar.setVisible(true);
        return jPanelFuncionarioViewEditar;
    }

    private static void criarComponetes(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar, DefaultComboBoxModel<Cargo> defaultListModelCargo ){
        
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

        jComboBoxCargo.setModel(defaultListModelCargo);

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
    
    private static void criarEventos(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar,DefaultComboBoxModel<Cargo> defaultListModelCargo){
        jButtonGravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jTextFieldNome.getText().isEmpty()){                
                    FuncionarioViewEditar.funcionarioAtual.setNomaFuncionario(jTextFieldNome.getText());
                    FuncionarioViewEditar.funcionarioAtual.setSobrenomeFuncionario(jTextFieldSobrenome.getText());
                    FuncionarioViewEditar.funcionarioAtual.setDsEmail(jTextFieldEmail.getText());
                    
                    DateFormat  formatter = new SimpleDateFormat("yyyy-mm-dd");
                    Date date = null;

                    try {
                        date = new Date( formatter.parse(fieldFormattedTextFieldDataNascimento.getText()).getTime() );
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    FuncionarioViewEditar.funcionarioAtual.setDataNascimento(date);
                    
                    FuncionarioViewEditar.funcionarioAtual.setCargo((Cargo) jComboBoxCargo.getSelectedItem());

                    formattedTextFieldSalario.setText(formattedTextFieldSalario.getText().replace(",", ".")); 
                    FuncionarioViewEditar.funcionarioAtual.setVlSalario(Double.parseDouble(formattedTextFieldSalario.getText()));

                    try {
                        FuncionarioViewEditar.funcionarioAtual = FuncionarioDao.editarFuncionario(FuncionarioViewEditar.funcionarioAtual);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    SistemaView.inicio(true);

                }else{
                    System.out.println("CAMPO VAZIO!");
                }
            }
        });
    }

    private static void carregarDados(JPanel jPanelFuncionarioViewEditar , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar, Funcionario funcionarioAtual){

        jTextFieldNome.setText(funcionarioAtual.getNomaFuncionario());
        jTextFieldSobrenome.setText(funcionarioAtual.getSobrenomeFuncionario());
        jTextFieldEmail.setText("TESTE");
        jTextFieldEmail.setText(funcionarioAtual.getDsEmail());

        fieldFormattedTextFieldDataNascimento.setText(funcionarioAtual.getDataNascimento().toString());

        
        //carregar os cargos -> jComboBoxCargo
        try {
            for (Cargo cargoFor : CargoDao.buscarTodos()) {
                jComboBoxCargo.addItem(cargoFor);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        int totalItems = jComboBoxCargo.getItemCount();

        for (int i = 0; i < totalItems; i++) {
            Cargo cargoFor = (Cargo) jComboBoxCargo.getItemAt(i);
            if( cargoFor.getIdCargo() == funcionarioAtual.getCargo().getIdCargo()){
                jComboBoxCargo.setSelectedIndex(i);
                break;
            }
        }

        formattedTextFieldSalario.setText(funcionarioAtual.getVlSalario().toString());
    }

}
