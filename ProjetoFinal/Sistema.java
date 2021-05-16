
import javax.swing.JFrame;

import Controller.Conn;

import View.*;
import View.Cargo.CargoViewConsultar;
import View.Cargo.CargoViewEditar;
import View.Funcionario.FuncionarioView;
import View.Funcionario.FuncionarioViewConsultar;

public class Sistema {

    public static JFrame jFrame;
    public static void main(String[] args) {
        
        //Conn.conn = Conn.abrirConexao();

        /*
        TODO Limpar os lof de console
            -preparar a interface de cadastro e tals.
            -modulo de login.
            -finalizar curso.
            -Medir uso da memoria.
        */

        jFrame = SistemaView.getFrame();
        
        jFrame.add(FuncionarioViewConsultar.getCargoViewConsultar());
        // //jFrame.add(InicioView.getInicioView());
        // //jFrame.add(LoginView.getLoginView());

        jFrame.setVisible(true); 

        if (Conn.conn != null) {
            jFrame = SistemaView.getFrame();
        
            jFrame.add(CargoViewConsultar.getCargoViewConsultar());
            //jFrame.add(InicioView.getInicioView());
            //jFrame.add(LoginView.getLoginView());

            jFrame.setVisible(true);       

        }
        
    }
}
