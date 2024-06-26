package com.nagarro.java_mini_assignment_2.Service.Validation;

public class NumericValidator implements Validator {
    private static final NumericValidator instance = new NumericValidator();

    NumericValidator() {}

    public static NumericValidator getInstance() {
        return instance;
    }

    @Override
    public boolean validate(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}