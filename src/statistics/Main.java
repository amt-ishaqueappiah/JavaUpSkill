package statistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       calculateStatistics();

    }

    public static void calculateStatistics() {
        Scanner userInput = new Scanner(System.in);

        // Validate the number of students input
        int N = 0;
        while (N <= 0) {
            System.out.println("Please enter a positive number for the total number of students:");
            if (userInput.hasNextInt()) {
                N = userInput.nextInt();
                if (N <= 0) {
                    System.out.println("The number of students must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                userInput.next();  // Consume the invalid input
            }
        }

        int[] scores = new int[N];

        // Initialize variables for statistics
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double total = 0;

        // Collect and process student scores
        for (int i = 0; i < N; i++) {
            int score = -1;
            while (score < 0 || score > 100) {
                System.out.println("Enter score for student " + (i + 1) + " (0-100):");
                if (userInput.hasNextInt()) {
                    score = userInput.nextInt();
                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score. Please enter a score between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid score between 0 and 100.");
                    userInput.next(); // Consume invalid input
                }
            }

            scores[i] = score;
            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }
            total += score;
        }

        // Calculate average
        double average = total / N;

        // Display statistics
        System.out.println("Values: ");
        System.out.println("The maximum grade is " + max);
        System.out.println("The minimum grade is " + min);
        System.out.println("The average grade is " + average);

        // Statistics for grade ranges
        int[] stats = new int[5];
        for (int score : scores) {
            if (score <= 20) {
                stats[0]++;
            } else if (score <= 40) {
                stats[1]++;
            } else if (score <= 60) {
                stats[2]++;
            } else if (score <= 80) {
                stats[3]++;
            } else {
                stats[4]++;
            }
        }

        // Find maximum and minimum counts
        int maximumCount = Integer.MIN_VALUE;
        int minimumCount = Integer.MAX_VALUE;

        for (int number : stats) {
            if (number > maximumCount) {
                maximumCount = number;
            }
            if (number < minimumCount) {
                minimumCount = number;
            }
        }

        // Display grade distribution
        for (int k = maximumCount; k > 0; k--) {
            System.out.print(k + " > ");
            for (int l : stats) {
                if (l >= k) {
                    System.out.print(" ###### ");
                } else {
                    System.out.print("        ");
                }
            }
            System.out.println();
        }

        // Close scanner
        userInput.close();
    }




}