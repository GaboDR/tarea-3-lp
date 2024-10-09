import java.util.ArrayList;

public class MapaGalactico {
    private ArrayList<Planeta> planetas;
    private static boolean centroGalacticoGenerado = false;
    private int posicion    ;

    public MapaGalactico(){
        planetas = new ArrayList<>();
        planetas.add(generadorPlaneta());
        posicion = 0;
    }
    public Planeta generadorPlaneta() { // Helado 1, Oceanico 2, radiactivo 3, volcanico 4, centro galactico 5
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 30) {
            return new Helado();
        } else if (probabilidad <= 60) {
            return new Oceanico();
        } else if (probabilidad <= 80) {
            return new Radiactivo();
        } else if (probabilidad <= 99) {
            return new Volcanico();
        } else {
            if (!centroGalacticoGenerado) {
                centroGalacticoGenerado = true;
                System.out.println("Centro galactico creado");

                return new CentroGalactico();
            } else {
                System.out.println("@@@");
                return generadorPlaneta();
            }
        }
    }

    public void crearPlaneta(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            planetas.add(generadorPlaneta());
    }
}
    public void agregar(Planeta planeta){
        planetas.add(planeta);
    }
    public Planeta acceder(int indice){
        return planetas.get(indice); 
    }
    public int size(){
        return planetas.size();
    }
    public void moverAdelante() {
        if (posicion < planetas.size() - 1) {
            posicion++;
        } else {
            System.out.println("Estás en el borde del mapa galáctico, no puedes avanzar más.");
        }
    }
    public void moverAtras() {
        if (posicion > 0) {
            posicion--;
        } else {
            System.out.println("Estás en el principio del mapa galáctico, no puedes retroceder más.");
        }
    }

    public void mover(int salto){
        posicion += salto;
    }

    public Planeta planetaActual() {
        return planetas.get(posicion);
    }

    public int obtenerPosicionActual() {
        return posicion;
    }
    public void mostrarMapa() {
        System.out.println("🌌 Mapa Galáctico 🌌");
        System.out.println("=====================");
    
        for (int i = 0; i < planetas.size(); i++) {
            Planeta planeta = planetas.get(i);
            String tipoPlaneta = planeta.getClass().getSimpleName(); // Obtener el tipo de planeta
            String indicador = (i == posicion) ? "←" : " "; // Indicar la posición actual con una flecha
            System.out.printf("[%s] ID: %d - Tipo: %s%n", indicador, i, tipoPlaneta); // Formato mejorado
        }
    
        System.out.println("=====================");
    }
    public void reset(){
        posicion = 0;
    }
}
