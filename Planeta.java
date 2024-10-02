public abstract class Planeta {

    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumo;
    private static int cIndice = 1;
    private int indice; 

    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio, int consumo) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.consumo = consumo;
        this.indice = cIndice++;
    }

    public boolean visitar(Jugador jugador){
        return false;
    }

    public int extraerRecursos(int tipo){
        return 0;
    }
    public boolean salir(){
        return false;
    }

}