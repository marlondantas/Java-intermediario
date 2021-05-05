package dois;

public class Animal {
    
    private String tipo;
    private String nome;

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }    

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void som(){
        System.out.println("Au au!");
    }

}
