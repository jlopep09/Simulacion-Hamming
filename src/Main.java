import controlador.Controlador;
import modelo.utilities.traductor;

import java.math.BigDecimal;

public class Main{
    public static void main(String[] args){
        prueba2();


    }
    public void prueba1(){
        System.out.println("_____________________________________________________");
        String Alpha = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghiíjklmnñopqrstuvwxyz";
        String binCodedInput = "00000001100110010010101001011101001";
        Controlador controlador = Controlador.getInstance();
        controlador.setAlphabet(Alpha);
        System.out.println(controlador.encode("Las"));
        //System.out.println(controlador.decode("00101101101001110011011001100000000"));

        System.out.println(controlador.decode("00000001100110010010101001011101001"));
    }
    public static void prueba2(){
        System.out.println("_____________________________________________________");
        String Alpha = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ,.-;()0123456789abcdeéfghiíjklmnñoópqrstuvwxyz";
        //String binCodedInput = "00000001100110010010101001011101001";
        Controlador controlador = Controlador.getInstance();
        controlador.setAlphabet(Alpha);
        //System.out.println(controlador.encode("Las claras noches de verano."));
        System.out.println(controlador.decode("0001111011001110110100010110000111100011111011010010101011001101110000010101001100110100101000111101010101001100000000010000111101001101101010110100111100101010110110101001100101010100110010000000100001101001010110011110100101111001011010000000000110010111100000111101010101000011010010100011110101010100001111100001101001111000010011001101001"));

        //System.out.println(controlador.decode("000111101100111011010000000011010011011010101101001111001010101101101010011001010101001100100000000011001011001110110101001100011001100110010000000001100110000110110011110100101100111100110000111110000111000011111000010011001110000110011000101100101010100001101100111110000010010100101101100110001100101111000010110000000011010011011010101010101111001011010000000001010100110011001011011111110101010100001101111000100101110100110011001011010001011011001101011010000111110011001010101110011010000110100101011001111010010111100001100110011000101010100110000000000101010101010110101011111111010101010000111011010110100110000110100101001011000110010110011111000010011000110011001100110011001000011101010110110100010110000111100011111011010100110000000000110011111000000101101011010000000010000110010110101101011010011000011010010100101100011001011001111111111101001100001101001010001111010101011111110001111001011000000001010101110011001111000110011011001111100000001111110011000011110101010100110000000001000011110100110110101001100010101010000110110011111000000011111011010110100110000110011001000000001010101000011000111110110100101010111000011001100000000110100110110101001100010101010000110110011110100110101011011010001100101111000010110110011000101100001111001100101010100101010100001101111000100101110100110011001011010000000010000111110000010010111010011010101111000001010101000011111000010011001010101101101010110100111100101010101100111110000000111101001010100101010101010101011100110000000011100000001111101101001111000010110111000001010101000011001100110110100111100101010101100111101001011110010110100000000001100101111000000000100110011100001011010101010101010101011010000000001010100110011010010100101100011001100001101100111101001011110010110100000000001100101100111011010100110001100110011001101010101111001110000101101000011111101001101101001010100111100001011011100000101010011001101001010010110001100110000110110011110100101111001011010000000000110010110011110011010101010000000101010111001100110011011001110110100001111110100110101011110000011001110101011011010000000011010011010101111111101100110000000011001111010011010101001100101010100110011000111100000000101010011001110101011100110001100110000110110011110011011010011010101111111101100110000000011001111010010111100001011011001100111100011001110110101001100101010110110101101001011110001100111100110001011000011110001111110011000110010110011101101011010011000011000111110110100101010110011010110100001111110100111001100010110010101010000111110000110100101111000011001010101001111001010101011001111100000100101000111110110100101010111000011001100000000110100110101011100110011110001100111101001000111110000110011001100110001111001010101011110001001011101001100110010110100100101000000001001010000000010101010000110000000001011010000110001111000000010011000000000111111100110010110011011001101001011101001100110010011000001111111000001111000000000110100110000111001100100001110000111011010000111111010011001100101101000101100100101101101000011111101001001100111100000111100011001101100111100110010010110110100101010011110001001011100110010101011010011011010000000010011000010110011110000000001101001101010100110010101010010010110101011001100000111110011001110000010010101100111010101110100100110011010101101010101001010010110"));
    }
}