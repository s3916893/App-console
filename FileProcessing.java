import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileProcessing {
    private static final String COMMA_DELIMITER =",";
    private static final String SEMICOLON_DELIMITER =";";
    ClaimManagementSystem claimManagementSystem = new ClaimManagementSystem();

    public FileProcessing(ClaimManagementSystem claimManagementSystem) {
        this.claimManagementSystem = claimManagementSystem;
    }

    void readCustomerFile(){
        try {
            File customerFile = new File("customers.csv");
            Scanner myReader = new Scanner(customerFile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(COMMA_DELIMITER, -1);
                if(line[2].equals("H")){
                    PolicyHolder policyHolder = new PolicyHolder();
                    policyHolder.setCustomerID(line[0]);
                    policyHolder.setFullName(line[1]);
                    claimManagementSystem.getCustomers().add(policyHolder);
                } else if (line[2].equals("D")) {
                    Dependent dependent = new Dependent();
                    dependent.setCustomerID(line[0]);
                    dependent.setFullName(line[1]);
                    claimManagementSystem.getCustomers().add(dependent);
                    for (Customer customer: claimManagementSystem.getCustomers())
                    {if (customer.getCustomerID().equals(line[3])){
                        if(customer instanceof PolicyHolder){
                            PolicyHolder policyHolder = (PolicyHolder) customer;
                            policyHolder.getDependents().add(dependent);
                        }
                    }

                    }
                }else {
                    System.out.println("Re-enter the role of the customer of "+ line[0] );
                }
            }claimManagementSystem.getCustomers().sort((a, b) -> a.compareTo(b));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    void readInsuranceCard() throws FileNotFoundException, ParseException {
        File insuranceCardFile = new File("insuranceCards.csv");
        Scanner myReader = new Scanner(insuranceCardFile);
        myReader.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] words = line.split(COMMA_DELIMITER);
            InsuranceCard insuranceCard = new InsuranceCard();
            Date claimDate= formatter.parse(words[3]);
            insuranceCard.setExpirationDate(claimDate);
            Customer customer = null;
            for (Customer c : claimManagementSystem.getCustomers()) {
                if (c.getCustomerID().equals(words[1])) {
                    customer = c;
                }
            }
            if (customer == null) {
                System.out.println("Can't find the customer");
            } else {
                insuranceCard.setCardHolder(customer);
            }
            insuranceCard.setCardNumber(words[0]);
            for (Customer c : claimManagementSystem.getCustomers()) {
                if (c.getCustomerID().equals(words[2]) && c instanceof PolicyHolder) {
                    customer = c;
                }
            }if (customer == null) {
                System.out.println("Can't find the customer");
            } else {
                insuranceCard.setPolicyOwner((PolicyHolder) customer);
            }
            if(insuranceCard.getCardHolder() instanceof  PolicyHolder){
                if(insuranceCard.getPolicyOwner().equals(insuranceCard.getCardHolder())){
                    claimManagementSystem.getInsuranceCards().add(insuranceCard);
                }else {
                    System.out.println("Error");
                };


            }


        }

    }
    public void readClaim() throws FileNotFoundException, ParseException {
        File claimFile = new File("claims.csv");
        Scanner myReader = new Scanner(claimFile);
        myReader.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        while(myReader.hasNextLine()){
            String line = myReader.nextLine();
            String[] data = line.split(COMMA_DELIMITER,-1);
            Date claimDate= formatter.parse(data[1]);
            Date examDate = formatter.parse(data[4]);
            Claim claim = new Claim();
            Customer customer = null;
            InsuranceCard insuranceCard = null;
            claim.setId(data[0]);
            claim.setClaimDate(claimDate);
            for (Customer c: claimManagementSystem.getCustomers()) {
                if(c.getCustomerID().equals(data[2])){
                    customer = c;
                }
            }if(customer == null){
                System.out.println("Couldn't find the insured person");
            }else {
                claim.setInsuredPerson(customer);
            }
            claim.setCardNumber(Integer.parseInt(data[3]));
            claim.setExamDate(examDate);
            String[] document = data[5].split(SEMICOLON_DELIMITER);
            ArrayList<String> documents = new ArrayList<>(Arrays.asList(document));
            claim.setDocuments(documents);
            claim.setClaimAmount(Double.parseDouble(data[6]));
            // Switch keyword
            switch (data[7].charAt(0)) {
                // Case statements
                case 'N':
                    claim.setStatus(Status.NEW);
                    break;
                case 'D':
                    claim.setStatus(Status.DONE);
                    break;
                case 'P':
                    claim.setStatus(Status.PROCESSING);
                    break;
            }claim.setReceiverBankingInfor(data[7]);
            claimManagementSystem.getClaims().add(claim);
            customer.addClaim(claim);


        }

    }

}
