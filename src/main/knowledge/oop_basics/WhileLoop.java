package oop_basics;

public class WhileLoop {


    public static void main(String[] args) {


        for (int i = 0; i < 10; i = i + 3) {
            if (i == 9)
                System.out.println(" 9 is displayed");
            else
                System.out.println("I didnot find");//
        }





        int j=20;
        do {


            System.out.println("I am in do while loop"+ j);
            j++;
        }
        while(j<30);
    }

}

