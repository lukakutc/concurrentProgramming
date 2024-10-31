package tp5SEM.ej3;

public class Animal implements Runnable{
    private String tipo;
    private Comedor c;
    int numero;

    public Animal(String tipo, Comedor c, int numero){
        this.tipo = tipo;
        this.c = c;
        this.numero = numero;
    }

    public void run(){
        c.comer(this);
    }

    public void comiendo(){
        System.out.println("El "+tipo+" "+numero+" esta comiendo!");
        try {
            Thread.sleep((int) (Math.random()*500));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    



    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comedor getC() {
        return c;
    }

    public void setC(Comedor c) {
        this.c = c;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
