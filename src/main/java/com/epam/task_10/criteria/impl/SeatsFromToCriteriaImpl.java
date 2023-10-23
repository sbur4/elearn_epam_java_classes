package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.enums.Seats;
import com.epam.task_10.model.Train;

public class SeatsFromToCriteriaImpl extends AbstractCriteria<Train> {
    private final Seats seatType;
    private final Integer quantityFrom;
    private final Integer quantityTo;

    public SeatsFromToCriteriaImpl(Seats seatType, Integer quantityFrom, Integer quantityTo) {
        this.seatType = seatType;
        this.quantityFrom = quantityFrom;
        this.quantityTo = quantityTo;
    }

    @Override
    public boolean test(Train train) {
        return  train.getSeats().entrySet().stream()
                .anyMatch(t -> t.getKey() == seatType && t.getValue() >= quantityFrom && t.getValue() <= quantityTo);
    }
}