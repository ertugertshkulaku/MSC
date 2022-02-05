package com.shkulaku.RealEstate.service.implementation;


import com.shkulaku.RealEstate.model.payload.CarsAndBikes;
import com.shkulaku.RealEstate.model.payload.RealEstateDTO;
import com.shkulaku.RealEstate.repository.repositoryInterface.RealEstateRepositoryInterface;
import com.shkulaku.RealEstate.service.serviceInterface.RealEstateServiceInterface;
import com.shkulaku.RealEstate.utilities.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RealEstateServiceImplementation implements RealEstateServiceInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RealEstateRepositoryInterface realEstateRepositoryInterface;


    @Override
    public RealEstateDTO findRealEstate(String realEstateId) {
        logger.debug("[{}] BEGIN realEstateId: [{}]", Utilities.getCurrentMethodName(), realEstateId);
        RealEstateDTO result = realEstateRepositoryInterface.findOneRealEstate(realEstateId);

        RealEstateDTO after = new RealEstateDTO();
        BeanUtils.copyProperties(result, after);
        after.setUuid("1");
        System.err.println(after);
        System.err.println(result);

        logger.debug("[{}] END result: [{}]", Utilities.getCurrentMethodName(), result);
        return result;
    }

    @Override
    public CarsAndBikes saveCarsOrBike(String realEstateId, CarsAndBikes carsAndBikes) {
        logger.debug("[{}] BEGIN realEstateId: [{}], carsAndBikes: [{}]", Utilities.getCurrentMethodName(), realEstateId, carsAndBikes);
        try {
            RealEstateDTO realEstate = realEstateRepositoryInterface.findOneRealEstate(realEstateId);
          if (carsAndBikes.getUuid() != null){
              updateCarsOrBike(realEstate, carsAndBikes);
          }else {
              if (realEstate.getCarsAndBikes() == null) {
                  realEstate.setCarsAndBikes(new ArrayList<>());
              }
                  carsAndBikes.setUuid(UUID.randomUUID().toString());
                  carsAndBikes.setCreationDate(Instant.now());
              realEstate.getCarsAndBikes().add(carsAndBikes);
              }


          realEstateRepositoryInterface.updateRealEstate(realEstate);

        }catch (Exception e){
            logger.error(e.getMessage(), Utilities.getCurrentMethodName());
        }
        logger.debug("[{}] END result: [{}]", Utilities.getCurrentMethodName(), carsAndBikes);
        return carsAndBikes;
    }

    private void updateCarsOrBike(RealEstateDTO realEstate, CarsAndBikes carsAndBikes) {
        logger.debug("[{}] BEGIN realEstate: [{}] carsAndBikes: [{}]", Utilities.getCurrentMethodName(), realEstate, carsAndBikes);
        for (CarsAndBikes carsAndBikesDTO : realEstate.getCarsAndBikes()) {
            if (carsAndBikesDTO.getUuid().equals(carsAndBikes.getUuid())) {
                BeanUtils.copyProperties(carsAndBikes, carsAndBikesDTO);
                break;
            }
        }logger.debug("[{}] END", Utilities.getCurrentMethodName());
    }
}
