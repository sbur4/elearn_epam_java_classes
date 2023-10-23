package com.epam.task_10;

import com.epam.task_10.builder.impl.TrainBuilderImpl;
import com.epam.task_10.contorller.Controller;
import com.epam.task_10.mapper.impl.SeatsMapperImpl;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.processRun(builderInit());
    }

    private static TrainBuilderImpl builderInit() {
        return new TrainBuilderImpl(new SeatsMapperImpl());
    }
}