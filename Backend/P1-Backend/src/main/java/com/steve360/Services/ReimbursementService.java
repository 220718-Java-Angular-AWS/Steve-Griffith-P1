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


    public Reimbursements getReimbursement(int id){
        return dao.read(id);
    }

    public List<Reimbursements> getAllReimbursements(){
        return dao.readAll();
    }

    public void updateUser(Reimbursements reimbursement){
        dao.update(reimbursement);
    }

    public void deleteReimbursement(int id){
        dao.delete(id);
    }
}
