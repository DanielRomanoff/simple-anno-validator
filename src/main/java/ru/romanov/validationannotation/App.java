package ru.romanov.validationannotation;


import ru.romanov.validationannotation.componets.Park;
import ru.romanov.validationannotation.componets.Train;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/***
 * Описать класс Парк.
 * Поезд может быть принят в любой парк, поэтому предусматривается приоритетность приёма поезда в парк,
 * для этого используются поля ПриоритетПриёмаТранзитногоПоезда и ПриоритетПриёмаПоездаВРасформирование.
 * Создать ограничение для валидации класса Парк, которое проверяет, что одновременно значение этих полей не равно нулю.
 * Продемонстрировать работу с ограничением.
 */

public class App {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Park park = Park.builder()
                .trains(
                        List.of(
                                Train.builder()
                                        .receivingPriority(1)
                                        .build(),

                                Train.builder().build(),

                                Train.builder()
                                        .acceptanceTransitPriority(1)
                                        .build(),

                                Train.builder()
                                        .receivingPriority(1)
                                        .acceptanceTransitPriority(1)
                                        .build()
                        ))
                .build();

        Set<ConstraintViolation<Park>> parkViolations = validator.validate(park);
        for (ConstraintViolation<Park> constraintViolation : parkViolations) {
            System.out.println("Ошибки: \n" +
                    "Поле - " + constraintViolation.getPropertyPath() + "\n" +
                    "Значение - " + constraintViolation.getInvalidValue() + "\n" +
                    "Сообщение об ошибке - " + constraintViolation.getMessage());
        }
        factory.close();
    }
}
