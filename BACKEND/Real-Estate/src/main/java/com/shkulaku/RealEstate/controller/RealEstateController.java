package com.shkulaku.RealEstate.controller;

import com.shkulaku.RealEstate.enumeration.ErrorsEnumeration;
import com.shkulaku.RealEstate.exception.CustomException;
import com.shkulaku.RealEstate.model.payload.CarsAndBikes;
import com.shkulaku.RealEstate.model.payload.RealEstateDTO;
import com.shkulaku.RealEstate.service.serviceInterface.RealEstateServiceInterface;
import com.shkulaku.RealEstate.utilities.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.controller.realEstate}")
public class RealEstateController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RealEstateServiceInterface realEstateServiceInterface;


    @GetMapping("/findRealEstate")
    public ResponseEntity<RealEstateDTO> findRealEstate(@RequestParam("id") String realEstateId){
        logger.debug("[{}] BEGIN realEstateId: [{}]", Utilities.getCurrentMethodName(), realEstateId);
        if (realEstateId == null || realEstateId.isEmpty()){
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorsEnumeration.BAD_REQUEST, " realEstateId coming empty");
        }
        RealEstateDTO result = realEstateServiceInterface.findRealEstate(realEstateId);
        logger.debug("[{}] END result: [{}]", Utilities.getCurrentMethodName(), result);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/saveCarsOrBike")
    public ResponseEntity<CarsAndBikes> saveCarsOrBike(@RequestParam("id") String realEstateId,
                                                     @RequestBody CarsAndBikes carsAndBikes){
        logger.debug("[{}] BEGIN realEstateId: [{}], carsAndBikes: [{}]", Utilities.getCurrentMethodName(), realEstateId, carsAndBikes);
        if (realEstateId == null || realEstateId.isEmpty()){
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorsEnumeration.BAD_REQUEST, " realEstateId coming empty");
        }
        CarsAndBikes result = realEstateServiceInterface.saveCarsOrBike(realEstateId, carsAndBikes);
        logger.debug("[{}] END result: [{}]", Utilities.getCurrentMethodName(), result);
        return ResponseEntity.ok(result);
    }
}
