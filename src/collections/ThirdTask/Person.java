package collections.ThirdTask;

import java.util.Objects;

public abstract class Person {
    private int weight;
    private int height;
    private int id;
    private static int countId = 0;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.id = countId;
        countId++;

    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return weight == person.weight &&
                height == person.height &&
                id == person.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(weight, height, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + weight +
                ", height=" + height +
                ", id=" + id +
                '}';
    }
}
