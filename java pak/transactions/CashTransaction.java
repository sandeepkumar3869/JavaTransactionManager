package transactions;

import java.io.FileWriter;
import java.io.IOException;


public class CashTransaction {
    private float totalPrice;
    private String itemList;
    
    public CashTransaction(float totalPrice, String itemList) {
        this.totalPrice = totalPrice;
        this.itemList = itemList;
    }
    
    public void processTransaction(float cashReceived) {
        try {
            FileWriter cashDetails = new FileWriter("cash.txt", true);
            cashDetails.write("Total Items in Cart:\n" + itemList + "\n");
            cashDetails.write("Total Bill Amount: " + totalPrice + "\n");
            cashDetails.write("Cash Received from Customer: " + cashReceived + "\n");
            
            float amountToReturn = cashReceived - totalPrice;
            if (amountToReturn >= 0) {
                cashDetails.write("Cash Returned to Customer: " + amountToReturn + "\n");
                cashDetails.write("Payment of " + totalPrice + " done successfully by cash.\n");
            } else {
                cashDetails.write("Insufficient cash received. Additional amount needed: " + (-amountToReturn) + "\n");
            }
            
            cashDetails.write("------------------------------------------------------\n");
            cashDetails.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing cash transaction details.");
            e.printStackTrace();
        }
    }
    
   
}
