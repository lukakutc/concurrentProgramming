package recuLocksMon.locks.tp7ej1;

public class Test {
    public static void main(String[] args) {
        GestorSala sala = new GestorSala(0, 0, 10, 0);
        Thread[] personas = new Thread[250];
        Thread[] jubilados = new Thread[50];

        int i;

        for(i=0;i<250;i++){
            personas[i] = new Thread(new Persona(sala,""+i));
            personas[i].start();
            if(i%5==0 && i<50){
                jubilados[i] = new Thread(new Jubilado(sala,"j"+i));
                jubilados[i].start();
            }
        }
    }
}
