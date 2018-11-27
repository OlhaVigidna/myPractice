package collections.ThirdTask;

import java.util.*;

public class Fraction {
    private List<Deputy> deputies;

    public Fraction() {
        this.deputies = new ArrayList<>();
    }

    public Fraction(List<Deputy> deputies) {
        this.deputies = deputies;
    }

    public List<Deputy> addDeputy(List<Deputy> deputies) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("enter weight");
        int weight = scannerInt.nextInt();
        System.out.println("enter height");
        int height = scannerInt.nextInt();
        System.out.println("enter surname");
        String surname = scannerString.nextLine();
        System.out.println("enter name");
        String name = scannerString.nextLine();
        System.out.println("enter age");
        int age = scannerInt.nextInt();
        System.out.println("enter is grafter");
        boolean grafter = Boolean.parseBoolean(scannerString.nextLine());
        System.out.println("enter size of bribe");
        int bribe = scannerInt.nextInt();
        deputies.add(new Deputy(weight, height, surname, name, age, grafter, bribe));

        return deputies;
    }

    public List<Deputy> delete(List<Deputy> deputies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter surname");
        String surname = scanner.nextLine();
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("enter age");
        int age = scanner.nextInt();
        Iterator<Deputy> iterator = deputies.iterator();
        while (iterator.hasNext()) {
            Deputy next = iterator.next();
            if (next.getName().equals(name) && (next.getSourname().equals(surname)) && (next.getAge() == age)) {
                iterator.remove();
            }
        }
        return deputies;
    }

    public void theBigestGrafter(List<Deputy> deputies) {
        deputies.sort(new SortByBribe());
        System.out.println(deputies.get(0));
    }

    public void showAllDeputy(List<Deputy> deputies) {
        if (deputies.size() == 0) {
            System.out.println("list is empty");
        } else {
            for (Deputy deputy : deputies) {
                System.out.println(deputy);
            }
        }
    }

    public List<Deputy> deleteAllGrafters(List<Deputy> deputies) {
        Iterator<Deputy> iterator = deputies.iterator();
        while (iterator.hasNext()) {
            Deputy next = iterator.next();
            if (next.isGrafter()) {
                iterator.remove();
            }
        }
        return deputies;
    }

    public List<Deputy> deleteAll(List<Deputy> deputies){
        deputies.clear();
        return deputies;
    }

    public void sumOfBrible(List<Deputy> deputies){
        int sum = 0;
        for (Deputy deputy : deputies) {
            sum+=deputy.getSizeOfGrafte();
        }
        System.out.println(sum);
    }

    public List<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(List<Deputy> deputies) {
        this.deputies = deputies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Objects.equals(deputies, fraction.deputies);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deputies);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "deputies=" + deputies +
                '}';
    }
}
