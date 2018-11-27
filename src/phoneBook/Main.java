package phoneBook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<User, Set<Contact>> phoneMap = new TreeMap<>();

        phoneMap.put(new User("user2", "dg"), new HashSet<>());
        phoneMap.put(new User("user5", "af"), new HashSet<>());
        phoneMap.put(new User("user", "aad"), new HashSet<>());

//        addContact(phoneMap);
        deleteUser(phoneMap);
        System.out.println(phoneMap);

    }

    public static void addNewUser(Map<User, Set<Contact>> phoneMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter user name");
        String userName = scanner.nextLine();
        System.out.println("enter user surname");
        String userSurname = scanner.nextLine();
        phoneMap.put(new User(userName, userSurname), new HashSet<Contact>());
    }

    public static void addContact(Map<User, Set<Contact>> phoneMap){
        Scanner scanner = new Scanner(System.in);
        String zero;
        Set<Map.Entry<User, Set<Contact>>> entries = phoneMap.entrySet();
        System.out.println("enter user name");
        String user = scanner.nextLine();
        System.out.println("how many contacts do you want to add");
        int numbOfContacts = scanner.nextInt();
        zero = scanner.nextLine();
        for (Map.Entry<User, Set<Contact>> entry : entries) {
            if (entry.getKey().getName().equals(user)) {
                for (int i = 0; i < numbOfContacts; i++) {
                    System.out.println("enter contact type");
                    String contactType = scanner.nextLine();
                    System.out.println("enter phone number");
                    int phoneNumber = scanner.nextInt();
                    zero = scanner.nextLine();
                    entry.getValue().add(new Contact(contactType, phoneNumber));

                }
            }
        }
    }

    public static void deleteUser(Map<User, Set<Contact>> phoneMap){
        Set<Map.Entry<User, Set<Contact>>> entries = phoneMap.entrySet();
        Iterator<Map.Entry<User, Set<Contact>>> iterator = entries.iterator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter user name");
        String name = scanner.nextLine();
        System.out.println("enter user surname");
        String surname = scanner.nextLine();
        while (iterator.hasNext()){
            Map.Entry<User, Set<Contact>> next = iterator.next();
            if (next.getKey().getName().equals(name) && next.getKey().getSurname().equals(surname)){
                iterator.remove();
            }
        }
    }

}
