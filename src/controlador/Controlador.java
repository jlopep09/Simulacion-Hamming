package controlador;

public class Controlador {
    private static Controlador instance;
    private Controlador(){

    }
    public static Controlador getInstance(){
        if(instance == null){
            instance = new Controlador();
        }
        return instance;
    }

}
