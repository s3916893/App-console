import java.util.ArrayList;
import java.util.Date;

public class Claim{
    private String id; //(with the format f-numbers; 10 numbers)
    private Date claimDate;
    private Customer insuredPerson;

    private int cardNumber;
    private Date examDate;

    private ArrayList<String> documents; //(with the format ClaimId_CardNumber_DocumentName.pdf)
    private double claimAmount;

    private Status status; // (New, Processing, Done)

    private String ReceiverBankingInfor; //(Bank-Name-Number)

    public Claim() {

    }

    public Claim(String id, Date claimDate, Customer insuredPerson, int cardNumber, Date examDate, ArrayList<String> documents, double claimAmount, Status status, String receiverBankingInfor) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        ReceiverBankingInfor = receiverBankingInfor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReceiverBankingInfor() {
        return ReceiverBankingInfor;
    }

    public void setReceiverBankingInfor(String receiverBankingInfor) {
        ReceiverBankingInfor = receiverBankingInfor;
    }
}


