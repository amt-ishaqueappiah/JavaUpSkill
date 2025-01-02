package matrix;

public class CalculateMatrix {
    int[][] matrixA = new int[2][3];  // 2x3 matrix
    int[][] matrixB = new int[3][2];  // 3x2 matrix

    int[][] result = new int[2][2];  // Result matrix (2x2)
    int sum = 0;



    public void calculateMatrix(){
        for(int i=0;  i< 2; i++){

            for(int j=0; j<2; j++){

                for(int col=0; col<3; col++){
                    sum+=(matrixA[i][col]*matrixB[col][j] );

                }
                result[i][j]=sum;
                sum=0;
            }
        }
    }

    public void showResult(){
        for(int i =0; i<2;i++){
            for (int j=0; j<2;j++){
                System.out.print(result[i][j] +" ") ;

            }
            System.out.println();
        }

    }
}