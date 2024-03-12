package modelo.alphabet;

public class Alphabet {
    private String Alphabet;
    public Alphabet(String input){
        checkInput(input);
    }
    private void checkInput(String input){
        boolean valid = true;
        if(!valid){
            throw new IllegalArgumentException("Alphabet input is not valid.");
        }
    }
    public int getElementPos(char element){
        return this.Alphabet.indexOf(element);
    }
}
