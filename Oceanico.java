public class Oceanico extends Planeta {
    private int profundidad;

    public Oceanico(){
        super();
        this.radio = calAtributo(1000000, 10000);
        this.cristalesHidrogeno = calMineral(radio, 0.2f);
        this.floresDeSodio = calMineral(radio, 0.65f);
        this.profundidad = calAtributo(1000, 30);
        this.consumo = calConsumo(profundidad, 0.002f, 2);
    }
    public void mostrarAll(){
        super.mostrarAll();
        System.out.println("Profundidad: " + profundidad);        
        }
}
