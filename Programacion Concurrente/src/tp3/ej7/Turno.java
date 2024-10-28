package tp3.ej7;

public class Turno {
    //Elemento compartido
    private int turno;

    public Turno(){
        turno = 0;
    }

    public synchronized void cambiar(int turno){
        this.turno = turno;
    }
    public synchronized int getTurno(){
        return this.turno;
    }
}
