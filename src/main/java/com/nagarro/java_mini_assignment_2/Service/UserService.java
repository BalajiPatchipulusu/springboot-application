package com.nagarro.java_mini_assignment_2.Service;

import com.nagarro.java_mini_assignment_2.Entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserDetails saveUser(UserDetails user) {
        return userRepo.save(user);
    }

    public List<UserDetails> getAllUsers() {
        return userRepo.findAll();
    }

    public List<UserDetails> sortUserDetails(List<UserDetails> userDetailsList, String sortType, String sortOrder, int limit, int offset) {
        int maxLimit = Math.min(limit, 5);
        Comparator<UserDetails> comparator = createComparator(sortType, sortOrder);

        return userDetailsList.stream()
                .sorted(comparator)
                .skip(offset)
                .limit(maxLimit)
                .collect(Collectors.toList());
    }

    private Comparator<UserDetails> createComparator(String sortType, String sortOrder) {
        Comparator<UserDetails> comparator;

        if ("age".equalsIgnoreCase(sortType)) {
            comparator = Comparator.comparingInt(UserDetails::getAge);
        } else if ("name".equalsIgnoreCase(sortType)) {
            comparator = Comparator.comparingInt(user -> user.getName().length());
        } else {
            throw new IllegalArgumentException("Invalid sortType: " + sortType);
        }

        if ("even".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.thenComparingInt(user -> user.getAge() % 2);
        } else if ("odd".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.thenComparingInt(user -> user.getName().length() % 2);
        } else {
            throw new IllegalArgumentException("Invalid sortOrder: " + sortOrder);
        }

        return comparator;
    }
}