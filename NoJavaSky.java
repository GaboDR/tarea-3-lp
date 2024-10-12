import java.util.Scanner;

public class NoJavaSky {
    public static boolean partida = true;


    public static void main(String[] args) {
        
        System.out.println("Bienvenido a NoJavaSky, elija su nombre de avatar: ");

        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        System.out.println("Genial " + nombre + " ,empecemos con esta aventura");
        Jugador jugador = new Jugador();
        Nave nave = new Nave();
        MapaGalactico mapa = new MapaGalactico();
        jugador.introduccionConNarrativa();
        jugador.mostrarTutorial();

        while (partida) {

            nave.menu(mapa, jugador, nave);
            jugador.reset(nave, mapa);
        }

        scanner.close(); 
    }
}
