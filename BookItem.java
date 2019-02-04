/*Jasvant Singh Dosanjh
you will be creating BOOKItem class that will act as a template to store all 
of the data needed by the BIGGEST BARGAIN BOOKS, Inc to categorize its inventory*/
import java.text.DecimalFormat;
import java.util.Scanner;
public class BookItem
{
     DecimalFormat intFormat = new DecimalFormat("000");
     DecimalFormat doubleFormat = new DecimalFormat("$#,##0.00");
      int bookID;
      int numberInStock;
      double price;
      double totalValueOfStock;
      int code;
   
      
  public BookItem() {
        bookID = 0;
        numberInStock = 0;
        price = 0;
        code = 0;
    }    
  public BookItem(int newID, double newPrice, int newStock, int newCode) 
   {
      setBookID(newID);
      setStock(newStock);
      setPrice(newPrice);
      setCode(newCode);
   }
  public void setBookID(int newID)
   {
      bookID = newID;
   }
  public void setStock (int newStock) 
   {
      if (newStock >= 1 && newStock <=5000) 
      {
        numberInStock = newStock;
      }
      else 
      {
        numberInStock = 0;
      }
   }
   public void setCode (int newCode) {

    if (newCode > 0) {
        code = newCode;
    }
}
  public void setID (int newID)
   {
      if (newID >=11 && newID <= 111111)
      {
        bookID = newID;
      }
      else
      {
        bookID = 0;
      }
   }
  public void setPrice (double newPrice)
   {
      if (newPrice >= 1.0 && newPrice <=150.0)
      {
         price = newPrice;
      }
      else
      {
         price = 0;
      }
   }
  public int getID ()
   {
      return bookID;
   }
  public int getNumberInStock ()
   {
      return numberInStock;
   }
   public int getCode () {
    return code;
}
  public double getPrice () 
   {
      return price;
   }
  public double calcTotalValue()
   { 
     totalValueOfStock = numberInStock * price;
     return totalValueOfStock; 
   }
  public double getTotalValue()
   { 
     return totalValueOfStock;
   }
  public void display()
   {
     System.out.println("Display:");
     System.out.println("Book ID: " + bookID + " NumInStock: " + numberInStock + " Price: " + 
                      price + " TotalStockValue: " + calcTotalValue());
   }
}