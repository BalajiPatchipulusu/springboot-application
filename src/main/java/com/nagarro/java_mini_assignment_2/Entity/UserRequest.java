package com.nagarro.java_mini_assignment_2.Entity;

public class UserRequest {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public UserRequest(int size) {
        super();
        this.size = size;
    }

    public UserRequest() {
        super();
    }

    @Override
    public String toString() {
        return "UserCreationRequest [size=" + size + "]";
    }
    
}