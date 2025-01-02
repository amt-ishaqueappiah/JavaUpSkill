package matrix;

import java.util.Scanner;

public class CalculateMatrix {

    int[][] matrixA;
    int[][] matrixB;
    int[][] result;

    // Method to take input for matrices and perform calculations
    public void takeInputAndCalculate() {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions for matrixA
        System.out.print("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A: ");
        int colsA = scanner.nextInt();

        // Input dimensions for matrixB
        System.out.print("Enter the number of rows for matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int colsB = scanner.nextInt();

        // Check if matrix multiplication is possible
        if (rowsA != colsB) {
            System.out.println("Matrix multiplication is not possible because number of rows in matrix A is not equal to number of columns in matrix B.");
            return;
        }

        // Initialize the matrices based on input dimensions
        matrixA = new int[rowsA][colsA];
        matrixB = new int[rowsB][colsB];
        result = new int[rowsA][colsB];

        // Take input for matrixA
        System.out.println("Enter the values for matrix A (" + rowsA + "x" + colsA + "):");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("Enter value for matrixA[" + i + "][" + j + "]: ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Take input for matrixB
        System.out.println("Enter the values for matrix B (" + rowsB + "x" + colsB + "):");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("Enter value for matrixB[" + i + "][" + j + "]: ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        calculateMatrix(rowsA, colsA, rowsB, colsB);

        // Show the result
        showResult(rowsA, colsB);

        // Close the scanner
        scanner.close();
    }

    // Method to calculate the result matrix after multiplication
    public void calculateMatrix(int rowsA, int colsA, int rowsB, int colsB) {
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int col = 0; col < colsA; col++) {
                    sum += (matrixA[i][col] * matrixB[col][j]);
                }
                result[i][j] = sum;
            }
        }
    }

    // Method to display the result matrix
    public void showResult(int rowsA, int colsB) {
        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }



}
