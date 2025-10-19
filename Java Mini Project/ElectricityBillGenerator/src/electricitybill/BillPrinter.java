package electricitybill;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BillPrinter {

    public static void printBill(Customer customer, double totalBill) {
        System.out.println("=====================================");
        System.out.println("         ELECTRICITY BILL            ");
        System.out.println("=====================================");
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Name       : " + customer.getName());
        System.out.println("Address    : " + customer.getAddress());
        System.out.println("Units      : " + customer.getUnitsConsumed());
        System.out.printf("Total Bill : ₹%.2f\n", totalBill);
        System.out.println("=====================================");
    }

    public static void saveBillToFile(Customer customer, double totalBill) {
        String fileName = "bills/Bill_" + customer.getCustomerId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=====================================\n");
            writer.write("         ELECTRICITY BILL            \n");
            writer.write("=====================================\n");
            writer.write("Customer ID: " + customer.getCustomerId() + "\n");
            writer.write("Name       : " + customer.getName() + "\n");
            writer.write("Address    : " + customer.getAddress() + "\n");
            writer.write("Units      : " + customer.getUnitsConsumed() + "\n");
            writer.write(String.format("Total Bill : ₹%.2f\n", totalBill));
            writer.write("=====================================\n");
            System.out.println("Bill saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving bill to file.");
        }
    }
}
