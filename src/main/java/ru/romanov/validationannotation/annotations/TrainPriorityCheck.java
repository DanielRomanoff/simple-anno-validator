package ru.romanov.validationannotation.annotations;

import ru.romanov.validationannotation.validators.ParkValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ParkValidator.class})
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TrainPriorityCheck {
    String message() default "укажите необходимые приоритеты";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int acceptanceTransitPriority() default -1;
    int receivingPriority() default -1;
}
