/*Jasvant Singh Dosanjh
you will be creating an application to test your new class to be certain 
all of its methods are doing what you expect*/
import java.util.Scanner;
import javax.swing.JOptionPane;
public class UsesBookID 
{
   public static void main(String[] args) 
   {
         int bookID;
         int numberInStock;
         double price;
         Scanner keyboard = new Scanner(System.in);
       BOOKItem BOOK1, BOOK2, BOOK3, BOOK4;
       BOOK1 = new BOOKItem(bookID, numberInStock, price, code);
       BOOK2 = new BOOKItem(bookID, numberInStock, price, code);
       BOOK3 = new BOOKItem(bookID, numberInStock, price, code);
       BOOK4 = new BOOKItem(bookID, numberInStock, price, code);
         System.out.println("Enter in a blank separated list: ID, number in stock, quality, price" + 
                       "- use a BAD ID(<11 or >111111)");
          bookID = keyboard.nextInt();
          numberInStock = keyboard.nextInt();
          code = keyboard.nextInt();
          price = keyboard.nextDouble();
       BOOK1.setID(bookID);
       BOOK1.setStock(numberInStock);
       BOOK1.setPrice(price);
       BOOK1.display();
         System.out.println("Enter in a blank separated list: ID, number in stock, quality, price" + 
                       "- use a BAD STOCK(>5000)");
         bookID = keyboard.nextInt();
         numberInStock = keyboard.nextInt();
         price = keyboard.nextDouble();
       BOOK2.setID(bookID);
       BOOK2.setStock(numberInStock);
       BOOK2.setPrice(price);
       BOOK2.display();
         System.out.println("Enter in a blank separated list: ID, number in stock, quality, price" + 
                       "- use a BAD PRICE(>150.0)");
         bookID = keyboard.nextInt();
         numberInStock = keyboard.nextInt();
         price = keyboard.nextDouble();
       BOOK3.setID(bookID);
       BOOK3.setStock(numberInStock);
       BOOK3.setPrice(price);
       BOOK3.display();
         System.out.println("Enter in a blank separated list: ID, number in stock, quality, price" + 
                       "- use ALL GOOD DATA");
         bookID = keyboard.nextInt();
         numberInStock = keyboard.nextInt();
         price = keyboard.nextDouble();
       BOOK4.setID(bookID);
       BOOK4.setStock(numberInStock);
       BOOK4.setPrice(price);
       BOOK4.setCode(code);
       BOOK4.display();
         JOptionPane.showMessageDialog(null, display);
    }
}