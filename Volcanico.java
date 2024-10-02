public class Volcanico extends Planeta{
    private int temperatura;
    private int platino;

    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int consumo, int temperatura, int platino){
        super(radio, cristalesHidrogeno, floresDeSodio, consumo);
        this.temperatura = temperatura;
        this .platino = platino;
    }
}
