package recuLocksMon.tp6monitores.ej1;

public class GestionaTrafico {
    //recurso compartido?
    private String turno;
    private int pasando;
    private int pasaron;
    private int capacidad;

    public synchronized void entrarCocheNorte(String nombre){
        while(turno.equals("N")&&(pasando>=capacidad)){
            System.out.println(nombre+" debe esperar en entrada norte");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Entra "+nombre+" desde norte");
        pasando++;
    }
    public synchronized void entrarCocheSur(String nombre){
        while(turno.equals("S")&&(pasando>=capacidad)){
            System.out.println(nombre+" debe esperar en entrada sur");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Entra "+nombre+" desde sur");
        pasando++;
    }
    public synchronized void salirCocheNorte(String nombre){
        System.out.println("Sale "+nombre+" desde norte");
        pasando--;
        
    }

}

