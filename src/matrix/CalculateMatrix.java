package matrix;

import java.util.Scanner;

public class CalculateMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mistakeCount = 0;


        int rowsA = InputHandler.getValidIntInput("Enter the number of rows for matrix A: ", mistakeCount);
        if (rowsA == -1) return;
        int colsA = InputHandler.getValidIntInput("Enter the number of columns for matrix A: ", mistakeCount);
        if (colsA == -1) return;


        int rowsB = InputHandler.getValidIntInput("Enter the number of rows for matrix B: ", mistakeCount);
        if (rowsB == -1) return;
        int colsB = InputHandler.getValidIntInput("Enter the number of columns for matrix B: ", mistakeCount);
        if (colsB == -1) return;


        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible because number of columns in matrix A is not equal to number of rows in matrix B.");
            return;
        }


        int[][] matrixA = new int[rowsA][colsA];
        int[][] matrixB = new int[rowsB][colsB];


        System.out.println("Enter the values for matrix A (" + rowsA + "x" + colsA + "):");
        for (int i = 0; i < rowsA; i++) {
            matrixA[i] = InputHandler.getValidRowInput(colsA,  "Enter values for row " + (i + 1) + " of matrix A (separated by spaces) it should be "+ colsA+" numbers for each row : ", mistakeCount);
            if (matrixA[i] == null) return; // Exit if three mistakes are made
        }

        // Get values for matrix B
        System.out.println("Enter the values for matrix B (" + rowsB + "x" + colsB + "):");
        for (int i = 0; i < rowsB; i++) {
            matrixB[i] = InputHandler.getValidRowInput(colsB, "Enter values for row " + (i + 1) + " of matrix B (separated by spaces) it should be "+colsB+" numbers for each row : ", mistakeCount);
            if (matrixB[i] == null) return; // Exit if three mistakes are made
        }


        int[][] result = MatrixOperations.multiplyMatrices(matrixA, matrixB);


        MatrixOperations.showResult(result);
    }
}
