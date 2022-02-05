package com.shkulaku.RealEstate.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsAndBikes {

    private String uuid;
    private Instant creationDate;
    private String category;
    private double price;
    private String make;
    private String model;
    private String userContact;
}
