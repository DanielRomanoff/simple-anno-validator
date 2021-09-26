package ru.romanov.validationannotation.componets;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Train {
    Integer acceptanceTransitPriority;
    Integer receivingPriority;

    @Override
    public String toString() {
        return "Train{" +
                "acceptanceTransitPriority=" + acceptanceTransitPriority +
                ", receivingPriority=" + receivingPriority +
                '}';
    }
}
