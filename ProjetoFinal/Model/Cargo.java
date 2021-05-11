package Model;

import java.sql.ResultSet;


public class Cargo {
    
    private int idCargo;
    private String dsCargo;

    public Cargo(){
        System.out.println("Novo cargo");
    }

    public Cargo(int idCargo){
        System.out.println("Buscar cargo por id!");
    }

    public Cargo(ResultSet dados){
        
        System.out.println("Funcionario carregado");
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
