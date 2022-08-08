package Services;

import DAOs.DAOUser;
import Objects.User;

import java.util.List;

public class UserService {
    private DAOUser DAOUser;

    public UserService(){
        this.DAOUser = new DAOUser();
    }

    public void save(User user){
        DAOUser.create(user);
    }

    public boolean validate(String userName){
        return DAOUser.validate(userName);
    }

    public User getUserName(int userId){
        return DAOUser.read(userId);
    }

    public List<User> userList(){
        return DAOUser.readAll();
    }

    public void updateUser(User user){
        DAOUser.update(user);
    }

    public void deleteUser(int userId){
        DAOUser.delete(userId);
    }
}
