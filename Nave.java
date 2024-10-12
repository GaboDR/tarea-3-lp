import java.util.Scanner;

public class Nave {
    private float unidadesCombustible = 100f;
    private float eficienciaPropulsor = 0f;

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        int mapa = MG.size();
        int ubicacionFinal = MG.obtenerPosicionActual() + direccion*tamanoSalto;
        int consumoCombustible = (int) Math.ceil(0.75f * Math.pow(tamanoSalto, 2) * (1 - eficienciaPropulsor));
        if (unidadesCombustible - consumoCombustible > 0){
            if (ubicacionFinal >= mapa){           

                MG.crearPlaneta(ubicacionFinal - mapa+1);
            }
            MG.mover(tamanoSalto*direccion);
            unidadesCombustible -= consumoCombustible;

        }
        else{
            System.out.println("Combustible insuficiente para el salto");            
            return false;
        }
        return true;
    }
    public void recargarPropulsor(int hidrogeno){
        int carga = (int) (0.6f * hidrogeno * (1 + eficienciaPropulsor));
        if(carga + unidadesCombustible >100){
            unidadesCombustible = 100;
            System.out.println("Combustible a maxima capacidad");
        }
        else{
            unidadesCombustible += carga;
            System.out.println("Tu tanque tiene "+ unidadesCombustible+ " combustible");

        }
    }
    public void menu(MapaGalactico MG, Jugador jugador, Nave naveE) {
        boolean nave = true;
        Scanner scanner = new Scanner(System.in);
        while (nave) {
            System.out.println("¿Qué desea hacer en la nave (elija número)?");
            System.out.println("1: Viajar a un planeta");
            System.out.println("2: Recargar combustible de la nave");
            System.out.println("3: Recargar energía del exotraje");
            System.out.println("4: Aplicar mejoras a la nave");
            System.out.println("5: Ver inventario y estadísticas");
            System.out.println("6: Ingresar al planeta");
            System.out.println("7: Ver mapa galáctico");
    
            int opcion = Integer.parseInt(scanner.nextLine());
    
            switch (opcion) {
                case 1:
                    MG.mostrarMapa();
                    System.out.println("Ingrese la ID del planeta al que desea viajar: ");
                    int idPlaneta = Integer.parseInt(scanner.nextLine());
                    if (idPlaneta >= 0){
                        int direccion = idPlaneta > MG.obtenerPosicionActual() ? 1 : -1;
                        int tamanoSalto = Math.abs(idPlaneta - MG.obtenerPosicionActual());
                        viajarPlaneta(MG, direccion, tamanoSalto);
                    }
                    else{
                        System.out.println("*****************************");
                        System.out.println("** Has alcanzado el límite del Mapa Galáctico **");
                        System.out.println("*****************************");
                        System.out.println();
                        System.out.println("Sistema de Navegación:");
                        System.out.println("\"Más allá de este punto, el vacío es como el borde de Tatooine o los desiertos de Arrakis: desconocido y peligroso.");
                        System.out.println("Tu nave no puede continuar.\"");
                        System.out.println();
                        System.out.println("\"Mejor regresa antes de convertirte en otro mito perdido, como Krypton en las estrellas.\"");
                        System.out.println();
                    }
                    break;
    
                case 2:
                    jugador.mostrarInventario();
                    System.out.println("Hidrógeno disponible: " + jugador.getHidrogeno());
                    System.out.println("Combustible actual: " + unidadesCombustible);
                    System.out.println("Ingrese la cantidad de hidrógeno para recargar: ");
                    int hidrogeno = Integer.parseInt(scanner.nextLine());
                
                    if (jugador.getHidrogeno() - hidrogeno < 0) {
                        System.out.println("No tienes suficiente hidrógeno");
                    } else {

                        float maxRecarga = 100 -  unidadesCombustible;
                        float carga = 0.6f * hidrogeno * (1 + eficienciaPropulsor);
                

                        if (carga > maxRecarga) {
                            carga = maxRecarga;
                        }
                

                        int hidrogenoUtilizado = (int) (carga / (0.6f * (1 + eficienciaPropulsor)));
                
                        unidadesCombustible += carga;
                        jugador.setHidrogeno(-hidrogenoUtilizado);
                
                        System.out.println("Se recargó " + carga + " de combustible. Combustible actual: " + unidadesCombustible);
                        System.out.println("Se utilizó " + hidrogenoUtilizado + " de hidrógeno.");
                    }
                    break;
                
                case 3:
                    System.out.println("Sodio disponible: " + jugador.getSodio());
                    System.out.println("Energía del exotraje actual: " + jugador.getEnergia());
                    System.out.println("Ingrese la cantidad de sodio para recargar: ");
                    int sodio = Integer.parseInt(scanner.nextLine());
                
                    if (jugador.getSodio() - sodio < 0) {
                        System.out.println("No tienes suficiente sodio");
                    } else {

                        float maxRecarga = 100 - jugador.getEnergia();
                        float carga = 0.65f * sodio * (1f + eficienciaPropulsor);
                
                        if (carga > maxRecarga) {
                            carga = maxRecarga;
                        }
                
                        int sodioUtilizado = (int) (carga / (0.65f * (1f + eficienciaPropulsor)));
                
                        jugador.recargarEnergiaProteccion(sodioUtilizado);
                        jugador.setSodio(-sodioUtilizado);
                
                        System.out.println("Se recargó " + carga + " de energía de protección. Energía actual: " + jugador.getEnergia());
                        System.out.println("Se utilizó " + sodioUtilizado + " de sodio.");
                    }
                    break;
                
    
                case 4:
                if (jugador.getMejoras() >0){
                    if (eficienciaPropulsor < 1f) {
                        eficienciaPropulsor += jugador.getMejoras();
                        if (eficienciaPropulsor > 1f) {
                            eficienciaPropulsor = 1f;
                        }
                        System.out.println("Eficiencia del propulsor de la nave: " + eficienciaPropulsor);
                    } else {
                        System.out.println("La eficiencia ya está al máximo.");
                    }
                }
                else{
                    System.out.println("No tienes mejoras que aplicar a la nave.");
                }
                    break;
    
                case 5:
                    jugador.mostrarInventario();
                    System.out.println("\n============================");
                    System.out.println("        NAVE ESTADÍSTICAS    ");
                    System.out.println("============================");
                    System.out.println(String.format("Combustible:          %10.2f", unidadesCombustible));
                    System.out.println(String.format("Eficiencia Propulsor: %10.2f", eficienciaPropulsor));
                    System.out.println("============================\n");
                    break;
                
    
                case 6:
                    Planeta planeta = MG.planetaActual();
                    if (planeta instanceof CentroGalactico) {
                        if (naveE.getEficiencia() > 0.5f) {
                            System.out.println("Ingresando al planeta " + MG.planetaActual());
                            nave = false;
                            planeta.visitar(jugador);
                        } else {
                            System.out.println("Tu nave no es capaz de entrar al centro galáctico.");
                        }
                    } else {
                        System.out.println("Ingresando al planeta " + MG.planetaActual());
                        nave = false;
                        planeta.visitar(jugador);
                    }
                    break;
    
                case 7:
                    MG.mostrarMapa();
                    break;
    
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
    
        
        

        
    

    public void restart(){
        unidadesCombustible = 100f;
        eficienciaPropulsor = 0f;
    }
    public float getEficiencia(){
        return eficienciaPropulsor;
    }
    
}
