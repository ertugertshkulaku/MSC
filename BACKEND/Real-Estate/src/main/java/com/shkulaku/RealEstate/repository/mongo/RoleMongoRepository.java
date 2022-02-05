package com.shkulaku.RealEstate.repository.mongo;

import com.shkulaku.RealEstate.model.user.ERole;
import com.shkulaku.RealEstate.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleMongoRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);
    List<Role> findAllBy();

    boolean existsRoleByNameIn(Collection<ERole> name);
}
