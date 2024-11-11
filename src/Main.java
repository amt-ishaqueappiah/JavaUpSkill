import java.lang.management.MonitorInfo;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the total number of students");
        int N = userInput.nextInt();
        int[] scores = new int[N];



    int max =0;
    int min = 0;
    double average =0;
    double total =0;
   for(int i=0; i< N ; i++){

       System.out.println("Enter score for student " + (i +1));
       scores[i] = userInput.nextInt();
        min = scores[0];
       if(scores[i] > max){
           max= scores[i];
       }
       if(scores[i]< min){
           min =scores[i];
       }

       total+=scores[i];

   }
   average = total / N;

   System.out.println(
           " Values : \n  \n The maximum grade is " + max +"\n The minimum grade is " + min + "\n The average grade is " + average

   );

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
   int maximumCount=Integer.MIN_VALUE;
   int minimumCount=Integer.MAX_VALUE;

   for(int number:stats){
       if(number > maximumCount){
           maximumCount = number;
       }
       if(number < minimumCount) {
           minimumCount = number;
       }
   }
   for(int k = maximumCount; k >0; k--){
       System.out.print(k + " > ");
        for(int l: stats ){
            if(l >=k){
                System.out.print(" ###### ");
            }
            else
                System.out.print("        ");
        }
       System.out.println();

   }

    }



}