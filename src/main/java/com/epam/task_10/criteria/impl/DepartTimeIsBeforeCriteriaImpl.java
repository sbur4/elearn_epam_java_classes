package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.model.Train;

import java.time.LocalDateTime;

public class DepartTimeIsBeforeCriteriaImpl extends AbstractCriteria<Train> {
    private final LocalDateTime departTime;

    public DepartTimeIsBeforeCriteriaImpl(LocalDateTime departTime) {
        this.departTime = departTime;
    }

    @Override
    public boolean test(Train train) {
        return train.getDepartTime().isBefore(departTime);
    }
}