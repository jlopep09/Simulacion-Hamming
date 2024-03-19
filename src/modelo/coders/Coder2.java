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
        ArrayList<String> blocks = blockIt(input, blockSize);
        //Convert the blocks into a block matrix
        int[][] blocksMatrix = matrixIt(blocks);


        //Now we calculate the matrix product blocksMatrix * G
        int[][] encodeMatrix = MatrixProduct(blocksMatrix, G);
        printArray(encodeMatrix);
        System.out.println(GcolumnCount);
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

    public ArrayList<String> blockIt(String input, int sizeOfBlock) {
        ArrayList<String> result = new ArrayList<>();
        while(input.length() >= sizeOfBlock){
            result.add(input.substring(0,sizeOfBlock));
            input = input.substring(sizeOfBlock);
        }
        if(input.length() > 0 ){
            while(input.length() < sizeOfBlock){
                input = input+"0";
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
    public String decode(String input) {
        //get blocks from input
        ArrayList<String> blocks = blockIt(input, GcolumnCount);
        //remove last 3 digits bc G is standard matrix and there is no noise.
        for(int i = 0 ; i<blocks.size(); i++){
            blocks.set(i, blocks.get(i).substring(0,blockSize));
        }
        //remove extra digits added while preparing blocks for coder2
        Coder1 coder1 = new Coder1();
        int coder1blockSize = coder1.getCoder1BlockSize();
        int toRemove = input.length() % blockSize;
        System.out.println(toRemove);
        System.out.println(blocks.get(blocks.size()-1).length());
        if(toRemove> blocks.get(blocks.size()-1).length()){
            toRemove-=blocks.get(blocks.size()-1).length();
            blocks.remove(blocks.size()-1);
        }

        blocks.set(blocks.size()-1, blocks.get(blocks.size()-1).substring(0,toRemove-1));

        //concat result blocks
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<blocks.size(); i++){
            sb.append(blocks.get(i));
        }
        return sb.toString();
    }
}
