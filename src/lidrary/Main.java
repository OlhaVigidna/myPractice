package lidrary;

import java.util.Scanner;

public class Main {
   /* public  static final String MENU = "- щоб зареєструвати книгу введіть 1, \n - щоб переглянути всі книги введіть 2,\n " +
            "- щоб переглянути книги по жанрах введіть 3,\n - щоб переглянути книги по авторах введіть 4,\n - щоб " +
            "переглянути книги по роках  введіть 5,\n - щоб переглянути обрані книги введіть 6.";
    public static final String GENERES = " 0 - для дітей \n 1 - романи \n 2 - поезія";
    public static String zero;*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        Book[] forChild = {menu.createBook("Book1", "author1", 1998),
                menu.createBook("Book2", "author2", 2000), menu.createBook("Book3", "author3",
                2001)};
        Book[] romans = {menu.createBook("Book4", "author4", 2005), menu.createBook("Book5",
                "author5", 2005), menu.createBook("Book6", "author6", 2008)};
        Book[] poetry = {menu.createBook("Book7", "author7", 2009), menu.createBook("Book8",
                "author8", 2011), menu.createBook("Book9", "author9", 2013)};

        Book[][] library = {forChild, romans, poetry};

        Book[] selected = new Book[3];

        menu.myMenu(library, selected);



    }
}




