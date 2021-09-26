package ru.romanov.validationannotation.componets;

import lombok.*;
import ru.romanov.validationannotation.annotations.TrainPriorityCheck;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Park {
    @TrainPriorityCheck
    List<Train> trains;
}
