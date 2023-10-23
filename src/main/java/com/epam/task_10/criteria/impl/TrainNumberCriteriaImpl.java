package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.model.Train;

public class TrainNumberCriteriaImpl extends AbstractCriteria<Train> {
    private final String destinationPoint;

    public TrainNumberCriteriaImpl(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    @Override
    public boolean test(Train train) {
        return train.getDestinationPoint().equals(destinationPoint);
    }
}