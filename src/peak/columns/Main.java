package peak.columns;

import static peak.columns.Peak_Columns.*;

public class Main {
    public static void main(String[] args) {
        try {
            getInputFromUser();
            getRowMaxValues();
            getPeakColumns();
        } catch (Exception e) {
            System.out.println("An error occurred in the main method: " + e.getMessage());
        }
    }
}
