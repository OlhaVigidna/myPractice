package collections.ThirdTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deputy deputy = new Deputy(76, 167, "havr", "Oleh", 45, false,
                43000);
 Deputy deputy2 = new Deputy(76, 167, "havr", "Oleh", 45, true,
                43000);
 Deputy deputy3 = new Deputy(76, 167, "havr", "Oleh", 45, false,
                43000);
 Deputy deputy4 = new Deputy(76, 167, "havr", "Oleh", 45, true,
                43000);
   List<Deputy> list = new ArrayList<>();
   list.add(deputy);
   list.add(deputy2);
   list.add(deputy3);
   list.add(deputy4);
   Fraction fraction = new Fraction();
    fraction.setDeputies(list);
        System.out.println(fraction.getDeputies().get(0).getId());
        System.out.println(fraction.getDeputies().get(1).getId());
        System.out.println(fraction.getDeputies().get(2).getId());



    }

    public static void deputMenu(){
    }
}
