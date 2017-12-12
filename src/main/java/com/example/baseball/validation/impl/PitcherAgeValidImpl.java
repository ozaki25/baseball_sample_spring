package com.example.baseball.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.example.baseball.validation.PitcherAgeValid;

public class PitcherAgeValidImpl implements ConstraintValidator<PitcherAgeValid, Object> {
    private String ageField;
    private String positionField;
    private String message;

    @Override
    public void initialize(PitcherAgeValid constraintAnnotation) {
        ageField = constraintAnnotation.ageField();
        positionField = constraintAnnotation.positionField();
        message =constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Integer age =  (Integer)beanWrapper.getPropertyValue(ageField);
        String position = (String)beanWrapper.getPropertyValue(positionField);
        if(position != null && age != null && position.equals("ピッチャー") && age > 30) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(ageField).addConstraintViolation();
            return false;
        } else {
            return true;
        }
    }
}
