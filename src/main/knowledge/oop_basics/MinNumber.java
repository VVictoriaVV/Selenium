package oop_basics;

public class MinNumber {


    // 2 4 5
    // 3 4 7
    //1 2 9
    public static void main(String[] args) {
        int abc[][] = {{2, 4, 5}, {3, 4, 7}, {1, 2, 9}};
        int min = abc[0][0];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (abc[i][j] < min) {
                    min = abc[i][j];
                }

            }

        }
        System.out.println(min);

// find minimum number in 2D array
        // 2 4 5
        // 3 0 7
        //1 2 9
        int abcd[][] = {{2, 4, 5}, {3, 2, 10}, {1, 2, 0}};
        int min1 = abcd[0][0];
        int minColoumn=0;



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (abcd[i][j] < min1) {
                    min1 = abcd[i][j];
                    minColoumn = j;
                }

            }

        }
        int k=0;
        int max=abcd[0][minColoumn];
        while(k<3){
            if(abcd[k][minColoumn]>max){
                max=abcd[k][minColoumn];
            }
            k++;
        }
        System.out.println(max);

    }
}
