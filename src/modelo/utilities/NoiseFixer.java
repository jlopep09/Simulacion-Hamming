package modelo.utilities;

import controlador.Controlador;
import modelo.alphabet.Alphabet;

public class NoiseFixer {
    int[][] ControlMatrix;
    public NoiseFixer(){
        ControlMatrix = new int[][]{
                {0, 0, 0, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 0, 1}
        };
    }
}
