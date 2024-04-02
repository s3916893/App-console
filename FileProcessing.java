import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileProcessing {
    private static final String COMMA_DELIMITER =",";
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
    void readInsuranceCard() throws FileNotFoundException {
        File insuranceCardFile = new File("insuranceCards.csv");
        Scanner myReader = new Scanner(insuranceCardFile);
        myReader.nextLine();
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] words = line.split(COMMA_DELIMITER);
            InsuranceCard insuranceCard = new InsuranceCard();
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
    public static void main(String[] args) {
        ClaimManagementSystem claimManagementSystem1 = new ClaimManagementSystem();
        FileProcessing fileProcessing = new FileProcessing(claimManagementSystem1);

        fileProcessing.readCustomerFile();
        System.out.println(Arrays.toString(claimManagementSystem1.getCustomers().toArray()));
    }
}

