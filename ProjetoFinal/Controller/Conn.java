package Controller;

import java.sql.*;

public class Conn {
    
    public static Connection  conn;
    //public static Statement instrucaoSQL = null;

    public static Connection abrirConexao(){
        // Configuração dos parâmetros de conexão
        final String HOST = "192.168.1.235";
        final String PORT = "3306"; // Porta TCP padrão do MySQL
        final String DATA_BASE = "cursoJava";
 
        // Configuração dos parâmetros de autenticação
        final String USER = "root";
        final String PASSWORD = "root";
 
        String status = "Não conectou...";

        //instrucaoSQL = null;

        try {
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATA_BASE;
             
            //Conecxao
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            status = "Conectado com sucesso";

            //instrucao
            //instrucaoSQL = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

        } catch (Exception e) {
            status = "Deu ruim mano";
            System.out.println("Erro:  "+ e.getMessage());
        }finally{
            System.out.println("STATUS da conexao: " + status);
        }

        return conn;
    }

    public static Statement getStatement(){
        Statement saida = null;
        try {
            saida = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            System.out.println("Erro:  "+ e.getMessage());
        }
        return saida;
    }

    public static void fecharConexao(){
        try {
            Conn.conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //create
    public static int insertQueryReturnInt(String SQLQy, Statement instrucaoSQL) {
        ResultSet generatedKeys = null;
        String errorDescription = "";
        int generatedKey = -2;
    
        try {
            instrucaoSQL.execute(SQLQy,Statement.RETURN_GENERATED_KEYS);
            generatedKeys = instrucaoSQL.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedKey = (int) generatedKeys.getInt(1);

            }
        } catch (Exception e) {
            errorDescription = "Failed to insert SQL query: " + SQLQy + "( " + e.toString() + ")";
            System.out.println("errorDescription" + errorDescription);
            return -1;
        }
    
        return generatedKey;
    } 

    //read
    public static ResultSet selectQuery(String SQLQy, Statement instrucaoSQL) throws SQLException{
        ResultSet resultadoSQL = instrucaoSQL.executeQuery(SQLQy);
        return resultadoSQL;
    }

    //update
    public static boolean updateQuery(String SQLQy, Statement instrucaoSQL){
        //0 deu certo
        //-1 deu errado
        boolean saida = false;
        
        try {
            instrucaoSQL.execute(SQLQy);
            saida = true;
        } catch (Exception e) {
            //TODO: handle exception
        }

        return saida;
    }

    //delete
    public static boolean deleteQuery(String SQLQy, Statement instrucaoSQL){
        //0 deu certo
        //-1 deu errado
        boolean saida = false;
        
        try {
            instrucaoSQL.execute(SQLQy);
            saida = true;
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        return saida;
    }



}
