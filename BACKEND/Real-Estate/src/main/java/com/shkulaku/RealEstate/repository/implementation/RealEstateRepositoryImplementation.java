package com.shkulaku.RealEstate.repository.implementation;

import com.shkulaku.RealEstate.model.RealEstate;
import com.shkulaku.RealEstate.model.payload.RealEstateDTO;
import com.shkulaku.RealEstate.repository.mongo.RealEstateMongoRepository;
import com.shkulaku.RealEstate.repository.repositoryInterface.RealEstateRepositoryInterface;
import com.shkulaku.RealEstate.utilities.Utilities;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class RealEstateRepositoryImplementation implements RealEstateRepositoryInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RealEstateMongoRepository realEstateMongoRepository;


    @Override
    public RealEstateDTO findOneRealEstate(String realEstateId) {
        logger.debug("[{}] BEGIN", Utilities.getCurrentMethodName());
        RealEstate realEstate = realEstateMongoRepository.findRealEstateById(new ObjectId(realEstateId));
        RealEstateDTO result = new RealEstateDTO();
        BeanUtils.copyProperties(realEstate, result);
        result.setUuid(realEstate.getId().toHexString());
        logger.debug("[{}] END", Utilities.getCurrentMethodName());
        return result;
    }

    @Override
    public List<RealEstateDTO> findAllRealEstate() {
        logger.debug("[{}] BEGIN", Utilities.getCurrentMethodName());
        List<RealEstateDTO> result = new ArrayList<>();
        List<RealEstate> realEstate = realEstateMongoRepository.findAll();
        if (!realEstate.isEmpty()){
            for (RealEstate real  :realEstate){
                RealEstateDTO realEstateDTO = new RealEstateDTO();
                BeanUtils.copyProperties(real, realEstateDTO);
                result.add(realEstateDTO);
            }
        }
        logger.debug("[{}] END", Utilities.getCurrentMethodName());
        return result;
    }

    @Override
    public void updateRealEstate(RealEstateDTO realEstateDTO) {
        logger.debug("[{}] BEGIN realEstate: [{}]", Utilities.getCurrentMethodName(), realEstateDTO);
        try {
            Instant now = Instant.now();
            RealEstate realEstate;
            if (realEstateDTO.getUuid() == null){
                realEstateDTO.setCreationTime(now);
                realEstateDTO.setCarsAndBikes(new ArrayList<>());
                realEstateDTO.setHouseAndProperties(new ArrayList<>());
                realEstate = new RealEstate();
                if (realEstateDTO.getCreationTime() != null){
                    realEstate.setTtl(Date.from(realEstateDTO.getCreationTime()));
                }
                BeanUtils.copyProperties(realEstateDTO, realEstate);
            }else {
                realEstate = new RealEstate(realEstateDTO);
            }
            realEstate.setUuid(null);
            if (realEstateDTO.getCreationTime() != null){
                realEstate.setTtl(Date.from(realEstateDTO.getCreationTime()));
            }
            realEstate = realEstateMongoRepository.save(realEstate);
            BeanUtils.copyProperties(realEstate, realEstateDTO);
            realEstateDTO.setUuid(realEstate.getId().toHexString());
        }catch (Exception e){
            logger.error(e.getMessage(), Utilities.getCurrentMethodName());
        }
        logger.debug("[{}] END result: [{}]", Utilities.getCurrentMethodName(), realEstateDTO);
    }
}
