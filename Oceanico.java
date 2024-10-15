import java.util.Scanner;

public class Oceanico extends Planeta implements TieneAsentamientos{
    private int profundidad;
    /*
    None
    ***
    Inicializa los valores de un planeta oceánico, basado en las especificaciones iniciales del enunciado
    */
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
    /*
    None
    ***
    Muestra todos los atributos del planeta Oceánico, incluyendo los atributos heredados y la profundidad.
    */
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Profundidad: " + profundidad);        
        }
    /* Parametro 1: jugador (Jugador)
    ***
    None
    ***
    Permite al jugador interactuar con el planeta, seleccionando diferentes acciones como extraer recursos o interactuar con los locatarios.
    */
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
    
            if (jugador.getEnergia() <= 0) {
                System.out.println("Energía agotada. Has sido expulsado del planeta.");
                interactuar = false;
                jugador.truePerder();
            }
        }
    
    }
    /* Parametro 1: tipo (int)
    ***
    Return: cantidad (int)
    ***
    Permite al jugador extraer una cantidad de recurso de un tipo específico (cristales de hidrógeno o flores de sodio), ajustando el inventario del planeta.
    */
    public int extraerRecursos(int tipo) {
        int cantidad;
        System.out.println("Indique la cantidad de recurso que desea extraer: ");

        Scanner scanner2 = new Scanner(System.in);
        cantidad = Integer.parseInt(scanner2.nextLine());

        switch (tipo) {
            case 1: 
                if (cantidad > getCristalesHidrogeno()) {
                    System.out.println("No hay suficientes cristales de hidrógeno. Solo puedes extraer " + getCristalesHidrogeno() + " unidades.");
                    cantidad = getCristalesHidrogeno();  
                }
                setCristalesHidrogeno(getCristalesHidrogeno() - cantidad);
                break;

            case 2:
                if (cantidad > getFloresDeSodio()) {
                    System.out.println("No hay suficientes flores de sodio. Solo puedes extraer " + getFloresDeSodio() + " unidades.");
                    cantidad = getFloresDeSodio(); 
                }
                setFloresDeSodio(getFloresDeSodio() - cantidad);
                break;

            default:
                System.out.println("Tipo de recurso inválido.");
                cantidad = 0;
        }

        return cantidad;
    }

    /* Parametro 1: jugador (Jugador)
    ***
    None
    ***
    Permite al jugador visitar el asentamiento del planeta oceánico, donde puede mejorar la nave o el exotraje a cambio de platino o uranio.
    */
    public void visitarAsentamiento(Jugador jugador) {
    Scanner scanner = new Scanner(System.in);
    boolean interactuar = true;

    System.out.println("          __");
    System.out.println("         /  \\");
    System.out.println("        / ..|\\");
    System.out.println("       (_\\  |_)");
    System.out.println("       /  \\@'");
    System.out.println("      /     \\");
    System.out.println("   _ /  `   |");
    System.out.println("  //| . . . |\\");
    System.out.println(" // | . . . | \\");
    System.out.println("|||||.....|||||");
    System.out.println(" |||||.....|||||\n");

    System.out.println("\nHas llegado al asentamiento costero del planeta oceánico. Las gigantes estructuras flotantes parecen desafiar la calma del inmenso océano azul que se extiende hacia el horizonte.");
    System.out.println("A lo lejos, criaturas marinas colosales, cuyos cuerpos luminosos se deslizan entre las corrientes, emergen de las profundidades y emiten cantos hipnóticos que resuenan en el asentamiento.");
    System.out.println("\"Bienvenido, viajero estelar\", dice una voz mecánica que emana de un dron que flota junto a ti. \"Aquí, puedes mejorar tu nave o exotraje con los recursos de este mundo marino.\"");
    System.out.println("El agua a tus pies es tan clara que puedes ver criaturas nadando en las profundidades, su bioluminiscencia iluminando las plataformas.");

    while (interactuar) {
        System.out.println("\nOpciones disponibles:");
        System.out.println("1: Mejora de nave un 10% por 70 de platino");
        System.out.println("2: Mejora de exotraje un 12% por 35 de uranio");
        System.out.println("3: Salir del asentamiento");
        System.out.print("¿Qué deseas hacer? Ingresa tu opción: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        
        switch (opcion) {
            case 1:
                if (jugador.getPlatino() >= 70) {
                    jugador.setPlatino(-70); 
                    jugador.setMejorasNave(0.1f); 
                    System.out.println("Los ingenieros del asentamiento, acompañados por seres marinos inteligentes que parecen medusas gigantes, trabajan en tu nave.");
                    System.out.println("El agua del océano es utilizada en el proceso, brillando mientras tus motores son recalibrados.");
                    System.out.println("\"Has mejorado la eficiencia del propulsor de tu nave\", dice el dron. \"Ahora viajarás más lejos, con la velocidad de los vientos oceánicos.\"");
                } else {
                    System.out.println("El dron emite un pitido bajo. \"No tienes suficiente platino. Quizás podrías cazar una de las criaturas marinas para obtener más recursos...\"");
                }
                break;
            case 2:
                if (jugador.getUranio() >= 35) {
                    jugador.setUranio(-35); 
                    jugador.setEficiencia(0.12f); 
                    System.out.println("Te diriges al laboratorio submarino del asentamiento, sumergido en una cúpula de cristal bajo el agua.");
                    System.out.println("Los técnicos, junto a criaturas de las profundidades que brillan como estrellas, ajustan la tecnología de tu exotraje.");
                    System.out.println("\"Has mejorado la eficiencia energética de tu exotraje\", dice el dron. \"Como las criaturas que sobreviven en las heladas profundidades, resistirás mejor en ambientes hostiles.\"");
                } else {
                    System.out.println("El dron emite un zumbido. \"No tienes suficiente uranio. Quizás en las profundidades haya más... si te atreves a buscarlo.\"");
                }
                break;
            case 3:
                System.out.println("Te despides del asentamiento mientras las criaturas marinas emiten sus últimos cantos antes de sumergirse nuevamente en el océano.");
                System.out.println("\"Vuelve cuando necesites más mejoras\", murmura el dron mientras te deslizas por los pasillos húmedos y sales de la plataforma.");
                interactuar = false;
                break;
            default:
                System.out.println("\"Opción inválida\", señala el dron con un tono molesto. \"Por favor, elige nuevamente.\"");
        }
    }
}
    /* Parametro 1: profundidad
    ***
    None
    ***
    Setea el parametro
     */
    public void setProfundidad(int profundidad){
        this.profundidad = profundidad;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getProfundidad(){
        return profundidad;
    }
}
