public class Q7{
    public static void main(String[] args){
        int[][] matrix = { {0, 1, 2}, {3,4,5}, {6,7,8}};
        printMatrix(matrix);
        System.out.println(); //Makes a new row
        int[][] rMatrix = rotate(matrix);
        printMatrix(rMatrix);
    }

    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++)//Cycles through rows
        {
            for (int col = 0; col < matrix[row].length; col++)//Cycles through columns
            {
                System.out.printf("%5d", matrix[row][col]); //change the %5d to however much space you want
            }
            System.out.println(); //Makes a new row
        }
    }

    // Run time of O(N^2) as it iterates through every value in the matrix
    public static int[][] rotate(int[][] matrix){
        if(matrix.length != matrix[0].length) return matrix;
        int n = matrix.length;
        int[][] rMatrix = new int[n][n];
        int col = n-1;
        for(int i = 0; i < matrix.length; i++){
            int row = 0;
            for(int j = 0; j < matrix[0].length; j++){
                rMatrix[row][col] = matrix[i][j];
                row++;
            }
            col--;
        }
        return rMatrix;
    }
}
