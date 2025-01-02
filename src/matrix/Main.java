package matrix;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateMatrix calculateMatrix = new CalculateMatrix();
        System.out.println("Enter the values for matrix A (2x3):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter value for matrixA[" + i + "][" + j + "]: ");
                calculateMatrix.matrixA[i][j] = scanner.nextInt();
            }
        }

        // Take input for matrixB (3x2 matrix)
        System.out.println("Enter the values for matrix B (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value for matrixB[" + i + "][" + j + "]: ");
                calculateMatrix.matrixB[i][j] = scanner.nextInt();
            }
        }
        calculateMatrix.calculateMatrix();
        calculateMatrix.showResult();
        scanner.close();
    }
}
