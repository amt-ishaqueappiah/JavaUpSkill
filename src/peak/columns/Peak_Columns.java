package peak.columns;
import java.util.ArrayList;
import java.util.Scanner;

public class Peak_Columns {

    static int[][] matrixA;
    static ArrayList<Integer> maxValues = new ArrayList<>();
    static ArrayList<String> peakColumns = new ArrayList<>();
    static int max = 0;

    public static void getInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            int rows, cols;
            do {
                System.out.print("Enter number of rows (greater than 1): ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns (greater than 1): ");
                cols = scanner.nextInt();
                if (rows <= 1 || cols <= 1) {
                    System.out.println("Rows and columns must be greater than 1. Please try again.");
                }
            } while (rows <= 1 || cols <= 1);

            matrixA = new int[rows][cols];
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < rows; i++) {
                System.out.print("Enter values for row " + (i + 1) + " separated by commas: ");
                String[] inputValues = scanner.nextLine().split(",");
                if (inputValues.length != cols) {
                    System.out.println("Invalid number of columns entered. Please try again.");
                    i--; // Repeat the row input
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    matrixA[i][j] = Integer.parseInt(inputValues[j].trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void getRowMaxValues() {
        try {
            for (int[] array : matrixA) {
                max = 0;
                for (int item : array) {
                    if (item > max) {
                        max = item;
                    }
                }
                maxValues.add(max);
            }
            System.out.println("Maximum values in each row: " + maxValues);
        } catch (Exception e) {
            System.out.println("An error occurred while calculating row max values: " + e.getMessage());
        }
    }

    public static void getPeakColumns() {
        try {
            if (!maxValues.isEmpty()) {
                for (int i = 0; i < matrixA.length; i++) {
                    for (int j = 0; j < matrixA[i].length; j++) {
                        if (matrixA[i][j] == maxValues.get(i)) {
                            boolean isMinInColumn = true;
                            for (int k = 0; k < matrixA.length; k++) {
                                if (matrixA[k][j] < matrixA[i][j]) {
                                    isMinInColumn = false;
                                    break;
                                }
                            }
                            if (isMinInColumn) {
                                peakColumns.add("A (" + (i + 1) + ", " + (j + 1) + ") = " + matrixA[i][j]);
                            }
                        }
                    }
                }
                if (peakColumns.isEmpty()) {
                    System.out.println("No peak-columns found.");
                } else {
                    for (String peak : peakColumns) {
                        System.out.println(peak);
                    }
                }
            } else {
                System.out.println("No max values found.");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }



}
