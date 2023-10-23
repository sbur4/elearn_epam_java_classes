package com.epam.task_9.filter;

@FunctionalInterface
public interface Filter<T> {
    boolean filteredBy(T item);

    default Filter<T> and(Filter<T> other) {
        return item -> this.filteredBy(item) && other.filteredBy(item);
    }

    default Filter<T> or(Filter<T> other) {
        return item -> this.filteredBy(item) || other.filteredBy(item);
    }

    default Filter<T> not() {
        return item -> !this.filteredBy(item);
    }
}