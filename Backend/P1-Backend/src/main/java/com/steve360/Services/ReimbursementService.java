package com.steve360.Services;

import com.steve360.DAOs.DAOReimbursements
;
import com.steve360.Objects.Reimbursements;

import java.util.List;

public class ReimbursementService {

    private DAOReimbursements dao;

    public ReimbursementService(){
        this.dao = new DAOReimbursements();
    }

    public void save(Reimbursements reimbursement){
        dao.create(reimbursement);
    }


    public List<Reimbursements> getReimbursement(Integer userId){
        List<Reimbursements> reimbursementList = dao.readAll();

        for (Reimbursements reimbursement: reimbursementList) {
            if(!reimbursement.getUserId().equals(userId)){
                reimbursementList.remove(reimbursement);
            }

        }
        return reimbursementList;
    }

    public List<Reimbursements> getAllReimbursements(){
        return dao.readAll();
    }

    public void updateReimbursements(Reimbursements reimbursement, Integer userId){
        dao.update(reimbursement);
    }

    public void deleteReimbursement(int id){
        dao.delete(id);
    }

}
