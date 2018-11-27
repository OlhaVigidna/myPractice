package lidrary;

import java.util.Scanner;

public class Menu {

    public static final String MENU = "- щоб зареєструвати книгу введіть 1, \n - щоб переглянути всі книги введіть 2,\n " +
            "- щоб переглянути книги по жанрах введіть 3,\n - щоб переглянути книги по авторах введіть 4,\n - щоб " +
            "переглянути книги по роках  введіть 5,\n - щоб переглянути обрані книги введіть 6.";
    public static final String GENERES = " 0 - для дітей \n 1 - романи \n 2 - поезія";

    Scanner scannerForInt = new Scanner(System.in);
    Scanner scannerForString = new Scanner(System.in);

    public void myMenu(Book[][] books, Book[] books2) {

        System.out.println(MENU);
        int menuRes = scannerForInt.nextInt();

        switch (menuRes) {
            case 1: {
                registr(books);
                continueWork(books, books2);
                break;
            }
            case 2: {
                showAllBooks(books);
                continueWork(books, books2);
                break;
            }
            case 3: {
                showByGener(books, books2);
                continueWork(books, books2);
                break;
            }
            case 4: {
                showByAuthor(books);
                continueWork(books, books2);
                break;
            }
            case 5: {
                showByYear(books);
                continueWork(books, books2);
                break;
            }
            case 6: {
                showSelected(books2);
                continueWork(books, books2);
                break;
            }
        }
    }

    public void continueWork(Book[][] books, Book[] books2) {
        System.out.println("1 - continue \n no - 2");
        int res = scannerForInt.nextInt();
        if (res == 1) {
            myMenu(books, books2);
        }
    }

    public void showSelected(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public void showByYear(Book[][] books) {
        System.out.println("enter year");
        int res = scannerForInt.nextInt();
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                if (books[i][j].getYear() == (res)) {
                    System.out.println(books[i][j]);
                }
            }
        }
    }

    public void showByAuthor(Book[][] books) {
        System.out.println("enter author name");
        String authorName = scannerForString.nextLine();
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                if (books[i][j] != null) {
                    if (books[i][j].getAuthor().equals(authorName)) {
                        System.out.println(books[i][j]);
                    }
                }
            }
        }
    }

    public void showByGener(Book[][] books, Book[] books2) {
        System.out.println(GENERES);
        int res = scannerForInt.nextInt();
        System.out.println("show by author ? \n 1 - yes \n  2 - no");
        int res2 = scannerForInt.nextInt();
        switch (res2) {
            case 1:
                System.out.println("enter author name");
                String res3 = scannerForString.nextLine();
                for (int i = 0; i < books[res].length; i++) {
                    if (books[res][i] != null) {
                        if (books[res][i].getAuthor().equals(res3)) {
                            System.out.println(books[res][i]);
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < books[res].length; i++) {
                    System.out.println(books[res][i]);
                }
                break;
        }
        System.out.println("Add book to favorite? \n1 - yes \n2 - no");
        int res4 = scannerForInt.nextInt();
        if (res4 == 1) {
            addToFavotite(books[res], books2);
        }
    }

    public void addToFavotite(Book[] booksRes, Book[] books2) {
        System.out.println("enter number of book");
        int numbOfBook = scannerForInt.nextInt();

        Book elect = booksRes[numbOfBook - 1];

        if (isFull(books2)) {
            System.out.println("List of your favorite books is full. Do you want replace book from list? \n 1-yes" +
                    " \n 2 - no");
            int res1 = scannerForInt.nextInt();
            if (res1 == 1) {
                System.out.println("Enter number of book which you want replace");
                int res6 = scannerForInt.nextInt();
                books2[res6 - 1] = elect;
            }
        } else {
            for (int i = 0; i < books2.length; i++) {
                if (books2[i] == null) {
                    books2[i] = elect;
                    break;
                }
            }
        }
    }

    public void showAllBooks(Book[][] books) {
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                System.out.println(books[i][j]);
            }
        }
    }

    public void registr(Book[][] books) {
        System.out.println(GENERES);
        int res1 = scannerForInt.nextInt();
        Book[] clientChoose = zbilshenia(books[res1]);

        for (int i = 0; i < clientChoose.length; i++) {
            if (clientChoose[i] == null) {
                Book newBook = zapovn();
                if (exist(newBook, books)) {
                    System.out.println(" This book exist");
                }
                clientChoose[i] = newBook;
                System.out.println("book was registered");
                break;
            }

        }
        books[res1] = clientChoose;
    }

    public boolean exist(Book book, Book[][] books) {
        boolean isExist = false;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                Book check = books[i][j];
                if (check != null) {
                    if (book.equals(check)) {
                        isExist = true;
                    }
                }
            }
        }

        return isExist;
    }

    public boolean isFull(Book[] books2) {
        boolean isFull = true;
        for (Book book : books2) {
            if (book == null) { //!!!!
                isFull = false;
            }
        }
        return isFull;
    }

    public Book[] zbilshenia(Book[] books) {
        Book[] newArray;
        if (isFull(books)) {
            newArray = new Book[books.length + 3];
            for (int i = 0; i < books.length; i++) {
                newArray[i] = books[i];
            }
        } else newArray = books;

        return newArray;
    }

    public Book zapovn() {
        System.out.println("enter name of book");
        String name = scannerForString.nextLine();
        System.out.println("enter author of book");
        String author = scannerForString.nextLine();
        System.out.println("enter year of book");
        int year = scannerForInt.nextInt();
        Book newBook = createBook(name, author, year);
        return newBook;
    }

    public static int id = 1;

    static public Book createBook(String bookName, String author, int year) {
        Book book = new Book(id, bookName, author, year);
        id++;
        return book;
    }
}
