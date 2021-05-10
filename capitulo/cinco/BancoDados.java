package cinco;

import java.sql.*;
import cinco.*;

public class BancoDados {


    public static void main(String[] args) {
        
        // Configuração dos parâmetros de conexão
        final String HOST = "192.168.1.235";
        final String PORT = "3306"; // Porta TCP padrão do MySQL
        final String DATA_BASE = "cursoJava";

        // Configuração dos parâmetros de autenticação
        final String USER = "root";
        final String PASSWORD = "root";

        String status = "Não conectou...";

        try {
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATA_BASE;
            
            //Conecxao
            Connection  conn = DriverManager.getConnection(url, USER, PASSWORD);
            status = "Conectado com sucesso";

            //instrucao
            Statement instrucaoSQL = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //resultado
            ResultSet resultadoSQL = instrucaoSQL.executeQuery("select * from tbod_carro");

            while (resultadoSQL.next()) {
                Carro carro = new Carro(resultadoSQL);
                System.out.println(carro.getLinha());
                System.out.println("##################################################################################");
            }
            
            
        } catch (Exception e) {
            //TODO: handle exception
            status = "Deu ruim mano";
        }finally{
            System.out.println("STATUS da conexao: " + status);
        }

    }    
}
