package tres;

final public class Triangulo extends Geometria{
    
    public Triangulo(double lado, double altura){
        super();
        this.setAltura(altura);
        this.setLado(lado);
    }

    @Override
    public double area(){
        return (this.getAltura()*this.getLado()) / 2 ;
    }

    @Override
    public double perimetro(){
        return this.getLado() * 3;
    }
}
