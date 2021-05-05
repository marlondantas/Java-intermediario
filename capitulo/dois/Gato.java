package dois;

public class Gato extends Animal{
    
    public void Gato(){
        this.setTipo("Mam\u00EDferos");
    }

    @Override
    public void som(){
        System.out.println("Miau!");
    }
}
