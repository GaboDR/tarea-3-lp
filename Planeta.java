public abstract class Planeta {

    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumo;
    private static int cIndice = 0;
    private int indice; 

    public Planeta(){
        this.indice = cIndice++;

    }
    public int getIndice(){
        return indice;
    }

    public int calMineral(int radio, float constante){
        int mineral = (int) (constante * 4 * Math.PI * Math.pow(radio, 2));
        return mineral;
    }

    public int calAtributo(int max, int min){
        int atributo = (int) (Math.random() * (max - min + 1)) + min;
        return atributo;
    }
    public int calConsumo(int variable, float constante, int exponente){
        variable = Math.abs(variable);
        variable = (int) Math.pow(variable, exponente);
        int consumo = (int) (constante * variable);
        return consumo;
    }
    
    public boolean visitar(Jugador jugador){
        System.out.println("Haz ingresado al planeta");
        menuRecursos(jugador);

        return true;
    }
    public abstract void menuRecursos(Jugador jugador);

    public abstract int extraerRecursos(int tipo);

    public boolean salir(){
        System.out.println("Haz salido al planeta");

        return false;
    }
    public int getRadio() {
        return radio;
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
    public void mostrarAll(){
        System.out.println("Planeta " + getClass().getSimpleName());
        System.out.println("Índice: " + getIndice());
        System.out.println("Radio: " + getRadio());
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        System.out.println("Consumo: " + getConsumo());
    }
}