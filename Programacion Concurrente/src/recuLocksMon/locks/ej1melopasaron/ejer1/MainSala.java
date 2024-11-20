package recuLocksMon.locks.ej1melopasaron.ejer1;

public class MainSala {
    public static void main(String[] args) {
        GestorSala gs = new GestorSala();
        PersonasOJubilados[] arr = new PersonasOJubilados[20];
        Thread[] t = new Thread[20];
        MedidorTemperatura md = new MedidorTemperatura(gs);
        Thread temp = new Thread(md,"Temperatura");

        for (int i = 0; i < 20; i++){
            if (i % 3 == 1){
                arr[i] = new PersonasOJubilados(gs, true);
                t[i] = new Thread(arr[i], "Jubilado n°" + i);
            }else{
                arr[i] = new PersonasOJubilados(gs, false);
                t[i] = new Thread(arr[i], "Persona n°" + i);
            }
            t[i].start();
        }
        temp.start();
        
        for (int i = 0; i < 20; i++){
            try {
                t[i].join();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        try {
            temp.join();    
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        System.out.println(">Termino Main...");
    } 
}
