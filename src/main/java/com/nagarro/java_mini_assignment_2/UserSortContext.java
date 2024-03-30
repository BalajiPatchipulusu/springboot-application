package com.nagarro.java_mini_assignment_2;

import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;
import com.nagarro.java_mini_assignment_2.Service.Sorting.UserSortingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSortContext {

    @Autowired
    private UserSortingStrategy sortingStrategy;

    public void setSortingStrategy(UserSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(List<UserDetailsResponse> userList, String type) {
        sortingStrategy.sort(userList, type);
    }

}