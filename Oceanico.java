import java.util.Scanner;

public class Oceanico extends Planeta implements TieneAsentamientos{
    private int profundidad;

    public Oceanico(){
        super();
        int radio = calAtributo(1000000, 10000);
        int cristalesHidrogeno = calMineral(radio, 0.2f);
        int floresDeSodio = calMineral(radio, 0.65f);
        this.profundidad = calAtributo(1000, 30);
        int consumo = calConsumo(profundidad, 0.002f, 2);
        setRadio(radio);
        setCristalesHidrogeno(cristalesHidrogeno);
        setFloresDeSodio(floresDeSodio);
        setConsumo(consumo);
    }
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Profundidad: " + profundidad);        
        }
    public void menuRecursos(Jugador jugador) {
        boolean interactuar = true;
        Scanner scanner = new Scanner(System.in);
    
        while (interactuar) {
            System.out.println("Que acción desea hacer (ingrese número de la acción): ");
            System.out.println("1: Extraer cristales de hidrógeno");
            System.out.println("2: Extraer flores de sodio");
            System.out.println("3: Hablar con los locatarios");
            System.out.println("4: Salir del planeta");
    
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
                    jugador.setSodio(cantidadExtraida);
                    break;
                case 3:
                    visitarAsentamiento(jugador);
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
        int cantidad;
        System.out.println("Indique la cantidad de recurso que desea extraer: ");

        Scanner scanner2 = new Scanner(System.in);
        cantidad = Integer.parseInt(scanner2.nextLine());
        switch (tipo) {
            case 1:
                setCristalesHidrogeno(getCristalesHidrogeno() - cantidad);
                break;
            case 2:
                setFloresDeSodio(getFloresDeSodio() - cantidad);
                break;
        }

        return cantidad;
    }

    public void visitarAsentamiento(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        boolean interactuar = true;
    
        System.out.println("Bienvenido al asentamiento. Aquí puedes mejorar tu nave o exotraje.");
    
        while (interactuar) {
            System.out.println("Opciones disponibles:");
            System.out.println("1: Mejorar la eficiencia del propulsor de la nave un 2% (requiere 10 de platino)");
            System.out.println("2: Mejorar la eficiencia del exotraje un 5% (requiere 10 de uranio)");
            System.out.println("3: Salir del asentamiento");
    
            int opcion = Integer.parseInt(scanner.nextLine());
    
            switch (opcion) {
                case 1:
                    if (jugador.getPlatino() >= 10) {
                        jugador.setPlatino(-10); // Resta 10 de platino
                        jugador.setMejorasNave(0.02f); // Mejora la nave
                        System.out.println("Has mejorado la eficiencia del propulsor de tu nave.");
                    } else {
                        System.out.println("No tienes suficiente platino.");
                    }
                    break;
                case 2:
                    if (jugador.getUranio() >= 10) {
                        jugador.setUranio(-10); // Resta 10 de uranio
                        jugador.setEficiencia(0.05f); // Mejora la eficiencia del exotraje
                        System.out.println("Has mejorado la eficiencia energética de tu exotraje.");
                    } else {
                        System.out.println("No tienes suficiente uranio.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del asentamiento.");
                    interactuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Elige nuevamente.");
            }
        }
    }
    
}
