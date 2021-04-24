package com.example.navtest1;

public class MessageList {

    private String firstname;
    private String message;

    public MessageList(){

    }

    public MessageList(String firstname, String message){
        this.firstname = firstname;
        this.message = message;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getMessage(){
        return message;
    }
}
