
import Controller.Conn;
import View.*;

public class Sistema {

    public static void main(String[] args) {
        
        Conn.conn = Conn.abrirConexao();
        //Conn.instrucaoSQL = Conn.getStatement();

        if (Conn.conn != null) {
           //CargoView.criarComponetes(instrucaoSQL).setVisible(true);
           CargoView.testComponetes();
           FuncionarioView.testarComponentes();
        }
        
    }
}
