package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.enums.CriteriaType;
import com.epam.task_10.enums.Seats;
import com.epam.task_10.model.Train;

import java.util.Objects;

public class SeatsCriteriaImpl extends AbstractCriteria<Train> {
    private final Seats seatType;
    private final Integer quantity;
    private final CriteriaType criteriaType;

    public SeatsCriteriaImpl(Seats seatType, Integer quantity, CriteriaType criteriaType) {
        this.seatType = seatType;
        this.quantity = quantity;
        this.criteriaType = criteriaType;
    }

    @Override
    public boolean test(Train train) {
        switch (criteriaType) {
            case EQUALS_TO:
                return train.getSeats().entrySet().stream()
                        .anyMatch(entry -> entry.getKey() == seatType && Objects.equals(entry.getValue(), quantity));
            case LESS_THAN:
                return train.getSeats().entrySet().stream()
                        .anyMatch(entry -> entry.getKey() == seatType && entry.getValue() < quantity);
            case MORE_THAN:
                return train.getSeats().entrySet().stream()
                        .anyMatch(t -> t.getKey() == seatType && t.getValue() > quantity);
            case LESS_THAN_AND_EQUALS_TO:
                return train.getSeats().entrySet().stream()
                        .anyMatch(t -> t.getKey() == seatType && t.getValue() <= quantity);
            case MORE_THAN_AND_EQUALS_TO:
                return train.getSeats().entrySet().stream()
                        .anyMatch(t -> t.getKey() == seatType && t.getValue() >= quantity);
            default:
                throw new IllegalArgumentException("Unknown criterion type: " + criteriaType.name());
        }
    }
}