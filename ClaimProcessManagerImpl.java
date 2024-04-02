import java.util.ArrayList;

public class ClaimProcessManagerImpl implements ClaimProcessManager{

    private ClaimManagementSystem claimManagementSystem;

    public ClaimProcessManagerImpl(ClaimManagementSystem claimManagementSystem) {
        this.claimManagementSystem = claimManagementSystem;
    }


    @Override
    public void add(Claim claim) {
        ArrayList<Claim> claims = claimManagementSystem.getClaims(); // This is a list of claims
        if(claims.contains(claim)){ //check if the claim users want to add is already existing or not
            return; //if yes just return the claim
        }
        for (int i = 0; i < claims.size() ; i++) { //check if the id of the claim in the
            // list is bigger than the id of the claim input or not
            if(claims.get(i).compareTo(claim) > 0){ // if it is bigger the claim will
                // be added after the claim in the list
                claims.add(i, claim); // if it is bigger the claim input will be added after it
                return;
            }
        }claims.add(claim);
    }



    @Override
    public void delete(Claim claim) {   //remove the claim
        claimManagementSystem.getClaims().remove(claim);
    }

    @Override
    public void update(Claim claim) {   //change information of the claim
        ArrayList<Claim>claims = claimManagementSystem.getClaims();
        for (Claim cl: claims) {
            if(cl.equals(claim)){
                cl.setClaimDate(claim.getClaimDate());
                cl.setInsuredPerson(claim.getInsuredPerson());
                cl.setCardNumber(claim.getCardNumber());
                cl.setExamDate(claim.getExamDate());
                cl.setDocuments(claim.getDocuments());
                cl.setClaimAmount(claim.getClaimAmount());
                cl.setStatus(claim.getStatus());
                cl.setReceiverBankingInfor(claim.getReceiverBankingInfor());
            }
        }
    }

    @Override
    public Claim getOne(Claim claim) {
        int index = claimManagementSystem.getClaims().indexOf(claim);
        if (index == -1){
            return null;
        }return claimManagementSystem.getClaims().get(index);
    }
    @Override
    public Claim getOne(String id){
        Claim claim = new Claim();
        claim.setId(id);
        return getOne(claim);
    }

    @Override
    public ArrayList<Claim> getAll() {
        return claimManagementSystem.getClaims();
    }
}

