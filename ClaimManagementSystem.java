import java.util.ArrayList;
public class ClaimManagementSystem {
    private ArrayList<Claim>claims;
    private ArrayList<InsuranceCard>insuranceCards;
    private ArrayList<Customer>customers;

    public ClaimManagementSystem(){
        this.claims = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.insuranceCards = new ArrayList<>();
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public ArrayList<InsuranceCard> getInsuranceCards() {
        return insuranceCards;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
