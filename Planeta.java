import java.util.Scanner;

public abstract class Planeta {

    protected int radio;
    protected int cristalesHidrogeno;
    protected int floresDeSodio;
    protected int consumo;
    private static int cIndice = 0;
    protected int indice; 

    public Planeta(){
        this.indice = cIndice++;

    }
    public int getIndice(){
        return indice;
    }

    public int calMineral(int radio, float constante){
        int mineral = (int) (constante * 4 * Math.PI * Math.pow(radio, 2));
        return mineral;
    }

    public int calAtributo(int max, int min){
        int atributo = (int) (Math.random() * (max - min + 1)) + min;
        return atributo;
    }
    public int calConsumo(int variable, float constante, int exponente){
        variable = Math.abs(variable);
        variable = (int) Math.pow(variable, exponente);
        int consumo = (int) (constante * variable);
        return consumo;
    }
    
    public boolean visitar(Jugador jugador){
        System.out.println("Haz ingresado al planeta");
        return true;
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
            if (this instanceof Volcanico) {
                ((Volcanico) this).extraerPlatino(cantidad); // Llama al método específico de Volcanico
            } else {
                System.out.println("Este planeta no tiene platino.");
            }
                break;
            case 4:
                System.out.println("Opción 4 seleccionada: Ayuda");
                break;
            case 5:
                System.out.println("Opción 5 seleccionada: Salir");
                break;
            // No hay caso default
        }
    


        //jugador.sethidrogeno(cantidad);

        scanner.close();
        return 0;
    }
    public boolean salir(){
        System.out.println("Haz salido al planeta");

        return false;
    }
    public int getRadio() {
        return radio;
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public int getConsumo() {
        return consumo;
    }
    public void mostrarAll(){
        System.out.println("Planeta " + getClass().getSimpleName());
        System.out.println("Índice: " + getIndice());
        System.out.println("Radio: " + getRadio());
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        System.out.println("Consumo: " + getConsumo());
    }
}