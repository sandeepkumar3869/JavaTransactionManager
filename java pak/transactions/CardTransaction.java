package transactions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class CardTransaction {
    private float totalPrice;
    private String itemList;
    private static final String ENCODE_CARD_NO = ")(*&^%$#@!";

    public CardTransaction(float totalPrice, String itemList) {
        this.totalPrice = totalPrice;
        this.itemList = itemList;
    }

    public void processTransaction(String cardOwnerName, String cardNumber) {
        try {
            FileWriter cardDetails = new FileWriter("card.txt", true);
            cardDetails.write("Total Items in Cart:\n" + itemList + "\n");
            cardDetails.write("Total Bill Amount: " + totalPrice + "\n");
            cardDetails.write("Transaction Date: " + printCurrentDate() + "\n");
            cardDetails.write("Transaction No.: " + printTransactionNumber() + "\n");
            cardDetails.write("Card Owner's Name: " + cardOwnerName + "\n");
            cardDetails.write("Card No.: " + encryptCardNumber(cardNumber) + "\n");
            cardDetails.write("Payment done successfully of amount " + totalPrice + "\n");
            cardDetails.write("------------------------------------------------------\n");
            cardDetails.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing card transaction details.");
            e.printStackTrace();
        }
    }

    private String printCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    private String printTransactionNumber() {
        Random random = new Random();
        StringBuilder transactionNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            transactionNumber.append(digit);
        }
        return transactionNumber.toString();
    }

    private String encryptCardNumber(String cardNumber) {
        StringBuilder encryptedCardNumber = new StringBuilder();
        for (int i = 0; i < cardNumber.length(); i++) {
            char currentChar = cardNumber.charAt(i);
            int index = "1234567890".indexOf(currentChar);
            if (index != -1) {
                encryptedCardNumber.append(ENCODE_CARD_NO.charAt(index));
            } else {
                encryptedCardNumber.append(currentChar);
            }
        }
        return encryptedCardNumber.toString();
    }
}

