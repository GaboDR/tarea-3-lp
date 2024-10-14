public class CentroGalactico extends Planeta {

    /* Parametro 1: Jugador
    ***
    None
    ***
    Muestra un mensaje de victoria cuando el jugador llega al Centro Galactico,
    declarando el final exitoso del juego.
    */

    public void menuRecursos(Jugador jugador){
        System.out.println(" ");
        System.out.println("  __     ______  _    _   _    _ _    _ _   _ ");
        System.out.println("  \\ \\   / / __ \\| |  | | | |  | | |  | | | | |");
        System.out.println("   \\ \\_/ / |  | | |  | | | |  | | |  | | |_| |");
        System.out.println("    \\   /| |  | | |  | | | |  | | |  | |  _  |");
        System.out.println("     | | | |__| | |__| | | |__| | |__| | | | |");
        System.out.println("     |_|  \\____/ \\____/   \\____/ \\____/|_| |_|");
        System.out.println(" ");
        System.out.println("       ***** ¡Has ganado el juego! ***** ");
        System.out.println("      Felicitaciones, tu aventura ha sido exitosa.");
        System.out.println(" ");
        System.out.println("           ヽ༼ຈل͜ຈ༽ﾉ  ¡VICTORIA! ヽ༼ຈل͜ຈ༽ﾉ ");
        System.out.println(" ");
        System.out.println("           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("               ___");
        System.out.println("              /^  ^\\");
        System.out.println("              |  O  |");
        System.out.println("              |  \\_/ |");
        System.out.println("               \\____/");
        System.out.println("            //  || ||  \\\\");
        System.out.println("           ||   || ||   ||");
        System.out.println("           ||___|| ||___||");
        System.out.println("           ||         ||");
        System.out.println("           ||         ||");
        System.out.println("          /_|         |_\\");
        System.out.println(" ");
        System.out.println("           ¡Gracias por jugar!");
        System.out.println(" ");
        
        NoJavaSky.partida = false;
    }
    /*Parametro 1: Tipo (int)
    ***
    Retorno: int
    ***
    Implementacion necesaria para el abstract.
    */
    public int extraerRecursos(int tipo){return 0;}
}
