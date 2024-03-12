package modelo.alphabet;

public class Alphabet {
    private String Alphabet;
    public Alphabet(String input){
        checkInput(input);
        this.Alphabet = input;
    }
    private void checkInput(String input){
        boolean valid = true;

        for(int i = 0; i<input.length();i++){
            if(input.indexOf(input.charAt(i))!=input.lastIndexOf(input.charAt(i))){
                valid = false;
                System.out.println(input.charAt(i));
                System.out.println(input.indexOf(input.charAt(i)));
                System.out.println(input.lastIndexOf(input.charAt(i)));
            }
        }
        if(!valid){
            throw new IllegalArgumentException("Alphabet input is not valid.");
        }
    }
    public int getElementPos(char element){
        return this.Alphabet.indexOf(element);
    }
    public int length(){
        return this.Alphabet.length();
    }
    public String getAlphabet(){
        return Alphabet;
    }
}
