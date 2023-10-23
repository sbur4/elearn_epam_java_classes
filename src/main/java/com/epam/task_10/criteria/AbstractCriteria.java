package com.epam.task_10.criteria;

import java.util.function.Predicate;

public abstract class AbstractCriteria<T> implements Predicate<T> {
    public AbstractCriteria<T> and(AbstractCriteria<T> other) {
        return new AndCriteria<>(this, other);
    }

    public AbstractCriteria<T> or(AbstractCriteria<T> other) {
        return new OrCriteria<>(this, other);
    }

    public AbstractCriteria<T> not() {
        return new NotCriteria<>(this);
    }
}