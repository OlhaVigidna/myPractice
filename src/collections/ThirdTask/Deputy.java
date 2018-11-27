package collections.ThirdTask;

import java.util.Objects;

public class Deputy extends Person {
    private String sourname;
    private String name;
    private int age;
    private boolean grafter;
    private int sizeOfGrafte;

    public Deputy(int weight, int height, String sourname, String name, int age, boolean grafter, int sizeOfGrafte) {
        super(weight, height);
        this.sourname = sourname;
        this.name = name;
        this.age = age;
        this.grafter = grafter;
        this.sizeOfGrafte = sizeOfGrafte;
    }

    public void getGrafter(int greftSum) {
        if (this.isGrafter()) {
            if (greftSum > (this.getSizeOfGrafte() * 2)) {
                System.out.println("А ви точно від Олександра Петровича?");
            } else {
                System.out.println("Домовилися, з вами приємно мати справу");
            }
        } else {
            System.out.println("Заберіть гроші!!!");
        }
    }

    public String getSourname() {
        return sourname;
    }

    public void setSourname(String sourname) {
        this.sourname = sourname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGrafter() {
        return grafter;
    }

    public void setGrafter(boolean grafter) {
        this.grafter = grafter;
    }

    public int getSizeOfGrafte() {
        return sizeOfGrafte;
    }

    public void setSizeOfGrafte(int sizeOfGrafte) {
        this.sizeOfGrafte = sizeOfGrafte;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "sourname='" + sourname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grafter=" + grafter +
                ", sizeOfGrafte=" + sizeOfGrafte +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deputy deputy = (Deputy) o;
        return age == deputy.age &&
                grafter == deputy.grafter &&
                sizeOfGrafte == deputy.sizeOfGrafte &&
                Objects.equals(sourname, deputy.sourname) &&
                Objects.equals(name, deputy.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sourname, name, age, grafter, sizeOfGrafte);
    }
}
