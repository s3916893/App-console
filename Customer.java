import java.util.ArrayList;

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
}