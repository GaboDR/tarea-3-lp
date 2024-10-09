public class CentroGalactico extends Planeta {
    public void menuRecursos(Jugador jugador){
        System.out.println(" ");
        System.out.println("  __     ______  _    _   _      ____   _   _   _ ");
        System.out.println("  \\ \\   / / __ \\| |  | | | |    / __ \\ | | | | | |");
        System.out.println("   \\ \\_/ / |  | | |  | | | |   | |  | || | | | | |");
        System.out.println("    \\   /| |  | | |  | | | |   | |  | || | | | | |");
        System.out.println("     | | | |__| | |__| | | |___| |__| || |_| |_| |");
        System.out.println("     |_|  \\____/ \\____/  |______\\____/  \\_____(_)_|");
        System.out.println(" ");
        System.out.println("       ***** ¡Has ganado el juego! ***** ");
        System.out.println("      Felicitaciones, tu aventura ha sido exitosa.");
        System.out.println(" ");
        System.out.println("           ヽ༼ຈل͜ຈ༽ﾉ  ¡VICTORIA! ヽ༼ຈل͜ຈ༽ﾉ ");
        System.out.println(" ");
        NoJavaSky.partida = false;
    }

    public int extraerRecursos(int tipo){return 0;}
}
