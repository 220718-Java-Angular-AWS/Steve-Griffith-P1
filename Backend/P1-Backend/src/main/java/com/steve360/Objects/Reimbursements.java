package com.steve360.Objects;

public class Reimbursements
 {

    private Integer reimbursementId;
    private Integer userId;
    private String reimbursementType;

    private String reimbursementStatus;
    private float reimbursementCost;

    public Reimbursements()
    {
        //Default No-Args
    }

    //All-Args constructor
    public Reimbursements(int reimbursementId, String reimbursementType, String reimbursementStatus, float reimbursementCost, Integer userId){
        this.reimbursementId = reimbursementId;
        this.reimbursementType = reimbursementType;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementCost = reimbursementCost;
        this.userId = userId;
    }

    //Getters and Setters
    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;

    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType){
        this.reimbursementType = reimbursementType;

    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public float getReimbursementCost() {
        return reimbursementCost;
    }

    public void setReimbursementCost(float reimbursementCost) {
        this.reimbursementCost = reimbursementCost;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
}