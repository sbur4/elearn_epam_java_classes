package com.epam.task_10.builder;

public interface Builder<B, T> {
    B builder(Object... params);

    T build();
}