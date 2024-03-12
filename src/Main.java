import controlador.Controlador;

public class Main{
    public static void main(String[] args){

        System.out.println("_____________________________________________________");
        String Alpha = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghiíjklmnñopqrstuvwxyz";
        String binCodedInput = "00000001100110010010101001011101001";
        Controlador controlador = Controlador.getInstance();
        controlador.setAlphabet(Alpha);
    }
}