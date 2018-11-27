package collections.zoo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Person, HashSet<Pet>> zooclub = new TreeMap<>();

        addPerson(zooclub);
        addPerson(zooclub);
        System.out.println(zooclub);
//        System.out.println(zooclub);
//        addPet(zooclub);
//        System.out.println(zooclub);
//        deletePet(zooclub);
//        System.out.println(zooclub);


    }


    public static void addPerson(Map<Person, HashSet<Pet>> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter person name");
        String personName = scanner.nextLine();
        System.out.println("Enter person age");
        int personAge = scanner.nextInt();
        map.put(new Person(personName, personAge), new HashSet<>());
    }

    public static void addPet(Map<Person, HashSet<Pet>> map){
        Set<Map.Entry<Person, HashSet<Pet>>> entries = map.entrySet();
        Iterator<Map.Entry<Person, HashSet<Pet>>> iterator = entries.iterator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter owner name");
        String ownerName = scanner.nextLine();
        while (iterator.hasNext()){
            Map.Entry<Person, HashSet<Pet>> next = iterator.next();
            if (next.getKey().getName().equals(ownerName)){
                System.out.println("enter the number of pets you want to add ");
                int numbOfPets = scanner.nextInt();
                String zero = scanner.nextLine();
                for (int i = 0; i < numbOfPets; i++) {
                    System.out.println("enter pet name");
                    String petName = scanner.nextLine();
                    System.out.println("enter pet color");
                    String petColor = scanner.nextLine();
                     next.getValue().add(new Pet(petName, petColor));
                }
            }
        }
    }

    public static void deletePet(Map<Person, HashSet<Pet>> map){
        Set<Map.Entry<Person, HashSet<Pet>>> entries = map.entrySet();
        for (Map.Entry<Person, HashSet<Pet>> entry : entries) {
            System.out.println(entry.getKey().getName());
        }
//        Iterator<Map.Entry<Person, HashSet<Pet>>> iterator = entries.iterator();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter name of user to delete");
//        String res = scanner.nextLine();
//        while (iterator.hasNext()){
//            if (iterator.next().getKey().getName().equals(res)){
//                iterator.remove();
//            }
//        }

    }



}
