package oop_basics;

public class PyramidTriangle {
    public static void main(String[] args) {
        //1 2 3 4
        //5 6 7
        //8 9
        //10

        int k=1;
        for(int i=0;i<5;i++){
           // System.out.println("outer loop started");
            for(int j=1;j<=5-i;j++){
                System.out.print( k);
                System.out.println("\t");
                k++;
            }
            System.out.println( "");
        }
    }
}
