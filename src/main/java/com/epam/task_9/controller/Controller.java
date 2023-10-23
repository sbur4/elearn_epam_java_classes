package com.epam.task_9.controller;

import com.epam.task_9.filter.Filter;
import com.epam.task_9.model.Product;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public void processRun() {
        List<Product> products = generateProducts();

        Filter<Product> firstTaskFilter = product -> product.getName().equals("Erdinger");
        List<Product> firstTaskResult = products.stream().filter(firstTaskFilter::filteredBy).collect(Collectors.toList());
        System.out.println(firstTaskResult + System.lineSeparator());

        Filter<Product> secondOneTaskFilter = product -> product.getName().endsWith("r");
        Filter<Product> secondTwoTaskFilter = product -> product.getPrice() < 14.5;
        Filter<Product> combinedFilter = secondOneTaskFilter.and(secondTwoTaskFilter);
        List<Product> secondTaskResult = products.stream().filter(combinedFilter::filteredBy)
                .collect(Collectors.toList());
        System.out.println(secondTaskResult + System.lineSeparator());

        Filter<Product> thirdTaskFilter = product -> product.getExpirationDate()
                .isAfter(LocalDateTime.of(2022, Month.OCTOBER, 30, 0, 0));
        List<Product> thirdTaskResult = products.stream().filter(thirdTaskFilter::filteredBy)
                .collect(Collectors.toList());
        System.out.println(thirdTaskResult + System.lineSeparator());
    }

    private List<Product> generateProducts() {
        Product product1 = new Product(1L, "Budweiser", 1234567809L, "USA", 14.9d,
                LocalDateTime.of(2022, Month.OCTOBER, 28, 1, 10), 100);
        Product product2 = new Product(2L, "Krombacher", 8087654321L, "Germany", 14.8d,
                LocalDateTime.of(2022, Month.OCTOBER, 29, 2, 20), 150);
        Product product3 = new Product(3L, "Grainworks", 1234554321L, "USA", 14.35d,
                LocalDateTime.of(2022, Month.OCTOBER, 30, 3, 30), 200);
        Product product4 = new Product(4L, "Weihenstephan", 707606505L, "Germany", 14.5d,
                LocalDateTime.of(2022, Month.OCTOBER, 31, 4, 40), 250);
        Product product5 = new Product(5L, "Erdinger", 1234567809L, "Germany", 14.46d,
                LocalDateTime.of(2022, Month.OCTOBER, 30, 5, 50), 300);
        Product product6 = new Product(6L, "Veltins", 1234554321L, "Germany", 14.7d,
                LocalDateTime.of(2022, Month.OCTOBER, 29, 22, 12), 350);
        Product product7 = new Product(7L, "Warsteiner", 707606505L, "Germany", 14.1d,
                LocalDateTime.of(2022, Month.OCTOBER, 28, 11, 34), 400);

        return Stream.of(product1, product2, product3, product4, product5, product6, product7).collect(Collectors.toList());
    }
}