package com.collection;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.collection.productDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class product {
	Statement stmt;
	ResultSet rs;
	String qry=null;
	int count;
	DButil db=new DButil();
    private List<productDetails>products;
    Connection con;
    public Connection getDBConnection() {

    	Connection con=null;

    	try {

    	Class.forName("com.mysql.cj.jdbc.Driver");

    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","");

    	}catch(Exception e) {

    	System.out.println(e);

    	}

    	return con;

    	}

    public product() {
           products = new ArrayList<>();
    }

    public product(Object id, Object name, int price) {
		// TODO Auto-generated constructor stub
	}

	public void add(productDetails p) {
      
        try {
        	con=getDBConnection();
        	stmt=con.createStatement();
			qry="insert into products(name,price)values('"+p.getName()+"','"+p.getPrice()+"')";
        	count=stmt.executeUpdate(qry);
        	if(count==1)
        		System.out.println("Inserted");
        	else
        		throw new Exception();
        }
        catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
//       
//        System.out.println("product added successfully.");
    }

    public void remove(int removeId) {
//        boolean found = false;
//        for (productDetails shop : products) {
//            if (shop.getId().equals(removeId)) {
//            	products.remove(shop);
//                System.out.println("product removed successfully.");
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("product with ID " + removeId + " not found.");
//        }
    	try {
        	con=getDBConnection();
        	stmt=con.createStatement();
			qry="delete from products where id="+removeId+"";
        	count=stmt.executeUpdate(qry);
        	if(count==1)
        		System.out.println("Deleted");
        	else
        		throw new Exception();
        }
        catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
    }

    public void update(productDetails p) {
//        try (Scanner scanner = new Scanner(System.in)) {
//			for (productDetails shop : products) {
//			    if (shop.getId().equals(id)) {
//			        System.out.println("Enter new name:");
//			        shop.setName(scanner.nextLine());
//			        System.out.println("Enter new price:");
//			        double price = scanner.nextDouble();
//			        scanner.nextLine(); 
//			        shop.setPrice(price);
//			        System.out.println("product updated successfully.");
//			        return;
//			    }
//			}
//		}
    	try {

    		con=getDBConnection();
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		int count = stmt.executeUpdate("UPDATE products SET name='" + p.getName() + "', price=" + p.getPrice() + " WHERE id=" + p.getId());
    		System.out.println("UPDATED SUCCESSFULLY");
    		}
    		catch(Exception ex)
    		{
    		System.out.println(ex.getMessage());
    		}
    		}
    	

    	
//        System.out.println("product with ID " + p.getId + " not found.");
    

//    public void search(String id) {
//        for (productDetails shop : products) {
//            if (shop.getId().equals(id)) {
//                System.out.println("product ID: " + shop.getId());
//                System.out.println("product Name: " + shop.getName());
//                System.out.println("product Price: $" + shop.getPrice());
//                return;
//            }
//        }
//        System.out.println("product with ID " + id + " not found.");
//    }

    public void show() {
//        if (products.isEmpty()) {
//            System.out.println("No product available.");
//        } else {
//            for (productDetails shop : products) {
//                System.out.println("ID: " + shop.getId() + ", Name: " + shop.getName() + ", Price: $" + shop.getPrice());
//            }
//        }
    	 try {
    	      con = getDBConnection();
    	      stmt=con.createStatement();
    	      rs=stmt.executeQuery("select * from products");
    	      while(rs.next())
    	      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
    	      }
    	      catch(Exception e) {
    	      System.out.println(e.getMessage());
    	      }
    }
}




