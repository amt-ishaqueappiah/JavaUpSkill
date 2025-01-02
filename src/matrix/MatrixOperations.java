package matrix;

public class MatrixOperations {


    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int col = 0; col < colsA; col++) {
                    sum += (matrixA[i][col] * matrixB[col][j]);
                }
                result[i][j] = sum;
            }
        }

        return result;
    }


    public static void showResult(int[][] result) {
        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
