package com.epam.task_10.model;

import com.epam.task_10.builder.impl.TrainBuilderImpl;
import com.epam.task_10.enums.Seats;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Train {
    private String destinationPoint;
    private String trainNumber;
    private LocalDateTime departTime;
    private Map<Seats, Integer> seats;

    {
        this.seats = new LinkedHashMap<>();
        seats.put(Seats.TOTAL, 0);
        seats.put(Seats.COMFORT, 0);
        seats.put(Seats.STANDARD, 0);
        seats.put(Seats.LUXURY, 0);
    }

    public Train() {
    }

    public Train(String destinationPoint, String trainNumber, LocalDateTime departTime) {
        this.destinationPoint = destinationPoint;
        this.trainNumber = trainNumber;
        this.departTime = departTime;
    }

    public Train(String destinationPoint, String trainNumber, LocalDateTime departTime, Map<Seats, Integer> seats) {
        this.destinationPoint = destinationPoint;
        this.trainNumber = trainNumber;
        this.departTime = departTime;
        this.seats = seats;
    }

    public Train(TrainBuilderImpl builder) {
        this.destinationPoint = builder.destinationPoint;
        this.trainNumber = builder.trainNumber;
        this.departTime = builder.departTime;
        this.seats = builder.seats;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDateTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalDateTime departTime) {
        this.departTime = departTime;
    }

    public Map<Seats, Integer> getSeats() {
        return seats;
    }

    public void setSeats(Map<Seats, Integer> seatsnumberOfPlaces) {
        this.seats = seatsnumberOfPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Train)) {
            return false;
        }

        Train train = (Train) o;
        return Objects.equals(destinationPoint, train.destinationPoint) && Objects.equals(trainNumber, train.trainNumber)
                && Objects.equals(departTime, train.departTime) && Objects.equals(seats, train.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationPoint, trainNumber, departTime, seats);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Train.class.getSimpleName() + "[", "]")
                .add("destinationPoint='" + destinationPoint + "'")
                .add("trainNumber='" + trainNumber + "'")
                .add("departTime=" + departTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")))
                .add("seats=" + seats)
                .toString();
    }
}