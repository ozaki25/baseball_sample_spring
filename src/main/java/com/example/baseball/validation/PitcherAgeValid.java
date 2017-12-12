package com.example.baseball.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import com.example.baseball.validation.impl.PitcherAgeValidImpl;

@Documented
@Constraint(validatedBy={PitcherAgeValidImpl.class})
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface PitcherAgeValid {
    String message() default "{com.example.baseball.validation.PitcherAgeValid.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String ageField();
    String positionField();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        PitcherAgeValid value();
    }
}
