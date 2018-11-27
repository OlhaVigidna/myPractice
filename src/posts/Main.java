package posts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Post> posts = new HashSet<>();
        Set<Author> authors = new HashSet<>();


        createPost(posts, authors, "title1", "describle", "country", "city", 3,
                "Bob", 0);
        createPost(posts, authors, "title2", "describle", "country", "city", 6,
                "Bob", 0);

        menu(posts, authors);

    }

//    String title, String describe,
//    String country, String city, int nomb, String name

    public static void menu(Set<Post> posts, Set<Author> authors){
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        System.out.println("1-створити пост \n2-переглянути всі пости \n3-переглянути пости по типах, \n4-видалити пост " +
                "\n5-знайти пост певного типу в певному місті");
        int mainMenuChoose = scannerInt.nextInt();
        switch (mainMenuChoose){
            case 1:{
                System.out.println("створити пост з пошуку роботи-0, \nстворити пост з пропозицією роботи-1");
                int typeCoose = scannerInt.nextInt();
                System.out.println("Введіть заголовок оголошення");
                String title = scannerString.nextLine();
                System.out.println("Введіть опис оголошення");
                String describe = scannerString.nextLine();
                System.out.println("Введіть країну оголошення");
                String country = scannerString.nextLine();
                System.out.println("Введіть місто оголошення");
                String city = scannerString.nextLine();
                System.out.println("Введіть номер автора оголошення");
                int nomb = scannerInt.nextInt();
                System.out.println("Введіть імя автора оголошення");
                String name = scannerString.nextLine();

              posts =  createPost(posts, authors, title, describe, country, city, nomb, name, typeCoose);
              break;
            }
            case 2:{
                showAllPosts(posts);
                break;
            }
            case 3:{
                System.out.println("щоб переглянути пости з пошуку роботи-0, \nщоб переглянути пости з пропозицією роботи-1");
                int typeCoose = scannerInt.nextInt();
                showByType(posts, typeCoose);
                break;
            }
            case 4:{
                System.out.println("Введіть заголовок оголошення");
                String title = scannerString.nextLine();
                System.out.println("Введіть опис оголошення");
                String describe = scannerString.nextLine();
                deletePost(posts, title, describe);
                break;
            }
            case 5:{
                System.out.println("пости з пошуку роботи-0, \nпости з пропозицією роботи-1");
                int typeCoose = scannerInt.nextInt();
                System.out.println("Введіть місто оголошення");
                String city = scannerString.nextLine();
                showByTypeAndByCity(posts, city, typeCoose);
                break;
            }
        }
        System.out.println("continue? \n1-yes, \n2-no");
        int continueChoose = scannerInt.nextInt();
        if (continueChoose==1){
            menu(posts, authors);
        }
    }



    public static void showByTypeAndByCity(Set<Post> posts, String city, int typeChoose){
       String type = type(typeChoose);
        for (Post post : posts) {
            if (post.getLocation().getCity().equals(city) && (post.getClass().getName().equals(type))){
                System.out.println(post);
            }
        }
    }

    public static String type(int typeCoose){
        String type = null;
        switch (typeCoose){
            case 0:{
                type = "posts.SearchPost";
                break;
            }
            case 1:{
                type = "posts.PropousePosts";
                break;
            }
        }
        return type;
    }

    public static void deletePost(Set<Post> posts, String title, String descr){
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()){
            Post next = iterator.next();
            if (next.getTitle().equals(title) && (next.getDescribe().equals(descr))){
                iterator.remove();
            }
        }
    }

    public static void showByType(Set<Post> posts, int typeChoose){
        String type =  type(typeChoose);
        for (Post post : posts) {
            if (post.getClass().getName().equals(type)){
                System.out.println(post);
            }
        }
    }

    public static void showAllPosts(Set<Post> posts){
        for (Post post : posts) {
            System.out.println(post);
        }

    }

    public static Set<Post> createPost(Set<Post> posts, Set<Author> authors, String title, String describe,
                                       String country, String city, int nomb, String name, int typeOfPost){

        Author author = new Author(nomb, name);
        if (authors.size() != 0){
        for (Author author1 : authors) {
            if (author1.hashCode()==author.hashCode()){
                author = author1;
            }
        }
        }else {
            authors.add(author);
        }




        switch (typeOfPost){
            case 0:{
                SearchPost searchPost = new SearchPost(title, describe, country, city, author);
                posts.add(searchPost);
                break;
            }
            case 1:{
                PropousePosts propousePosts = new PropousePosts(title, describe, country, city, author);
                posts.add(propousePosts);
                break;
            }
        }

        return posts;
    }
}
