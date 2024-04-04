import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class InsuranceCard {
    private String cardNumber; //10 digits
    private Customer cardHolder;
    private PolicyHolder policyOwner;
    private Date expirationDate;

    public InsuranceCard() {
    }

    public InsuranceCard(String cardNumber, Customer cardHolder, PolicyHolder policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public PolicyHolder getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(PolicyHolder policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceCard that = (InsuranceCard) o;
        return Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "InsuranceCard{" +
                "cardNumber=" + cardNumber  +
                ", cardHolder=" + cardHolder.getCustomerID() +
                ", policyOwner=" + policyOwner.getCustomerID() +
                ", expirationDate=" + df.format(expirationDate) +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}
