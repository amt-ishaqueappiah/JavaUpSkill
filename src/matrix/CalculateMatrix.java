package matrix;

public class CalculateMatrix {
    int[][] matrixA = {{12, 2, 4}, {10, 1, 1}};
    int[][] matrixB={{2 ,2},{1 ,2},{1 ,1}};

    int[][] result= new int[2][2];
    int sum =0;

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