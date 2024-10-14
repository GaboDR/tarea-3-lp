import java.util.Scanner;

public class Jugador {

    private int sodio;
    private int hidrogeno;
    private int platino;
    private int uranio;
    private float mejorasNave;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaPropulsor;
    private boolean perder;
    /*
    ***
    None
    ***
    Constructor de la clase Jugador. Inicializa los atributos del jugador, como la energía de protección, eficiencia del propulsor, y los recursos (sodio, hidrógeno, platino, uranio). También establece las mejoras de la nave y el estado de perder en falso.
    */
    public Jugador(){
        unidadesEnergiaProteccion = 100f;
        eficienciaEnergiaPropulsor = 0f;
        sodio = 0;
        hidrogeno = 0;
        platino = 0;
        uranio = 0;
        mejorasNave = 0;
        perder = false;

    }
    /*
    Parametro 1: sodios (int)
    ***
    None
    ***
    Suma la cantidad de sodio especificada al inventario del jugador.
    */
    public void setSodio(int sodios){
        sodio += sodios;
    }
    /*
    Parametro 1: hidrogenos (int)
    ***
    None
    ***
    Suma la cantidad de hidrógeno especificada al inventario del jugador.
    */
    public void setHidrogeno(int hidrogenos){
        hidrogeno += hidrogenos;
    }
    /*
    Parametro 1: platinos (int)
    ***
    None
    ***
    Suma la cantidad de platino especificada al inventario del jugador.
    */
    public void setPlatino(int platinos){
        platino += platinos;
    }
    /*
    Parametro 1: uranios (int)
    ***
    None
    ***
    Suma la cantidad de uranio especificada al inventario del jugador.
    */
    public void setUranio(int uranios){
        uranio += uranios;
    }
    /*
    Parametro 1: mejoras (float)
    ***
    None
    ***
    Incrementa la eficiencia del exotraje según la cantidad de mejoras. Si la eficiencia excede el 100%, se ajusta al límite máximo y se muestra un mensaje.
    */
    public void setEficiencia(float mejoras){
        if (eficienciaEnergiaPropulsor + mejoras > 1.0f) {
            eficienciaEnergiaPropulsor = 1.0f; 
            System.out.println("La eficiencia del exotraje ha alcanzado el máximo permitido (100%).");
        } else {
            eficienciaEnergiaPropulsor += mejoras;
        }
    }
    /*
    Parametro 1: mejoras (float)
    ***
    None
    ***
    Suma las mejoras especificadas a las mejoras de la nave.
    */
    public void setMejorasNave(float mejoras){
        mejorasNave += mejoras;
    }
    /*
    ***
    None
    ***
    Establece el estado del jugador a 'perder' como verdadero, indicando que ha perdido.
*/
    public void truePerder(){
        perder = true;
    }
    /*
    ***
    None
    ***
    Establece el estado del jugador a 'perder' como falso, indicando que no ha perdido.
    */
    public void falsePerder(){
        perder = false;
    }
    /*
    Parametro 1: sodio (int)
    ***
    None
    ***
    Recarga la energía de protección del exotraje en función de la cantidad de sodio y la eficiencia del propulsor. No excede el límite de 100 unidades de energía.
    */
    public void recargarEnergiaProteccion(int sodio){
        float carga = 0.65f * (float) sodio * (1f + eficienciaEnergiaPropulsor);
        if (unidadesEnergiaProteccion +carga>=100) {
            unidadesEnergiaProteccion = 100;
        } else {
            unidadesEnergiaProteccion += carga;
        }
    }
    /*
    Parametro 1: unidade (int)
    Parametro 2: consumo (int)
    ***
    None
    ***
    Reduce la energía de protección del exotraje en función de la cantidad de unidades consumidas y la eficiencia del propulsor.
    */
    public void cosumirEnergia(int unidade, int consumo){
        unidadesEnergiaProteccion -= 0.5f * (float) unidade * ((float) consumo)/100 * (1-eficienciaEnergiaPropulsor);
    }
    /*
    ***
    None
    ***
    Muestra el inventario actual del jugador, incluyendo la energía del exotraje, eficiencia del exotraje, y los recursos recolectados (sodio, hidrógeno, platino, uranio).
    */
    public void mostrarInventario() {
        System.out.println("\n============================");
        System.out.println("         INVENTARIO          ");
        System.out.println("============================");
        System.out.println(String.format("Energía del Exotraje:  %10.2f", unidadesEnergiaProteccion));
        System.out.println(String.format("Eficiencia Exotraje:   %10.2f", eficienciaEnergiaPropulsor));
        System.out.println("----------------------------");
        System.out.println(String.format("Hidrógeno:             %10d", hidrogeno));
        System.out.println(String.format("Sodio:                %10d", sodio));
        System.out.println(String.format("Platino:              %10d", platino));
        System.out.println(String.format("Uranio:               %10d", uranio));
        System.out.println("============================\n");
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getSodio(){
        return sodio;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getHidrogeno(){
        return hidrogeno;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getPlatino(){
        return platino;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getUranio(){
        return uranio;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public float getEnergia(){
        return unidadesEnergiaProteccion;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public float getMejoras(){
        return mejorasNave;
    }
    /*
    Parametro 1: nave (Nave)
    Parametro 2: mapa (MapaGalactico)
    ***
    None
    ***
    Reinicia el inventario del jugador, las mejoras de la nave, y la energía del exotraje en caso de que el jugador haya perdido. También reinicia el estado de la nave y del mapa galáctico. 
    */
    public void reset(Nave nave, MapaGalactico mapa) {
        if (perder) {
            sodio = 0;
            hidrogeno = 0;
            platino = 0;
            uranio = 0;
    
            mejorasNave = 0;
            eficienciaEnergiaPropulsor = 0f;
    
            unidadesEnergiaProteccion = 100f;
            
            perder = false;

            nave.restart();
            mapa.reset();
    
            System.out.println("SE ACTIVO EL SISTEMA DE EMERGENCIA!!!");
            System.out.println("Vuelves al planeta 0 y pierdes todo tu inventario y mejoras");

        }
    }
    /*
    ***
    None
    ***
    Muestra el tutorial del juego, explicando las mecánicas como la recolección de recursos, la mejora de equipo, y el viaje entre planetas. Pausa en varios puntos para permitir al jugador leer.
    */
    public void mostrarTutorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al tutorial de tu aventura intergaláctica. Aquí aprenderás cómo moverte, extraer recursos y mejorar tu equipo.");
        pausarTutorial(scanner);

        System.out.println("\n--- Interactuar con el Planeta ---");
        System.out.println("Cuando aterrices en un planeta, tendrás las siguientes opciones:");
        System.out.println(" Extraer Cristales de Hidrógeno.");
        System.out.println(" Recoger Flores de Sodio.");
        System.out.println(" Extaer uranio.");
        System.out.println(" Recoger platino.");
        System.out.println(" Visitar los Asentamientos para mejorar tu nave o exotraje.");
        System.out.println(" Salir del planeta.");
        System.out.println(" Las opciones dependeran del tipo de planeta que estes.");

        pausarTutorial(scanner); 

        System.out.println("\n--- Minado de Recursos ---");
        System.out.println("Para extraer recursos, elige la opción del recurso en el menú del planeta.");
        System.out.println("Extraer Cristales de Hidrógeno te permitirá recargar combustible para la nave.");
        System.out.println("Extraer Flores de Sodio te permitirá recargar la energía de tu exotraje.");
        System.out.println("Extraer uranio y platino te servirá para tradear con locatarios.");
        System.out.println("Ten en cuenta que extraer recursos consume la energía de tu exotraje, y si se agota, serás expulsado del planeta,");
        System.out.println("perderas todo tu inventario, mejoras y volveras al inicio del mapa.");

        pausarTutorial(scanner); 

        System.out.println("\n--- Interactuar con Asentamientos ---");
        System.out.println("En los asentamientos, puedes intercambiar recursos para mejorar tu equipo:");
        System.out.println("1. Mejorar la eficiencia del propulsor de tu nave usando platino o uranio.");
        System.out.println("2. Mejorar la eficiencia energética de tu exotraje usando platino o uranio.");
        System.out.println("Estas mejoras te permitirán viajar más lejos y protegerte mejor en ambientes hostiles.");
        System.out.println("las mejoras de la nave pueden ser aplicadas cuando estes en ella ¡No se aplican automaticamente!.");

        pausarTutorial(scanner);

        System.out.println("\n--- Viajar entre Planetas ---");
        System.out.println("Para viajar entre planetas, debes utilizar tu nave.");
        System.out.println("Usa el mapa galáctico para ver la ubicación de los planetas y planificar tus viajes.");
        System.out.println("Cada salto consume combustible, que puedes recargar extrayendo Cristales de Hidrógeno.");
        System.out.println("Si mejoras la eficiencia del propulsor en los asentamientos, consumirás menos combustible en cada salto.");
        System.out.println("Cuando hagas un viaje te quedaras orbitando el planeta hasta que decidas ingresar.");

        pausarTutorial(scanner); 

        System.out.println("\n--- Recargar Combustible y Energía ---");
        System.out.println("Recarga el combustible de tu nave usando Cristales de Hidrógeno.");
        System.out.println("Recarga la energía de tu exotraje usando Flores de Sodio.");
        System.out.println("Recuerda que puedes ver la cantidad de hidrógeno y sodio en tu inventario.");
        System.out.println("Todas estas opciones estan disponibles cuando estes en tu nave orbitando el planeta, no las podras hacer cuando ingreses al planeta.");

        
        pausarTutorial(scanner);

        System.out.println("\n¡Eso es todo por ahora! Explora la galaxia, mejora tu equipo y sobrevive en los planetas más hostiles.");
    }
    /*
    Parametro 1: scanner (Scanner)
    ***
    None
    ***
    Pausa el tutorial para que el usuario presione una tecla y continuar con la siguiente sección.
    */
    private void pausarTutorial(Scanner scanner) {
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine(); 
    }
    /*
    ***
    None
    ***
    Muestra una introducción con narrativa y arte ASCII al inicio del juego, explicando la misión del jugador y las mecánicas clave del juego.
    */
    public void introduccionConNarrativa() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("          __");
        System.out.println("         /  \\");
        System.out.println("   .-.  |    |");
        System.out.println("   | |  |    |");
        System.out.println("   | |  |    |");
        System.out.println("   | |  |    |");
        System.out.println("   | |  |    |");
        System.out.println("   | | /| |\\ |");
        System.out.println("   |_|/ |_| \\_|");
        System.out.println();
        System.out.println("==== Bienvenido al universo de NoJavaSky ====");
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("Te despiertas en la cabina de tu nave, flotando en la vasta inmensidad del espacio.");
        System.out.println("Las estrellas parpadean a lo lejos, mientras un planeta azul verdoso gira lentamente debajo de ti.");
        System.out.println("Este es solo uno de los muchos planetas por descubrir...");
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("        _____");
        System.out.println("     ,-:` \\;',`'-,");
        System.out.println("    .'-;_,;  ':-;_,'");
        System.out.println("   /;   '/    ,  _`.-\\");
        System.out.println("  | '`. (`     /` ` \\`|");
        System.out.println("  |:.  `\\`-.   \\_   / |");
        System.out.println("  |     (   `,  .`\\ ;'|");
        System.out.println("   \\     | .'     `-'/'");
        System.out.println("    `.   ;/        .'");
        System.out.println("      `'-._____.'");
        System.out.println();
        System.out.println("Misión: Sobrevivir, explorar y expandir.");
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("Tu misión es simple, pero desafiante: Explorar sistemas estelares desconocidos, recolectar recursos,");
        System.out.println("mejorar tu nave y exotraje, y sobrevivir en condiciones inhóspitas.");
        System.out.println("Podrás interactuar con los asentamientos alienígenas y mejorar tu equipo, o correr el riesgo de morir en planetas hostiles.");

        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("En tu viaje espacial, estas son algunas de las mecánicas clave:");
        System.out.println("1. **Exploración y recursos**: Viaja entre planetas y extrae recursos como Hidrógeno y Sodio para recargar tu nave y tu exotraje.");
        System.out.println("2. **Asentamientos**: Mejora tu nave o exotraje en los asentamientos con platino y uranio, donde también puedes comerciar con especies locales.");
        System.out.println("3. **Viaje galáctico**: Navega el Mapa Galáctico y descubre nuevos planetas. Tu eficiencia y combustible determinarán cuán lejos puedes llegar.");
        System.out.println("4. **Supervivencia**: Asegúrate de tener suficientes recursos para sobrevivir. Si agotas tu energía, tu viaje podría llegar a un trágico fin.");
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("       .--.");
        System.out.println("      |o_o |");
        System.out.println("      |:_/ |");
        System.out.println("     //   \\ \\");
        System.out.println("    (|     | )");
        System.out.println("   /'\\_   _/`\\");
        System.out.println("   \\___)=(___/");
        System.out.println();
        System.out.println("**Advertencia**: Si tu energía llega a 0, serás expulsado de los planetas y perderás tu progreso volviendo al planeta 0.");
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();
    
        System.out.println("Para ganar, debes alcanzar el mítico Centro Galactico, donde se dice que la verdadera aventura comienza, ");
        System.out.println("Como el Centro Galactico es una area hostil para las naves, tu eficiencia de propulsor debe ser mayor al 50% para ingresar");
        
        System.out.println("Para perder... simplemente agota tu energía o combustible. Pero eso no ocurrirá si juegas con inteligencia, ¿verdad?");
    
        System.out.println("Buena suerte, viajero estelar.");
        System.out.println("Presiona cualquier tecla para finalizar...");
        scanner.nextLine();
    }
    
}
