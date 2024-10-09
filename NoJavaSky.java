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

        while (partida) {

            nave.menu(mapa, jugador, nave);

            System.out.println("Terminar partida? 0/1");
            // Comprobar si hay entrada disponible antes de leer
            if (scanner.hasNextLine()) {
                int tipo = Integer.parseInt(scanner.nextLine());
                if (tipo == 1) {
                    partida = false;
                }
            } else {
                System.out.println("No se recibió entrada, intenta de nuevo.");
            }
            jugador.reset(nave, mapa);
        }

        System.out.println("Gracias por jugar, " + nombre + "!");
        scanner.close(); // Cerrar el scanner al final del programa
    }
}
