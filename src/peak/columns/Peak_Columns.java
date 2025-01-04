package peak.columns;
import java.util.ArrayList;

public class Peak_Columns {

    static int[][] matrixA = {
            {3, 5, 6, 7, 7},
            {4, 2, 2, 8, 9},
            {6, 3, 2, 9, 7}
    };

    static ArrayList<Integer> maxValues = new ArrayList<>();
    static ArrayList<String> peakColumns = new ArrayList<>();
    static int max = 0;


    public static void getRowMaxValues() {
        for (int[] array : matrixA) {
            for (int item : array) {
                if (item > max) {
                    max = item;
                }
            }
            maxValues.add(max);
            max=0;
        }
        System.out.println("Maximum values in each row: " + maxValues);
    }


    public static void getPeakColumns() {
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

            // Output the peak-columns
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
    }

    public static void main(String[] args) {
        getRowMaxValues();
        getPeakColumns();
    }
}
