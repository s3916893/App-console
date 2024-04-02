import java.util.ArrayList;

public interface ClaimProcessManager {
    void add(Claim claim);
    void delete(Claim claim);
    void update(Claim claim);
    Claim getOne(Claim claim);
    Claim getOne(String id);
    ArrayList<Claim> getAll();

}
