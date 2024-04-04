import java.util.ArrayList;

public class PolicyHolder extends Customer {
    private ArrayList<Customer> dependents;

    public PolicyHolder() {
        dependents = new ArrayList<>();
    }

    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims, ArrayList<Customer> dependents) {
        super(customerID, fullName, insuranceCard, claims);
        this.dependents = dependents;
    }

    public ArrayList<Customer> getDependents() {
        return dependents;
    }

    public void setDependents(ArrayList<Customer> dependents) {
        this.dependents = dependents;
    }

    @Override
    public String toString() {
        return  getCustomerID() + ":" + getFullName()+
                dependents;
    }
}
