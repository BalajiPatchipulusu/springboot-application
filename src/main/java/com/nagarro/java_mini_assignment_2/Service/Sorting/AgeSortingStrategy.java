package com.nagarro.java_mini_assignment_2.Service.Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;

@Component
@Primary
public class AgeSortingStrategy implements UserSortingStrategy {
    @Override
    public void sort(List<UserDetailsResponse> users, String type) {
        Comparator<UserDetailsResponse> ageComparator = Comparator.comparingInt(UserDetailsResponse::getAge);

        List<UserDetailsResponse> evenUsers = users.stream()
                .filter(user -> user.getAge() % 2 == 0)
                .sorted(ageComparator)
                .collect(Collectors.toList());

        List<UserDetailsResponse> oddUsers = users.stream()
                .filter(user -> user.getAge() % 2 != 0)
                .sorted(ageComparator)
                .collect(Collectors.toList());

        users.clear();
        if(type.equalsIgnoreCase("EVEN")) {
            users.addAll(evenUsers);
            users.addAll(oddUsers);
        }else {
            users.addAll(evenUsers);
            users.addAll(oddUsers);
        }
    }
}