import java.util.Scanner;

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

    public void menuRecursos(Jugador jugador){
        System.out.println("Que accion desea hacer (ingrese numero de la accion): ");
        System.out.println("1: Extraer cristales de hidrogeno");
        System.out.println("2: Extraer flores de sodio");
        System.out.println("3: Hablar con los locatarios");
        System.out.println("4: Salir del planeta");


        Scanner scanner = new Scanner(System.in);
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1 || tipo ==2) {
            int agregarInventario = extraerRecursos(tipo);
        }
        else if (tipo == 3){

        }

        scanner.close();
    }

    public int extraerRecursos(int tipo){
        int cantidad;
        System.out.println("Indique la cantidad de recurso que desea extraer: ");

        Scanner scanner = new Scanner(System.in);
        cantidad = Integer.parseInt(scanner.nextLine());
        switch (tipo) {
            case 1: 
                cristalesHidrogeno -= cantidad;
                break;
            case 2:
                floresDeSodio -= cantidad;
                break;
        }

        scanner.close();
        return cantidad;
    }

}