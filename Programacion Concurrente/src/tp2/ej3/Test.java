package tp2.ej3;

public class Test {
    public static void main(String[] args) {
        new Thread(new RunnableEjemplo(),"Maria Jose").start();
        new Thread(new RunnableEjemplo(),"Jose Maria").start();
        System.out.println("Termina thread main");
    }
}
