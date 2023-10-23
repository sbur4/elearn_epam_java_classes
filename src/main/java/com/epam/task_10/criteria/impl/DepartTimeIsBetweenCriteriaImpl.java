package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.model.Train;

import java.time.LocalDateTime;

public class DepartTimeIsBetweenCriteriaImpl extends AbstractCriteria<Train> {
    private final LocalDateTime startDepartTime;
    private final LocalDateTime endDepartTime;

    public DepartTimeIsBetweenCriteriaImpl(LocalDateTime startDepartTime, LocalDateTime endDepartTime) {
        this.startDepartTime = startDepartTime;
        this.endDepartTime = endDepartTime;
    }

    @Override
    public boolean test(Train train) {
        return train.getDepartTime().isAfter(startDepartTime) && train.getDepartTime().isBefore(endDepartTime);
    }
}