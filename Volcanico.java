import java.util.Scanner;

public class Volcanico extends Planeta{
    private int temperatura;
    private int platino;

    public Volcanico(){
        super();
        int radio = calAtributo(100000, 1000);
        int cristalesHidrogeno = calMineral(radio, 0.3f);
        int floresDeSodio = 0;
        this.temperatura = calAtributo(256, 120);
        int consumo = calConsumo(temperatura, 0.08f, 1);
        this.platino = (int) (0.25f * 4 * Math.PI * Math.pow(radio, 2) - 20.5f * Math.pow(temperatura, 2));

        setRadio(radio);
        setCristalesHidrogeno(cristalesHidrogeno);
        setFloresDeSodio(floresDeSodio);
        setConsumo(consumo);
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

    public void menuRecursos(Jugador jugador) {
        boolean interactuar = true;
        Scanner scanner = new Scanner(System.in);
    
        while (interactuar) {
            System.out.println("Que acción desea hacer (ingrese número de la acción): ");
            System.out.println("1: Extraer cristales de hidrógeno");
            System.out.println("2: Extraer uranio");
            System.out.println("3: Salir del planeta");
    
            int cantidadExtraida = 0;
            int tipo = Integer.parseInt(scanner.nextLine());
    
            // Usar switch en lugar de if-else
            switch (tipo) {
                case 1:
                    cantidadExtraida = extraerRecursos(tipo);
                    jugador.setHidrogeno(cantidadExtraida);
                    break;
                case 2:
                    cantidadExtraida = extraerRecursos(tipo);
                    jugador.setPlatino(cantidadExtraida);
                    break;
                case 3:
                    interactuar = false; // Salir del planeta
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
                platino -= cantidad;
                break;
        }

        return cantidad;
    }
}
