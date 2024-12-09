package TPFinal.atracciones.atraccion4;

public class HiloTemporizador implements Runnable {
    ControlTren ct;

    public HiloTemporizador(ControlTren ct) {
        this.ct = ct;
    }
    
    public void run(){
        ct.avisarTiempoTerminado();
    }
}
