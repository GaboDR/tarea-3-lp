public class Oceanico extends Planeta {
    private int profundidad;

    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int consumo, int profundidad){
        super(radio, cristalesHidrogeno, floresDeSodio, consumo);
        this.profundidad = profundidad;
    }
}
