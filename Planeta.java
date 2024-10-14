public abstract class Planeta {

    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumo;
    private static int cIndice = 0;
    private int indice; 

    /* None
    ***
    Inicializa un nuevo objeto de tipo Planeta y asigna un índice único a cada instancia creada.
    */
    public Planeta(){
        this.indice = cIndice++;

    }
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getIndice(){
        return indice;
    }
    /* Parametro 1: radio (int)
    Parametro 2: constante (float)
    ***
    Return: mineral (int)
    ***
    Calcula la cantidad de un mineral en el planeta, basado en su radio y una constante específica.
    */
    public int calMineral(int radio, float constante){
        int mineral = (int) (constante * 4 * Math.PI * Math.pow(radio, 2));
        return mineral;
    }
    /* Parametro 1: max (int)
    Parametro 2: min (int)
    ***
    Return: atributo (int)
    ***
    Calcula un valor aleatorio dentro de un rango entre `min` y `max`.
    */
    public int calAtributo(int max, int min){
        int atributo = (int) (Math.random() * (max - min + 1)) + min;
        return atributo;
    }
    /* Parametro 1: variable (int)
    Parametro 2: constante (float)
    Parametro 3: exponente (int)
    ***
    Return: consumo (int)
    ***
    Calcula el consumo de recursos basado en una variable, una constante y un exponente.
    */
    public int calConsumo(int variable, float constante, int exponente){
        variable = Math.abs(variable);
        variable = (int) Math.pow(variable, exponente);
        int consumo = (int) (constante * variable);
        return consumo;
    }
    /* Parametro: jugador (Jugador)
    ***
    Return: true (boolean)
    ***
    El jugador ingresa al planeta, se interactúa con el menú de recursos y se devuelve `true` para indicar que la visita fue exitosa.
    */
    public boolean visitar(Jugador jugador){
        System.out.println("Haz ingresado al planeta");
        menuRecursos(jugador);

        return true;
    }
    
    public abstract void menuRecursos(Jugador jugador);
    public abstract int extraerRecursos(int tipo);
    /*
    None
    ***
    Return: false (boolean)
    ***
    El jugador sale del planeta y se devuelve `false` para indicar que ya no está en el planeta.
    */
    public boolean salir(){
        System.out.println("Haz salido al planeta");

        return false;
    }
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getRadio() {
        return radio;
    }
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getFloresDeSodio() {
        return floresDeSodio;
    }
    /*
    ***
    Retorno: int
    ***
    Getter.
    */
    public int getConsumo() {
        return consumo;
    }

    /*
    Establece el radio del planeta.
    ***
    Param: radio (int)
    - Valor del radio del planeta que se va a establecer.
    */
    public void setRadio(int radio) {
        this.radio = radio;
    }

    /*
    Establece la cantidad de cristales de hidrógeno en el planeta.
    ***
    Param: cristalesHidrogeno (int)
    - Cantidad de cristales de hidrógeno disponible en el planeta.
    */
    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    /*
    Establece la cantidad de flores de sodio en el planeta.
    ***
    Param: floresDeSodio (int)
    - Cantidad de flores de sodio disponible en el planeta.
    */
    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    /*
    Establece el consumo de recursos en el planeta.
    ***
    Param: consumo (int)
    - El valor de consumo asociado a las actividades en el planeta.
    */
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
    /*
    None
    ***
    Muestra toda la información relevante del planeta, incluyendo el tipo, índice, radio, y los recursos disponibles.
*/
    public void mostrarAll(){
        System.out.println("Planeta " + getClass().getSimpleName());
        System.out.println("Índice: " + getIndice());
        System.out.println("Radio: " + getRadio());
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        System.out.println("Consumo: " + getConsumo());
    }

}