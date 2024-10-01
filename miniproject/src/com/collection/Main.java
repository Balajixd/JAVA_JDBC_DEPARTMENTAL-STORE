package com.collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        product inventory = new product();
        user currentUser = new user();
        productDetails p1 = new productDetails();
        int choice;

        while (true) {
            boolean loggedIn = false;
            boolean isAdmin = false;

            while (!loggedIn) {
                System.out.println("WELCOME TO THE PRODUCT SHOP MANAGER");
                System.out.println("ENTER THE LOGIN DETAILS:");
                System.out.println("ENTER THE USERNAME:");
                currentUser.setName(scanner.nextLine());
                System.out.println("ENTER THE PASSWORD:");
                currentUser.setPass(scanner.nextLine());

                if (currentUser.getName().equals("admin") && currentUser.getPass().equals("admin")) {
                    loggedIn = true;
                    isAdmin = true;
                    System.out.println("SUCCESSFULLY LOGGED IN AS ADMIN.");
                } else if (currentUser.getName().equals("user") && currentUser.getPass().equals("user")) {
                    loggedIn = true;
                    System.out.println("SUCCESSFULLY LOGGED IN AS USER.");
                } else {
                    System.out.println("Invalid login. Please try again.");
                }
            }

            if (isAdmin) {
                do {
                    System.out.println("ADMIN OPTIONS:");
                    System.out.println("1. Add product");
                    System.out.println("2. Remove product");
                    System.out.println("3. Update product");
                    System.out.println("4. Search product");
                    System.out.println("5. Show All product");
                    System.out.println("6. Exit");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                        	  
                              //System.out.println("Enter product ID:");
                           //   int id = scanner.nextInt();
                              System.out.println("Enterproduct Name:");
                              String name = scanner.next()+scanner.nextLine();
                              System.out.println("Enter product Price:");
                              double price = scanner.nextDouble();
                              scanner.nextLine();
                              productDetails shop = new productDetails(name,price);
                              product p=new product();
                              p.add(shop);
                            
                            break;
                        case 2:
                            System.out.println("Enter the ID of the product to remove:");
                            int removeId = scanner.nextInt();
                            inventory.remove(removeId);
                            break;
                        case 3:                        	
                            System.out.println("Enter the ID of the product to update:");
                            int updateId = scanner.nextInt();
                            p1.setName(scanner.next());
                            p1.setPrice(scanner.nextInt());
                            p1.setId(updateId);
                            inventory.update(p1);
                            break;
                        case 4:
                            System.out.println("Enter the ID of the product to search:");
                            String searchId = scanner.nextLine();
                            //inventory.search(searchId);
                            break;
                        case 5:
                            inventory.show();
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (choice != 6);

            } else {
                do {
                    System.out.println("USER OPTIONS:");
                    System.out.println("1. Show All product");
                    System.out.println("2. Search product");
                    System.out.println("3. Exit");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            inventory.show();
                            break;
                        case 2:
                            System.out.println("Enter the ID of the product to search:");
                            String searchId = scanner.nextLine();
                            //inventory.search(searchId);
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (choice != 3);
            }
        }
    }
}