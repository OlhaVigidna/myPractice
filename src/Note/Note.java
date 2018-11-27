package Note;

import java.util.Objects;

public class Note {
    private String name;
    private String text;
    private String date;
    private String plase;
    private  int contact;
    private Type type;

    public static Builder builder(){
        return new Builder();
    }

    static class Builder{
       private Note note = new Note();

        public Builder name (String name){
            note.name = name;
            return this;
        }

        public Builder text(String text){
            note.text = text;
            return this;
        }

        public Builder date(String date){
            note.date = date;
            return this;
        }

        public Builder plase(String plase){
            note.plase = plase;
            return this;
        }

        public Builder contact(int contact){
            note.contact = contact;
            return this;
        }

        public Builder type(Type type){
            note.type = type;
            return this;
        }

        public Note build(){
            return note;
        }
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getPlase() {
        return plase;
    }

    public int getContact() {
        return contact;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", plase='" + plase + '\'' +
                ", contact=" + contact +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return contact == note.contact &&
                Objects.equals(name, note.name) &&
                Objects.equals(text, note.text) &&
                Objects.equals(date, note.date) &&
                Objects.equals(plase, note.plase) &&
                type == note.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, text, date, plase, contact, type);
    }
}
