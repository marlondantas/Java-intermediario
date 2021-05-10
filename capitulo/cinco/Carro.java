package cinco;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro {
    
    private int idCarro;
    private String nmCarro;
    private String nmModelo;

    private String nmMotor;
    private String nmFabricante;

    private Date dtFabricacao;
    private Date dtAnoModelo;
    private String cor;

    Carro(){
        System.out.println("novo Carro");
    }

    Carro(ResultSet dados){
        System.out.println("Carro buscado do banco");

        try {
            
            setIdCarro(dados.getInt("id_carro"));
            setNmCarro(dados.getString("nm_carro"));
            setnmModelo(dados.getString("nm_modelo"));
            setnmMotor(dados.getString("nm_motor"));
            setNmFabricante(dados.getString("nm_fabricante"));
            setCor(dados.getString("cor"));
            setDtAnoModelo(dados.getDate("dt_fabricacao"));
            setDtFabricacao(dados.getDate("dt_ano_modelo"));

        } catch (SQLException e) {
            System.out.println("ERRO NA ALOCACAO DE DADOS");
            e.printStackTrace();
        }
    }

    public String getLinha(){
        return ( "CARRO ID: "+ getIdCarro() + " nome: " + getNmCarro() + " modelo: " + getnmModelo() + " Motor: " + getnmMotor() + " nome do fabricante: " + getnmFabricante() + " cor: " + getCor());
    }

    /*Gets and Sets*/

    public int getIdCarro(){
        return this.idCarro;
    } 
    public String getNmCarro(){
        return this.nmCarro;
    }
    public String getnmModelo(){
        return this.nmModelo;
    }
    public String getnmMotor(){
        return this.nmMotor;
    }
    public String getnmFabricante(){
        return this.nmFabricante;
    }
    public String getCor(){
        return this.cor;
    }
    public Date getDtAnoModelo(){
        return this.dtAnoModelo;
    }
    public Date getDtFabricacao(){
        return this.dtFabricacao;
    }

    public void setIdCarro(int id ){
        this.idCarro = id;
    } 
    public void setNmCarro(String nmCarro){
        this.nmCarro = nmCarro;
    }
    public void setnmModelo(String nmModelo){
        this.nmModelo = nmModelo;
    }
    public void setnmMotor(String nmMotor){
        this.nmMotor = nmMotor;
    }
    public void setNmFabricante(String nmFabricante){
        this.nmFabricante = nmFabricante;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setDtAnoModelo(Date dtAnoModelo){
        this.dtAnoModelo  = dtAnoModelo;
    }
    public void setDtFabricacao(Date dtFabricacao){
        this.dtFabricacao = dtFabricacao;
    }

}
