package recuLocksMon.locks.ej1melopasaron.ejer1;

public class PersonasOJubilados implements Runnable{
    
    private GestorSala gestor;
    private boolean esJubilado;

    public PersonasOJubilados(GestorSala gs, boolean esJubilado){
        this.gestor = gs;
        this.esJubilado = esJubilado;
    }

    public void run(){
        try {
            if (esJubilado){
                gestor.entrarSalaJubilado();
            }else{
                gestor.entrarSala();
            }
            Thread.sleep(3000);
            gestor.salirSala();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
