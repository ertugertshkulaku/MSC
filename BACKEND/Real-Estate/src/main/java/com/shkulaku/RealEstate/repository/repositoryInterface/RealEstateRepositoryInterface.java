package com.shkulaku.RealEstate.repository.repositoryInterface;


import com.shkulaku.RealEstate.model.payload.RealEstateDTO;

import java.util.List;


public interface RealEstateRepositoryInterface{

    RealEstateDTO findOneRealEstate(String realEstateId);

    List<RealEstateDTO>  findAllRealEstate();

    void updateRealEstate(RealEstateDTO realEstate);
}
