package dois;

public class Caneta {
    
    private String marca;
    private boolean tinta;
    private String corTinta;

    public Caneta(){
        this.marca = "Pilot";
        this.tinta =true;
        this.corTinta = "Azul";
    }

    public void setTinta(boolean tinta){
        this.tinta = tinta;
    }
    
    public boolean getTinta(){
        return this.tinta;
    }
}
