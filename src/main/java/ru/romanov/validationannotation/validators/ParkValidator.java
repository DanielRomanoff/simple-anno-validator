package ru.romanov.validationannotation.validators;

import ru.romanov.validationannotation.annotations.TrainPriorityCheck;
import ru.romanov.validationannotation.componets.Train;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ParkValidator implements ConstraintValidator<TrainPriorityCheck, List<Train>> {
    Integer acceptanceTransitPriority;
    Integer receivingPriority;

    @Override
    public void initialize(TrainPriorityCheck constraintAnnotation) {
        acceptanceTransitPriority = constraintAnnotation.acceptanceTransitPriority();
        receivingPriority = constraintAnnotation.receivingPriority();
    }

    @Override
    public boolean isValid(List<Train> trains, ConstraintValidatorContext constraintValidatorContext) {
        return trains.stream().noneMatch(train -> train.getReceivingPriority() == null || train.getAcceptanceTransitPriority() == null);
    }
}
