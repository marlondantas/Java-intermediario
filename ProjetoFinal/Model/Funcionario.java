package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.CargoDao;

public class Funcionario {
    
    private int idFuncionario;
    private String nomaFuncionario;
    private String sobrenomeFuncionario;
    private Date  dataNascimento = new Date(0);
    private String dsEmail;
    private Double vlSalario;

    private Cargo cargo;

    @Override
    public String toString() {
        /*return "{" +
            " idFuncionario='" + getIdFuncionario() + "'" +
            ", nomaFuncionario='" + getNomaFuncionario() + "'" +
            ", sobrenomeFuncionario='" + getSobrenomeFuncionario() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", dsEmail='" + getDsEmail() + "'" +
            ", vlSalario='" + getVlSalario() + "'" +
            ", cargo='" + getCargo().getDsCargo() + "'" +
            "}";*/

        return getIdFuncionario() + " - " + getNomaFuncionario() + " " + getSobrenomeFuncionario();
    }


    public Funcionario(){
        //System.out.println("Novo funcionario");
    }

    public Funcionario(ResultSet dados) throws SQLException{
        //Load dados
        this.setIdFuncionario(dados.getInt("id_funcionario"));
        this.setNomaFuncionario(dados.getString("nm_funcionario"));
        this.setSobrenomeFuncionario(dados.getString("nm_sobrenome"));
        this.setDsEmail(dados.getString("ds_email"));
        this.setDataNascimento(dados.getDate("dt_nascimento"));
        this.setVlSalario(dados.getDouble("vl_salario"));

        this.setCargo(CargoDao.buscarPorID(dados.getInt("id_cargo")));

        //System.out.println("Funcionario carregado");
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
