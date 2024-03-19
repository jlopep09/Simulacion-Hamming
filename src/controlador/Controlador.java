package controlador;

import modelo.alphabet.Alphabet;
import modelo.coders.Coder1;
import modelo.coders.Coder2;

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
        Coder1 coder1 = new Coder1();
        Coder2 coder2 = new Coder2();
        String result = "";
        result =  coder1.encode(input);
        result = coder2.encode(result);

        return result;
    }
    public String decode(String input){
        if(_alphabet == null){
            throw new RuntimeException("Cant decode, you must set up the alphabet");
        }
        Coder1 coder1 = new Coder1();
        Coder2 coder2 = new Coder2();
        String result = "";
        result =  coder2.decode(input);
        result = coder1.decode(result);

        return result;
    }

    public Alphabet getAlphabet() {
        return _alphabet;
    }
}
