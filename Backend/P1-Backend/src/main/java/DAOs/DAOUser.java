package DAOs;

import Interfaces.CRUDInterface;
import Objects.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOUser implements CRUDInterface<User> {

    Connection connection;

    public DAOUser(){
        this.connection = connection;
    }


    @Override
    public void create(User user) {

        try{
            String sql = "Insert Into credentials (userName, password, email) Values(?, ?, ?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, User.getUserName());
            psmt.setString(2, User.getPassword());
            psmt.setString(3, User.getEmail());

            psmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //TODO: do I really need a Select * here?
    @Override
    public User read(int userId) {
        User user = new User();
        try {

            String sql = "Select * From users Where userId= ?";
            PreparedStatement psmt = connection.prepareStatement(sql);

            psmt.setInt(1, userId);

            psmt.executeQuery();

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean validate(String userName) {

        boolean userExists = false;
        try {

            String sql = "Select username from credentials where username = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, userName);
            ResultSet result = psmt.executeQuery();

            if(result.next()){
                userExists = true;
            }
            return userExists;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO: look into changing from read all to read some for security reasons
    @Override
    public List<User> readAll() {
        List<User> userList = new LinkedList<>();

        try {
            String sql = "Select * From users";
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet results = psmt.executeQuery();

            while (results.next()) {
                User user = new User();
                User.setUserId(results.getInt("userId"));
                User.setUserName(results.getString("userName"));
                User.setEmail(results.getString("email"));
                User.setPassword(results.getString("password"));
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    //TODO: maybe not update userid, might confuse the database
    @Override
    public void update(User user) {
        try{
            String sql = "Update users Set userName = ?, email = ?, password = ?, Where userID = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, User.getUserName());
            psmt.setString(2, User.getEmail());
            psmt.setString(3, User.getPassword());
            psmt.setInt(4, User.getUserId());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE userId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
