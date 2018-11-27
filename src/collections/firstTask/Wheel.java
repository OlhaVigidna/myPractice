package collections.firstTask;

import java.util.Objects;

public class Wheel {
    private String maker;
    private double diameter;

    public Wheel(String maker, double diameter) {
        this.maker = maker;
        this.diameter = diameter;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "maker='" + maker + '\'' +
                ", diameter=" + diameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.diameter, diameter) == 0 &&
                Objects.equals(maker, wheel.maker);
    }

    @Override
    public int hashCode() {

        return Objects.hash(maker, diameter);
    }
}
