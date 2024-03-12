package modelo.coders;

import java.util.ArrayList;

public class Coder2 implements Coder{

    int[][] G;
    int blockSize, GcolumnCount;
    public Coder2(){
        G = new int[][]{
                {1, 0, 0, 0,    0, 1, 1},
                {0, 1, 0, 0,    1, 0, 1},
                {0, 0, 1, 0,    1, 1, 0},
                {0, 0, 0, 1,    1, 1, 1}
        };
        blockSize = 4; //Numero de filas de la matriz generadora
        GcolumnCount = 7;

    }
    @Override
    public String encode(String input) {

        //Makes blocks from input
        ArrayList<String> blocks = blockIt(input);
        //Convert the blocks into a block matrix
        int[][] blocksMatrix = matrixIt(blocks);

        //Now we calculate the matrix product blocksMatrix * G
        int[][] encodeMatrix = MatrixProduct(blocksMatrix, G);
        //finally we concat the result string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<blocks.size(); i++){
            for(int j = 0; j<GcolumnCount; j++){
                sb.append(encodeMatrix[i][j]);
            }
        }
        return sb.toString();
    }

    private int[][] matrixIt(ArrayList<String> blocks) {
        int[][] blocksMatrix = new int[blocks.size()][blockSize];
        for(int i = 0; i<blocks.size(); i++){
            for(int j = 0; j<blockSize; j++){
                blocksMatrix[i][j] = Integer.valueOf(blocks.get(i).charAt(j)+"");
            }
        }
        return blocksMatrix;
    }

    private ArrayList<String> blockIt(String input) {
        ArrayList<String> result = new ArrayList<>();
        while(input.length() >= blockSize){
            result.add(input.substring(0,4));
            input = input.substring(4);
        }
        if(input.length() > 0 ){
            while(input.length() < blockSize){
                input = input+"01";
            }
            result.add(input);
        }
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

        return result;
    }





    @Override
    public String decode() {
        return null;
    }
}
