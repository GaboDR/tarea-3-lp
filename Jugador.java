public class Jugador {

    private int sodio;
    private int hidrogeno;
    private int platino;
    private int uranio;
    private float mejorasNave;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaPropulsor;
    private boolean perder;

    public Jugador(){
        unidadesEnergiaProteccion = 100f;
        eficienciaEnergiaPropulsor = 0f;
        sodio = 0;
        hidrogeno = 0;
        platino = 0;
        uranio = 0;
        mejorasNave = 0;
        perder = false;

    }

    public void setSodio(int sodios){
        sodio += sodios;
    }
    public void setHidrogeno(int sodios){
        hidrogeno += sodios;
    }
    public void setPlatino(int sodios){
        platino += sodios;
    }
    public void setUranio(int sodios){
        uranio += sodios;
    }
    public void setEficiencia(float mejoras){
        if (eficienciaEnergiaPropulsor + mejoras > 1.0f) {
            eficienciaEnergiaPropulsor = 1.0f; // Límite de eficiencia
            System.out.println("La eficiencia del exotraje ha alcanzado el máximo permitido (100%).");
        } else {
            eficienciaEnergiaPropulsor += mejoras;
        }
    }

    public void setMejorasNave(float mejoras){
        mejorasNave += mejoras;
    }
    public void truePerder(){
        perder = true;
    }
    public void falsePerder(){
        perder = false;
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
        System.out.println("Energia del exotraje: " + unidadesEnergiaProteccion);
        System.out.println("Eficiendia: " + eficienciaEnergiaPropulsor);


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
    public float getEnergia(){
        return unidadesEnergiaProteccion;
    }
    public float getMejoras(){
        return mejorasNave;
    }
    public void reset(Nave nave, MapaGalactico mapa) {
        if (perder) {
            sodio = 0;
            hidrogeno = 0;
            platino = 0;
            uranio = 0;
    
            mejorasNave = 0;
            eficienciaEnergiaPropulsor = 0f;
    
            unidadesEnergiaProteccion = 100f;
            
            perder = false;

            nave.restart();
            mapa.reset();
    
            System.out.println("SE ACTIVO EL SISTEMA DE EMERGENCIA");
            System.out.println("Vuelves al planeta 0 y pierdes todo tu inventario y mejoras");

        }
    }

}
