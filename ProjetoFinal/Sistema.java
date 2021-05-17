
import Controller.Conn;
import View.SistemaView;

public class Sistema {
    public static void main(String[] args) {
        iniciarSistema();
    }

    private static void iniciarSistema(){
        
        Conn.conn = Conn.abrirConexao();
        
        if (Conn.conn != null) {
            SistemaView.jFrameSistema = SistemaView.getFrame();
            SistemaView.login();

            SistemaView.jFrameSistema.setVisible(true);       

        }
    }
}
