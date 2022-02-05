package com.shkulaku.RealEstate.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateDTO {

    private String uuid;
    private Instant creationTime;
    private List<CarsAndBikes> carsAndBikes;
    private List<HouseAndProperty> houseAndProperties;
}
