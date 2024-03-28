package com.nagarro.java_mini_assignment_2.Service.Sorting;

import java.util.List;

import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;

public interface UserSortingStrategy {

    void sort(List<UserDetailsResponse> users, String type);

}