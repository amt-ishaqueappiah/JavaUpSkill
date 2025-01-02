package matrix;

import java.util.Scanner;

public class InputHandler {


    public static int getValidIntInput(String prompt, int mistakeCount) {
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


    public static int[] getValidRowInput(int length, String prompt, int mistakeCount) {
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


            if (mistakeCount >= 3) {
                System.out.println("Too many incorrect inputs. Please start again.");
                return null;
            }
        }
        return row;
    }
}
