package recuLocksMon.locks.ej1melopasaron.ejer1;

public class MedidorTemperatura implements Runnable{
    
    GestorSala gs;

    public MedidorTemperatura(GestorSala gs){
        this.gs = gs;
    }

    public void run(){
        try {
            for (int i = 0; i < 5; i++){
                gs.notificarTemperatura(2);
                Thread.sleep(3500);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
