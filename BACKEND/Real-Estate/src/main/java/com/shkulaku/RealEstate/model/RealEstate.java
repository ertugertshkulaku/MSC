package com.shkulaku.RealEstate.model;


import com.shkulaku.RealEstate.model.payload.RealEstateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "real-estate")
public class RealEstate extends RealEstateDTO {

    @Id
    private ObjectId id;
    private Date ttl;

    public RealEstate(RealEstateDTO realEstateDTO) {
        this.setId(new ObjectId(realEstateDTO.getUuid()));
        BeanUtils.copyProperties(realEstateDTO, this);
    }
}
