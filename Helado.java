import java.util.Scanner;

public class Helado extends Planeta implements TieneAsentamientos{
    private int temperatura;

    public Helado(){
        super();
        int radio = calAtributo(1000000, 1000);
        int cristales = calMineral(radio, 0.65f);
        int flores = calMineral(radio, 0.35f);
        this.temperatura = calAtributo(-30, -120);
        int consumo = calConsumo(temperatura, 0.15f, 1);
        setRadio(radio);
        setCristalesHidrogeno(cristales);
        setFloresDeSodio(flores);
        setConsumo(consumo);
    }
    public int getTemp(){
        return temperatura;
    }

    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Temperatura: " + temperatura);        
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
    
        System.out.println("Los locales están muy interesados en tu uranio y platino.");
        System.out.println("Puedes intercambiarlos por mejoras de nave o exotraje.");
    
        while (interactuar) {
            System.out.println("Opciones de mejora:");
            System.out.println("1: Mejora de nave 5%  por 50 uranio");
            System.out.println("2: Mejora de exotraje 10% por 30 platino");
            System.out.println("3: Salir del asentamiento");
    
            int opcion = Integer.parseInt(scanner.nextLine());
    
            switch (opcion) {
                case 1:
                    if (jugador.getUranio() >= 50) {
                        jugador.setUranio(- 50);
                        jugador.setMejorasNave(0.05f);;
                        System.out.println("Has comprado mejoras a tu nave, recuerda aplicarlas!!.");
                    } else {
                        System.out.println("No tienes suficiente uranio para esta mejora.");
                    }
                    break;
                case 2:
                    if (jugador.getPlatino() >= 30) {
                        jugador.setPlatino(jugador.getPlatino() - 30);
                        jugador.setEficiencia(0.1f);;
                        System.out.println("Has mejorado tu exotraje. Eficiencia aumentada en un 10%.");
                    } else {
                        System.out.println("No tienes suficiente platino para esta mejora.");
                    }
                    break;
                case 3:
                    interactuar = false;
                    System.out.println("Has salido del asentamiento.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor elige una opción válida.");
            }
        }
    }  

}