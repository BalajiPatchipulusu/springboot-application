package com.nagarro.java_mini_assignment_2.Service.Validation;

public class EnglishAlphabetsValidator implements Validator {
    private static final EnglishAlphabetsValidator instance = new EnglishAlphabetsValidator();

    EnglishAlphabetsValidator() {}

    public static EnglishAlphabetsValidator getInstance() {
        return instance;
    }

    @Override
    public boolean validate(String input) {
        return input.matches("^[a-zA-Z]*$");
    }
}