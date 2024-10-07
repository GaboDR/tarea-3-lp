public class Helado extends Planeta{
    private int temperatura;

    public Helado(){
        super();
        this.radio = calAtributo(1000000, 1000);
        this.cristalesHidrogeno = calMineral(radio, 0.65f);
        this.floresDeSodio = calMineral(radio, 0.35f);
        this.temperatura = calAtributo(-30, -120);
        this.consumo = calConsumo(temperatura, 0.15f, 1);
    }
    public int getTemp(){
        return temperatura;
    }

    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Temperatura: " + temperatura);        
    }

}