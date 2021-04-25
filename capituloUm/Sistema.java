

public class Sistema {
    public static void main(String[] args) {
        
        System.out.println("##############################################################");
        System.out.println("Classe aluno:");
        Aluno aluno = new Aluno();
        double saida = aluno.calcularMediaProvas(7.5, 8.5, 8.0);
        
        System.out.println("Saida: "+saida);
        
        System.out.println("##############################################################");
        System.out.println("Classe Calculadora:");

        System.out.println("Realizando a soma de dois valores");
        int numeroUm = 23, numeroDois = 25;

        System.out.println("A soma dos valores "+numeroUm + " + " + numeroDois  + " = "+ Calculadora.soma(numeroUm, numeroDois));

        System.out.println("##############################################################");
        System.out.println("Classe Aluno (segunda versao):");

        Aluno joao = new Aluno();

        System.out.println("Proximo semestre do João:" + joao.proximoSemestre()  );
        System.out.println("Quantidade de faltas do joão:" +joao.quntidadeFaltas() );
        
        System.out.println("##############################################################");



    }
}
