package view;

import model.Product;
import model.ProductManager;
import validate.ValidateProduct;

import java.util.List;

public class Menu {
    static ProductManager productManager = new ProductManager();
    public void showMenu(){
        do {
            System.out.println("\t\t**** WELL COME ****");
            System.out.println("=====>>> Quiet Mart Menu <<<======");
            System.out.println("\t\t1. Add new Product \n\t\t2. Edit Product \n\t\t3. Find - Show Product \n\t\t4. Remove Product \n\t\t0. Exit");
            int choice = ValidateProduct.inputChoice();
            switch (choice){
                case 0: return;
                case 1:
                    addProductInMenu();
                    break;
                case 2:
                    editProductInMenu();
                    break;
                case 3:
                    showProductInMenu();
                    break;
                case 4:removeProductInMenu();
                    break;
            }
        }while (true);
    }
    public static Product getInfo(){
        System.out.println("Enter Product Infomation !!");
        int id;
        do {
            id = ValidateProduct.inputId();
            if (productManager.findById(id) != null){
                System.out.println("The Id already exists, please re-Enter !!!");
            }
        }while (productManager.findById(id) != null);
        String name = ValidateProduct.inputName();
        int quantity = ValidateProduct.inputQuantity();
        int price = ValidateProduct.inputPrice();
        String type = ValidateProduct.inputType();
        return new Product(id,name,quantity,price,type);
    }
    public  void addProductInMenu(){
        Product product = getInfo();
        productManager.add(product);
        System.out.println("*** Successfully Added the new Product ***");

    }
    public void removeProductInMenu() {
        int id = ValidateProduct.inputIdToEdit();
        int index = productManager.findByIdToGetIndex(id);
        if (index != -1){
            productManager.remove(index);
            System.out.println("****** Successfully deleted the product *******");
        }else {
            System.out.println("!!!!!!! The id not found ... try again");
        }
    }
    public void editProductInMenu(){
        int id = ValidateProduct.inputIdToEdit();
        int index = productManager.findByIdToGetIndex(id);
        if (id != -1){
            Product product1 = getInfo();
            productManager.edit(index,product1);
            System.out.println("****** Successfully Updated the product *******");
        }else {
            System.out.println("!!!!!!! The id not found ... try again");
        }
    }
    public void showAllProductToMenu(){
        List<Product> products = productManager.findAll();
        for (Product product: products) {
            System.out.println(product);
        }
    }
    public void findById(){
        int id = ValidateProduct.inputIdToEdit();
        Product product = productManager.findById(id);
        if (product != null){
            System.out.println("Search Result : ");
            System.out.println(product);
        }else {
            System.out.println("!!!!!!! The id not found ... try again");
        }
    }
    public void showProductInMenu(){
        do {
            System.out.println("======>>>> Menu Show Product <<<<=====");
            System.out.println("\t\t1. Show All Product \n\t\t2. Find Product by Id \n\t\t3. Find Product By name \n\t\t4. Find Product by Type\n\t\t0. Return");
            int choice1 = ValidateProduct.inputChoice();
            switch (choice1){
                case 0:
                    return;
                case 1:showAllProductToMenu();
                    break;
                case 2:findById();
                    break;
                case 3:showProductByName();
                    break;
                case 4:showProductByType();
                    break;
            }
        }while (true);
    }
    public void showProductByName(){
        String name = ValidateProduct.inputNameToFind();
        List<Product> products = productManager.findByName(name);
        if (products != null){
            System.out.println("*** Search result is : ");
            for (Product product : products) {
                System.out.println(product);
            }
        }else {
            System.out.println("!!!! Error ... The name not found.... try again..");
        }
    }
    public void showProductByType(){
        String type = ValidateProduct.inputTypeToShow();
        List<Product> products = productManager.findByType(type);
        if (!products.isEmpty()){
            System.out.println("*** Search result is : ");
            for (Product product : products) {
                System.out.println(product);
            }
        }else {
            System.out.println("!!!! Error ... The type not found.... try again..");
        }
    }

}