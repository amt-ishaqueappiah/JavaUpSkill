package peak.colums;
import java.util.ArrayList;

public class Peak_Columns {

static int[][] matrixA ={{1,8,3,4,0},{6,7,2,7,0}};
static ArrayList<Integer> maxValues= new ArrayList<>() ;
static  ArrayList<Integer> minValues = new ArrayList<>();
static int max=0;
static  int min=Integer.MAX_VALUE;

   public static void getRowMaxValues(){
       for(int[] array:matrixA ){
            for(int item: array){
                if(item>max){
                    max=item;
                }
                System.out.print(item +" ");
            }
            maxValues.add(max);
            max=0;
           System.out.println();
       }
       System.out.println(maxValues);
    }

    public static void getPeakColums(){
       for(int val:maxValues){
           for (int[] array:matrixA){
               for (int newVal=0; newVal<array.length;newVal++){
                   for(int j=0;j<maxValues.size();j++){
                       if(val< matrixA[j][newVal] && !minValues.contains(val)){
                           if(min>val){
                               min=val;
                               minValues.add(min);
                           }

                       }

                   }

               }

           }
       }
        for(int item:minValues){
            System.out.print(item+" ");
        }
    }


    public static void main(String[] args) {

            getRowMaxValues();
            getPeakColums();

    }
}
