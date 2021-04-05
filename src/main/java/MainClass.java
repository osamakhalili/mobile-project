import com.google.common.base.CharMatcher;

import java.util.Scanner;

public class MainClass {
    public  static  MobileManagement mobileManagement = new MobileManagement();
    public static void main(String[] args) {
      String greetingText = "Grupp 11 osama and mohammad ";
        System.out.println(greetingText);
        CharMatcher matcher = CharMatcher.isNot('n');
        String result = matcher.retainFrom(greetingText);
        System.out.println(result);

        while (true){
            printMainMenu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            selectChoice(choice);
        }
    }

    public  static void selectChoice(int choice){
        switch (choice) {
            case 1:
                System.out.println("Current mobiles:");
               mobileManagement.fetchAll().forEach(c->System.out.println(c));
                break;
            case 2:
                insertForm();
                break;
            case 3:
                updateForm();
                break;
            case 4:
                deleteForm();
                break;
            case 0:
                System.exit(0);
            default:
               System.out.println("Invalid choice!");
        }
    }
    public static void printMainMenu(){
        System.out.println("------------------- Main menu -------------------------");
        System.out.println("Enter your choice number:");
        System.out.println("1. display current mobiles in store");
        System.out.println("2. Add a new mobile");
        System.out.println("3. update Existed mobile");
        System.out.println("4. delete mobile by id");
        System.out.println("0. exit");
        System.out.println("-------------------------------------------------------");
    }
    public static  void insertForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new mobile:");

        System.out.println("mobileName:");
        String mobileName = sc.nextLine();

        System.out.println("mobileModel:");
        String mobileModel = sc.nextLine();

        System.out.println("mobileYear:");
        double mobileYear = sc.nextDouble();


        System.out.println("memory:");
        double memory = sc.nextDouble();

        System.out.println("price:");
        double price = sc.nextDouble();
        mobileManagement.insert(new Mobile(mobileName,mobileModel,mobileYear,memory,price));
    }

    public static  void updateForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mobile id:");
        int id = sc.nextInt();
        Mobile foundMobile = new Mobile();
         for (Mobile mb : mobileManagement.fetchAll()){
             if(mb.getId()==id){
                 foundMobile = mb;
                 break;
             }
         }
         if(foundMobile==null){
             System.out.println("Mobile not found");
         }else{

        System.out.println("mobileName:");
        String mobileName = sc.nextLine();

        System.out.println("mobileModel:");
        String mobileModel = sc.nextLine();

        System.out.println("mobileYear:");
        double mobileYear = sc.nextDouble();


        System.out.println("memory:");
        double memory = sc.nextDouble();

        System.out.println("price:");
        double price = sc.nextDouble();
        foundMobile.setMobileName(mobileName);
        foundMobile.setMobileModel(mobileModel);
        foundMobile.setMobileYear(mobileYear);
        foundMobile.setPrice(price);
        foundMobile.setMemory(memory);
         }
    }

    public static void deleteForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mobile id:");
        int id = sc.nextInt();
        Mobile foundMobile = new Mobile();
        for (Mobile mb : mobileManagement.fetchAll()){
            if(mb.getId()==id){
                foundMobile = mb;
                break;
            }
        }
        if(foundMobile==null){
            System.out.println("Mobile not found");
        }else{
            mobileManagement.fetchAll().removeIf(c->c.getId()==id);
            System.out.println("Removed successfully");
        }
    }

    }

