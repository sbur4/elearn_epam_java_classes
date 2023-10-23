package com.epam.task_10.criteria;

import java.util.Arrays;
import java.util.List;

public class AndCriteria<T> extends AbstractCriteria<T> {
    private final List<AbstractCriteria<T>> leaveItems;

    @SafeVarargs
    public AndCriteria(AbstractCriteria<T>... selectors) {
        this.leaveItems = Arrays.asList(selectors);
    }

    @Override
    public boolean test(T t) {
        return leaveItems.stream().allMatch(item -> (item.test(t)));
    }
}