package um;

public class Aluno {
    
    private int matricula;
    private String turno = "";
    private int semestre = 1;
    private int faltas = 0;
    private String nome;

    public Aluno(){
        System.out.println("Construido a classe aluno...");
        this.turno = "";
    }

    public Aluno(int numeroMatricula){
        this.matricula = numeroMatricula;
        System.out.println("Novo aluno - matricula " + this.matricula);
        this.turno = "";

    }

    public Aluno(String nomeAluno, int numeroMatricula){
        this.nome = nomeAluno;
        this.matricula = numeroMatricula;

        System.out.println("Novo aluno - Nome: " + this.nome + " - matricula: " + this.matricula);
    }

    /* metodos gets & sets */
    public void setMatricula(int numeroMatricula){
        this.matricula = numeroMatricula; 
    }

    public int getMatricula(){
        return this.matricula;
    }

    public int proximoSemestre(){
        return this.semestre  + 1;
    }

    public int quntidadeFaltas(){
        return this.faltas;
    }
    
    public double calcularMediaProvas(double notaUm, double notaDois, double notaTres ){
        return (notaUm+notaDois+notaTres)/3;
    }


}
