package tp5SEM.parcialSemaforo;

public class Mayor implements Runnable {
    private Bancos banco;

    public Mayor(Bancos b) {
        banco = b;
    }

    public void run(){
        while(true){
            banco.cocinarComida();
        }
    }
    

}
