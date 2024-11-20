package recuLocksMon.hamsters.platoYRueda;

public class Test {
    public static void main(String[] args) {
        Plato plato = new Plato(5);
        Rueda rueda = new Rueda(2);
        Thread[] hamsters = new Thread[25];
        int i;

        for(i=0;i<25;i++){
            hamsters[i] = new Thread(new Hamster(plato,rueda,""+i));
        }
        for(i=0;i<25;i++){
            hamsters[i].start();
        }
    }
}
