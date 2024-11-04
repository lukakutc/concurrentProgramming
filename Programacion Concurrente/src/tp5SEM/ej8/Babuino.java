package tp5SEM.ej8;

public class Babuino implements Runnable {
    private Cuerda c;
    private String tipo;

    public Babuino(Cuerda c, String tipo) {
        this.c = c;
        this.tipo = tipo;
    }

    public void run(){
        c.cruzar(tipo);
    }
    
}
