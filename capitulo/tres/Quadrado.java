package tres;

public final class Quadrado extends Geometria{

    public Quadrado(double lado){
        super();
        this.setLado(lado);
    }

    @Override
    public double area(){
        return this.getLado() * this.getLado();
    }

    @Override
    public double perimetro(){
        return this.getLado() * 4;
    }
}
