import java.util.ArrayList;

public class MapaGalactico {
    private ArrayList<Planeta> planetas;
    private static boolean centroGalacticoGenerado = false;

    public MapaGalactico(){
        planetas = new ArrayList<>();
        planetas.add(generadorPlaneta());
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
                return new CentroGalactico();
            } else {
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

}
