//Jasvant Singh Dosanjh
//you will be creating a database of BOOKs that are in the inventory of the BestBargainBook Store
//Dont mind my comments thru out my code, i implemented them so I wouldnt get lost trying to find stuff :)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
public class Project9 extends JFrame
{
  Font f1 = new Font("Serif", Font.BOLD, 30);
  Font f2 = new Font("Serif", Font.PLAIN, 18);
  private BookItem[] bookArray = new BookItem[10];
  private JLabel headerLbl;
  private JLabel messagesLbl;
  private JTextField idLabelFld;
  private JTextField idFld;
  private JTextField priceLabelFld;
  private JTextField priceFld;
  private JTextField numInStockLabelFld;
  private JTextField numInStockFld;
  private JTextField codeLabelFld;
  private JTextField codeFld;
  private JTextField messagesFld;
  private JButton insertBtn;
  private JButton deleteBtn;
  private JButton displayBtn;
  private JButton displayOneBtn;
  private JButton hideBtn;
  private JButton clearBtn;
  private String input = "";
  private String displayOneStr = "";
  private int idInput = 0;
  private double priceInput = 0.0;
  private int numInStockInput = 0;
  private int codeInput = 0;
  private int index = 0;
  private int numItems = 0;
  private int responseCode = 0;
  private Container c = getContentPane();
  //Main Method, sets arrayFrame params
  public static void main(String[] args)
  {
        Project9 arrayFrame = new Project9();
        arrayFrame.setSize(555,450);
        arrayFrame.setVisible(true);
        arrayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }     
  //Constructor
  public Project9()
  {
        //Creates the array 
        for (int i = 0; i < bookArray.length; i++)
        {
              bookArray[i] = new BookItem();
              System.out.println(bookArray[i]);
        } 
        setTitle("Project 9");
        c.setLayout(new FlowLayout());
        headerLbl = new JLabel("Data Entry: BestBargainBook Store");
        headerLbl.setFont(f1);
        c.add(headerLbl);
        idLabelFld = new JTextField("Enter ID:", 15);
        idLabelFld.setEditable(false);
        c.add(idLabelFld);
        idFld = new JTextField(25);
        c.add(idFld);
        priceLabelFld = new JTextField("Enter Price:", 15);
        priceLabelFld.setEditable(false);
        c.add(priceLabelFld);
        priceFld = new JTextField(25);
        c.add(priceFld);
        numInStockLabelFld = new JTextField("Enter Number In Stock:", 15);
        numInStockLabelFld.setEditable(false);
        c.add(numInStockLabelFld);
        numInStockFld = new JTextField(25);
        c.add(numInStockFld);
        codeLabelFld = new JTextField("Enter Code: 1,2,3 or 4:", 15);
        codeLabelFld.setEditable(false);
        c.add(codeLabelFld);
        codeFld = new JTextField(25);
        c.add(codeFld);
        insertBtn = new JButton("Insert");
        c.add(insertBtn);
        deleteBtn = new JButton("Delete");
        c.add(deleteBtn);
        displayBtn = new JButton("Display");
        c.add(displayBtn);
        displayOneBtn = new JButton("DisplayOne");
        c.add(displayOneBtn);
        hideBtn = new JButton("Hide");
        c.add(hideBtn);
        clearBtn = new JButton("Clear");
        c.add(clearBtn);
        messagesLbl = new JLabel("Messages:");
        messagesLbl.setFont(f2);
        c.add(messagesLbl);
        messagesFld = new JTextField(30);
        c.add(messagesFld);
        //Event Listeners
        insertBtn.addActionListener(new EventHandler());
        deleteBtn.addActionListener(new EventHandler());
        displayBtn.addActionListener(new EventHandler());
        displayOneBtn.addActionListener(new EventHandler());
        hideBtn.addActionListener(new EventHandler());
        clearBtn.addActionListener(new EventHandler());
  }//end constructor      
private class EventHandler implements ActionListener
{
  public void actionPerformed(ActionEvent ev)
  {
        if (ev.getSource() == insertBtn)
        {
              input = idFld.getText();
              idInput = Integer.parseInt(input);
              input = priceFld.getText();
              priceInput = Double.parseDouble(input);
              input = numInStockFld.getText();
              numInStockInput = Integer.parseInt(input);
              input = codeFld.getText();
              codeInput = Integer.parseInt(input);
              insert(idInput, priceInput, numInStockInput, 
                     codeInput); 
              if (responseCode == 0)
              {
                    messagesFld.setText("Array is full. Cannot insert book ID: " + 
                                        idInput);
              }
              else if (responseCode == 1)
              {
                    messagesFld.setText("Succesful insertion of " + idInput);
              }
              else if (responseCode == -1)
              {
                    messagesFld.setText("Duplicate ID: " + idInput);
              }                          
        }
        else if (ev.getSource() == deleteBtn)
        {
              input = idFld.getText();
              idInput = Integer.parseInt(input);
              delete(idInput);
              if (responseCode == 1)
              {      
                    messagesFld.setText("Successful delete of book ID: " +
                                        idInput);
              }
              else if (responseCode == -1)
              {
                    messagesFld.setText("ID: " + idInput + " not found.");
              }                                
        }
        else if (ev.getSource() == displayBtn)
        {
              for (index = 0; index < bookArray.length; index++)
              {
                    bookArray[index].display();
              }      
        } 
        else if (ev.getSource() == displayOneBtn)
        {
              input = idFld.getText();
              idInput = Integer.parseInt(input);
              for (index = 0; index < bookArray.length; index++)
              {
                    if (bookArray[index].getID() == idInput)
                    {
                          bookArray[index].getID();
                          bookArray[index].getPrice();
                          bookArray[index].getNumberInStock();
                          bookArray[index].getCode();
                          messagesFld.setText("id: " + bookArray[index].getID() +
                                              "  Price: " + bookArray[index].getPrice() +
                                              "  Number In Stock: " + bookArray[index].getNumberInStock() +
                                              "  Code: " + bookArray[index].getCode()); 
                    }
              }      
        }      
        else if (ev.getSource() == hideBtn)
        {
                JButton button = (JButton)ev.getSource();
                Window window = SwingUtilities.windowForComponent( button );
                JFrame frame = (JFrame)window;
                frame.setState(JFrame.ICONIFIED);   
        }
        else if (ev.getSource() == clearBtn)
        {
              idFld.setText("");
              priceFld.setText("");
              numInStockFld.setText("");
              codeFld.setText("");
              messagesFld.setText("");
              repaint();
        }
  }//End actionPerformed
}//End handler
  //insert method, called when insert button is pressed
  public int insert(int bookID, double price, int numInStock, int code)
  {
        if (numItems == 10)
        {
              System.out.println("\nThe Array is full, please delete an entry");

              responseCode = 0;
              return responseCode;
        }      
        for (index = 0; index < bookArray.length; index++)
        {
              if (bookArray[index].getID() == bookID)
              {
                    System.out.println("\nThat ID already exists");

                    responseCode = -1;
                    return responseCode;
              }
              else if (bookArray[index].getID() == 0)
              {
                    bookArray[index] = new BookItem(bookID, priceInput, numInStock, code);
                    numItems++; 
                    System.out.println("\n" + idInput + "\n" + priceInput + "\n" + 
                                       numInStockInput + "\n" + codeInput + "\n" + index);
                    System.out.println("\nID: " + bookArray[index].getID());
                    System.out.println("Price: " + bookArray[index].getPrice());
                    System.out.println("NIS: " + bookArray[index].getNumberInStock());
                    System.out.println("Code: " + bookArray[index].getCode());
                    System.out.println("Items in Array: " + numItems); 
                    responseCode = 1;
                    return responseCode;
              }               
        }
        return responseCode;
  }//end insert method 
  //Delete method, called when delete button is pressed
  public int delete(int id)
  {
        for (index = 0; index < bookArray.length; index++)
        {
              if (bookArray[index].getID() == id)
              {
                    bookArray[index].setID(0);
                    bookArray[index].setPrice(0);
                    bookArray[index].setStock(0);
                    bookArray[index].setCode(0);
                    numItems--;
                    System.out.println("\nSuccessful deletion");
                    responseCode = 1;
                    return responseCode;
              }               
        }
        responseCode = -1;
        return responseCode;
  }//end delete method
}//end app  