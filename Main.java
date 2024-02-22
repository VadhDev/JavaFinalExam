//* KHIEV VIVADH */

import java.util.Scanner;

interface DiscountRate {
    double getServiceDiscountRate(String type);
    double getProductDiscountRate(String type);
}

class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    // Getter and setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.20; 
            case "Gold":
                return 0.15; 
            case "Silver":
                return 0.10; 
            default:
                return 0.0; 
        }
    }

    public double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10; 
            default:
                return 0.0; 
        }
    }
}

// Sale class
class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date, double serviceExpense, double productExpense) {
        this.customer = customer;
        this.date = date;
        this.serviceExpense = serviceExpense - (serviceExpense * customer.getServiceDiscountRate(customer.getCustomerType()));
        this.productExpense = productExpense - (productExpense * customer.getProductDiscountRate(customer.getCustomerType()));
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input customer details
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter customer type (Premium/Gold/Silver/Normal):");
        String customerType = scanner.nextLine();

        // Create customer object
        Customer customer = new Customer(customerName, customerType);

        // Input sale details
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = scanner.nextLine();

        System.out.println("Enter service expense:");
        double serviceExpense = scanner.nextDouble();

        System.out.println("Enter product expense:");
        double productExpense = scanner.nextDouble();

        // Create sale object
        Sale sale = new Sale(customer, date, serviceExpense, productExpense);

        // Display sale details
        System.out.println("Customer Name: " + sale.getCustomer().getCustomerName());
        System.out.println("Customer Type: " + sale.getCustomer().getCustomerType());
        System.out.println("Date: " + sale.getDate());
        System.out.println("Service Expense after discount: $" + sale.getServiceExpense());
        System.out.println("Product Expense after discount: $" + sale.getProductExpense());

        scanner.close();
    }
}
