package collections.firstTask;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Car> set = new TreeSet<>();

        List<Car> older = new ArrayList<>();
        List<Car> younger = new ArrayList<>();

//        TreeSet<Car> set = new TreeSet<>();

        set.add(new Car("jeep", 1998, 12, "red", new Engine("model1", 3.5f,
                125), new Wheel("Opel", 22.5)));
        set.add(new Car("sedan", 1995, 9, "blue", new Engine("model2", 3f,
                140), new Wheel("BMW", 25.3)));
        set.add(new Car("miniCooper", 2018, 16, "black", new Engine("model3", 4.7f,
                170), new Wheel("Audi", 28)));
        set.add(new Car("jeep", 2015, 20, "yellow", new Engine("model4", 2f,
                250), new Wheel("SEAT", 30)));


        for (Car car : set) {
            if (car.getYear()<2000){
                older.add(car);
            }else if (car.getYear()>2000){
                younger.add(car);
            }
        }

        older.sort(new CompairByYear());
        younger.sort(new CompairByYear().reversed());

        Set<Car> allCars = new LinkedHashSet<>();
        allCars.addAll(older);
        allCars.addAll(younger);
        System.out.println(allCars);


//        List<Car> list =  new ArrayList<>();
//        list.add(new Car("jeep", 1998, 12, "red", new Engine("model1", 3.5f,
//                125), new Wheel("Opel", 22.5)));
//        list.add(new Car("sedan", 1995, 9, "blue", new Engine("model2", 3f,
//                140), new Wheel("BMW", 25.3)));
//        list.add(new Car("miniCooper", 2018, 16, "black", new Engine("model3", 4.7f,
//                170), new Wheel("Audi", 28)));
//        list.add(new Car("jeep", 2015, 20, "yellow", new Engine("model4", 2f,
//                250), new Wheel("SEAT", 30)));

//
//
//        list.sort(new CompairByYear());
//
//        for (Car car1 : list) {
//            if (car1.getYear()>2000){
//                car1.getWheel().setDiameter(car1.getWheel().getDiameter()-1);
//            }else if (car1.getYear()<2000){
//                car1.setColor("green");
//            }
//        }
//
//        System.out.println(list.toString());

    }


}
