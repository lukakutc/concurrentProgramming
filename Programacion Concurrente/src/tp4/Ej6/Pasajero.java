package tp4.Ej6;

public class Pasajero implements Runnable{
    private Taxi t;

    public Pasajero(Taxi t){
        this.t = t;
    }

    public void run(){
        System.out.println("El pasajero busca un taxi");
        t.despertarTaxista();
        t.indicarDestino();
    }

}
