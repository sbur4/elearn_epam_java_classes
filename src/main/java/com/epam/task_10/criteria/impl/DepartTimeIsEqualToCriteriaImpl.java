package com.epam.task_10.criteria.impl;

import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.model.Train;

import java.time.LocalDateTime;

public class DepartTimeIsEqualToCriteriaImpl extends AbstractCriteria<Train> {
    private final LocalDateTime departTime;

    public DepartTimeIsEqualToCriteriaImpl(LocalDateTime departTime) {
        this.departTime = departTime;
    }

    @Override
    public boolean test(Train train) {
        return train.getDepartTime().isEqual(departTime);
    }
}