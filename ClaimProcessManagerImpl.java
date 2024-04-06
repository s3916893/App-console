import java.util.ArrayList;
public class ClaimProcessManagerImpl implements ClaimProcessManager{
    private ClaimManagementSystem claimManagementSystem;

    public ClaimProcessManagerImpl(ClaimManagementSystem claimManagementSystem) {
        this.claimManagementSystem = claimManagementSystem;
    }
    @Override
    public void add(Claim claim) {
        ArrayList<Claim>claims = claimManagementSystem.getClaims();
        if(claims.contains(claim)){
            return;
        }
        for (int i = 0; i < claims.size() ; i++) {
            if(claims.get(i).compareTo(claim) > 0){
                claims.add(i, claim);
                return;
            }
        }claims.add(claim);
    }
    @Override
    public void delete(Claim claim) {
        claimManagementSystem.getClaims().remove(claim);
    }
    @Override
    public void update(Claim claim) {
        delete(claim);
        add(claim);
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
