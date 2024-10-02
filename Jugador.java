public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaPropulsor;

    public Jugador(){
        unidadesEnergiaProteccion = 100f;
        eficienciaEnergiaPropulsor = 0f;
    }

    public void recargarEnergiaProteccion(int sodio){
        unidadesEnergiaProteccion = 0.65f * sodio * (1f + eficienciaEnergiaPropulsor);
        return;
    }

}
