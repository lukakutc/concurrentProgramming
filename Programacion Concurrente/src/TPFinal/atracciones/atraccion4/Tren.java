package TPFinal.atracciones.atraccion4;

public class Tren implements Runnable {
    private ControlTren ct;

    public Tren(ControlTren ct) {
        this.ct = ct;
    }

    public void run(){
        while(true){
            ct.empezarViaje();
            System.out.println("Tren inicia su recorrido");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ct.terminarViaje();
        }
    }
    
}
