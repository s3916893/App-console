import java.util.ArrayList;
import java.util.Objects;

public abstract class Customer {
    private String CustomerID; //(with the format c-numbers; 7 numbers) ;
    private String fullName;
    private InsuranceCard InsuranceCard;
    private ArrayList<Claim> claims;

    public Customer(){};
    public Customer(String customerID, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        CustomerID = customerID;
        this.fullName = fullName;
        InsuranceCard = insuranceCard;
        this.claims = claims;
    }
    public void addClaim(Claim claim){
        this.claims.add(claim);
    }
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return InsuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        InsuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    public int compareTo(Customer customer){
        return this.getCustomerID().compareTo(customer.getCustomerID());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", InsuranceCard=" + InsuranceCard +
                ", claims=" + claims +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(CustomerID, customer.CustomerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerID);
    }
}