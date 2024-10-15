import java.util.ArrayList;

public class MapaGalactico {
    private ArrayList<Planeta> planetas;
    private static boolean centroGalacticoGenerado = false;
    private int posicion;
    /*
    ***
    None
    ***
    Inicializa la lista de planetas y genera el primer planeta en la posición 0.
    */
    public MapaGalactico(){
        planetas = new ArrayList<>();
        planetas.add(generadorPlaneta());
        posicion = 0;
    }
    /*
    ***
    None
    ***
    Retorna un objeto de tipo Planeta que representa el planeta generado.
    */
    public Planeta generadorPlaneta() { // Helado 1, Oceanico 2, radiactivo 3, volcanico 4, centro galactico 5
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 30) {
            return new Helado();
        } 
        else if (probabilidad <= 60) {
            return new Oceanico();
        } 
        else if (probabilidad <= 80) {
            return new Radiactivo();
        } 
        else if (probabilidad <= 99) {
            return new Volcanico();
        } 
        else {
            if (!centroGalacticoGenerado) {
                centroGalacticoGenerado = true;
                return new CentroGalactico();
            } else {
                return generadorPlaneta();
            }
        }
    }
    /* Parametro 1: cantidad (int)
    ***
    None.
    ***
    Genera planetas utilizando el método generadorPlaneta y los añade a la lista de planetas.
    */
    public void crearPlaneta(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            planetas.add(generadorPlaneta());
    }
}
    /* Parametro 1: planeta (Planeta)
    ***
    No retorna nada.
    ***
    Añade el planeta proporcionado a la lista de planetas.
    */
    public void agregar(Planeta planeta){
        planetas.add(planeta);
    }
    /* Parametro 1: indice (int)
    ***
    Retorna un objeto de tipo Planeta.
    ***
    Devuelve el planeta en la posición especificada por el índice en la lista de planetas.
    */
    public Planeta acceder(int indice){
        return planetas.get(indice); 
    }
    /*
    ***
    None
    ***
    Retorna un entero que representa la cantidad de planetas en la lista.
    */
    public int size(){
        return planetas.size();
    }
    /* Parametro 1: salto (int)
    ***
    None.
    ***
    Aumenta la posición actual según el valor proporcionado en el parámetro salto.
    */
    public void mover(int salto){
        posicion += salto;
    }
    /*
    ***
    None
    ***
    Retorna un objeto de tipo Planeta que representa el planeta en la posición actual.
    */
    public Planeta planetaActual() {
        return planetas.get(posicion);
    }
    /*
    ***
    None
    ***
    Retorna un entero que representa la posición actual en la lista de planetas.
    */
    public int obtenerPosicionActual() {
        return posicion;
    }
    /*
    ***
    None
    ***
    No retorna nada.
    ***
    Imprime en consola la lista de planetas y destaca la posición actual con una flecha o un asterisco.
    */
    public void mostrarMapa() {
        System.out.println("\nMapa Galáctico");
        System.out.println("*******************************");
        
        for (int i = 0; i < planetas.size(); i++) {
            Planeta planeta = planetas.get(i);
            String tipoPlaneta = planeta.getClass().getSimpleName();
            String indicador = (i == posicion) ? "<--" : "*"; 
            System.out.printf("  %s  ID: %d - Tipo: %s%n", indicador, i, tipoPlaneta);
        }
        
        System.out.println("*******************************\n");
    }
    /*
    ***
    None
    ***
    No retorna nada.
    ***
    Establece la posición actual a 0, reiniciando el mapa.
    */
    public void reset(){
        posicion = 0;
    }
    /* Parametro 1: i
    ***
    None
    ***
    Setea el parametro
     */
    public void setPosicio(int i){
        this.posicion = i;
    }
}
