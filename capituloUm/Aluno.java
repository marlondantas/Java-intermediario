

public class Aluno {
    
    private int matricula;
    private String turno;
    private int semestre = 1;
    private int faltas = 0;

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
