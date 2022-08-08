package DAOs;

import Interfaces.CRUDInterface;
import Objects.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


//TODO: change SQl Strings to be more secure
public class DAORoles implements CRUDInterface<Roles> {
    Connection connection;
    public DAORoles(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Roles roles) {
        try{
            String sql = "Insert into roles (roleType) Values(?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, Roles.getRoleType());

            psmt.executeUpdate();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Roles read(int id) {
        Roles role = new Roles();
        try{
            String sql = "Select * from Roles where userId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, id);
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    @Override
    public boolean validate(String userName) {
        return false;
    }

    @Override
    public List<Roles> readAll() {
        List<Roles> rolesList = new LinkedList<>();
        try{
            String sql = "Select * from Roles";
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet results = psmt.executeQuery();

            while(results.next()){
                Roles role = new Roles();
                Roles.setRoleId(results.getInt("roleId"));
                Roles.setRoleType(results.getString("roleType"));
            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesList;
    }

    @Override
    public void update(Roles roles) {
        try{
            String sql = "Update roles set role = ? where userId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, Roles.getRoleType());
            psmt.executeUpdate();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "delete From Roles Where userId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
