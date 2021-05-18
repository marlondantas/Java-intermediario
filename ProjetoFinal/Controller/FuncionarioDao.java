package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Funcionario;

public class FuncionarioDao {

    public static Funcionario buscarPorID(int id_funcionario) throws SQLException{
        String query =  "select * from tbod_funcionario where id_funcionario = '"+id_funcionario+"'";

        ResultSet resultadoSQL = Conn.selectQuery(query, Conn.getStatement());
        ///busca o benedito
        Funcionario funcionario = null;
        while (resultadoSQL.next()) {
            funcionario = new Funcionario(resultadoSQL);
        }

        return funcionario;
    }

    public static ArrayList<Funcionario> buscarTodos() throws SQLException{
        ArrayList<Funcionario> funcionarios = new ArrayList();
        
        //resultado
        String query =  "select * from tbod_funcionario";
        ResultSet resultadoSQL = Conn.selectQuery(query, Conn.getStatement());

        while (resultadoSQL.next()) {
            Funcionario funcionario = new Funcionario(resultadoSQL);
            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    public static Funcionario criarFuncionario(Funcionario funcionario) throws SQLException{

        String query = "insert into tbod_funcionario(nm_funcionario,nm_sobrenome,dt_nascimento,ds_email,id_cargo,vl_salario) "+
        "values (':nm_funcionario',':nm_sobrenome',':dt_nascimento',':ds_email',':id_cargo',':vl_salario')";

        query = query.replace(":nm_funcionario", funcionario.getNomaFuncionario());
        query = query.replace(":nm_sobrenome", funcionario.getSobrenomeFuncionario());
        query = query.replace(":dt_nascimento", funcionario.getDataNascimento().toString());
        query = query.replace(":ds_email", funcionario.getDsEmail());
        query = query.replace(":id_cargo", funcionario.getCargo().getIdCargo()+"");
        query = query.replace(":vl_salario",  funcionario.getVlSalario()+"");

        System.out.println("QUERY >>> " + query);

        int resultadoSQL = Conn.insertQueryReturnInt(query,Conn.getStatement());
        //System.out.println("resultadoSQL: "+ resultadoSQL);
        
        funcionario.setIdFuncionario(resultadoSQL);
        
        return funcionario;
    }

    public static Funcionario editarFuncionario(Funcionario funcionario) throws SQLException{
        //System.out.println("update NO BANCO DE DADOS (dsCargo)");
        
        String query = "update tbod_funcionario set nm_funcionario = ':nm_funcionario', nm_sobrenome = ':nm_sobrenome', dt_nascimento= ':dt_nascimento', ds_email= ':ds_email', id_cargo = ':id_cargo', vl_salario = ':vl_salario' where id_funcionario = ':id_funcionario'";
        
        query =  query.replace(":nm_funcionario", funcionario.getNomaFuncionario());
        query =  query.replace(":nm_sobrenome", funcionario.getSobrenomeFuncionario());
        query =  query.replace(":dt_nascimento", funcionario.getDataNascimento().toString());
        query =  query.replace(":ds_email", funcionario.getDsEmail());

        System.out.println("CARGO: " + funcionario.getCargo().getIdCargo()+"");

        query =  query.replace(":id_cargo", funcionario.getCargo().getIdCargo()+"");
        query =  query.replace(":vl_salario",  funcionario.getVlSalario()+"");

        System.out.println("id_funcionario: " +  funcionario.getIdFuncionario()+"");

        query =  query.replace(":id_funcionario",  funcionario.getIdFuncionario()+"");

        System.out.println("QUERY > "+ query);
        boolean resultadoSQL = Conn.updateQuery(query, Conn.getStatement());
        Funcionario funcionarioSaida = null;

        if(resultadoSQL == true){
            funcionarioSaida = FuncionarioDao.buscarPorID(funcionario.getIdFuncionario());
        }

        return funcionarioSaida;
    }

    public static boolean excluirFuncionario(int idFuncionario) throws SQLException{
        //System.out.println("delete NO BANCO DE DADOS (dsCargo)");
        String query = "delete from tbod_funcionario where id_funcionario = '"+idFuncionario+"' ";

        boolean resultadoSQL = Conn.deleteQuery(query, Conn.getStatement());

        return resultadoSQL;
    }

}
