public class Helado extends Planeta{
    private int temperatura;

    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int consumo, int temperatura) {   
        super(radio, cristalesHidrogeno, floresDeSodio, consumo);        
        this.temperatura = temperatura;
    }

}