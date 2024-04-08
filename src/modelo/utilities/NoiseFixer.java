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
    public int[][] getSyndrome(int[][] input){
        System.out.println("input");
        printArray(input);
        System.out.println("COntrolMarix");
        printArray(ControlMatrix);
        System.out.println("result");
        return MatrixProduct(ControlMatrix, input );
    }
    public boolean checkSyndrome(int[][] input){
        System.out.println("checking syndrom matrix");
        printArray(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j]!=0){
                    System.out.println("error detected, value "+ input[i][j]);
                    return true;
                }
            }
            System.out.println("");
        }
        return false;
    }
    private int[][] MatrixProduct(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                // Calculating the dot product of row i of matrix a and column j of matrix b
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                // The result is 1 if sum is odd, 0 if even
                result[i][j] = sum % 2;
            }
        }
        printArray(result);
        return result;
    }
    private void printArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
