package tp8.ej1tp7sabado;

public class Temperatura implements Runnable {
    GestorSala sala;

    public Temperatura(GestorSala sala) {
        this.sala = sala;
    }
    public void run(){
        while(true){
            int temperatura = 25 + (int)(Math.random()*15);
            sala.notificarTemperatura(temperatura);
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
