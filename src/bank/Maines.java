package bank;

import java.util.Scanner;

public class Maines {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        User myUser = new User("log", "1111", 256);

        checking(myUser, scan);

    }

    static void checking (User user, Scanner scanner){
        System.out.println("Enter the login");
        String currentLog = scanner.nextLine();

        System.out.println("Enter the password");
        String currentPass = scanner.nextLine();

        if ((currentLog.equals(user.getLogin())) && currentPass.equals(user.getPassword())){
            menu(user, scanner);

        }else {
            System.out.println("Ви ввули невірний логін або пароль!");
        }

    }

   static void menu(User user, Scanner scanner){
       System.out.println("Вітаємо в головному меню. \nОберіть дію: \n - для перегляду стану рахунку введіть 1 " +
               "\n - для зняття коштів введіть 2 \n - для внесення коштів введіть 3 \n - для виходу введіть 4 " +
               "\n - для продовження роботи введіть 5");
       int res1  = Integer.parseInt(scanner.nextLine());

       switch (res1){
           case 1: {
               System.out.println(user.getRahunok());
               System.out.println("Якщо бажаєте продовжити введіть 1");
               int decide = Integer.parseInt(scanner.nextLine());
               if (decide == 1){
                   menu(user, scanner);
               }
               break;
           }
           case 2: {
               System.out.println("Введіть суму коштів:");
               int res2 = Integer.parseInt(scanner.nextLine());
               if ((user.getRahunok()-res2) >=0){
                   System.out.println("Операція пройшла успішно.");
                   user.setRahunok(user.getRahunok()-res2);
               }else {
                   System.out.println("На вашому рахунку недостатньо коштів.");
               }
               System.out.println("Якщо бажаєте продовжити введіть 1");
               int decide = Integer.parseInt(scanner.nextLine());
               if (decide == 1){
                   menu(user, scanner);
               }
               break;
           }
           case 3: {
               System.out.println("Введіть суму коштів яку бажаєте внести");
               int enterMony = Integer.parseInt(scanner.nextLine());
               user.setRahunok(user.getRahunok()+enterMony);
               System.out.println("Операція прорйшла успішно.");
               System.out.println("Якщо бажаєте продовжити введіть 1");
               int decide = Integer.parseInt(scanner.nextLine());
               if (decide == 1){
                   menu(user, scanner);
               }
               break;
           }
           case 4: {
               break;
           }
           case 5: {
               System.out.println("Продовжити роботу");
               System.out.println("Якщо бажаєте продовжити введіть 1");
               int decide = Integer.parseInt(scanner.nextLine());
               if (decide == 1){
                   menu(user, scanner);
               }
               break;
           }
           default: {
               checking(user, scanner);
           }


       }

    }
}


