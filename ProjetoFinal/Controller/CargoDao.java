package Controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Cargo;

public class CargoDao {
    
    private  Statement instrucaoSQL;

    public CargoDao(Statement instrucaoSQL){
        this.instrucaoSQL = instrucaoSQL;
    }

    CargoDao(Statement instrucaoSQL, int idCargo){
        this.instrucaoSQL = instrucaoSQL;
    }

    public Cargo buscarPorID(int idCargo){

        ///busca o benedito

        Cargo cargo = new Cargo();
        return cargo;
    }

    public Cargo buscarTodos() throws SQLException{
        //teste para finalizar a noitinha:
       
        //resultado
        ResultSet resultadoSQL = this.instrucaoSQL.executeQuery("select * from tbod_carro");
 
        while (resultadoSQL.next()) {
            System.out.println("NOME DO CARRO: " + resultadoSQL.getString("nm_carro"));
        }

        Cargo cargo = new Cargo();
        return cargo;
    }

    public Cargo criarCargo(String dsCargo){

        System.out.println("CRIADO NO BANCO DE DADOS");

        Cargo cargo = new Cargo();
        return cargo;
    }

    public Cargo editarCargo(){
        
        Cargo cargo = new Cargo();
        return cargo;
    }

    public boolean excluirCargo(){
        return false;
    }
}
