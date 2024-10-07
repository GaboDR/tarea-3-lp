public class Radiactivo extends Planeta{
    private int radiacion;
    private int uranio;

    public Radiactivo(){
        super();
        this.radio = calAtributo(100000, 10000);
        this.cristalesHidrogeno = calMineral(radio, 0.2f);
        this.floresDeSodio = calMineral(radio, 0.2f);
        this.radiacion = calAtributo(50, 10);
        this.consumo = calConsumo(radiacion, 0.3f, 1);
        this.uranio = calMineral(radio, 0.25f);
    }

    public int getUranio(){
        return uranio;
    }
}
