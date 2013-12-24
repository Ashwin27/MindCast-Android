package com.mindcast;

public class Status{
    private String userID;
    private String status;

    public Status(String userID, String status){
        this.userID = userID;
        this.status = status;
    }

    public Status(){

    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getUserID(){
        return this.status;
    }

    public void setUserID(String status){
        this.status = status;
    }
}
