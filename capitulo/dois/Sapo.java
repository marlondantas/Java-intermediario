package dois;

public class Sapo extends Animal{
    
    public void Sapo(){
        this.setTipo("Anf\u00EDbio");
    }

    @Override
    public void som(){
        System.out.println("Frog!");
    }
}
