public class Jugador {

    private int sodio;
    private int hidrogeno;
    private int platino;
    private int uranio;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaPropulsor;

    public Jugador(){
        unidadesEnergiaProteccion = 100f;
        eficienciaEnergiaPropulsor = 0f;
        sodio = 0;
        hidrogeno = 0;
        platino = 0;
        uranio = 0;
    }

    public void setSodio(int sodios){
        sodio += sodios;
    }
    public void sethidrogeno(int sodios){
        hidrogeno += sodios;
    }
    public void setPlatino(int sodios){
        platino += sodios;
    }
    public void setUranio(int sodios){
        uranio += sodios;
    }
    public void seteficiencia(float sodios){
        eficienciaEnergiaPropulsor += sodios;
    }

    public void recargarEnergiaProteccion(int sodio){
        float carga = 0.65f * (float) sodio * (1f + eficienciaEnergiaPropulsor);
        if (unidadesEnergiaProteccion +carga>=100) {
            unidadesEnergiaProteccion = 100;
        } else {
            unidadesEnergiaProteccion += carga;
        }
    }

    public void cosumirEnergia(int unidade, int consumo){
        unidadesEnergiaProteccion -= 0.5f * (float) unidade * ((float) consumo)/100 * (1-eficienciaEnergiaPropulsor);
    }
    public void mostrarInventario(){
        System.out.println("Inventario:");
        System.out.println("Hidrogeno: " + hidrogeno);
        System.out.println("Sodio: " + sodio);
        System.out.println("Platino: " + platino);
        System.out.println("Uranio: " + uranio);
    }

    public int getSodio(){
        return sodio;
    }
    public int getHidrogeno(){
        return hidrogeno;
    }
    public int getPlatino(){
        return platino;
    }
    public int getUranio(){
        return uranio;
    }
}
