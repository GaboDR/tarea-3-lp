import java.util.Scanner;

public class Radiactivo extends Planeta{
    private int radiacion;
    private int uranio;

    /*
    None
    ***
    Return: void
    Inicializa el planeta con atributos calculados
    */
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
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getUranio(){
        return uranio;
    }
    /*
    None
    ***
    Return: void
    ***
    Muestra toda la información del planeta radiactivo, incluyendo radiación y uranio, además de los atributos heredados.
    */
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Radiacion: " + radiacion);        
        System.out.println("Uranio: " + uranio);        

    }
    /* Parametro 1: jugador (Jugador)
    Return: void
    ***
    Menú de recursos del planeta. Permite al jugador extraer cristales de hidrógeno, flores de sodio o uranio, y salir del planeta. La interacción continúa hasta que el jugador elige salir o su energía se agota.
    */
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
    
            if (jugador.getEnergia() <= 0) {
                System.out.println("Energía agotada. Has sido expulsado del planeta.");
                interactuar = false;
                jugador.truePerder();

            }
        }
    

    }
    
    /* Parametro 1: tipo (int)
    ***
    Return: int
    ***
    Permite al jugador extraer recursos del planeta en función del tipo seleccionado. 
    */
    public int extraerRecursos(int tipo) {
        System.out.println("Indique la cantidad de recurso que desea extraer: ");
    
        Scanner scanner2 = new Scanner(System.in);
        int cantidad = Integer.parseInt(scanner2.nextLine());
    
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
    
            case 3: // Uranio
                if (cantidad > uranio) {
                    System.out.println("No hay suficiente uranio. Solo puedes extraer " + uranio + " unidades.");
                    cantidad = uranio; 
                }
                uranio -= cantidad;
                break;
    
            default:
                System.out.println("Tipo de recurso inválido.");
                cantidad = 0; 
        }
    
        return cantidad;
    }
    /* Parametro 1: u
    ***
    None
    ***
    Setea el parametro
     */
    public void setUranio(int u){
        this.uranio = u;
    }
    /*
    ***
    None
    ***
    getter.
    */
    public int getRadiacion(){
        return radiacion;
    }
    /* Parametro 1: r
    ***
    None
    ***
    Setea el parametro
     */
    public void setRadiacion(int r){
        this.radiacion = r;
    }

}