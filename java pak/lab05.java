import java.util.Scanner;
import transactions.CashTransaction;
import transactions.CardTransaction;

import java.util.Random;

import java.util.Date;
import java.text.SimpleDateFormat;

public class lab05 {
   

    static String[][] supermarketItems = new String[20][2];
    static String[][] COLM = new String[2][2];

    static String item = " ";
    static float price = 0.00f;

    public static void main(String[] args) {
        int count = 0;

        Scanner scan = new Scanner(System.in);

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String encode_card_no = ")(*&^%$#@!";
        int p = 0;

        while (p == 0) {
            System.out.println();
            String[][] COLM = { { "Items's name ", "Price" } };

            String[][] supermarketItems = {

                    { "Sugar (1kg)", "50.75" },
                    { "Cooking Oil (1L)", "100.45" },
                    { "Laundry Detergent (1kg)", "80.45" },
                    { "Rice (5kg)", "200.34" },
                    { "All-Purpose Flour (2kg)", "60.78" },
                    { "Salt (1kg)", "20.33" },
                    { "Bathing Soap (4 bars)", "40.7" },
                    { "Milk (1L)", "30.3" },
                    { "Eggs (1 dozen)", "45.90" },
                    { "Bread Loaf", "25.23" },
                    { "Biscuits (500g)", "35.87" },
                    { "Potato Chips (200g)", "50.23" },
                    { "Shampoo (200ml)", "70.09" },
                    { "Toothpaste (150g)", "40.90" },
                    { "Instant Coffee (100g)", "90.34" },
                    { "Tea Leaves (250g)", "55.34" }
            };
            System.out.println();

            // for (int i = 0; i < 2; i++) {
            System.out.print(COLM[0][0] + "    " + COLM[0][1]);

            System.out.println();
            System.out.println();
            // }

            for (int i = 0; i < supermarketItems.length; i++) {
                System.out.print((i + 1) + "." + supermarketItems[i][0] + "  RS" + supermarketItems[i][1]);

                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.print("enter the no.  to add in cart : ");
            int serial = scan.nextInt();
            serial = serial - 1;
            System.out.print("how much quantity : ");
            int qunty = scan.nextInt();

            int total_sales = count + (1 * qunty);

            // Float pp = Float.parseFloat(supermarketItems[1][serial]);
            float pp = Float.parseFloat(supermarketItems[serial][1]);

            // System.out.println("ok");
            price = price + (pp * qunty);
            item = item + "\n" + supermarketItems[serial][0] + " X " + qunty + "            -  Rs " + (pp * qunty)
                    + "\n";

            System.out.print("do  you want to add more  items (y/n) : ");
            String item_choice = scan.next().toLowerCase();
            if (item_choice.equals("n")) {
                break;
            }

        }
        System.out.println();
        System.out.println("total item in cart \n" + item);
        System.out.println("total  bill amount : " + price);

        System.out.println();

        while (true) {
            System.out.println("1. Card");
            System.out.println("2. Cash");
            System.out.println();
            System.out.print("Please select the mode of transaction: ");

            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("Enter Card Owner's Name: ");
                String cardOwnerName = scan.next();

                System.out.print("Enter Card Number: ");
                String cardNumber = scan.next();

                // Instantiate CardTransaction object
                CardTransaction cardTransaction = new CardTransaction(price, item);

                // Process card transaction
                cardTransaction.processTransaction(cardOwnerName, cardNumber);

                break;
            } else if (choice == 2) {
                System.out.print("Enter the amount of cash collected: ");
                float cashReceived = scan.nextFloat();

                // Instantiate CashTransaction object
                CashTransaction cashTransaction = new CashTransaction(price, item);

                // Process cash transaction
                cashTransaction.processTransaction(cashReceived);

                break;
            } else {
                System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
