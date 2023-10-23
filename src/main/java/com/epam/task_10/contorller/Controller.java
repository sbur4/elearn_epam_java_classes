package com.epam.task_10.contorller;

import com.epam.task_10.builder.impl.TrainBuilderImpl;
import com.epam.task_10.criteria.AbstractCriteria;
import com.epam.task_10.criteria.impl.DepartTimeIsAfterCriteriaImpl;
import com.epam.task_10.criteria.impl.DestinationCriteriaImpl;
import com.epam.task_10.criteria.impl.SeatsCriteriaImpl;
import com.epam.task_10.enums.CriteriaType;
import com.epam.task_10.enums.Seats;
import com.epam.task_10.model.Train;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public void processRun(TrainBuilderImpl trainBuilder) {
        List<Train> trains = generateTrains(trainBuilder);

        AbstractCriteria firstTask = new DestinationCriteriaImpl("London King's Cross");
        List<Train> filteredTrainsByDestination = filterBy(trains, firstTask);
        System.out.println(filteredTrainsByDestination + System.lineSeparator());

        AbstractCriteria secondTask = new DestinationCriteriaImpl("London King's Cross")
                .and(new DepartTimeIsAfterCriteriaImpl(LocalDateTime.of(2021, Month.JANUARY, 4, 0, 0)));
        List<Train> filteredTrainsByDestinationAndDepartAfterTime = filterBy(trains, secondTask);
        System.out.println(filteredTrainsByDestinationAndDepartAfterTime + System.lineSeparator());

        AbstractCriteria thirdTask = new DestinationCriteriaImpl("London King's Cross")
                .and(new SeatsCriteriaImpl(Seats.LUXURY, 30, CriteriaType.EQUALS_TO));
        List<Train> filteredTrainsByDestinationAndHaveSeats = filterBy(trains, thirdTask);
        System.out.println(filteredTrainsByDestinationAndHaveSeats + System.lineSeparator());
    }

    private static List<Train> filterBy(List<Train> trains, AbstractCriteria criteria) {
        return (List<Train>) trains.stream().filter(criteria).collect(Collectors.toList());
    }

    private static List<Train> generateTrains(TrainBuilderImpl trainBuilder) {
        // main
        Train train1 = trainBuilder.builder("London King's Cross", "EN 406/407",
                LocalDateTime.of(2021, Month.JANUARY, 5, 1, 2),
                Stream.of(100, 50, 30, 20).collect(Collectors.toList())).build();
        Train train2 = trainBuilder.builder("Aberdeen", "EC 1160/1167",
                LocalDateTime.of(2021, Month.JANUARY, 1, 3, 4),
                Stream.of(90, 40, 20, 30).collect(Collectors.toList())).build();
        Train train3 = trainBuilder.builder("London Paddington", "BR 1272",
                LocalDateTime.of(2021, Month.JANUARY, 3, 5, 6),
                Stream.of(80, 30, 25, 15).collect(Collectors.toList())).build();
        Train train4 = trainBuilder.builder("London Waterloo", "IC 542/545",
                LocalDateTime.of(2021, Month.JANUARY, 7, 7, 8),
                Stream.of(70, 20, 20, 30).collect(Collectors.toList())).build();
        Train train5 = trainBuilder.builder("London Victoria", "SR 1700/1701",
                LocalDateTime.of(2021, Month.JANUARY, 8, 9, 0),
                Stream.of(60, 10, 15, 35).collect(Collectors.toList())).build();
        Train train6 = trainBuilder.builder("Brighton", "LBSCR 657-659",
                LocalDateTime.of(2021, Month.JANUARY, 2, 10, 1),
                Stream.of(50, 5, 10, 35).collect(Collectors.toList())).build();
        Train train7 = trainBuilder.builder("Cardiff Central", "GWR 1596/1597",
                LocalDateTime.of(2021, Month.JANUARY, 4, 22, 33),
                Stream.of(50, 35, 5, 10).collect(Collectors.toList())).build();

        // others
        Train train11 = trainBuilder.builder("London King's Cross", "EN 236/237",
                LocalDateTime.of(2021, Month.JANUARY, 5, 15, 17),
                Stream.of(60, 10, 15, 35).collect(Collectors.toList())).build();
        Train train22 = trainBuilder.builder("London King's Cross", "EC 142/145",
                LocalDateTime.of(2021, Month.JANUARY, 1, 18, 59),
                Stream.of(70, 20, 20, 30).collect(Collectors.toList())).build();
        Train train33 = trainBuilder.builder("London King's Cross", "BR 210",
                LocalDateTime.of(2021, Month.JANUARY, 3, 5, 6),
                Stream.of(80, 30, 25, 15).collect(Collectors.toList())).build();
        Train train44 = trainBuilder.builder("London Waterloo", "IC 520/521/522/523",
                LocalDateTime.of(2021, Month.JANUARY, 7, 7, 8),
                Stream.of(90, 40, 20, 30).collect(Collectors.toList())).build();
        Train train55 = trainBuilder.builder("London Waterloo", "SR 1488/1489",
                LocalDateTime.of(2021, Month.JANUARY, 8, 9, 0),
                Stream.of(100, 50, 30, 20).collect(Collectors.toList())).build();

        return Stream.of(train1, train2, train3, train4, train5, train6, train7, train11, train22, train33,
                train44, train55).collect(Collectors.toList());
    }
}