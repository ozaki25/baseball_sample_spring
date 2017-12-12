package com.example.baseball.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.baseball.validation.PositionValid;

public class PositionValidImpl implements ConstraintValidator<PositionValid, String> {
    @Override
    public void initialize(PositionValid constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return true;
        Pattern pattern = Pattern.compile("^[ァ-ヶー]*$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
