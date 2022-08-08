package Objects;

public class Roles {


    private static Integer roleId;
    private static String roleType;

    public Roles() {

    }

    public Roles(Integer roleId, String roleType){
        Roles.roleId = roleId;
        Roles.roleType = roleType;
    }

    public static Integer getRoleId() {
        return roleId;
    }

    public static void setRoleId(Integer roleId) {
        Roles.roleId = roleId;
    }

    public static String getRoleType() {
        return roleType;
    }

    public static void setRoleType(String roleType) {
        Roles.roleType = roleType;
    }
}
