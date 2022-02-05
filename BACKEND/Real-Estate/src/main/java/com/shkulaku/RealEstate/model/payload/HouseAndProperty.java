package com.shkulaku.RealEstate.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseAndProperty {

    private String uuid;
    private String category;
    private double price;
    private String location;
    private String description;
    private double surface;
    private Instant creationDate;
    private String userContact;
}
