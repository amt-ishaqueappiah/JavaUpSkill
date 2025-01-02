package matrix;

import java.util.Scanner;

public class CalculateMatrix {

    int[][] matrixA;
    int[][] matrixB;
    int[][] result;

    // Method to take input for matrices and perform calculations
    public void takeInputAndCalculate() {
        Scanner scanner = new Scanner(System.in);

        int mistakeCount = 0;


        int rowsA = getValidIntInput("Enter the number of rows for matrix A: ", mistakeCount);
        if (rowsA == -1) return; // Exit if three mistakes are made
        int colsA = getValidIntInput("Enter the number of columns for matrix A: ", mistakeCount);
        if (colsA == -1) return;


        int rowsB = getValidIntInput("Enter the number of rows for matrix B: ", mistakeCount);
        if (rowsB == -1) return;
        int colsB = getValidIntInput("Enter the number of columns for matrix B: ", mistakeCount);
        if (colsB == -1) return;


        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible because number of columns in matrix A is not equal to number of rows in matrix B.");
            return;
        }


        matrixA = new int[rowsA][colsA];
        matrixB = new int[rowsB][colsB];
        result = new int[rowsA][colsB];


        System.out.println("Enter the values for matrix A (" + rowsA + "x" + colsA + "):");
        for (int i = 0; i < rowsA; i++) {
            matrixA[i] = getValidRowInput(colsA, "Enter values for row " + (i + 1) + " of matrix A (separated by spaces): ", mistakeCount);
            if (matrixA[i] == null) return; // Exit if three mistakes are made
        }


        System.out.println("Enter the values for matrix B (" + rowsB + "x" + colsB + "):");
        for (int i = 0; i < rowsB; i++) {
            matrixB[i] = getValidRowInput(colsB, "Enter values for row " + (i + 1) + " of matrix B (separated by spaces): ", mistakeCount);
            if (matrixB[i] == null) return; // Exit if three mistakes are made
        }


        calculateMatrix(rowsA, colsA, rowsB, colsB);


        showResult(rowsA, colsB);


        scanner.close();
    }


    private int getValidIntInput(String prompt, int mistakeCount) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input <= 0) {
                    System.out.println("Please enter a positive integer.");
                    mistakeCount++;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                mistakeCount++;
            }


            if (mistakeCount >= 3) {
                System.out.println("Too many incorrect inputs. Please start again.");
                return -1; // Signal to end the program
            }
        }
        return input;
    }


    private int[] getValidRowInput(int length, String prompt, int mistakeCount) {
        Scanner scanner = new Scanner(System.in);
        int[] row = new int[length];
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // Split by whitespace

            if (parts.length == length) {
                try {
                    for (int i = 0; i < length; i++) {
                        row[i] = Integer.parseInt(parts[i]);
                    }
                    break;  // If we successfully parsed all elements, break the loop
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    mistakeCount++;
                }
            } else {
                System.out.println("Incorrect number of values. Please enter exactly " + length + " values.");
                mistakeCount++;
            }

            // If three mistakes are made, notify and exit the program
            if (mistakeCount >= 3) {
                System.out.println("Too many incorrect inputs. Please start again.");
                return null; // Signal to end the program
            }
        }
        return row;
    }


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
