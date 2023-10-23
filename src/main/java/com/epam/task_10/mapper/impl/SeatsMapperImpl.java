package com.epam.task_10.mapper.impl;

import com.epam.task_10.mapper.Mapper;
import com.epam.task_10.enums.Seats;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SeatsMapperImpl implements Mapper<Map<Seats, Integer>, List<Integer>> {
    @Override
    public Map<Seats, Integer> mapTo(List<Integer> currentSeats) {
        Map<Seats, Integer> seats = new LinkedHashMap<>();
        if (currentSeats.isEmpty()) {
            return Collections.emptyMap();
        }

        int totalSeats = getSeats(currentSeats.get(0));
        int comfortSeats = getSeats(currentSeats.get(1));
        int standardSeats = getSeats(currentSeats.get(2));
        int luxurySeats = getSeats(currentSeats.get(3));

        seats.put(Seats.TOTAL, totalSeats);
        seats.put(Seats.COMFORT, comfortSeats);
        seats.put(Seats.STANDARD, standardSeats);
        seats.put(Seats.LUXURY, luxurySeats);

        return seats;
    }

    private static int getSeats(Integer currentSeat) {
        return Objects.nonNull(currentSeat) && currentSeat > 0 ? currentSeat : 0;
    }
}