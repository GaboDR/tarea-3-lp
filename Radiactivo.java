import java.util.Scanner;

public class Radiactivo extends Planeta{
    private int radiacion;
    private int uranio;

    public Radiactivo(){
        super();
        int radio = calAtributo(100000, 10000);
        int cristalesHidrogeno = calMineral(radio, 0.2f);
        int floresDeSodio = calMineral(radio, 0.2f);
        this.radiacion = calAtributo(50, 10);
        int consumo = calConsumo(radiacion, 0.3f, 1);
        this.uranio = calMineral(radio, 0.25f);

        setRadio(radio);
        setCristalesHidrogeno(cristalesHidrogeno);
        setFloresDeSodio(floresDeSodio);
        setConsumo(consumo);
    }

    public int getUranio(){
        return uranio;
    }
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Radiacion: " + radiacion);        
        System.out.println("Uranio: " + uranio);        

    }

    public void menuRecursos(Jugador jugador) {
        boolean interactuar = true;
        Scanner scanner1 = new Scanner(System.in);
    
        while (interactuar) {
            System.out.println("Que acción desea hacer (ingrese número de la acción): ");
            System.out.println("1: Extraer cristales de hidrógeno");
            System.out.println("2: Extraer flores de sodio");
            System.out.println("3: Extraer uranio");
            System.out.println("4: Salir del planeta");
    
            int cantidadExtraida = 0;
            int tipo = Integer.parseInt(scanner1.nextLine());
    
            // Usar switch en lugar de if-else
            switch (tipo) {
                case 1:
                    cantidadExtraida = extraerRecursos(tipo);
                    jugador.setHidrogeno(cantidadExtraida);
                    break;
                case 2:
                    cantidadExtraida = extraerRecursos(tipo);
                    jugador.setSodio(cantidadExtraida);
                    break;
                case 3:
                    cantidadExtraida = extraerRecursos(tipo);
                    jugador.setUranio(cantidadExtraida);
                    break;
                case 4:
                    interactuar = false;
                    break;
                default:
                    System.out.println("Opción inválida, por favor elija una acción válida.");
            }
    
            if (cantidadExtraida > 0) {
                jugador.cosumirEnergia(cantidadExtraida, getConsumo());
                System.out.println("Energía restante del jugador: " + jugador.getEnergia());
            }
    
            // Verificar si la energía del jugador es 0 para salir automáticamente
            if (jugador.getEnergia() <= 0) {
                System.out.println("Energía agotada. Has sido expulsado del planeta.");
                interactuar = false;
                jugador.truePerder();

            }
        }
    

    }
    

    public int extraerRecursos(int tipo){
        System.out.println("Indique la cantidad de recurso que desea extraer: ");

        Scanner scanner2 = new Scanner(System.in);
        int cantidad = Integer.parseInt(scanner2.nextLine());

        switch (tipo) {
            case 1:
                setCristalesHidrogeno(getCristalesHidrogeno() - cantidad);
                break;
            case 2:
                setFloresDeSodio(getFloresDeSodio() - cantidad);
                break;
            case 3:
                uranio -= cantidad;
                break;
        }


        return cantidad;
    }
}
