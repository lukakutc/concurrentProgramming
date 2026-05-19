public class Visitante extends Thread {

    private int id;
    private MontaniaRusa montaniaRusa;

    public Visitante(int id, MontaniaRusa montaniaRusa) {
        this.id = id;
        this.montaniaRusa = montaniaRusa;
    }

    @Override
    public void run() {
        montaniaRusa.subir(id);
    }
}