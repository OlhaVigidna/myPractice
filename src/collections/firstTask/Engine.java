package collections.firstTask;

import java.util.Objects;

public class Engine {
    private String model;
    private float value;
    private int pover;

    public Engine(String model, float value, int pover) {
        this.model = model;
        this.value = value;
        this.pover = pover;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getPover() {
        return pover;
    }

    public void setPover(int pover) {
        this.pover = pover;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", value=" + value +
                ", pover=" + pover +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Float.compare(engine.value, value) == 0 &&
                pover == engine.pover &&
                Objects.equals(model, engine.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, value, pover);
    }
}
