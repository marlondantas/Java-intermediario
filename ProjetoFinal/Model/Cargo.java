package Model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Cargo {
    
    private int idCargo;
    private String dsCargo;

    public Cargo(){
        System.out.println("Novo cargo");
    }

    public Cargo(int idCargo){
        System.out.println("Buscar cargo por id!");
    }

    public Cargo(ResultSet dados) throws SQLException{
        
        this.setDsCargo(dados.getString("ds_carga"));
        this.setIdCargo(dados.getInt("id_cargo"));

        System.out.println("dados carregado");
    }

    @Override
    public String toString() {
        // return "{" +
        //     " idCargo='" + getIdCargo() + "'" +
        //     ", dsCargo='" + getDsCargo() + "'" +
        //     "}";
        return getDsCargo();
    }

    public int getIdCargo() {
        return this.idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getDsCargo() {
        return this.dsCargo;
    }

    public void setDsCargo(String dsCargo) {
        this.dsCargo = dsCargo;
    }


}
