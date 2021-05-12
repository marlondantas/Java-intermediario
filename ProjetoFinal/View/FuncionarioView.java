package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Funcionario;
import Controller.CargoDao;
import Controller.Conn;
import Controller.FuncionarioDao;

public class FuncionarioView {

    public static JPanel jPanel;
    public static JFrame jFrame;

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
