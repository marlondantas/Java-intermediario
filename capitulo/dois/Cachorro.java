package dois;

public class Cachorro extends Animal {
    
    public void Cachorro(){
        this.setTipo("Mam\u00EDferos");
    }

    @Override
    public void som(){
        System.out.println("Au aU!");
    }
}
