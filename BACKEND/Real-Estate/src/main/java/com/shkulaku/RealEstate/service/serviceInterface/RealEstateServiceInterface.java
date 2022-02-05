package com.shkulaku.RealEstate.service.serviceInterface;


import com.shkulaku.RealEstate.model.payload.CarsAndBikes;
import com.shkulaku.RealEstate.model.payload.RealEstateDTO;

public interface RealEstateServiceInterface {

    CarsAndBikes saveCarsOrBike(String realEstateId, CarsAndBikes carsAndBikes);

    RealEstateDTO findRealEstate(String realEstateId);
}
