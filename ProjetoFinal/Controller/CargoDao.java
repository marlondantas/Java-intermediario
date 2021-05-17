package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cargo;

public class CargoDao {
    
    public static Cargo buscarPorID(int idCargo) throws SQLException{
        String query =  "select * from tbod_cargo where id_cargo = '"+idCargo+"'";

        ResultSet resultadoSQL = Conn.selectQuery(query, Conn.getStatement());
        ///busca o benedito
        Cargo cargo = null;
        while (resultadoSQL.next()) {
            cargo = new Cargo(resultadoSQL);
        }

        return cargo;
    }

    public static ArrayList<Cargo> buscarTodos() throws SQLException{
        ArrayList<Cargo> cargos = new ArrayList();
        
        //resultado
        String query =  "select * from tbod_cargo";
        ResultSet resultadoSQL = Conn.selectQuery(query, Conn.getStatement());

        while (resultadoSQL.next()) {
            Cargo cargo = new Cargo(resultadoSQL);
            cargos.add(cargo);
        }

        return cargos;
    }

    public static Cargo criarCargo(String dsCargo) throws SQLException{

        String query = "insert into tbod_cargo(ds_carga) values ('"+dsCargo+"')";
       
        int resultadoSQL = Conn.insertQueryReturnInt(query, Conn.getStatement());
        //System.out.println("resultadoSQL: "+ resultadoSQL);
        
        Cargo cargo = CargoDao.buscarPorID(resultadoSQL);

        return cargo;
    }

    public static Cargo editarCargo(Cargo cargo) throws SQLException{
        //System.out.println("update NO BANCO DE DADOS (dsCargo)");
        
        String query = "update tbod_cargo set ds_carga = '"+cargo.getDsCargo()+"' where id_cargo = '"+cargo.getIdCargo()+"' ";
        
        boolean resultadoSQL = Conn.updateQuery(query, Conn.getStatement());
        Cargo cargoSaida = null;
        if(resultadoSQL == true){
            cargoSaida = CargoDao.buscarPorID(cargo.getIdCargo());
        }

        return cargoSaida;
    }

    public static boolean excluirCargo(int idCargo) throws SQLException{
        //System.out.println("delete NO BANCO DE DADOS (dsCargo)");
        String query = "delete from tbod_cargo where id_cargo = '"+idCargo+"' ";

        boolean resultadoSQL = Conn.deleteQuery(query, Conn.getStatement());

        return resultadoSQL;
    }
}
