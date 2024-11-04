package tp5SEM.parcialSemaforo;

public class Menor implements Runnable {
    private Bancos banco;

    public Menor(Bancos banco) {
        this.banco = banco;
    }

    public void run() {
        while (true) {
            banco.sentarse();
        }
    }
}
