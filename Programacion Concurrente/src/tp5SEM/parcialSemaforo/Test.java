package tp5SEM.parcialSemaforo;

public class Test {
    public static void main(String[] args) {
        Bancos banco = new Bancos();

        Thread mayor = new Thread(new Mayor(banco));
        Thread [] arregloMenores = new Thread [8];

        int i;
        for(i=0;i<8;i++){
            arregloMenores[i] = new Thread(new Menor(banco),"#"+i);
        }

        mayor.start();
        for(i=0;i<8;i++){
            arregloMenores[i].start();
        }
    }
}
