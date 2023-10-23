package com.epam.task_10.builder.impl;

import com.epam.task_10.builder.Builder;
import com.epam.task_10.mapper.impl.SeatsMapperImpl;
import com.epam.task_10.enums.Seats;
import com.epam.task_10.model.Train;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TrainBuilderImpl implements Builder<TrainBuilderImpl, Train> {
    private final SeatsMapperImpl mapper;
    public String destinationPoint;
    public String trainNumber;
    public LocalDateTime departTime;
    public Map<Seats, Integer> seats;

    public TrainBuilderImpl(SeatsMapperImpl mapper) {
        this.mapper = mapper;
    }

    @Override
    public TrainBuilderImpl builder(Object... params) {
        this.destinationPoint = params[0].toString();
        this.trainNumber = params[1].toString();
        this.departTime = (LocalDateTime) params[2];

        if (params.length == 4) {
            if (params[3] instanceof Map) {
                Map<Seats, Integer> currentSeats = (Map<Seats, Integer>) params[3];
                if (!currentSeats.isEmpty()) {
                    this.seats = currentSeats;
                }
            } else if (params[3] instanceof List) {
                List<Integer> currentSeats = (List<Integer>) params[3];
                if (!currentSeats.isEmpty()) {
                    this.seats = mapper.mapTo(currentSeats);
                }
            }
        }

        return this;
    }

    public Train build() {
        return new Train(this);
    }
}