import java.util.Scanner;

public class Nave {
    private float unidadesCombustible = 10000000000000f;
    private float eficienciaPropulsor = 0f;

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        int mapa = MG.size();
        int ubicacionFinal = MG.obtenerPosicionActual() + direccion*tamanoSalto;
        int consumoCombustible = (int) (0.75f * Math.pow(tamanoSalto, 2) * (1 - eficienciaPropulsor));
        if (unidadesCombustible - consumoCombustible > 0){
            if (ubicacionFinal > mapa){
                System.out.println(ubicacionFinal - mapa+1);            

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
    public void menu(MapaGalactico MG, Jugador jugador, Nave naveE){
        boolean nave = true;
        Scanner scanner = new Scanner(System.in);
        while (nave) {
            System.out.println("¿Qué desea hacer en la nave (elija número)?");
            System.out.println("1: Viajar a un planeta");
            System.out.println("2: Recargar combustible de la nave");
            System.out.println("3: Recargar energía del exotraje");
            System.out.println("4: Aplicar mejoras a la nave");
            System.out.println("5: Ver inventario y estadisticas");
            System.out.println("6: Ingresar al planeta");
            System.out.println("7: Ver mapa galactico");


            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // Mostrar el mapa antes de que el usuario ingrese la ID
                    MG.mostrarMapa();
                    System.out.println("Ingrese la ID del planeta al que desea viajar: ");
                    int idPlaneta = Integer.parseInt(scanner.nextLine());
                
                    // Calcular la dirección según la posición actual y la ID del planeta
                    int direccion = idPlaneta > MG.obtenerPosicionActual() ? 1 : -1;
                    // Calcular el tamaño del salto basado en la diferencia de posiciones
                    int tamanoSalto = Math.abs(idPlaneta - MG.obtenerPosicionActual());
                
                    // Realizar el viaje al planeta seleccionado
                    viajarPlaneta(MG, direccion, tamanoSalto);
                    break;

                case 2:
                    jugador.mostrarInventario();
                    System.out.println("Hidrogeno didponible: " + jugador.getHidrogeno());
                    System.out.println("Combustible: " + unidadesCombustible);
                    System.out.println("Ingrese la cantidad de hidrógeno para recargar: ");
                    int hidrogeno = Integer.parseInt(scanner.nextLine());
                    if (jugador.getHidrogeno()-hidrogeno<0) {
                        System.out.println("No tienes suficiente hidrogeno");
                    }
                    else{
                        recargarPropulsor(hidrogeno);
                        jugador.setHidrogeno(-hidrogeno);
                    }
                    break;

                case 3:
                    System.out.println("Sodio disponible: " + jugador.getSodio());
                    System.out.println("Energia del exotraje: " + jugador.getEnergia());
                    System.out.println("Ingrese cantitidad de sodio");
                    int sodio = Integer.parseInt(scanner.nextLine());
                    if (jugador.getSodio() - sodio<0) {
                        System.out.println("No tienes suficiente sodio");
                    }
                    else{
                        jugador.recargarEnergiaProteccion(sodio); // Ejemplo de valor
                        jugador.setSodio(-sodio);
                    }

                    break;
                case 4:
                    if (eficienciaPropulsor < 1f) {
                        eficienciaPropulsor += jugador.getMejoras();
                        if (eficienciaPropulsor > 1f) {
                            eficienciaPropulsor = 1f;  // Limitar eficiencia a 1
                        }
                        System.out.println("Eficiencia del propulsor: " + eficienciaPropulsor);
                    } else {
                        System.out.println("La eficiencia ya está al máximo");
                    }
                    break;

                case 5:
                    jugador.mostrarInventario();
                    System.out.println("Combustible: " + unidadesCombustible);

                    break;

                case 6:
                Planeta planeta = MG.planetaActual();
                if (planeta instanceof CentroGalactico){
                    if (naveE.getEficiencia()>0.5f){
                        System.out.println("Ingresando al planeta " + MG.planetaActual());
                        nave = false;
                        planeta.visitar(jugador);

                    }
                    else{
                        System.out.println("Tu nave no es capaz de entrar al centro galactico");
                    }
                }
                else{
                    System.out.println("Ingresando al planeta " + MG.planetaActual());
                    nave = false;
                    planeta.visitar(jugador);

                }
                    // Aquí puedes invocar el método de interacción con el planeta
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
