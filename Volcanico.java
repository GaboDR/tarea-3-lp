import java.util.Scanner;

public class Volcanico extends Planeta{
    private int temperatura;
    private int platino;

    public Volcanico(){
        super();
        this.radio = calAtributo(100000, 1000);
        this.cristalesHidrogeno = calMineral(radio, 0.3f);
        this.floresDeSodio = 0;
        this.temperatura = calAtributo(256, 120);
        this.consumo = calConsumo(temperatura, 0.08f, 1);
        this.platino = (int) (0.25f * 4 * Math.PI * Math.pow(radio, 2) - 20.5f * Math.pow(temperatura, 2));
    }

    public int getPlatino(){
        return platino;
    }
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Temperatura: " + temperatura);    
        System.out.println("Platino: " + platino);        

    }
    public void setPlatino(int numero){
        platino -= numero;
    }
    
    public void extraerPlatino(int cantidad) {
        if (cantidad <= platino) {
            platino -= cantidad;
            System.out.println("Se han extraído " + cantidad + " de platino.");
        } else {
            System.out.println("No hay suficiente platino para extraer.");
        }
    }

    public void menuRecursos(Jugador jugador){
        System.out.println("Que accion desea hacer (ingrese numero de la accion): ");
        System.out.println("1: Extraer cristales de hidrogeno");
        System.out.println("2: Extraer flores de sodio");
        System.out.println("3: Extraer platino");
        System.out.println("4: Salir del planeta");

        Scanner scanner = new Scanner(System.in);
        int cantidad = Integer.parseInt(scanner.nextLine());

        if (cantidad != 4){
            int agregarInventario = extraerRecursos(cantidad);

        }



        scanner.close();
    }

    public int extraerRecursos(int tipo){
        System.out.println("Indique la cantidad de recurso que desea extraer: ");

        Scanner scanner = new Scanner(System.in);
        int cantidad = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1: // Cristales
                cristalesHidrogeno -= cantidad;
                break;
            case 2:
                floresDeSodio -= cantidad;
                break;
            case 3:
                platino -= cantidad;
                break;
        }

        scanner.close();
        return cantidad;
    }
}
