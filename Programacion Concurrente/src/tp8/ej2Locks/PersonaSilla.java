package tp8.ej2Locks;

public class PersonaSilla implements Runnable{
    private Observatorio o;
    private String nombre;
    public PersonaSilla(Observatorio o, String nombre) {
        this.o = o;
        this.nombre = nombre;
    }
    public void run (){
        o.entrarSilla(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        o.salirSilla(nombre);
    }
    
    
}
