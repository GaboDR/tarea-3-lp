public class Radiactivo extends Planeta{
    private int radiacion;
    private int uranio;

    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int consumo, int radiacion, int uranio){
        super(radio, cristalesHidrogeno, floresDeSodio, consumo);
        this.radiacion = radiacion;
        this.uranio = uranio;

    }
}
