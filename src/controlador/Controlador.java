package controlador;

import modelo.alphabet.Alphabet;

public class Controlador {
    private static Controlador instance;
    private Alphabet _alphabet;
    private Controlador(){

    }
    public static Controlador getInstance(){
        if(instance == null){
            instance = new Controlador();
        }
        return instance;
    }
    public Alphabet setAlphabet(String input){
        _alphabet = new Alphabet(input);
        return _alphabet;
    }
    public String encode(String input){
        if(_alphabet == null){
            throw new RuntimeException("Cant encode, you must set up the alphabet");
        }
        return "NOT IMPLEMENTED";
    }

}
