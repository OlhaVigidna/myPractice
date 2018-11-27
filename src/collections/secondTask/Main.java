package collections.secondTask;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        List<Auth> auths = new ArrayList<>();

        people.add(new Person(1,"vaysa",32));
        people.add(new Person(2,"petya",31));
        people.add(new Person(3,"kolya",30));
        people.add(new Person(4,"anya",29));
        people.add(new Person(5,"masha",28));
        people.add(new Person(6,"andriy",30));
        people.add(new Person(7,"maxim",31));
        people.add(new Person(8,"vadym",32));
        people.add(new Person(9,"taras",33));

        auths.add(new Auth(5,"login5","password5"));
        auths.add(new Auth(2,"login2","password2"));
        auths.add(new Auth(1,"login1","password1"));
        auths.add(new Auth(7,"login7","password7"));
        auths.add(new Auth(3,"login3","password3"));
        auths.add(new Auth(4,"login4","password4"));
        auths.add(new Auth(8,"login8","password8"));
        auths.add(new Auth(6,"login6","password6"));
        auths.add(new Auth(9,"login9","password9"));

        List<User> users = unit(people, auths);
        System.out.println(users);

    }

    public static List<User> unit(List<Person> people, List<Auth> auths){
       List<User> users = new ArrayList<>();

        for (int i = 0; i < people.size()-1; i++) {
            for (int j = 0; j < auths.size()-1; j++) {
                if (people.get(i).getId() == auths.get(j).getId()){
                    users.add(new User(people.get(i), auths.get(j)));
                }

            }

        }

        return users;
    }
}
