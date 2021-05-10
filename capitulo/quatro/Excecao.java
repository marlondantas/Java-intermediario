package quatro;

public class Excecao {
    
    public static void main(String[] args) {
        
        System.out.println("Iniciando sistema!");

        String[] alunos = new String[50];
        int indexAluno = 51; 

        try {
            System.out.println("ALUNOS: " + alunos[indexAluno]);
        } 
        catch (ArrayIndexOutOfBoundsException erro){
            System.out.println("Index invalido para essa operacao: \n" + erro);
        }
        catch (Exception erro) {
            System.out.println("Erro desconhecido: \n" + erro);
        }
        finally{
            System.out.println("Termino da execucao");
        }

    }

}
