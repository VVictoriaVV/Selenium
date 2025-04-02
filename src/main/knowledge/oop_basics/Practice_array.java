package oop_basics;

public class Practice_array {


    public static void main(String[] args) {

        //- A container which stores multiple values of same data type

        int a[] = new int[5];// Delcares an aray and allocates memory for the values
        a[0] = 2;
        a[1] = 6;
        a[2] = 1;
        a[3] = 9;
        a[4] = 12;//initilased values into that array

        int b[] = {1, 4, 3, 5, 7, 8};

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        int d[][] = new int[2][3];
        d[0][0] = 2;
        d[0][1] = 4;
        d[0][2] = 5;
        d[1][0] = 3;
        d[1][1] = 4;
        d[1][2] = 7;
//System.out.println(a[1][0]);
/*int b[][]= {‌{2,4,5},{3,4,7},{5,2,1}};
System.out.println(b[2][1]);*/

        for (int i = 0; i < 2; i++) //row
        {

            for (int j = 0; j < 3; j++) //coloumn
            {

                System.out.println(d[i][j]);
            }
        }

    }


}

// retrieve values present in this array/


//Multi Dimensional code

////a[row][coloum]







