package com.epam.task_10.mapper;

public interface Mapper<T, V> {
    T mapTo(V value);
}