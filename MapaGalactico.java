import java.util.ArrayList;
public class MapaGalactico {
    private ArrayList<Planeta> planetas;

    public MapaGalactico(){
        planetas = new ArrayList<>();
    }

    public void agregar(Planeta planeta){
        planetas.add(planeta);
    }
}
