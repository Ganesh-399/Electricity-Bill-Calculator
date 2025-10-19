package electricitybill;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectricityBillMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Double> bills = new ArrayList<>();
        int choice = 0;

        do {
            System.out.println("=====================================");
            System.out.println("   ELECTRICITY BILL GENERATOR MENU    ");
            System.out.println("=====================================");
            System.out.println("1. Add Customer and Generate Bill");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter 1-3.");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    // Input Customer Details
                    int id = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("Enter Customer ID: ");
                            id = Integer.parseInt(sc.nextLine());
                            if (id <= 0) {
                                System.out.println("Customer ID must be positive.");
                            } else {
                                validInput = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Enter numeric value.");
                        }
                    }

                    String name = "";
                    while (name.isEmpty()) {
                        System.out.print("Enter Customer Name: ");
                        name = sc.nextLine();
                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                        }
                    }

                    System.out.print("Enter Customer Address: ");
                    String address = sc.nextLine();

                    double units = -1;
                    validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("Enter Units Consumed: ");
                            units = Double.parseDouble(sc.nextLine());
                            if (units < 0) {
                                System.out.println("Units cannot be negative.");
                            } else {
                                validInput = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Enter numeric value for units.");
                        }
                    }

                    Customer customer = new Customer(id, name, address, units);
                    customers.add(customer);

                    double totalBill = BillCalculator.calculateBill(units);
                    bills.add(totalBill);

                    BillPrinter.printBill(customer, totalBill);
                    BillPrinter.saveBillToFile(customer, totalBill);
                    break;

                case 2:
                    // Summary Report
                    if (customers.isEmpty()) {
                        System.out.println("No customer data available.");
                    } else {
                        System.out.println("\n=====================================");
                        System.out.println("         SUMMARY REPORT              ");
                        System.out.println("=====================================");
                        System.out.printf("%-10s %-15s %-15s %-10s\n", "Cust ID", "Name", "Units Consumed", "Bill Amount");

                        double totalUnits = 0;
                        double totalAmount = 0;

                        for (int i = 0; i < customers.size(); i++) {
                            Customer c = customers.get(i);
                            double bill = bills.get(i);
                            System.out.printf("%-10d %-15s %-15.2f ₹%-10.2f\n", c.getCustomerId(), c.getName(), c.getUnitsConsumed(), bill);
                            totalUnits += c.getUnitsConsumed();
                            totalAmount += bill;
                        }

                        System.out.println("-------------------------------------");
                        System.out.printf("TOTAL         %-15s %-15.2f ₹%-10.2f\n", "", totalUnits, totalAmount);
                        System.out.println("=====================================");
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    if (choice != 0) {
                        System.out.println("Invalid choice. Please try again.");
                    }
            }

        } while (choice != 3);

        sc.close();
    }
}
