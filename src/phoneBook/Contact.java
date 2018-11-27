package phoneBook;

import java.util.Objects;

public class Contact {
    private String contactTipe;
    private int phoneNomber;

    public Contact(String contactTipe, int phoneNomber) {
        this.contactTipe = contactTipe;
        this.phoneNomber = phoneNomber;
    }

    public String getContactTipe() {
        return contactTipe;
    }

    public void setContactTipe(String contactTipe) {
        this.contactTipe = contactTipe;
    }

    public int getPhoneNomber() {
        return phoneNomber;
    }

    public void setPhoneNomber(int phoneNomber) {
        this.phoneNomber = phoneNomber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return phoneNomber == contact.phoneNomber &&
                Objects.equals(contactTipe, contact.contactTipe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactTipe, phoneNomber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactTipe='" + contactTipe + '\'' +
                ", phoneNomber=" + phoneNomber +
                '}';
    }
}
