public class Volcanico extends Planeta{
    private int temperatura;
    private int platino;

    public Volcanico(){
        super();
        this.radio = calAtributo(100000, 1000);
        this.cristalesHidrogeno = calMineral(radio, 0.3f);
        this.floresDeSodio = 0;
        this.temperatura = calAtributo(256, 120);
        this.consumo = calConsumo(temperatura, 0.08f, 1);
        this.platino = (int) (0.25f * 4 * Math.PI * Math.pow(radio, 2) - 20.5f * Math.pow(temperatura, 2));
    }

    public int getPlatino(){
        return platino;
    }
}
