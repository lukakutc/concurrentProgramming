package tp8.ej1tp7sabado;

public class Test {
    public static void main(String[] args) {
        GestorSala sala = new GestorSala(5,3 ,35 );
        Thread temperatura = new Thread( new Temperatura(sala));
        int i;
        Thread[] hilos = new Thread[50];
        for(i=0;i<50;i++){
            if(i%2==0){
                hilos[i] = new Thread(new Persona(sala, "p"+i));
                hilos[i].start();
            }else{
                hilos[i] = new Thread(new Jubilado(sala,"ju"+i));
                hilos[i].start();
            }
        }
        temperatura.start();
    }
}
