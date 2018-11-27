package collections.zoo;

import java.util.Objects;

public class Pet {
    private String nameOfPet;
    private String color;

    public Pet(String nameOfPet, String color) {
        this.nameOfPet = nameOfPet;
        this.color = color;
    }

    public String getNameOfPet() {
        return nameOfPet;
    }

    public void setNameOfPet(String nameOfPet) {
        this.nameOfPet = nameOfPet;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(nameOfPet, pet.nameOfPet) &&
                Objects.equals(color, pet.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameOfPet, color);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nameOfPet='" + nameOfPet + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
