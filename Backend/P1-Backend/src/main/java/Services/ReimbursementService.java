package Services;

import DAOs.DAOReimbursements
;
import Objects.Reimbursements;

import java.util.List;

public class ReimbursementService {

    private DAOReimbursements DAOReimbursements;

    public ReimbursementService(){
        this.DAOReimbursements = new DAOReimbursements();
    }

    public void save(Reimbursements reimbursements){
        DAOReimbursements.create(reimbursements);
    }


    public Reimbursements getReimbursements(int reimbursementId){
        return DAOReimbursements.read(reimbursementId);
    }

    public List<Reimbursements> reimbursements(){
        return DAOReimbursements.readAll();
    }

    public void updateUser(Reimbursements reimbursements){
        DAOReimbursements.update(reimbursements);
    }

    public void deleteReimbursements(int reimbursementId){
        DAOReimbursements.delete(reimbursementId);
    }
}
