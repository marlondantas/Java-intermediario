package Model;

import java.sql.Date;
import java.sql.ResultSet;



public class Funcionario {
    
    private int idFuncionario;
    private String nomaFuncionario;
    private String sobrenomeFuncionario;
    private Date  dataNascimento;
    private String dsEmail;
    private Double vlSalario;

    private Cargo cargo;


    Funcionario(){
        System.out.println("Novo funcionario");
    }

    Funcionario(ResultSet dados){
        //Load dados

        System.out.println("Funcionario carregado");
    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomaFuncionario() {
        return this.nomaFuncionario;
    }

    public void setNomaFuncionario(String nomaFuncionario) {
        this.nomaFuncionario = nomaFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return this.sobrenomeFuncionario;
    }

    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDsEmail() {
        return this.dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public Double getVlSalario() {
        return this.vlSalario;
    }

    public void setVlSalario(Double vlSalario) {
        this.vlSalario = vlSalario;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


}
