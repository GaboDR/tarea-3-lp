import java.util.Scanner;
public class NoJavaSky {
    public static boolean partida = true;
    public static boolean enPlaneta = false;


    public static void main(String[] args) {
        System.out.println("Bienvenido a NoJavaSky, elija su nombre de avatar: ");

        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        System.out.println("Genial "+ nombre+ " ,empecemos con esta aventuea");
        /*while (partida) {
            
        }*/
        MapaGalactico mapa = new MapaGalactico();
        mapa.crearPlaneta(10);
        for (int i = 0; i < 10; i++) {
            Planeta planeta = mapa.acceder(i); // Acceder al planeta por su índice
            planeta.mostrarAll(); // Mostrar los atributos del planeta
            System.out.println("-----------------------------");
        }
        System.out.println(nombre);

        scanner.close();
    }
}