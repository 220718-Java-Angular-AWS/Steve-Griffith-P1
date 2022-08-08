package Objects;

public class User {

    private static Integer userId;
    private static String userName;
    private static String password;
    private static String email;



    public User() {

    }

    public User(Integer userId, String userName, String password, String email){
        User.userId = userId;
        User.userName = userName;
        User.password = password;
        User.email = email;
    }

    public static void setUserId(Integer userId) {
        User.userId = userId;
    }

    public static Integer getUserId() {
        return userId;
    }

    public static void setUserName(String userName){
        User.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setPassword(String password) {
        User.password = password;
    }


    public static String getPassword() {
        return password;
    }


    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }
}
