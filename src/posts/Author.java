package posts;

import java.util.Objects;

public class Author {
    private int nomb;
    private String name;

    public Author(int nomb, String name) {
        this.nomb = nomb;
        this.name = name;
    }

    public int getNomb() {
        return nomb;
    }

    public void setNomb(int nomb) {
        this.nomb = nomb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return nomb == author.nomb &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nomb, name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "nomb=" + nomb +
                ", name='" + name + '\'' +
                '}';
    }
}
