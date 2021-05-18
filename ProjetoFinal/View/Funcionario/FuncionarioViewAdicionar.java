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

public class FuncionarioViewAdicionar {

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

        DefaultComboBoxModel<Cargo> defaultListModelCargo = new DefaultComboBoxModel();
        JComboBox jComboBoxCargo = new JComboBox();

        JLabel jLabelSalario = new JLabel("Salario: ", JLabel.LEFT);

        JFormattedTextField formattedTextFieldSalario = new  JFormattedTextField(new DecimalFormat("###0.00",new DecimalFormatSymbols(new Locale("pt","BR"))));

        JButton jButtonGravar = new JButton("Adicionar");

        criarComponetes(jPanelFuncionarioView, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome,jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar,defaultListModelCargo);
        criarEventos(jPanelFuncionarioView, jLabelTitulo, jLabelNome, jTextFieldNome, jLabelSobrenome, jTextFieldSobrenome,jLabelDataNascimento, fieldFormattedTextFieldDataNascimento, jLabelEmail, jTextFieldEmail, jLabelCargo, jComboBoxCargo, jLabelSalario, formattedTextFieldSalario, jButtonGravar, defaultListModelCargo);

        jPanelFuncionarioView.setVisible(true);

        return jPanelFuncionarioView;

    }

    private static void criarComponetes(JPanel jPanelFuncionarioView , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar,DefaultComboBoxModel<Cargo> defaultListModelCargo ){
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 20) );
        formattedTextFieldSalario.setValue(0.00);

        jComboBoxCargo.setModel(defaultListModelCargo);

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

        try {
            for (Cargo cargoFor : CargoDao.buscarTodos()) {
                jComboBoxCargo.addItem(cargoFor);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


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

    private static void criarEventos(JPanel jPanelFuncionarioView , JLabel jLabelTitulo,  JLabel jLabelNome, JTextField jTextFieldNome, JLabel jLabelSobrenome,  JTextField jTextFieldSobrenome,JLabel jLabelDataNascimento,JFormattedTextField fieldFormattedTextFieldDataNascimento,  JLabel jLabelEmail, JTextField jTextFieldEmail, JLabel jLabelCargo,  JComboBox jComboBoxCargo,  JLabel jLabelSalario,   JFormattedTextField formattedTextFieldSalario, JButton jButtonGravar, DefaultComboBoxModel<Cargo> defaultListModelCargo){
        jButtonGravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jTextFieldNome.getText().isEmpty()){                
                    Funcionario funcionarioNovo = new Funcionario();
                    
                    funcionarioNovo.setNomaFuncionario(jTextFieldNome.getText());
                    funcionarioNovo.setSobrenomeFuncionario(jTextFieldSobrenome.getText());
                    funcionarioNovo.setDsEmail(jTextFieldEmail.getText());
                    
                    DateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;

                    try {
                        date = new Date( formatter.parse(fieldFormattedTextFieldDataNascimento.getText()).getTime() );
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    funcionarioNovo.setDataNascimento(date);
                    
                    funcionarioNovo.setCargo((Cargo) jComboBoxCargo.getSelectedItem());

                    formattedTextFieldSalario.setText(formattedTextFieldSalario.getText().replace(",", ".")); 
                    System.out.println("VALOR DE SALARIO");

                    funcionarioNovo.setVlSalario(Double.parseDouble(formattedTextFieldSalario.getText()));

                    try {
                        funcionarioNovo = FuncionarioDao.criarFuncionario(funcionarioNovo);
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
