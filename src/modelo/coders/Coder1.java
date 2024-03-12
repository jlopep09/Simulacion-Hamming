package modelo.coders;

import controlador.Controlador;
import modelo.alphabet.Alphabet;
import modelo.utilities.traductor;

import java.math.BigDecimal;

public class Coder1 implements Coder{
    private int blockSize = 0;
    public Coder1(){
        Double blockDoubleSize = Math.log(Controlador.getInstance().getAlphabet().length()) / Math.log(2);
        blockSize = Integer.parseInt(blockDoubleSize+"");
        if(blockDoubleSize>blockSize){
            blockSize+=1;
        }
    }

    @Override
    public String encode(String input) {
        traductor _traductor = new traductor();
        Alphabet _alphabet = Controlador.getInstance().getAlphabet();

        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i< input.length();i++){
            StringBuilder temp = new StringBuilder();
            temp.append(_traductor.getBinaryRepresentationFromDecimal(new BigDecimal(_alphabet.getElementPos(input.charAt(i)))));
            if(temp.length() > blockSize){
                throw  new RuntimeException("binary representation is larger than blockSize");
            }
            while(temp.length()<blockSize){
                temp.insert(0,0+"");
            }
            result.append(temp);
        }
        return result.toString();
    }

    @Override
    public String decode() {
        return null;
    }
}
