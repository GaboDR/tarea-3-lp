import java.util.Scanner;

public class Helado extends Planeta implements TieneAsentamientos{
    private int temperatura;
    /*
    ***
    None
    ***
    Constructor de la clase Helado. Inicializa atributos como el radio,
    la cantidad de cristales, flores y la temperatura, ademas de calcular
    el consumo de energia segun la temperatura.
    */
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
    /*
    ***
    Retorno: int
    ***
    Devuelve la temperatura del planeta Helado.
    */
    public int getTemp(){
        return temperatura;
    }
    /*
    ***
    None
    ***
    Muestra todos los atributos del planeta, incluyendo la temperatura.
    */
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Temperatura: " + temperatura);        
    }
    /*
    Parametro 1: Jugador
    ***
    None
    ***
    Muestra un menu de opciones para que el jugador interactue con los recursos
    del planeta, incluyendo la extraccion de cristales de hidrogeno y flores de sodio,
    asi como visitar asentamientos.
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
    /* Parametro 1: Tipo (int)
    ***
    Retorno: int
    ***
    Permite extraer una cantidad especifica de recursos segun el tipo.
    Limita la extraccion a la cantidad disponible en el planeta.
    */
    public int extraerRecursos(int tipo) {
        int cantidad;
        System.out.println("Indique la cantidad de recurso que desea extraer: ");
        Scanner scanner2 = new Scanner(System.in);
        cantidad = Integer.parseInt(scanner2.nextLine());
    
        switch (tipo) {
            case 1: // Cristales de hidrógeno
                if (cantidad > getCristalesHidrogeno()) {
                    System.out.println("No hay suficientes cristales de hidrógeno. Solo puedes extraer " + getCristalesHidrogeno() + " unidades.");
                    cantidad = getCristalesHidrogeno();  
                }
                setCristalesHidrogeno(getCristalesHidrogeno() - cantidad);
                break;
    
            case 2: // Flores de sodio
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
    /* Parametro 1: Jugador
    ***
    None
    ***
    Permite al jugador visitar un asentamiento en el planeta Helado,
    donde puede mejorar su nave o exotraje a cambio de uranio o platino.
    */
    public void visitarAsentamiento(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        boolean interactuar = true;
    
        System.out.println("     *    .     .       .   . *       *");
        System.out.println("     .       *        .        *     .");
        System.out.println("       *    .      *   .   *   .     .");
        System.out.println("          __/ \\__    .      *     *  .");
        System.out.println("     *  . \\_o_o_o/  *   .      .  *   ");
        System.out.println("  .     .  || || || .      *    .     *");
        System.out.println("         __||_||_||__      .   *   . ");
        System.out.println("     .  /___________/   *    .        *");
    
        System.out.println("\nHas llegado a un inhóspito asentamiento en el desolado planeta helado. El frío cortante te recibe al bajar de tu nave.");
        System.out.println("Los locales, cubiertos en gruesas capas de piel sintética y rodeados de construcciones semi-enterradas en el hielo, parecen más duros que las mismas montañas de hielo que los rodean.");
        System.out.println("Aquí, puedes intercambiar uranio y platino por mejoras para tu nave o exotraje, esenciales para sobrevivir en este mundo brutal.");
        System.out.println("A lo lejos, colosales tormentas de nieve giran sin cesar, devorando todo a su paso.");
    
        while (interactuar) {
            System.out.println("\nOpciones de mejora:");
            System.out.println("1: Mejora de nave 5% por 50 uranio");
            System.out.println("2: Mejora de exotraje 10% por 30 platino");
            System.out.println("3: Salir del asentamiento");
            System.out.print("¿Qué deseas hacer? Ingresa tu opción: ");
            
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:
                    if (jugador.getUranio() >= 50) {
                        jugador.setUranio(-50);
                        jugador.setMejorasNave(0.05f);
                        System.out.println("Los habitantes, con manos expertas endurecidas por el frío, trabajan rápidamente en tu nave. Utilizan los recursos naturales del hielo y la radiación del uranio para mejorar el propulsor.");
                        System.out.println("\"La nave está lista\", dice uno de ellos, su aliento visible en el aire congelado. \"Con estas mejoras, tu nave será más rápida que el viento helado.\"");
                    } else {
                        System.out.println("Uno de los locales te mira con desaprobación: \"No tienes suficiente uranio. Sin este recurso, no podemos ayudarte.\"");
                    }
                    break;
                case 2:
                    if (jugador.getPlatino() >= 30) {
                        jugador.setPlatino(-30);
                        jugador.setEficiencia(0.1f);
                        System.out.println("Te diriges a un pequeño laboratorio excavado en la nieve. Aquí, los ingenieros locales utilizan platino y otros metales raros para reforzar tu exotraje.");
                        System.out.println("El frío gélido se siente menos intenso a medida que el aislamiento del exotraje mejora.");
                        System.out.println("\"Ahora podrás enfrentarte a las peores tormentas\", te asegura uno de los ingenieros mientras ajusta los últimos detalles de tu traje.");
                    } else {
                        System.out.println("Los ingenieros te observan en silencio mientras les informas que no tienes suficiente platino.");
                        System.out.println("\"Vuelve cuando tengas más recursos\", dice uno con un tono frío como el hielo que los rodea.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del asentamiento, el viento helado te envuelve de nuevo. Los locales te observan desde sus refugios en la nieve.");
                    System.out.println("\"Que las tormentas te sean leves, viajero\", dice uno de ellos antes de que las puertas del asentamiento se cierren detrás de ti.");
                    interactuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor elige una opción válida.");
            }
        }
    }
    

}