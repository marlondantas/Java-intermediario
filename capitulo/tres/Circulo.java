package tres;

final public class Circulo extends Geometria{
 
    public Circulo(double raio){
        super();
        this.setRaio(raio);
    }

    @Override
    public double area(){
        return 3.14 * this.getRaio();
    }

    @Override
    public double perimetro(){
        return 3.14 * (2 * this.getRaio());
    }
}
