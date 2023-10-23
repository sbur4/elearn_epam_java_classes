package com.epam.task_10.criteria;

import com.epam.task_10.criteria.AbstractCriteria;

public class NotCriteria<T> extends AbstractCriteria<T> {
    private final AbstractCriteria<T> component;

    public NotCriteria(AbstractCriteria<T> selector) {
        this.component = selector;
    }

    @Override
    public boolean test(T t) {
        return !(component.test(t));
    }
}