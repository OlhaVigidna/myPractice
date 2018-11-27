package bank;

public class User {
   private String login;
   private String password;
   private int rahunok;

    public User(String login, String passvord, int rahunok) {
        this.login = login;
        this.password = passvord;
        this.rahunok = rahunok;
    }


    public void setRahunok(int rahunok) {
        this.rahunok = rahunok;
    }

    public String getLogin() {

        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getRahunok() {
        return rahunok;
    }
}
