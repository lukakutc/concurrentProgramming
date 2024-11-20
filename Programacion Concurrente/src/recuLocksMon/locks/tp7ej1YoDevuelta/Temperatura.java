package recuLocksMon.locks.tp7ej1YoDevuelta;

public class Temperatura implements Runnable{
    private GestorSala sala;

    public Temperatura(GestorSala sala) {
        this.sala = sala;
    }

    public void run(){
        while(true){
            sala.notificarTemperatura(27+ (int) (Math.random()*7));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
