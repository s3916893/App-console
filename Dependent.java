import java.util.ArrayList;

public class Dependent extends Customer{
    public Dependent() {
    }

    public Dependent(String customerID, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(customerID, fullName, insuranceCard, claims);
    }

    @Override
    public String toString() {
        return getCustomerID() + ":"+getFullName();
    }
}

