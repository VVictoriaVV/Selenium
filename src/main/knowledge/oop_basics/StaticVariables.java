package oop_basics;

public class StaticVariables {

    String name;
    String address;
   static  String city="Moscow";
   static int i =0;
   public int a =10;

    StaticVariables(String name, String address) {
        this.name = name;
        this.address = address;
        i++;
        System.out.println(i);


        System.out.println(name + " " + address);

    }

    public void  getAddress() {
        System.out.println(address+" "+city);
    }



    public static void getCity() {
        System.out.println(city);
    }


    public static void main(String[] args) {

        StaticVariables obj = new StaticVariables("Vika", "USA");
        obj.getAddress();
        StaticVariables.getCity();

    }
}
