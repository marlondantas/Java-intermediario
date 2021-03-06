package um;

import tres.*;
import dois.*;
import um.*;

public class Sistema {
    public static void main(String[] args) {
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumento: " + args[i]);
        }

        System.out.println("##############################################################");
        System.out.println("Classe aluno:");
        
        Aluno aluno = new Aluno();


        double saida = aluno.calcularMediaProvas(7.5, 8.5, 8.0);
        
        System.out.println("Saida: "+saida);

        System.out.println("##############################################################");
        System.out.println("Classe aluno: set && get");
        aluno.setMatricula(340578);

        System.out.println("O numero da matricula do aluno \u00E9: "+aluno.getMatricula());

        System.out.println("##############################################################");
        System.out.println("Classe Calculadora:");

        System.out.println("Realizando a soma de dois valores");
        int numeroUm = 23, numeroDois = 25;

        System.out.println("A soma dos valores "+numeroUm + " + " + numeroDois  + " = "+ Calculadora.soma(numeroUm, numeroDois));

        System.out.println("##############################################################");
        System.out.println("Classe Aluno (segunda versao):");

        Aluno joao = new Aluno(25484);
        Aluno renato = new Aluno("Renato",35874);

        System.out.println("Classe Aluno: "+joao.getMatricula());
        System.out.println("Classe Aluno: "+renato.getMatricula());

        System.out.println("Proximo semestre do Jo\u00E3o:" + joao.proximoSemestre()  );
        System.out.println("Quantidade de faltas do jo\u00E3o:" +joao.quntidadeFaltas() );
        
        System.out.println("##############################################################");
        System.out.println("Classes animais:");

        Cachorro dog = new Cachorro();
        Cobra snake = new Cobra();
        Gato cat = new Gato();
        Galinha chicken = new Galinha();
        Sapo frog = new Sapo();

        System.out.println(" O cachorro faz: ");
        dog.som();
        System.out.println(" O gato faz: ");
        cat.som();
        System.out.println(" A cabro faz: ");
        snake.som();
        System.out.println(" A galinha faz: ");
        chicken.som();
        System.out.println(" A sapo faz: ");
        frog.som();

        System.out.println("##############################################################");
        System.out.println("Classes Abstract:");

        Aluno alunoAbstrato = new Aluno("Abstract",2214);
        System.out.println("Aluno nome: " + alunoAbstrato.getNome() + " aluno matricula: "+ alunoAbstrato.getMatricula());

        Professor professorAbstrato = new Professor();
        professorAbstrato.setNome("NOME");
        professorAbstrato.setUsuario("usuario");
        System.out.println("Professor nome: " + professorAbstrato.getNome() + " Professor usuario: "+ professorAbstrato.getUsuario());

        Servente serventeAbstrato = new Servente();
        serventeAbstrato.setNome("serventeAbstrato");
        serventeAbstrato.setTurno("Manha");
        System.out.println("Servente nome: " + serventeAbstrato.getNome() + " servente turno: "+ serventeAbstrato.getTurno());

        System.out.println("##############################################################");
        System.out.println("Classes FINAL:");

        Quadrado quadrado = new Quadrado(10);
        System.out.println("Quadrado: area -> "+quadrado.area() + " e perimetro: "+quadrado.perimetro());

        Circulo circulo = new Circulo(10);
        System.out.println("Circulo: area -> "+circulo.area() + " e perimetro: "+circulo.perimetro());

        Triangulo triangulo = new Triangulo(10,5);
        System.out.println("Triangulo: area -> "+triangulo.area() + " e perimetro: "+triangulo.perimetro());
        System.out.println("##############################################################");
    }
}
