package posts;

import java.util.Objects;

public class Post {
    private String title;
    private String describe;
    private  Location location = new Location();
    private Author author;

    public Post(String title, String describe, String country, String city, Author author) {
        this.title = title;
        this.describe = describe;
        this.author = author;
        this.location.setCity(city);
        this.location.setCountry(country);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(describe, post.describe) &&
                Objects.equals(location, post.location) &&
                Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, describe, location, author);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", location=" + location +
                ", author=" + author +
                '}';
    }
}
