package recuLocksMon.locks.tp7ej2;

public class Test{
    public static void main(String[] args) {
        Recursos recurso = new Recursos(3,3);
        Thread[] p = new Thread[50];
        int i;
        for(i=0;i<50;i++){
            p[i] = new Thread(new Programador(""+i,recurso));
            p[i].start();
        }

    }
}