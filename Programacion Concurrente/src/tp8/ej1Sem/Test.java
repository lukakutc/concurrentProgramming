package tp8.ej1Sem;

public class Test {
    public static void main(String[] args) {
        int i;
        Recinto r = new Recinto();
        Thread[] a = new Thread[100];

        for (i = 0; i < 100; i++) {
            a[i] = new Thread(new Soldado(r), "" + i);
        }
        for(i=0;i<100;i++){
            a[i].start();
        }
    }
}
