package tp8.ej4sem;

public class Persona implements Runnable{
    private Centro centro;
    
    public Persona(Centro centro){
        this.centro=centro;
    }

    public void run(){
        centro.entrarSala();
    }
}
