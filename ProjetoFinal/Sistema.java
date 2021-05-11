
import java.sql.*;

import View.*;

public class Sistema {
    public static void main(String[] args) {
        // Configuração dos parâmetros de conexão
        final String HOST = "192.168.1.235";
        final String PORT = "3306"; // Porta TCP padrão do MySQL
        final String DATA_BASE = "cursoJava";
 
        // Configuração dos parâmetros de autenticação
        final String USER = "root";
        final String PASSWORD = "root";
 
        String status = "Não conectou...";
         
        Connection  conn;
        Statement instrucaoSQL = null;

        try {
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATA_BASE;
             
            //Conecxao
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            status = "Conectado com sucesso";

            //instrucao
            instrucaoSQL = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

        } catch (Exception e) {
             //TODO: handle exception
            status = "Deu ruim mano";
        }finally{
            System.out.println("STATUS da conexao: " + status);
        }

        if (instrucaoSQL !=    null) {
           CargoView.criarComponetes(instrucaoSQL).setVisible(true);
        }
        
    }
}
