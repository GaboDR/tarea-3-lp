import java.util.Scanner;

public class Radiactivo extends Planeta{
    private int radiacion;
    private int uranio;

    public Radiactivo(){
        super();
        this.radio = calAtributo(100000, 10000);
        this.cristalesHidrogeno = calMineral(radio, 0.2f);
        this.floresDeSodio = calMineral(radio, 0.2f);
        this.radiacion = calAtributo(50, 10);
        this.consumo = calConsumo(radiacion, 0.3f, 1);
        this.uranio = calMineral(radio, 0.25f);
    }

    public int getUranio(){
        return uranio;
    }
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Radiacion: " + radiacion);        
        System.out.println("Uranio: " + uranio);        

    }

    public void menuRecursos(Jugador jugador){
        System.out.println("Que accion desea hacer (ingrese numero de la accion): ");
        System.out.println("1: Extraer cristales de hidrogeno");
        System.out.println("2: Extraer flores de sodio");
        System.out.println("3: Extraer uranio");
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
                uranio -= cantidad;
                break;
        }

        scanner.close();
        return cantidad;
    }
}
