package Task.ArrayOperation;

import java.util.Random;

public class ArrayOperation{
    public static void main(String[] args){
        IOHandler ioh = new IOHandler();

        Matrix A = new Matrix(3, 3), B = new Matrix(3,3);

        ioh.print("행렬 A",A);
        ioh.print("행렬 B",B);
        
        ioh.print("덧셈",add(A,B));
        ioh.print("뺄셈",sub(A,B));
        ioh.print("곱셈",mul(A,B));
    }
    public static Matrix mul(Matrix A, Matrix B){
        int row = A.getMatrix().length;
        int col = B.getMatrix()[0].length;
        int[][] temp = new int[row][col];

        for(int i=0; i<row; i++)
            for( int j = 0; j<col; j++)
                for( int k=0; k<A.getMatrix()[0].length; k++)
                    temp[i][j] += A.getMatrix()[i][k] * B.getMatrix()[k][j];

        return new Matrix(temp);
    }
    public static Matrix sub(Matrix A, Matrix B){
        int row = A.getMatrix().length;
        int col = A.getMatrix()[0].length;
        int[][] temp = new int[row][col];

        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                temp[i][j] = A.getMatrix()[i][j] - B.getMatrix()[i][j];

        return new Matrix(temp);
    }
    public static Matrix add(Matrix A, Matrix B){
        int row = A.getMatrix().length;
        int col = A.getMatrix()[0].length;
        int[][] temp = new int[row][col];

        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                temp[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];

        return new Matrix(temp);
    }
}

class IOHandler{
    public void print(String sentence,Matrix M){
        System.out.println(sentence);

        for(int[] row : M.getMatrix()){
            for(int elem : row)
                System.out.print(elem + " ");
            
            System.out.println();
        }

        System.out.println();
    }
}

class Matrix
{
    private int[][] matrix;

    public Matrix(int r, int c){
        matrix = new int[r][c];
        init_random();
    }
    public Matrix(int[][] matrix)
    {
        this.matrix = matrix.clone();

        for(int i=0; i<matrix.length; i++)
            this.matrix[i] = matrix[i].clone();
    }
    public int[][] getMatrix(){
        return matrix;
    }
    public void setMatrix(int i, int j, int value){
        matrix[i][j] = value;
    }
    public void init_random(){
        Random random = new Random();

        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[i].length; j++)
                matrix[i][j] = random.nextInt(10);
    }
}