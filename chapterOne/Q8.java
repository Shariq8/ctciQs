public class Q8{
    public static void main(String[] args){
      int[][] matrix = { {0, 1, 2}, {3,0,5}, {6,7,8}};
        // printMatrix(matrix);
        setZeros(matrix);
        printMatrix(matrix);
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

    //Book solution
    public static void setZeros(int[][] matrix){
      boolean[] row = new boolean[matrix.length];
      boolean[] column = new boolean[matrix[0].length];
      for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix.length; j++){
          if(matrix[i][j] == 0){
            row[i] = true;
            column[j] = true;
          }
        }
      }

      for(int i = 0; i < row.length; i++){
        if(row[i]) nullifyRow(matrix,i);
      }

      for(int j = 0; j < column.length; j++){
        if(column[j]) nullifyColumn(matrix,j);
      }
    }

    public static void nullifyRow(int[][] matrix, int row){
        for(int j = 0; j < matrix[0].length; j++){
          matrix[row][j] = 0;
        }
      }

    public static void nullifyColumn(int[][] matrix, int col){
      for(int i = 0; i < matrix.length; i++){
        matrix[i][col] = 0;
      }
    }
}

