package com.shkulaku.RealEstate;


import com.shkulaku.RealEstate.model.payload.RealEstateDTO;
import com.shkulaku.RealEstate.model.user.ERole;
import com.shkulaku.RealEstate.model.user.Role;
import com.shkulaku.RealEstate.repository.mongo.RoleMongoRepository;
import com.shkulaku.RealEstate.repository.repositoryInterface.RealEstateRepositoryInterface;
import com.shkulaku.RealEstate.utilities.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class RealEstateApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private RealEstateRepositoryInterface realEstateRepositoryInterface;

	@Autowired
	private RoleMongoRepository roleMongoRepository;


	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}


	@PostConstruct
	private void buildRealEstate(){
		List<RealEstateDTO> list = realEstateRepositoryInterface.findAllRealEstate();
		if (list.isEmpty()){
			logger.debug("[{}] BEGIN", Utilities.getCurrentMethodName());
			RealEstateDTO realEstateDTO = new RealEstateDTO();
			 realEstateRepositoryInterface.updateRealEstate(realEstateDTO);
			logger.debug("[{}] END ", Utilities.getCurrentMethodName());
		}
	}

	@PostConstruct
	private void buildRole(){
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("", ERole.ROLE_ADMIN));
		roles.add(new Role("", ERole.ROLE_MODERATOR));
		roles.add(new Role("", ERole.ROLE_USER));
		Collection<ERole> eRoles = List.of(ERole.ROLE_USER, ERole.ROLE_MODERATOR, ERole.ROLE_ADMIN);
		if (!roleMongoRepository.existsRoleByNameIn(eRoles)){
			roleMongoRepository.saveAll(roles);
		}
	}

}
