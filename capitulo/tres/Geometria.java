package tres;

public abstract class Geometria {

    private double lado;
    private double altura;
    private double raio;

    public abstract double area();
    public abstract double perimetro();

    public double getLado(){
        return this.lado;
    }

    public void setLado(double lado){
        this.lado = lado;
    }

    public double getAltura(){
        return this.altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getRaio(){
        return this.raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }
}
