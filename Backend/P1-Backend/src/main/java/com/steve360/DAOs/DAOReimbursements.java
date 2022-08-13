package com.steve360.DAOs;

import com.steve360.Interfaces.CRUDInterface;
import com.steve360.Objects.Reimbursements;
import com.steve360.Services.ManagerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOReimbursements implements CRUDInterface<Reimbursements> {
        Connection connection;

        public DAOReimbursements(){
            this.connection = ManagerService.getConnection();
        }

        @Override
        public void create(Reimbursements reimbursements){
            try{
                String sql = "Insert Into reimbursements (reimbursementType, reimbursementcost, reimbursemenstatus, userid) Values(?, ?, ?, Pending)";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setString(1, reimbursements.getReimbursementType());
                psmt.setFloat(3, reimbursements.getReimbursementCost());
                psmt.setString(2, reimbursements.getReimbursementStatus());
               psmt.setInt(4, reimbursements.getUserId());


                psmt.executeUpdate();
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
        public Reimbursements read(int id) {
            Reimbursements reimbursements = new Reimbursements();

            try{
                String sql = "Select * From reimbursements Where reimbursementid = ?";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setInt(1, id);

                ResultSet resultSet =psmt.executeQuery();
                if(resultSet.next()){
                    reimbursements.setReimbursementId(resultSet.getInt("reimbursementid"));
                    reimbursements.setReimbursementType(resultSet.getString("reimbursementtype"));
                    reimbursements.setReimbursementCost(resultSet.getFloat("reimbursementcost"));
                    reimbursements.setReimbursementStatus(resultSet.getString("reimbursementstatus"));
                }

            }

            catch (SQLException e) {
                e.printStackTrace();
            }
            return reimbursements;
        }

    @Override
    public Reimbursements validate(String userName, String password) {
        return null;
    }


    @Override
        public List<Reimbursements> readAll() {
            List<Reimbursements> reimbursementsList = new LinkedList<>();

            try{
                String sql = "Select * from reimbursements";
                PreparedStatement psmt = connection.prepareStatement(sql);

                ResultSet results = psmt.executeQuery();

                while (results.next()){
                    Reimbursements reimbursements = new Reimbursements();

                    reimbursements.setReimbursementId((results.getInt("reimbursementId")));
                    reimbursements.setReimbursementType((results.getString("reimbursementType")));
                    reimbursements.setReimbursementStatus((results.getString("reimbursementStatus")));
                    reimbursements.setReimbursementCost((results.getFloat("reimbursementCost")));
                    reimbursementsList.add(reimbursements);

                }
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
            return reimbursementsList;
        }


        @Override
        public void update(Reimbursements reimbursements) {

            try{

                String sql = "Update reimbursements Set reimbursementId = ?, reimbursementType = ?, reimbursementStatus = ?, reimbursementCost = ?, userId = ?";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setInt(1, reimbursements.getReimbursementId());
                psmt.setString(2, reimbursements.getReimbursementType());
                psmt.setString(3, reimbursements.getReimbursementStatus());
                psmt.setFloat(4, reimbursements.getReimbursementCost());
                psmt.setInt(5,reimbursements.getUserId());
                psmt.executeUpdate();
            }

            catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void delete(int id) {
            try{
                String sql = "Delete From Reimbursements where userId = ?";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setInt(1, id);
                psmt.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }