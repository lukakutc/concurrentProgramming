package tp8.ejParcial2024locks;

public class Escolar implements Runnable {
    private Parque p;
    private String nombre;
    private int cantAlumnos;

    public Escolar(Parque p, String nombre, int cantAlumnos) {
        this.p = p;
        this.nombre = nombre;
        this.cantAlumnos = cantAlumnos;
    }

    public void run(){
        p.entraEscolar(cantAlumnos, nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.salirEscolar(cantAlumnos, nombre);
    }


}
