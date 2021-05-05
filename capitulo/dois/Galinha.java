package dois;

public class Galinha extends Animal{

    public void Galinha(){
        this.setTipo("Aves");
    }
    
    @Override
    public void som(){
        System.out.println("Cocoric\u00F3!");
    }
}
