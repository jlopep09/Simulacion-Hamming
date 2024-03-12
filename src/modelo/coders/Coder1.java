package modelo.coders;

import controlador.Controlador;
import modelo.alphabet.Alphabet;
import modelo.utilities.traductor;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Coder1 implements Coder{
    private int blockSize = 0;
    public Coder1(){
        this.blockSize = getCoder1BlockSize();
    }
    public int getCoder1BlockSize(){
        double blockDoubleSize = Math.log(Controlador.getInstance().getAlphabet().length()) / Math.log(2);
        int result = (int)blockDoubleSize;
        if(blockDoubleSize>result){
            result+=1;
        }
        return result;

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
                System.out.println(temp.toString());
                System.out.println(blockSize);
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
    public String decode(String input) {

        Coder2 coder2 = new Coder2();
        ArrayList<String> blocks = coder2.blockIt(input, blockSize);

        //concat result blocks obtaining the equivalent element for their value
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<blocks.size(); i++){
            traductor _traductor = new traductor();
            int decVal = Integer.parseInt(_traductor.getDecimalValueFromBinary(blocks.get(i)));
            String tempElement = Controlador.getInstance().getAlphabet().getAlphabet().charAt(decVal)+"";
            sb.append(tempElement);
        }
        return sb.toString();
    }
}
