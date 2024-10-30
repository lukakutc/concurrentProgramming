package ejerciciosClasicos.BarberoDormilon;

public class Barbero implements Runnable {
    private Sillon sillon;

    public Barbero(Sillon sillon){
        this.sillon = sillon;
    }
    public void run(){
        while(true){
            sillon.cortar();
            
        }
    }
}
