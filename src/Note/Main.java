package Note;

import java.util.*;

public class Main {
    private static Map<User, Set<Note>> notesMap = new HashMap<>();


    public static void main(String[] args) {
        User localUser = login();
        if (userExist(notesMap, localUser)) {
            System.out.println("Welcome! \n1-create note \n2-show notes \n3-show by types \n4-return to main printMenu");
        } else {
            createUser(localUser);
        }
        printMenu(localUser);
    }

    private static User login() {
        Scanner scannerString = new Scanner(System.in);
        System.out.println("enter user login");
        String login = scannerString.nextLine();
        System.out.println("enter user password");
        String password = scannerString.nextLine();
        return new User(login, password);
    }

    private static void createUser(User localUser) {
        notesMap.put(localUser, new HashSet<>());
        System.out.println("Welcome, new user! \n1-create note \n2-return to main printMenu");
        Scanner scannerInt = new Scanner(System.in);
        int newUserFirstChoose = scannerInt.nextInt();
        switch (newUserFirstChoose) {
            case 1: {
                createNote(localUser);
                if (continueWork()) {
                    printMenu(localUser);
                }
                break;
            }
            case 2: {
                printMenu(localUser);
            }
        }
    }

    public static void printMenu(User localUser) {

        Scanner scannerInt = new Scanner(System.in);
        int userFirstChoose = scannerInt.nextInt();
        switch (userFirstChoose) {
            case 1: {
                createNote(localUser);
                break;
            }
            case 2: {
                showNotes(localUser);
                break;
            }
            case 3: {
                showByType(localUser);
                break;
            }
            case 4: {
                printMenu(localUser);
                break;
            }

        }

        if (continueWork()) {
            printMenu(localUser);
        }

    }


    public static void showNotes(User localUser) {
        Set<Map.Entry<User, Set<Note>>> entries = notesMap.entrySet();
        for (Map.Entry<User, Set<Note>> entry : entries) {
            if (entry.getKey().equals(localUser)) {
                for (Note note : entry.getValue()) {
                    System.out.println(note);
                }
            }
        }
    }

    public static void showByType(User localUser) {
        Set<Map.Entry<User, Set<Note>>> entries = notesMap.entrySet();
        for (Map.Entry<User, Set<Note>> entry : entries) {
            if (entry.getKey().equals(localUser)) {

                for (int i = 1; i < 5; i++) {
                    Type type = type(i);
                    countRealisation(entry.getValue(), type);

                }
            }
        }

    }

    public static void countRealisation(Set<Note> notes, Type type) {
        Count count = (not, smType) -> {
            int counting = 0;
            for (Note smNot : not) {
                if (smNot.getType().equals(smType)) {
                    counting++;
                }
            }
            System.out.println(smType + "(" + counting + ")");
        };
        count.count(notes, type);
    }


    public static boolean userExist(Map<User, Set<Note>> notesMap, User localUser) {
        boolean exist = false;
        Set<Map.Entry<User, Set<Note>>> entries = notesMap.entrySet();
        for (Map.Entry<User, Set<Note>> entry : entries) {
            if (entry.getKey().equals(localUser)) {
                exist = true;
            }
        }
        return exist;
    }

    public static Map<User, Set<Note>> createNote(User localUser) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        Note note = new Note();

        String name = null, text = null, date = null, place = null;
        int contact = 0;
        Type type = null;

        boolean contin = true;
        do {
            System.out.println("1-name, 2-text, 3-date, 4-place, 5-contact, 6-type, 7-save");
            int choose = scannerInt.nextInt();
            switch (choose) {
                case 1: {
                    System.out.println("enter note name(String)");
                    name = scannerString.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("enter note text (String");
                    text = scannerString.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("enter note date (String)");
                    date = scannerString.nextLine();
                    break;
                }
                case 4: {
                    System.out.println("enter note place (String)");
                    place = scannerString.nextLine();
                    break;
                }
                case 5: {
                    System.out.println("enter note contact (int)");
                    contact = scannerInt.nextInt();
                    break;
                }
                case 6: {
                    type = chooseNoteType();
                    break;
                }
                case 7: {
                    note = Note.builder().text(text).name(name).contact(contact).date(date).
                            plase(place).type(type).build();
                    contin = false;
                    break;

                }
            }
        } while (contin);

        Set<Map.Entry<User, Set<Note>>> entries = notesMap.entrySet();
        for (Map.Entry<User, Set<Note>> entry : entries) {
            if (entry.getKey().equals(localUser)) {
                entry.getValue().add(note);
            }
        }

        return notesMap;
    }

    public static Type chooseNoteType() {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Choose note type: \n1 - event \n2 - meeting \n3 - note \n4 - d.n");
        int chose = scannerInt.nextInt();
        Type type = type(chose);
        return type;
    }

    public static Type type(int nomb) {
        Type type = null;
        switch (nomb) {
            case 1: {
                type = Type.EVENT;
                break;
            }
            case 2: {
                type = Type.MEETING;
                break;
            }
            case 3: {
                type = Type.NOTE;
                break;
            }
            case 4: {
                type = Type.DN;
            }
        }
        return type;

    }

    public static boolean continueWork() {
        boolean choose = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-continue \n2-no");
        int res = scanner.nextInt();
        if (res == 1) {
            choose = true;
        }
        return choose;
    }
}
