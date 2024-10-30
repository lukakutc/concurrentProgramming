package tp4.Ej6;

public class Taxista implements Runnable {
    private Taxi t;

    public Taxista (Taxi t){
        this.t = t;
    }

    public void run(){
        t.viajeTerminado();
        t.bajarPasajero();
        System.out.println("El taxista sigue durmiendo");
    }
}
