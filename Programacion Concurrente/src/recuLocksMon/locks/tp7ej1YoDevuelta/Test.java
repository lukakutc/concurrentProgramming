package recuLocksMon.locks.tp7ej1YoDevuelta;

public class Test {
    public static void main(String[] args) {
        GestorSala sala = new GestorSala(5, 3,  30, 25);
        new Thread(new Temperatura(sala)).start();
        Thread[] personas = new Thread[27];
        int i;

        for(i=0;i<27;i++){
            if((i+1)%3 == 0){
                personas[i]= new Thread(new Jubilado("ju"+i, sala));
                personas[i].start();
            }else{
                personas[i]= new Thread(new Persona("p"+i,sala));
                personas[i].start();
            }
        }
    }
}
