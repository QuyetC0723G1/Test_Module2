package validate;

import java.util.Scanner;

public class ValidateProduct {
    public static Scanner input = new Scanner(System.in);
    public static int inputChoice(){
        String choiceRegex = "[0-9]";
        String choice;
        do{
            System.out.println("Enter Your Choice : ");
            choice = input.nextLine();
            if (choice.matches(choiceRegex)){
                break;
            }else {
                System.out.println("Please Enter number 0 - 9 only !!");
            }
        }while (true);
        return Integer.parseInt(choice);
    }
    public static int inputId(){
        String regex = "^[1-9]\\d{2,}$";
        String id;
        do {
            System.out.println("Enter Product Id  : ");
            id = input.nextLine();
            if(id.matches(regex)) {
                break;
            }else {
                System.out.println("!! Error....The id needs to be 3 or more digits ");
            }
        } while (true);
        return Integer.parseInt(id);

    }
    public static String inputName(){
        String regex = "^[a-zA-Z0-9]{6,8}$";
        String name;
        do {
            System.out.println("Enter Product Name : ");
            name = input.nextLine();
            if (name.matches(regex)){
                break;
            }else {
                System.out.println("!! Error....The name needs 6 to 8 character ");
            }
        }while (true);
        return name;
    }
    public static int inputQuantity(){
        String regex = "^(0*[1-9][0-9]?|100)$";
        String quantity;
        do {
            System.out.println("Enter quantity of Product : ");
            quantity = input.nextLine();
            if (quantity.matches(regex)){
                break;
            }else {
                System.out.println("!! Error... Quantity needs > 0 and < 100 ");
            }
        }while (true);
        return Integer.parseInt(quantity);
    }
    public static int inputPrice(){
        String regex = "^(0*[1-9][0-9]{0,2}|1000)$";
        String price;
        do {
            System.out.println("Enter Product Price : ");
            price = input.nextLine();
            if (price.matches(regex)){
                break;
            }else {
                System.out.println("!! Error... Price needs > 0 and < 1000 ");
            }
        }while (true);
        return Integer.parseInt(price);
    }
    public static String inputType(){
        System.out.println("Enter Product type : ");
        return input.nextLine();
    }
    public static int inputIdToEdit(){
        String regex = "^[1-9]\\d{2,}$";
        String id;
        do {
            System.out.println("Enter Product Id To Find : ");
            id = input.nextLine();
            if(id.matches(regex)) {
                break;
            }else {
                System.out.println("!! Error....The id needs to be 3 or more digits ");
            }
        } while (true);
        return Integer.parseInt(id);

    }
    public static String inputTypeToShow(){
        System.out.println("Enter Product type you want Find : ");
        return input.nextLine();
    }
    public static String inputNameToFind(){
        String regex = "^[a-zA-Z0-9]{3,8}$";
        String name;
        do {
            System.out.println("Enter Product Name you Want to Find : ");
            name = input.nextLine();
            if (name.matches(regex)){
                break;
            }else {
                System.out.println("!! Error....The name needs 3 to 8 character ");
            }
        }while (true);
        return name;
    }


}
