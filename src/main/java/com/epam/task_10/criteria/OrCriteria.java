package com.epam.task_10.criteria;

import java.util.Arrays;
import java.util.List;

public class OrCriteria<T> extends AbstractCriteria<T> {
    private final List<AbstractCriteria<T>> leaveItems;

    @SafeVarargs
    public OrCriteria(AbstractCriteria<T>... selectors) {
        this.leaveItems = Arrays.asList(selectors);
    }

    @Override
    public boolean test(T t) {
        return leaveItems.stream().anyMatch(item -> (item.test(t)));
    }
}