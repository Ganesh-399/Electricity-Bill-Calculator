package electricitybill;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private double unitsConsumed;

    public Customer(int customerId, String name, String address, double unitsConsumed) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.unitsConsumed = unitsConsumed;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }
}

