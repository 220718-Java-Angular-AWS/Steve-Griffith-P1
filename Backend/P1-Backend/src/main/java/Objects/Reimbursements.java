package Objects;

public class Reimbursements
 {

    private static int reimbursementId;
    private static String reimbursementType;

    private static String reimbursementStatus;
    private static float reimbursementCost;

    public Reimbursements
(){
        //Default No-Args
    }

    //All-Args constructor
    public Reimbursements(int reimbursementId, String reimbursementType, String reimbursementStatus, float reimbursementCost){
        Reimbursements.reimbursementId = reimbursementId;
        Reimbursements.reimbursementType = reimbursementType;
        Reimbursements.reimbursementStatus = reimbursementStatus;
        Reimbursements.reimbursementCost = reimbursementCost;
    }

    //Getters and Setters
    public static int getReimbursementId() {
        return reimbursementId;
    }

    public static void setReimbursementId(int reimbursementId) {
        Reimbursements.reimbursementId = reimbursementId;

    }

    public static String getReimbursementType() {
        return reimbursementType;
    }

    public static void setReimbursementType(String reimbursementType){
        Reimbursements.reimbursementType = reimbursementType;

    }

    public static String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public static void setReimbursementStatus(String reimbursementStatus) {
        Reimbursements.reimbursementStatus = reimbursementStatus;
    }

    public static float getReimbursementCost() {
        return reimbursementCost;
    }

    public static void setReimbursementCost(float reimbursementCost) {
    }
}
