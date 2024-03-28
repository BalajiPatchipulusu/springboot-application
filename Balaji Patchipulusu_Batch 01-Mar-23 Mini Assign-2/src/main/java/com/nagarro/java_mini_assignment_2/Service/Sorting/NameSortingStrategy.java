package com.nagarro.java_mini_assignment_2.Service.Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;

@Component
public class NameSortingStrategy implements UserSortingStrategy {
    @Override
    public void sort(List<UserDetailsResponse> users, String type) {
        Comparator<UserDetailsResponse> nameLengthComparator = Comparator.comparingInt(user -> user.getName().length());

        List<UserDetailsResponse> oddLengthUsers = users.stream()
                .filter(user -> user.getName().length() % 2 != 0)
                .sorted(nameLengthComparator)
                .collect(Collectors.toList());

        List<UserDetailsResponse> evenLengthUsers = users.stream()
                .filter(user -> user.getName().length() % 2 == 0)
                .sorted(nameLengthComparator)
                .collect(Collectors.toList());

        users.clear();
        if(type.equalsIgnoreCase("ODD")) {
            users.addAll(oddLengthUsers);
            users.addAll(evenLengthUsers);
        }
        else {
            users.addAll(oddLengthUsers);
            users.addAll(evenLengthUsers);
        }
    }
}