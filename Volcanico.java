import java.util.Scanner;

public class Volcanico extends Planeta{
    private int temperatura;
    private int platino;
    /*
    None
    ***
    Return: void
    Inicializa el planeta con atributos calculados
    */
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
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getPlatino(){
        return platino;
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
        System.out.println("Temperatura: " + temperatura);    
        System.out.println("Platino: " + platino);        

    }
    /* Parametro 1: numero (int)
    ***
    Return: void
    ***
    Establece la cantidad de platino restando un número especificado del total disponible.
    */
    public void setPlatino(int numero){
        platino -= numero;
    }
    /* Parametro 1: cantidad (int)
    ***
    Return: void
    ***
    Extrae una cantidad específica de platino si hay suficiente disponible. De lo contrario, notifica que no hay suficiente platino.
    */
    public void extraerPlatino(int cantidad) {
        if (cantidad <= platino) {
            platino -= cantidad;
            System.out.println("Se han extraído " + cantidad + " de platino.");
        } else {
            System.out.println("No hay suficiente platino para extraer.");
        }
    }
    /* Parametro 1: jugador (Jugador)
    Return: void
    ***
    Menú de recursos del planeta. Permite al jugador extraer cristales de hidrógeno, flores de sodio o uranio, y salir del planeta. La interacción continúa hasta que el jugador elige salir o su energía se agota.
    */
    public void menuRecursos(Jugador jugador) {
        boolean interactuar = true;
        Scanner scanner = new Scanner(System.in);
    
        while (interactuar) {
            System.out.println("Que acción desea hacer (ingrese número de la acción): ");
            System.out.println("1: Extraer cristales de hidrógeno");
            System.out.println("2: Extraer platino");
            System.out.println("3: Salir del planeta");
    
            int cantidadExtraida = 0;
            int tipo = Integer.parseInt(scanner.nextLine());
    
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
    
    
            case 2: // Platino
                if (cantidad > platino) {
                    System.out.println("No hay suficiente platino. Solo puedes extraer " + platino + " unidades.");
                    cantidad = platino; 
                }
                platino -= cantidad;
                break;
    
            default:
                System.out.println("Tipo de recurso inválido.");
                cantidad = 0; 
        }
    
        return cantidad;
    }
    /*
    ***
    Retorno: int
    ***
    Devuelve la temperatura del planeta.
    */
    public int getTemp(){
        return temperatura;
    }
    /* Parametro 1: temperatura
    ***
    None
    ***
    Setea el parametro
     */
    public void setTemp(int temperatura){
        this.temperatura = temperatura;
    }
}
