package tp8.ejParcial2024locks;

public class Test {
    public static void main(String[] args) {
        Parque p = new Parque(15, 10);
        Thread[] hilos = new Thread[50];
        Thread[] hilosEscuela = new Thread[25];
        int i;

        for(i=0;i<50;i++){
            if(i%2==0){
                hilos[i] = new Thread(new Residente("residente"+i, p));
                hilos[i].start();
            }else{
                hilos[i] = new Thread(new NoResidente(p, "No residente"+i));
                hilos[i].start();
            }
        }

        for(i=0;i<8;i++){
            hilosEscuela[i] = new Thread(new Escolar(p,"escolar"+i,8));
            hilosEscuela[i].start();
        }
        
    }
}
