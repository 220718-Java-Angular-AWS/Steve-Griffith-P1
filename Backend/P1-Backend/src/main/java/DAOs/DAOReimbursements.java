package DAOs;

import Interfaces.CRUDInterface;
import Objects.Reimbursements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOReimbursements implements CRUDInterface<Reimbursements> {
        Connection connection;

        public DAOReimbursements(){
            this.connection = connection;
        }

        @Override
        public void create(Reimbursements reimbursements){
            try{
                String sql = "Insert Into reimbursements (reimbursementType, reimbursementStatus, reimbursementCost) Values(?, ?, ?)";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setString(1, Reimbursements.getReimbursementType());
                psmt.setString(2, Reimbursements.getReimbursementStatus());
                psmt.setFloat(3, Reimbursements.getReimbursementCost());

                psmt.executeUpdate();
            }

            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

//TODO: change from select *
    @Override
        public Reimbursements read(int id) {
            Reimbursements reimbursements = new Reimbursements();

            try{
                String sql = "Select * From users Where userid= ?";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setInt(1, id);

                psmt.executeQuery();
            }

            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return reimbursements;
        }

    @Override
    public boolean validate(String userName) {
        return false;
    }


    @Override
        public List<Reimbursements> readAll() {
            List<Reimbursements> reimbursementsList = new LinkedList<>();

            try{
                String sql = "Select * from reimbursements";
                PreparedStatement psmt = connection.prepareStatement(sql);
                ResultSet results = psmt.executeQuery();

                while (results.next()){
                    Reimbursements.setReimbursementId((results.getInt("reimbursementId")));
                    Reimbursements.setReimbursementType((results.getString("reimbursementType")));
                    Reimbursements.setReimbursementStatus((results.getString("reimbursementStatus")));
                    Reimbursements.setReimbursementCost((results.getFloat("reimbursementCost")));

                }
            }

            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return reimbursementsList;
        }


        @Override
        public void update(Reimbursements reimbursements) {

            try{
                String sql = "Update reimbursements Set reimbursementId = ?, reimbursementType = ?, reimbursementStatus = ?, reimbursementCost = ?";
                PreparedStatement psmt = connection.prepareStatement(sql);
                psmt.setInt(1, Reimbursements.getReimbursementId());
                psmt.setString(2, Reimbursements.getReimbursementType());
                psmt.setString(3, Reimbursements.getReimbursementStatus());
                psmt.setFloat(4, Reimbursements.getReimbursementCost());
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
                throw new RuntimeException(e);
            }
        }
    }
