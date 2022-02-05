package com.shkulaku.RealEstate.repository.mongo;

import com.shkulaku.RealEstate.model.RealEstate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateMongoRepository extends MongoRepository<RealEstate, ObjectId> {

    RealEstate findRealEstateById(ObjectId realEstateId);
}
